package test;

import java.util.List;

import dao.SportDao;
import model.Caloriesout;
import model.Loginuser;

public class Sportstest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SportDao sDao = new SportDao();
		Loginuser user = new Loginuser("aaa");
		//ユーザーID参照テスト
		Caloriesout test1 = sDao.selectById("aaa");
		System.out.println("selectByIdtest:" + test1.getUserid());

		//時間参照テスト
		java.sql.Date time1 = java.sql.Date.valueOf("2022-06-28");
		Caloriesout test2 = sDao.selectByindaily("aaa", time1);
		System.out.println("selectByindailytest:" + test2.getIndaily());
		//消費カロリーテスト(ユーザーIDなし)
		Loginuser test3 = new Loginuser("asdf");
		Caloriesout out1 = new Caloriesout(1000, time1);
		if (sDao.save(out1, test3)) {
			System.out.println("save1test:テスト成功");
		} else {
			System.out.println("save1test:テスト失敗");
		}

		//消費カロリーテスト(時間なし)
		java.sql.Date time2 = java.sql.Date.valueOf("2022-06-29");
		Caloriesout out2 = new Caloriesout(1000, time2);
		if (sDao.save(out2, user)) {
			System.out.println("save2test:テスト成功");
		} else {
			System.out.println("save2test:テスト失敗");
		}

		//消費カロリーテスト(時間あり、ユーザーIDあり)
		java.sql.Date time3 = java.sql.Date.valueOf("2022-06-28");
		Caloriesout out3 = new Caloriesout(1000, time3);
		if (sDao.save(out3, user)) {
			System.out.println("save2test:テスト成功");
		} else {
			System.out.println("save2test:テスト失敗");
		}

		//今日の消費カロリー参照テスト
		Caloriesout test4 = sDao.findcalo(user);
		System.out.println("selectByIdtest:" + test4.getCaloriesout());

		//指定日の消費カロリー参照テスト
		java.sql.Date time4 = java.sql.Date.valueOf("2022-06-23");
		Caloriesout test5 = sDao.findcalo(user, time4);
		System.out.println("selectByIdtest:" + test5.getCaloriesout());

		//全ての消費カロリー参照テスト
		List<Caloriesout> test6 = sDao.findAll(user);
		for(Caloriesout caloris : test6) {
			System.out.println("Caloriesout:" + caloris.getCaloriesout());
		}

	}

}
