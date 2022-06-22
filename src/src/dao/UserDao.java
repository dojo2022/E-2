package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Loginpass;
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
	public Userdata finddaily(Object userid) {

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

	//新規登録
	public boolean userdata(Userdata user) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "insert into userdata (userid, password , email, gender, birth, targetweight,daily,lastlogin,height) "
					+ "values (?, ?, ?, ? ,? ,?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, use.getUserid());
			pStmt.executeQuery();

			if (user.getUserid() != null && !user.getUserid().equals("")) {
				pStmt.setString(1, user.getUserid());
			} else {
				result = false;
			}
			if (user.getPassword() != null && !user.getPassword().equals("")) {
				pStmt.setString(2, user.getPassword());
			} else {
				result = false;
			}

			if (user.getEmail() != null && !user.getEmail().equals("")) {
				pStmt.setString(3, user.getEmail());
			} else {
				result = false;
			}

			if (user.getGender() != null && !user.getGender().equals("")) {
				pStmt.setString(4, user.getGender());
			} else {
				result = false;
			}

			if (user.getBirth() != null) {
				pStmt.setDate(5, user.getBirth());
			} else {
				result = false;
			}

			if (user.getTargetweight() != 0) {
				pStmt.setDouble(6, user.getTargetweight());
			} else {
				result = false;
			}
			if (user.getDaily() != 0) {
				pStmt.setInt(7, user.getDaily());
			} else {
				result = false;
			}
			if (user.getLastlogin() != null) {
				pStmt.setDate(8, user.getLastlogin());
			} else {
				result = false;
			}
			if (user.getHeight() != 0) {
				pStmt.setDouble(9, user.getHeight());
			} else {
				result = false;
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
				} catch (SQLException e) {
					e.printStackTrace();
					result = false;
				}

			}
		}
		return result;
	}
//身長参照
	public Userdata findheight() {
		Connection conn = null;
		Userdata height = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "select * from userdata ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, use.getUserid());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Userdata hg = new Userdata(
						rs.getString("userid"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("gender"),
						rs.getDate("birth"),
						rs.getDouble("TARGETWEIGHT"),
						rs.getInt("daily"),
						rs.getDate("lastlogin"),
						rs.getDouble("height"));
				height = hg;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			height = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			height = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					height = null;
				}

			}
		}
		return height;
	}

	//email参照
	public Userdata findemail() {
		Connection conn = null;
		Userdata email = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "select email from userdata";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, use.getUserid());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Userdata em = new Userdata(
						rs.getString("email"));
				email = em;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			email = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			email = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					email = null;
				}

			}
		}
		return email;
	}
	//登録変更
	public boolean save(Userdata user, Loginpass pass) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");
			String sql = "update userdata set password=?, email=?, height=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (user.getPassword() != null && !user.getPassword().equals("")) {
				pStmt.setString(1, user.getPassword());
			} else {
				pStmt.setString(1, pass.getPassword());
			}
			if (user.getEmail() != null && !user.getEmail().equals("")) {
				pStmt.setString(2, user.getEmail());
			} else {
				result = false;
			}
			if (user.getHeight() > 50.0  && user.getHeight() < 300.0){
				pStmt.setDouble(3, user.getHeight());
			} else {
				result = false;
			}

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

}

