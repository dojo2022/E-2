
package test ;
import dao.UserDao;
import model.Userdata;

public class signtest {

	public static void main(String[] args){
/*
		SimpleDateFormat f = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");

		java.util.Date d_util = f.parse("2020/09/22 01:34:56");

		System.out.println(d_util);

		String s_util = f.format(d_util);

		System.out.println(s_util);

		long num = d_util.getTime();

		Date d_sql = new Date(num);

		System.out.println(d_sql);

		String s_sql = f.format(d_sql);

		System.out.println(s_sql);
    }
}
*/











/*package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class signtest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat f =new SimpleDateFormat("yyyy/MM/dd HH : mm : ss");
			java.util.Date d =  f .parse ("2020/09/22/ 01:23:45");
				 System.out.println (d);
				 //String s =f.format(d);
				 //System.out.println(s);
}
}
*/

		// TODO 自動生成されたメソッド・スタブ



		                                                // insertのテスト

				System.out.println("---------- insert()のテスト ----------");
				java.sql.Date d_util =  java.sql.Date.valueOf("2020-09-22");
				java.sql.Date e_util =  java.sql.Date.valueOf("2020-09-22");
				UserDao uDao = new UserDao();
				Userdata insRec = new Userdata(
						"aaa", "aaa", "aaa", "男", d_util, 170.0 , 0, e_util, 170.0 );
				if (uDao.userdata(insRec)){
					System.out.println("登録成功！");
					}else {
						System.out.println("登録失敗！");
					}
				}
	}















			//データ
/*create table userdata (
userid varchar (20),
password varchar (20),
email varchar (40),
gender varchar ,
birth date ,
targetweight double ,
daily int ,
lastlogin date ,
height double )
*/