package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Caloriesout;
import model.Loginuser;
import model.Userdatas;

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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa",
					"");

			// SQL文を準備する
			String sql = "SELECT * FROM caloriesout WHERE userid = ?";

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
	public Caloriesout selectByindaily(String user, Date time) {
		Connection conn = null;
		//今回は1件だけを返すメソッドなのでArrayListではない
		Caloriesout ret = new Caloriesout();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa",
					"");
			// SQL文を準備する
			String sql = "SELECT * FROM caloriesout WHERE userid = ? AND indaily = ?";
			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user);
			pStmt.setDate(2, time);
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//0件のケースもある
			if (rs.next()) {
				//next()がtrue＝1件のデータが取れた
				ret.setIndaily(rs.getDate("indaily"));
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
	public Boolean save(Caloriesout item, Loginuser user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa",
					"");

			Caloriesout target = this.selectById(user.getUserid());
			Caloriesout time = this.selectByindaily(user.getUserid(), item.getIndaily());
			if (target == null) {
				//idでデータが取れない＝新規作成
				// INSERT用SQL文を準備する
				String sql = "INSERT INTO caloriesout (userid, indaily, caloriesout) values (?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//パラメータ（データの値）を設定する
				if (user.getUserid() != null && !user.getUserid().equals("")) {
					pStmt.setString(1, user.getUserid());
				} else {
					result = false;
				}
				if (item.getIndaily() != null && !item.getIndaily().equals("")) {
					pStmt.setDate(2, item.getIndaily());
				} else {
					result = false;
				}
				if (item.getCaloriesout() > -1) {
					pStmt.setInt(3, item.getCaloriesout());
				} else {
					result = false;
				}
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			} else {
				if (time != null && time.getIndaily().equals(item.getIndaily())) {
					//idでデータが取れた＝更新
					// UPDATE用SQL文を準備する
					String sql = "UPDATE caloriesout SET caloriesout = ? WHERE userid = ? AND indaily = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					//パラメータ（データの値）を設定する
					//更新する値(SET caloriesout = ?)
					if (item.getCaloriesout() > -1) {
						pStmt.setInt(1, item.getCaloriesout());
					} else {
						result = false;
					}
					//検索条件(WHERE userid = ?)
					if (user.getUserid() != null && !user.getUserid().equals("")) {
						pStmt.setString(2, user.getUserid());
					} else {
						result = false;
					}
					if (item.getIndaily() != null && !item.getIndaily().equals("")) {
						pStmt.setDate(3, item.getIndaily());
					} else {
						result = false;
					}
					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				} else {
					//日付が違っていたら
					String sql = "INSERT INTO caloriesout (userid, indaily, caloriesout) values (?,?,?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					//パラメータ（データの値）を設定する
					if (user.getUserid() != null && !user.getUserid().equals("")) {
						pStmt.setString(1, user.getUserid());
					} else {
						result = false;
					}
					if (item.getIndaily() != null && !item.getIndaily().equals("")) {
						pStmt.setDate(2, item.getIndaily());
					} else {
						result = false;
					}
					if (item.getCaloriesout() > -1) {
						pStmt.setInt(3, item.getCaloriesout());
					} else {
						result = false;
					}

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

	//今日の消費カロリーを表示
	public Caloriesout findcalo(Loginuser user) {
		Connection conn = null;
		Caloriesout calorie = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");
			Userdatas users = new Userdatas();
			Date todays = users.today();

			String sql = "select caloriesout from caloriesout where userid = ? AND indaily = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			if (user.getUserid() != null && !user.getUserid().equals("")) {
				pStmt.setString(1, user.getUserid());
			} else {
				calorie = null;
			}
			if (todays != null && !todays.equals("")) {
				pStmt.setDate(2, todays);
			} else {
				calorie = null;
			}
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Caloriesout tag = new Caloriesout(
						rs.getInt("caloriesout"));
				calorie = tag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			calorie = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			calorie = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					calorie = null;
				}
			}
		}

		return calorie;

	}

	//日にちに対応した消費カロリーを表示
	public Caloriesout findcalo(Loginuser user, Date date) {
		Connection conn = null;
		Caloriesout calorie = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");
			String sql = "select caloriesout from caloriesout where userid = ? AND indaily = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			if (user.getUserid() != null && !user.getUserid().equals("")) {
				pStmt.setString(1, user.getUserid());
			} else {
				calorie = null;
			}
			if (date != null && !date.equals("")) {
				pStmt.setDate(2, date);
			} else {
				calorie = null;
			}
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Caloriesout tag = new Caloriesout(
						rs.getInt("caloriesout"));
				calorie = tag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			calorie = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			calorie = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					calorie = null;
				}
			}
		}

		return calorie;

	}

	//すべての消費カロリーを参照
	public List<Caloriesout> findAll(Loginuser user) {
		Connection conn = null;
		List<Caloriesout> findlist = new ArrayList<Caloriesout>();

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "select caloriesout from caloriesout where userid = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserid());

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Caloriesout co = new Caloriesout(
						rs.getInt("caloriesout"));
				findlist.add(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			findlist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			findlist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					findlist = null;
				}

			}
		}
		return findlist;
	}
}
