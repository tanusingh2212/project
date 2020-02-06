package com.ust.mail_simulatoree.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ust.mail_simulatoree.Model.Mail_Info;
import com.ust.mail_simulatoree.Model.User_Info;
import com.ust.mail_simulatoree.Service.MyService;

@Component
@RequestMapping("/")
public class My_Controller {

	@Autowired
	MyService ms;
	
	HttpSession ss=null;
	
	@RequestMapping("/UserRegister")
	public String reg() {
		return "Register";
	}
	@RequestMapping("/UserLogin")
	public String log() {
		return "Login";
	}
	@RequestMapping("/forgotPassword")
	public String forgotPassword() {
		return "secqurityvalidation";
	}
	@RequestMapping("/Compose1")
	public String Compose1(){
		return "Compose1";
				
	}
	@RequestMapping("/Compose")
	public String compose() {
	return "Compose";
		}
	@RequestMapping(value="/RegUser",method=RequestMethod.POST)
	public ModelAndView regUser(@ModelAttribute User_Info rdto,BindingResult result) throws Exception {
	boolean b=ms.regUser(rdto);
if(b) {
return new ModelAndView("Login","msg","<h3>Registration successfull</h3>");
}else {
	return new ModelAndView("Register","msg","This email id already registered");
}
		}
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req) {
		
		boolean  b=ms.login(req);
		if(b) {
			String em=req.getParameter("email");
			 ss=req.getSession();
			 ss.setAttribute("email", em);
			System.out.println("Success");
			return  new ModelAndView("Home","em",em);
		}
		else {
			System.out.println("Failed");
			return new ModelAndView("Login","msg","Invalid Id or Password");
		}
	}
	@RequestMapping(value="/changePass",method=RequestMethod.POST)
public ModelAndView changePass(HttpServletRequest req) {
		boolean  b=ms.changePass(req);
		ss=req.getSession();

		if(b) {
		return new ModelAndView ("Login","msg", "password change sucessfully");
       }
		else  {
			System.out.println("Failed");
			return new ModelAndView ("changepassword","msg", "password not change");
			}
		}
	@RequestMapping(value="/scqurityvalidate",method=RequestMethod.POST)
	public ModelAndView secqurityvalidation(HttpServletRequest req ) {
		boolean  b=ms.secqurityvalidation(req);
		if(b)
		{
			return new ModelAndView ("changepassword");
        }
		else {
			System.out.println("Failed");
			return new ModelAndView ("secqurityvalidation","msg", "wrong security question answer ");

		}		
	}
	@RequestMapping("/SentInbox")
	public ModelAndView sentInbox(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		List<Mail_Info>plist=ms.sentInbox(em);
		return new ModelAndView("SentEmail","plist",plist);
		
	}
	@RequestMapping(value="/Sent",method=RequestMethod.POST)
	public ModelAndView sent(HttpServletRequest req) {
	boolean b=ms.sent(req);
	if(b){
		return new ModelAndView("Home","msg","Mail Successfull Sent");
	}else {
		return new ModelAndView("Home","msg","Mail Send Failed");
	}
		}

	@RequestMapping("/Inbox")
	public ModelAndView Inbox(HttpServletRequest req) {
		String em=(String) ss.getAttribute("email");

		 if(ss.getAttribute("email")!=null) {
			 List<Mail_Info> plist=ms.inbox(em);
			  return new ModelAndView("Inbox","plist",plist);
			  }else {
				  return new ModelAndView("login","masg","Login First");
			  }
			  }
	@RequestMapping("/Draft")
	public ModelAndView draft(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		List<Mail_Info>plist=ms.draft(em);
		return new ModelAndView("Draft","plist",plist);
		}
	@RequestMapping("/logout")
public ModelAndView logout(HttpServletRequest req) {
		ss=req.getSession(false);
		ss.invalidate();
		return new ModelAndView("Login","msg","logout sucessfully");
	}
		{System.out.println("Plz login first");
}
	@RequestMapping("/delete")
	  public ModelAndView delete(@RequestParam int msgid) {
		  
		  boolean b=ms.delete(msgid);
		  if(b) {
		  return new ModelAndView("Home","msg","Deleted Successfully");
		  }else {
			  return new ModelAndView("Home","msg","Delete Failed");
		  }
	  }
	
	
	@RequestMapping("/message") 
	  public ModelAndView message(HttpServletRequest request) {
		  
		  if(ss.getAttribute("email")!=null) {
		 List<Mail_Info> list=ms.message(request);
		  return new ModelAndView("message","list",list);
		  }else {
			  return new ModelAndView("message","masg","Login First");
		  }
		  }
	  @RequestMapping("/message1") 
	  public ModelAndView message1(HttpServletRequest request) {
		  
		  if(ss.getAttribute("email")!=null) {
		 List<Mail_Info> list=ms.message1(request);
		  return new ModelAndView("message1","list",list);
		  }else {
			  return new ModelAndView("message1","masg","Login First");
		  }
		  }
	  
		 
	  }
         
	



