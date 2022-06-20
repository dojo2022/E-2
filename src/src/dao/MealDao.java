package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Meal;

public class MealDao {
	public boolean meal(Meal card) {
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
			if (card.getFoodnumber == null && card.getFoodnumber()) {
				pStmt.setInt(2, card.getFoodnumber());
			} else {
				pStmt.setString(2, null);
			}
			if (card.getDaily() != null && !card.getDaily().equals("")) {
				pStmt.setDate(3, (Date) card.getDaily());
			} else {
				pStmt.setString(3, null);
			}
			if (card.getSatiety() != null && !card.getSatiety().equals("")) {
				pStmt.setInt(4, card.getSatiety());
			} else {
				pStmt.setString(4, null);
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
