package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Meal;

public class MealDao {
	public boolean insert(Meal card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/data/healthcare", "sa", "");

			// SQL文を準備する
			String sql = "insert into meal (userid, foodnumber, daily, meal, satiety) values (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUserid() != null && !card.getUserid().equals("")) {
				pStmt.setString(1, card.getUserid());
			} else {
				pStmt.setString(1, null);
			}
			if (card.getFoodnumber() = null && !card.getFoodnumber().equals("")) {
				pStmt.setInt(2, card.getFoodnumber());
			} else {
				pStmt.setString(2, null);
			}
			if (card.getMail() != null && !card.getMail().equals("")) {
				pStmt.setString(3, card.getMail());
			} else {
				pStmt.setString(3, null);
			}
			if (card.getAddress() != null && !card.getAddress().equals("")) {
				pStmt.setString(4, card.getAddress());
			} else {
				pStmt.setString(4, null);
			}
			if (card.getName() != null && !card.getName().equals("")) {
				pStmt.setString(5, card.getName());
			} else {
				pStmt.setString(5, null);
			}
			if (card.getPost() != null && !card.getPost().equals("")) {
				pStmt.setString(6, card.getPost());
			} else {
				pStmt.setString(6, null);
			}
			if (card.getPhone() != null && !card.getPhone().equals("")) {
				pStmt.setString(7, card.getPhone());
			} else {
				pStmt.setString(7, null);
			}
			if (card.getEmail() != null && !card.getEmail().equals("")) {
				pStmt.setString(8, card.getEmail());
			} else {
				pStmt.setString(8, null);
			}
			if (card.getRemarks() != null && !card.getRemarks().equals("")) {
				pStmt.setString(9, card.getRemarks());
			} else {
				pStmt.setString(9, null);
			}
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
