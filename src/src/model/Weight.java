package model;

import java.io.Serializable;
import java.sql.Date;

public class Weight implements Serializable {
	private String userid;//userid
	private double weight;//体重
	private Date indaily;//日付
	public Weight() {
	}

	public Weight(double weight) {
		this.weight = weight;
	}

	public Weight(String userid, double weight, Date indaily) {
		this.userid = userid;
		this.weight = weight;
		this.indaily = indaily;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getIndaily() {
		return indaily;
	}
	public void setIndaily(Date indaily) {
		this.indaily = indaily;
	}


}
