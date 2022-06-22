package model;

import java.io.Serializable;

public class Meal implements Serializable{
	private String userid; //userid
	private int foodnumber; //食事番号
	private String daily;// 日付
	private String meal;//食事写真
	private int satiety;//満腹度


	public Meal(String userid, int foodnumber, String daily, String meal, int satiety) {
		this.userid = userid;
		this.foodnumber = foodnumber;
		this.daily = daily;
		this.meal = meal;
		this.satiety = satiety;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getFoodnumber() {
		return foodnumber;
	}

	public void setFoodnumber(int foodnumber) {
		this.foodnumber = foodnumber;
	}

	public String getDaily() {
		return daily;
	}

	public void setString(String daily) {
		this.daily = daily;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public int getSatiety() {
		return satiety;
	}

	public void setSatiety(int satiety) {
		this.satiety = satiety;
	}

}
