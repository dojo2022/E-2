package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import model.Weight;

public class WeightDao {
  public boolean insert(Weight weight){
	  Connection conn = null;
	  boolean result = false;

	  try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/data/healthcare", "sa", "");

			//SQL文を準備
	return result;
  }
}
