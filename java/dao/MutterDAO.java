package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	
	//データベース接続に使用する情報
	private final String JDBC_URL ="jdbc:mysql://localhost:3306/docotsubu?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll() {
		System.out.println("MutterDAOfindAllスタート");
		List<Mutter> mutterList = new ArrayList<>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
	//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			System.out.println("データベース接続1");
			
		//	SELECT文の準備
			String sql = "SELECT * FROM `mutter` ORDER BY ID DESC";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			
			//SELECTを実行して結果表を取得
			ResultSet rs = pSmt.executeQuery();
			
			//結果表に格納されたレコードの内容をEmployeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id= rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				System.out.println("while (rs.next())内");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
				System.out.println("ArrayListに追加");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	public boolean create(Mutter mutter)	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			//INSERT文の準備（idは自動連番なので指定しなくてもよい）
			String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pSmt.setString(1, mutter.getUsername());
			pSmt.setString(2, mutter.getText());
			
			//INSERT文を実行（resulｔには追加された行数が代入される）
			int result = pSmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
