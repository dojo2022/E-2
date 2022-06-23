package model;

import java.io.Serializable;

public class Loginuser implements Serializable {
	private String userid; // ログイン時のID
	public Loginuser() {
	}

	public Loginuser(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
