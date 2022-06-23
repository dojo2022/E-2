package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Loginuser;
import model.Userdata;
import model.Weight;

public class WeightDao {
	//目標体重参照
	public Userdata findtagweight(Loginuser user) {
		Connection conn = null;
		Userdata targetwight = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "select TARGETWEIGHT from userdata where userid = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserid());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Userdata tag = new Userdata(
						rs.getDouble("TARGETWEIGHT"));
				targetwight = tag;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			targetwight = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			targetwight = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					targetwight = null;
				}
			}
		}

		return targetwight;

	}

	//体重参照
	public Weight findweight(Loginuser user) {
		Connection conn = null;
		Weight weight = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/w	orkspace/data/healthcare", "sa", "");

			String sql = "select WEIGHT from WEIGHT where userid = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserid());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Weight wg = new Weight(
						rs.getDouble("WEIGHT"));
				weight = wg;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			weight = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			weight = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					weight = null;
				}

			}
		}
		return weight;
	}

	//目標体重登録
	public boolean save(Userdata user, Loginuser use) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");
			String sql = "update userdata set targetweight = ? where userid = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (user.getTargetweight() > 50.0 && user.getTargetweight() < 300.0) {
				pStmt.setDouble(1, user.getTargetweight());
			} else {
				result = false;
			}
			pStmt.setString(2, use.getUserid());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					result = false;
				}
			}
		}

		// 結果を返す
		return result;

	}

	//体重記録の追加

	public boolean save(Userdata user) {
	Connection conn = null;
	boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");
			// SQL文を準備する
			String sql = "update userdata set userid=? weight=? indaily=?";
			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);
	}


    }

}
