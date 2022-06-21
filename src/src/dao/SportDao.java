package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Caloriesout;

public class SportDao {
	//ユーザーのIDを参照
	public Caloriesout selectById(String userid) {
		Connection conn = null;
		//今回は1件だけを返すメソッドなのでArrayListではない
		Caloriesout ret = new Caloriesout();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/DojoSample/data/dojosample", "sa",
					"");

			// SQL文を準備する
			String sql = "SELECT * FROM caloriesout WHERE id = ?";

			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userid);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//0件のケースもある
			if (rs.next()) {
				//next()がtrue＝1件のデータが取れた
				ret.setUserid(rs.getString("userid"));
			} else {
				//next()がfalse＝データが無い
				ret = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					ret = null;
				}
			}
		}
		return ret;

	}

	//時間を参照
	public Caloriesout selectByindaily(Date date) {
		Connection conn = null;
		//今回は1件だけを返すメソッドなのでArrayListではない
		Caloriesout ret = new Caloriesout();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/DojoSample/data/dojosample", "sa",
					"");

			// SQL文を準備する
			String sql = "SELECT * FROM caloriesout WHERE id = ?";

			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setDate(1, date);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//0件のケースもある
			if (rs.next()) {
				//next()がtrue＝1件のデータが取れた
				ret.setUserid(rs.getString("indaily"));
			} else {
				//next()がfalse＝データが無い
				ret = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					ret = null;
				}
			}
		}
		return ret;

	}

	//消費カロリーを保存
	public Boolean save(Caloriesout item) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/DojoSample/data/dojosample", "sa",
					"");

			Caloriesout target = this.selectById(item.getUserid());
			Caloriesout time = this.selectByindaily(item.getIndaily());
			if (target == null) {
				//idでデータが取れない＝新規作成
				// INSERT用SQL文を準備する
				String sql = "INSERT INTO caloriesout (userid, indaily, caloriesout) values (?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//パラメータ（データの値）を設定する
				if (item.getUserid() != null && !item.getUserid().equals("")) {
					pStmt.setString(1, item.getUserid());
				} else {
					result = false;
				}
				if (item.getIndaily() != null && !item.getIndaily().equals("")) {
					pStmt.setDate(2, item.getIndaily());
				} else {
					result = false;
				}
				pStmt.setInt(3, item.getCaloriesout());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			} else {
				if (time != null || time.equals(item.getIndaily())) {
					//idでデータが取れた＝更新
					// UPDATE用SQL文を準備する
					String sql = "UPDATE caloriesout SET caloriesout = ? WHERE userid = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					//パラメータ（データの値）を設定する
					//更新する値(SET caloriesout = ?)
					pStmt.setInt(1, item.getCaloriesout());
					//検索条件(WHERE userid = ?)
					pStmt.setString(2, item.getUserid());

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				}else {
					//日付が違っていたら
					String sql = "INSERT INTO caloriesout (userid, indaily, caloriesout) values (?,?,?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					//パラメータ（データの値）を設定する
					if (item.getUserid() != null && !item.getUserid().equals("")) {
						pStmt.setString(1, item.getUserid());
					} else {
						result = false;
					}
					if (item.getIndaily() != null && !item.getIndaily().equals("")) {
						pStmt.setDate(2, item.getIndaily());
					} else {
						result = false;
					}
					pStmt.setInt(3, item.getCaloriesout());

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}
}
