package test;

import java.util.List;

import dao.UserDao;
import model.Userdata;

public class signtest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		// insert()のテスト
		 UserDao uDao = new UserDao();
				System.out.println("---------- insert()のテスト ----------");
				Userdata insRec = new Userdata("aaa", "aaa", "aaa", "男", "1999/9/20",170.0 , 0,"2022-11-12",170 );
				if (uDao.insert(insRec)) {
					System.out.println("登録成功！");
					List<> cardList3 = uDao.insert(insRec);
					for ( card : cardList3) {
						System.out.println("userid：" + card.getUserid());
						System.out.println("password：" + card.getPassword());
						System.out.println("email：" + card.getEmail());
						System.out.println("gender: " + card.getGender());
						System.out.println("birth"+card.getBirth());
						System.out.println("targetweight" + card.getTargetweight());
						System.out.println("daily" + card.getDaily());
						System.out.println("lastlogin" + card.getLastlogin());
						System.out.println("height" + card.getHeight());
					}
				}
				else {
					System.out.println("登録失敗！");
				}



	}

}

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
