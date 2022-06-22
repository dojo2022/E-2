package model;

import java.io.Serializable;

public class Loginpass implements Serializable {
	private String password;

	public Loginpass() {
	}

	public Loginpass(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
