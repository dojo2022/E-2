package model;

public class Meal {
	private String userid;
	private int foodnumber;
	private int daily;
	private String meal;
	private int satiety;
	public Meal(String userid, int foodnumber, int daily, String meal, int satiety) {
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
	public int getDaily() {
		return daily;
	}
	public void setDaily(int daily) {
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
