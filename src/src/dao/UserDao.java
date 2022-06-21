package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Userdata;

public class UserDao {
	// ログインできるならtrueを返す
	public boolean LoginOK(Userdata Userdata) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from USERDATA  where USERID = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Userdata.getUserid());
			pStmt.setString(2, Userdata.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
//ログイン日数参照
	public Userdata finddaily(Userdata use) {

		Connection conn = null;
		Userdata daily = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "select DAILY from userdata";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, use.getUserid());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Userdata day = new Userdata(
						rs.getDouble("DAILY"));
				daily = day;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			daily = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			daily = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					daily = null;
				}

			}
		}
		return daily;
	}

	//身長参照
	public boolean userdata(Userdata user) {
		Connection conn = null;
		boolean height= false;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "insert into userdata (userid, password , email, gender, birth, targetweight,daily,lastlogin,height) "
					+ "values (?, ?, ?, ? ,? ,?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, use.getUserid());
			ResultSet rs = pStmt.executeQuery();

			if (user.getUserid() != null && ! user.getUserid().equals("")) {
				pStmt.setString(1, user .getUserid());
			}
			else {
				height= false;
			}
			if  (user.getPassword() != null && ! user.getPassword().equals("")) {
			  pStmt.setString(2, user.getPassword());
			}
			else {
				height= false;
			}

			if  (user.getEmail() != null && ! user.getEmail().equals("")) {
				  pStmt.setString(3, user.getEmail());
				}
				else {
					height = false;
				}

			if  (user.getGender() != null && ! user.getGender().equals("")) {
				  pStmt.setString(4, user.getGender());
				}
				else {
					height= false;
				}

			if  (user.getBirth()!= null && user.getBirth().equals("")) {
				  pStmt.setDate(5, user.getBirth());
				}
				else {
					height= false;
				}

			if  (user.getTargetweight()!=  null && ! user.getTargetweight().equals("")) {
				  pStmt.setDouble(6, user.getTargetweight());
				}
				else {
					height= false;
				}
			if  (user.getDaily()!= null && ! user.getDaily().equals("")) {
				  pStmt.setInt(7, user.getDaily());
				}
				else {
					height = false;
				}
			if  (user.getLastlogin()!=null && ! user.getLastlogin().equals("")) {
				  pStmt.setDate(8, user.getLastlogin());
				}
				else {
					height = false;
				}
			if  (user.getHeight()null && ! user.getHeight().equals("")) {
				  pStmt.setDouble(9, user.getHeight());
				}
				else {
					height= false;
				}

		} catch (SQLException e) {
			e.printStackTrace();
			height = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			height = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					height = false;
				}

			}
		}
		return height;
	}
}
