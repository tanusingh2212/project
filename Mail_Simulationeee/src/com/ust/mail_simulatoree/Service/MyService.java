package com.ust.mail_simulatoree.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.mail_simulatoree.Model.Mail_Info;
import com.ust.mail_simulatoree.Model.User_Info;

public interface MyService {
	public boolean regUser(User_Info  rdto);
 public boolean login(HttpServletRequest req);

public boolean delete(int id);


public List<Mail_Info> message(HttpServletRequest request);
public List<Mail_Info> message1(HttpServletRequest request);

	public boolean changePass(HttpServletRequest req);
	public boolean secqurityvalidation(HttpServletRequest req );
	public boolean sent(HttpServletRequest req);
	public List<Mail_Info> sentInbox(String em);
	public List<Mail_Info> inbox(String em);
	public List<Mail_Info> draft(String em);
	

}
