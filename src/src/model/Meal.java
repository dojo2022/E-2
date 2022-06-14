package model;

import java.sql.Date;

public class Meal {
private String userid;//userid
private int foodnumber;//食事番号
private Date indaily;//日付
private String food;//食事写真
private int satiety;//満腹度

public Meal() {
}

public Meal(String userid, int foodnumber, Date indaily, String food, int satiety) {
	this.userid = userid;
	this.foodnumber = foodnumber;
	this.indaily = indaily;
	this.food = food;
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

public Date getIndaily() {
	return indaily;
}

public void setIndaily(Date indaily) {
	this.indaily = indaily;
}

public String getFood() {
	return food;
}

public void setFood(String food) {
	this.food = food;
}

public int getSatiety() {
	return satiety;
}

public void setSatiety(int satiety) {
	this.satiety = satiety;
}

}
