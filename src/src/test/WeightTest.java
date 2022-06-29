package test;

import dao.WeightDao;
import model.Aveweight;

public class WeightTest {

	public static void main(String[] args) {
		WeightDao wDao = new WeightDao();
		/*
		//目標体重参照テスト
		Userdata test1 = wDao.findtagweight(new Loginuser("aaa"));
		if (test1 != null) {
			System.out.println("WeightTest:テスト成功");
		} else {
			System.out.println("WeightTest:テスト失敗");
		}
		*/

		/*
		//体重参照
		Weight test1 = wDao.findweight(new Loginuser("aaa"));
		if (test1 != null) {
			System.out.println("WeightTest:テスト成功");
		} else {
			System.out.println("WeightTest:テスト失敗");
		}
		*/

		/*
		//目標体重登録
		if (wDao.save(new Userdata(60.0),new Loginuser("aaa"))) {
			System.out.println("WeightTest:テスト成功");

		} else {
			System.out.println("WeightTest:テスト失敗");
		}
		*/

		/*
		//体重の記録追加
		java.sql.Date time = java.sql.Date.valueOf("2022-06-28");
		if (wDao.saveweight(new Weight("aaa", 75.0, time))) {
			System.out.println("WeightTest:テスト成功");

		} else {
			System.out.println("WeightTest:テスト失敗");
		}
		*/

		/*
		List<Weight> findlist = wDao.findAll(new Loginuser("aaa"));
		if (findlist != null) {
			System.out.println("WeightTest:テスト成功");
		} else {
			System.out.println("WeightTest:テスト失敗");
		}
		*/


		int ages = 25;
		String gender = "男性";
		Aveweight test1 = wDao.selectave(ages, gender);
		if (test1 != null) {
			System.out.println("WeightTest:テスト成功");
		} else {
			System.out.println("WeightTest:テスト失敗");
		}

	}
}
