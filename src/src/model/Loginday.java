package model;

import java.io.Serializable;
import java.sql.Date;

public class Loginday implements Serializable{
	private Date lastlogin;

	public Loginday() {
	}

	public Loginday(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

}
