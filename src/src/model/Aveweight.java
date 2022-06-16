package model;

public class Aveweight {
	private String gender;//性別
	private int age;//年齢
	private double aveweight;//平均体重

	public Aveweight() {
	}

	public Aveweight(String gender, int age, double aveweight) {
		this.gender = gender;
		this.age = age;
		this.aveweight = aveweight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAveweight() {
		return aveweight;
	}

	public void setAveweight(double aveweight) {
		this.aveweight = aveweight;
	}

}
