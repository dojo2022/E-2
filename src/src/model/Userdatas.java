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

	public int calc(Userdata target) {
		int	result = 0;
		int a = target.getDaily();
		result = a + 1;
		return result;
	}

	public int age(Date birth) {
		int result = 0;
		Date time = today();
		Date mybirth = birth;

		int age = time.getYear() - mybirth.getYear();
		System.out.println(age);
		// 誕生月を迎えていなければ年齢-1
	    if (time.getMonth() < mybirth.getMonth()) {
	        age -= 1;
	    }else if(time.getDay() < mybirth.getDay()) {
	            age -= 1;
	        }
	    result = age;

		return result;
	}
}
