package com.ust.mail_simulatoree.DAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.mail_simulatoree.Model.Mail_Info;
import com.ust.mail_simulatoree.Model.User_Info;

public interface MyDao {


	public List<Mail_Info> message(HttpServletRequest request);
	public List<Mail_Info> message1(HttpServletRequest request);

	public boolean regUser(User_Info rdto);
	public boolean login(HttpServletRequest req);
	public boolean changePass(HttpServletRequest req);
	public boolean secqurityvalidation(HttpServletRequest req );
	public List<Mail_Info> sentInbox(String em);
	public boolean sent(HttpServletRequest req);
	public List<Mail_Info> inbox(String em);
	public List<Mail_Info> draft(String em);
	public boolean delete(int id);



}
