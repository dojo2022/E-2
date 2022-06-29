package test;

import dao.ContactDao;
import model.Contact;

public class ContactTest {

	public static void main(String[] args) {
		ContactDao cDao = new ContactDao();
		//問い合わせテスト
		if(cDao.contactin(new Contact("aaa", 1, "aaa@gmail.com", "aaaaaaaaaaaa"))) {
			System.out.println("ContactTest:テスト成功");

		}else {
			System.out.println("ContactTest:テスト失敗");
		}
	}
}
