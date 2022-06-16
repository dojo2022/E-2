package model;

import java.io.Serializable;
import java.sql.Date;

public class Weight implements Serializable {
	private String userid;//userid
	private double wight;//体重
	private Date indaily;//日付
	public Weight() {
	}
	public Weight(String userid, double wight, Date indaily) {
		this.userid = userid;
		this.wight = wight;
		this.indaily = indaily;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public double getWight() {
		return wight;
	}
	public void setWight(double wight) {
		this.wight = wight;
	}
	public Date getIndaily() {
		return indaily;
	}
	public void setIndaily(Date indaily) {
		this.indaily = indaily;
	}


}
