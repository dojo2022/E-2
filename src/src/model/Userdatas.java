package model;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Userdatas {
	public Date today() {
		String months[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		GregorianCalendar gcalendar = new GregorianCalendar();
		String today = Integer.valueOf(gcalendar.get(Calendar.YEAR)).toString() + "-"
				+ months[gcalendar.get(Calendar.MONTH)] + "-"
				+ Integer.valueOf(gcalendar.get(Calendar.DATE)).toString();
		Date sqldate = Date.valueOf(today);
		System.out.println(sqldate);
		return sqldate;
	}
}
