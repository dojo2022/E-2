package model;

import java.sql.Date;

public class Userdata {
	private String userid;
	private String password;
	private String email;
	private String gender;
	private Date birth;
	private double targetwight;
	private int daily;
	private Date lastlogin;
	private double height;

	public Userdata() {
	}

	public Userdata(String userid, String password, String email, String gender, Date birth, double targetwight,
			int daily,
			Date lastlogin, double height) {
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.targetwight = targetwight;
		this.daily = daily;
		this.lastlogin = lastlogin;
		this.height = height;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public double getTargetwight() {
		return targetwight;
	}

	public void setTargetwight(double targetwight) {
		this.targetwight = targetwight;
	}

	public int getDaily() {
		return daily;
	}

	public void setDaily(int daily) {
		this.daily = daily;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
