package test;

import dao.UserDao;
import model.Userdata;

public class Usertest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		UserDao uDao = new UserDao();
		//ログインテスト
		if(uDao.LoginOK(new Userdata("aaa","aaa"))) {
			System.out.println("Logintest:テスト成功");

		}else {
			System.out.println("Logintest:テスト失敗");
		}
		//ログイン日数テスト
		Userdata test1 = uDao.finddaily(Loginuser("aaa"));
	}
}
