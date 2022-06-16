package model;

import java.io.Serializable;

public class Sport implements  Serializable{
	private int number; //番号
	private String spsports;//運動
	private double mets;//メッツ
	public Sport() {
	}
	public Sport(int number, String spsports, double mets) {
		this.number = number;
		this.spsports = spsports;
		this.mets = mets;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSports() {
		return spsports;
	}
	public void setSports(String sports) {
		this.spsports = sports;
	}
	public double getMets() {
		return mets;
	}
	public void setMets(double mets) {
		this.mets = mets;
	}
}
