package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contact;

public class ContactDao {

	public boolean contactin (Contact contactin) {
		Connection conn = null;
		boolean result = false ;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			// SQL文を準備する
			String sql = "insert into contact (userid, email, contact) values (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			if (contactin.getUserid() != null && !contactin.getUserid().equals("")) {
				pStmt.setString(1, contactin.getUserid());
			}
			else {
				result = false;
			}
			if (contactin.getEmail() != null && !contactin.getEmail().equals("")) {
				pStmt.setString(2, contactin.getEmail());
			}
			else {
			    result = false;
			}
			if (contactin.getContact() != null && !contactin.getContact().equals("")) {
				pStmt.setString(3, contactin.getContact());
			}
			else {
				result = false;
			}
			// SQL文を実行する
						if (pStmt.executeUpdate() == 1) {
							result = true;
			}
		}

						catch (SQLException e) {
							e.printStackTrace();
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						finally {
							// データベースを切断
							if (conn != null) {
								try {
									conn.close();
								}
								catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}

						// 結果を返す
						return result ;
					}
}

