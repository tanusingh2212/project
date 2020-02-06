package com.ust.mail_simulatoree.DAO;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ust.mail_simulatoree.Model.Mail_Info;
import com.ust.mail_simulatoree.Model.User_Info;
@Component
public class MyDaoImp implements MyDao {

	 @Autowired
	 SessionFactory sf;
	 HttpSession ss=null;
		@Override
		public boolean regUser(User_Info rdto)
		{
			
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(User_Info.class);
			cr.add(Restrictions.eq("email", rdto.getEmail()));
			User_Info dto=(User_Info) cr.uniqueResult();
			if(dto!=null) {
			return false;
			}
			else {
				
				ss.save(rdto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}
		}
		@Override
		public boolean login(HttpServletRequest req) {
			
			String pw=req.getParameter("password");
			String email=req.getParameter("email");
			Session ss=sf.openSession();
			  Criteria cr =ss.createCriteria(User_Info.class);
			  cr.add(Restrictions.eq("password",pw));
			  cr.add(Restrictions.eq("email",email));
			  User_Info dto=(User_Info) cr.uniqueResult();
			ss.beginTransaction().commit();
			ss.close();
			if(dto!=null) {
			return true;
			}else {
				return false;
			}
} 
		@Override
		public boolean changePass(HttpServletRequest req) 
		{  		
			String password1=req.getParameter("password1");
			String password2=req.getParameter("password2");
if(password1.equals(password2))
			{this.ss=req.getSession(false);
			String memail=(String) this.ss.getAttribute("email");
			Session ss=sf.openSession();
			Mail_Info idto=null;
			Query qry=ss.createQuery("from User_Info where email='"+memail+"'");
			User_Info rdto=(User_Info) qry.uniqueResult();
			if(rdto!=null)
			{
			Query qry3=ss.createQuery("update User_Info set password=? where email=?");
		 		qry3.setParameter(0, new String(password1));
                qry3.setParameter(1, new String(memail));
				qry3.executeUpdate();
				ss.close();

	return true;
			}

			else{
				return false;
			}
			}
else{				return false;

	
}
		}
@Override
		public boolean secqurityvalidation(HttpServletRequest req ) {
			String email=req.getParameter("email");
           String question=req.getParameter("question");
           ss=req.getSession();
  		 ss.setAttribute("email", email);
           Session ss=sf.openSession();
      	 Criteria cr =ss.createCriteria(User_Info.class);
      	cr.add(Restrictions.eq("email",email));
      	cr.add(Restrictions.eq("question",question));

      User_Info dto=(User_Info) cr.uniqueResult();
      ss.beginTransaction().commit();
   
		ss.close();
		if(dto!=null) {
		return true;
		}else {
			return false;
		}			
		}
	
		@Override
		public List<Mail_Info> sentInbox(String em) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(Mail_Info.class);
			cr.add(Restrictions.eq("fromid", em));
			cr.add(Restrictions.isNotNull("message"));
			List<Mail_Info>ilist=cr.list();
			ss.close();
			return ilist;
		}
		@Override
		public boolean sent(HttpServletRequest req) {
			String	toid=req.getParameter("email");
			String	sub=req.getParameter("subject");
			String	message=req.getParameter("message");
            this.ss=req.getSession(false);
			String memail=(String) this.ss.getAttribute("email");
			Session ss=sf.openSession();
			
			Mail_Info idto=null;
			Query qry=ss.createQuery("from User_Info where email='"+toid+"'");
			User_Info rdto=(User_Info) qry.uniqueResult();
			List<Mail_Info>ilist;
			if(rdto!=null) {
			   idto=new Mail_Info();
			   idto.setFromid(memail);
               idto.setToid(toid);
               idto.setSubject(sub);
               idto.setMessage(message);
			   idto.setStatus("send");
				
				ilist=rdto.getInfolist();
				ilist.add(idto);
				ss.saveOrUpdate(rdto);
				ss.beginTransaction().commit();
				ss.close();
			return true;
			}else {
					idto=new Mail_Info();
					idto.setDraft(message);
					idto.setToid(toid);
					idto.setFromid(memail);
                    idto.setStatus("draft");
					

					qry=ss.createQuery("from User_Info where email='"+memail+"'");
					rdto=(User_Info) qry.uniqueResult();
					ilist=rdto.getInfolist();
					ilist.add(idto);
					ss.saveOrUpdate(rdto);
					ss.beginTransaction().commit();
					ss.close();
				return false;
			}
		}
		@Override
		public List<Mail_Info> message(HttpServletRequest request) {
			String id=request.getParameter("msgid");
			  int mid=Integer.parseInt(id);
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(Mail_Info.class);
			String memail=(String) this.ss.getAttribute("email");
            cr.add(Restrictions.eq("msgid",mid));
			cr.add(Restrictions.eq("status", "send"));
			List<Mail_Info> mlist=cr.list();
			return mlist;
		}
		@Override
		public List<Mail_Info> message1(HttpServletRequest request) {
			String id=request.getParameter("msgid");
			  int mid=Integer.parseInt(id);
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(Mail_Info.class);
			String memail=(String) this.ss.getAttribute("email");
			cr.add(Restrictions.eq("msgid",mid));
			cr.add(Restrictions.eq("status", "send"));
			List<Mail_Info> mlist=cr.list();
			return mlist;
		}

		@Override
		public List<Mail_Info> inbox(String em) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(Mail_Info.class);
			cr.add(Restrictions.eq("toid",em));
			cr.add(Restrictions.eq("status", "send"));
			List<Mail_Info> mlist=cr.list();
			return mlist;
			}
		@Override
		public List<Mail_Info> draft(String em) {
		    Session ss=sf.openSession();
		    Criteria cr=ss.createCriteria(Mail_Info.class);
			cr.add(Restrictions.eq("fromid", em));
			String status="draft";
			cr.add(Restrictions.eq("status", status));
            List<Mail_Info>ilist=cr.list();
			ss.close();
			return ilist;
			
		}
		
		@Override
		public boolean delete(int msgid) 
		{
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(Mail_Info.class);
			cr.add(Restrictions.eq("msgid", msgid));
			Mail_Info dto=(Mail_Info) cr.uniqueResult();
			if(dto!=null) {
				Query  qry2=ss.createQuery("delete from Mail_Info where msgid=?");
				qry2.setParameter(0, new Integer(msgid));
				qry2.executeUpdate();
              System.out.println("delete sucessfull");
				ss.close();
				return true;
			}else {
			return false;
			}
		}
}

		


