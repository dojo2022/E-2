package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Userdata;



public class WeightDao {
//目標体重を参照
	public Userdata findtagweight(Userdata use) {
		Connection conn = null;
		Userdata targetwight = null;

		try {
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/healthcare", "sa", "");

			String sql = "select TARGETWEIGHT from userdata";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, use.getUserid());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Userdata tag = new Userdata(
				rs.getDouble("TARGETWEIGHT")
				);
				targetwight = tag;
			}


		}catch (SQLException e) {
				e.printStackTrace();
				targetwight = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				targetwight = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						targetwight = null;
					}
				}
			}

		return targetwight;

	}
}
