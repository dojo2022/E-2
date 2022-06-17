package model;

import java.io.Serializable;

 public class Contact implements  Serializable{
   private  String  userid ; // userid
   private int number ; // 番号
   private String email ; //メールアドレス
   private String contact ; //お問い合わせ内容
 public Contact() {
	}

	public Contact(String userid, String email, String contact) {
	this.userid = userid;
	this.email = email;
	this.contact = contact;
}

	public Contact(String userid, int number, String email, String contact) {
		this.userid = userid;
		this.number = number;
		this.email = email;
		this.contact = contact;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}


}
