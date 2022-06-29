package test;

import dao.UserDao;
import model.Loginpass;
import model.Loginuser;
import model.Userdata;

public class Usertest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		UserDao uDao = new UserDao();
		//ログインテスト
		if (uDao.LoginOK(new Userdata("aaa", "aaa"))) {
			System.out.println("Logintest:テスト成功");

		} else {
			System.out.println("Logintest:テスト失敗");
		}
		//ログイン日数参照テスト
		Loginuser user = new Loginuser("aaa");
		Userdata test1 = uDao.finddaily(user);
		System.out.println("finddailytest:" + test1.getDaily());
		//身長参照テスト
		Userdata test2 = uDao.findheight(user);
		System.out.println("findheighttest:" + test2.getHeight());
		//email参照テスト
		Userdata test3 = uDao.findemail(user);
		System.out.println("findheighttest:" + test3.getEmail());
		//登録変更テスト
		Loginpass pass = new Loginpass("aaa");
		if (uDao.save(new Userdata("", "aaa", 170), pass, user)) {
			System.out.println("savetest:テスト成功");
		} else {
			System.out.println("savetest:テスト失敗");
		}
		//最終ログイン参照テスト
		Userdata test5 = uDao.findlastday("aaa");
		System.out.println("findheighttest:" + test5.getLastlogin());

		//最終ログイン更新テスト
		if (uDao.updatelastday("aaa")) {
			System.out.println("updatelastdaytest:テスト成功");
		} else {
			System.out.println("updatelastdaytest:テスト失敗");
		}
		//ログイン日数更新
		if (uDao.uplogin(user)) {
			System.out.println("uplogintest:テスト成功");
		} else {
			System.out.println("uplogintest:テスト失敗");
		}
	}
}
