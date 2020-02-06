package com.ust.mail_simulatoree.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User_Info {
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int uid;
	private String uname;
	@Column(unique=true)
	private String email;
	private String password;
	private String question;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="uid")
	private List<Mail_Info> infolist;
	public List<Mail_Info> getInfolist() {
		return infolist;
	}
	public void setInfolist(List<Mail_Info> infolist) {
		this.infolist = infolist;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
}
