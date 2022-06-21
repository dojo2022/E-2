package model;

import java.sql.Date;

public class Caloriesout {
	private String userid;
	private Date indaily;
	private int caloriesout;

	public Caloriesout() {
	}

	public Caloriesout(String userid, Date indaily, int caloriesout) {
		this.userid = userid;
		this.indaily = indaily;
		this.caloriesout = caloriesout;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public java.sql.Date getIndaily() {
		return indaily;
	}

	public void setIndaily(Date indaily) {
		this.indaily = indaily;
	}

	public int getCaloriesout() {
		return caloriesout;
	}

	public void setCaloriesout(int caloriesout) {
		this.caloriesout = caloriesout;
	}

}
