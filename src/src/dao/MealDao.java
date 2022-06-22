package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Caloriesout;
import model.Meal;

public class MealDao {

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
				String sql = "SELECT * FROM meal WHERE userid = ?";

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

	//食事記録の登録
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
			if (card.getFoodnumber() != (0 & card.getFoodnumber())) {
				pStmt.setInt(2, card.getFoodnumber());
			} else {
				pStmt.setString(2, null);
			}
			if (card.getDaily() != null & !card.getDaily().equals("")) {
				pStmt.setString(3, card.getDaily());
			} else {
				pStmt.setString(3, null);
			}
			if (card.getSatiety() != (0 & card.getSatiety())) {
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

	// 食事記録の過去データの参照
	public List<Meal> select(Meal param) {
		Connection conn = null;
		List<Meal> cardList = new ArrayList<Meal>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/data/healthcare", "sa", "");

			// SQL文を準備する
			String sql = "select userid, foodnumber, daily from MEAL WHERE userid LIKE ? AND foodnumber LIKE ? AND daily LIKE ? ORDER BY userid, foodnumber, daily";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUserid() != null) {
				pStmt.setString(1, "%" + param.getUserid() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getFoodnumber() != 0) {
				pStmt.setInt(2 + param.getFoodnumber(), 0);
			}
			if (param.getDaily() != null) {
				pStmt.setString(3, "%" + param.getDaily() + "%");
			} else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Meal card = new Meal(
						rs.getString("userid"),
						rs.getInt("foodnumber"),
						rs.getString("daily"),
						rs.getString("meal"),
						rs.getInt("satiety"));
				cardList.add(card);
			}


		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		// 結果を返す
		return cardList;
	}

	//画像参照
	public Meal imgfind() {
		Connection conn = null;
		Meal meal = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "select meal from meal ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, use.getUserid());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Meal me = new Meal(
						rs.getString("meal"));
				meal = me;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			meal = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			meal = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					meal = null;
				}

			}
		}
		return meal;
	}

	//満足度参照
		public Meal satifind() {
			Connection conn = null;
			Meal satiety = null;

			try {
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

				String sql = "select satiety from meal ";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//pStmt.setString(1, use.getUserid());
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					Meal sati = new Meal(
							rs.getInt("satiety"));
					satiety = sati;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				satiety = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				satiety = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						satiety = null;
					}

				}
			}
			return satiety;
		}
}
