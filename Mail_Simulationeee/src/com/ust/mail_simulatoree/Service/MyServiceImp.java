package com.ust.mail_simulatoree.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.mail_simulatoree.DAO.MyDao;
import com.ust.mail_simulatoree.Model.Mail_Info;
import com.ust.mail_simulatoree.Model.User_Info;

@Component
public class MyServiceImp implements MyService{
	@Autowired
	 MyDao udto;
		@Override
		public boolean regUser(User_Info rdto) {

			boolean b=udto.regUser(rdto);	
			return b;
		}
		@Override
		public boolean login(HttpServletRequest req) {
			// TODO Auto-generated method stub
		    boolean	b=udto.login(req);
			
			return b;
		}
		@Override
		public boolean delete(int id)
		{
			boolean b=udto.delete(id);
			return b;
		}
		

		/*@Override
		public List<MailInfoDTO> deletedMail()
		{
			List<MailInfoDTO> list=udto.deletedMail();
			return list;
		}*/
		
		
		@Override
		public boolean changePass(HttpServletRequest req) {
			// TODO Auto-generated method stub
			boolean	b=udto.changePass(req);
				
				return b;	
				}
		@Override
		public boolean secqurityvalidation(HttpServletRequest req) {
			// TODO Auto-generated method stub
			 boolean	b=udto.secqurityvalidation(req);
				
				return b;	
				}
		@Override
		public boolean sent(HttpServletRequest req) {
			// TODO Auto-generated method stub
			boolean b=udto.sent(req);
			return b;
		}
		@Override
		public List<Mail_Info> sentInbox(String em) {
			// TODO Auto-generated method stub
			
			return udto.sentInbox(em);
		}
		@Override
		public List<Mail_Info> inbox(String em) {
			// TODO Auto-generated method stub
			
			return udto.inbox(em);
		}
		@Override
		public List<Mail_Info> draft(String em) {
			// TODO Auto-generated method stub
			return udto.draft(em);
		}
		@Override
		public List<Mail_Info> message(HttpServletRequest request) {
			List<Mail_Info> list=udto.message(request);
			return list;
		}

		@Override
		public List<Mail_Info> message1(HttpServletRequest request) {
			List<Mail_Info> list=udto.message(request);
			return list;
		}
		
}
		
	

		
	


