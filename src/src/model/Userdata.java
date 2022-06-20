package model;

import java.io.Serializable;
import java.sql.Date;

public class Userdata implements Serializable {
	private String userid;//userid
	private String password;//パスワード
	private String email;//メールアドレス
	private String gender;//性別
	private Date birth;//生年月日
	private double targetwight;//目標体重
	private int daily;//ログイン日数
	private Date lastlogin;//最終ログイン
	private double height;//身長

	public Userdata() {
	}

    //本人認証
	/*
	public Userdata(String password, String email) {
		this.password = password;
		this.email = email;
}
*/
	//ログイン
	public Userdata(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public Userdata(double targetwight) {
		this.targetwight = targetwight;
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
