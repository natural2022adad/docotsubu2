package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	
	private final String JDBC_URL ="jdbc:mysql://localhost:8889/docotsubu?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	
	
	
	public Account findByLogin(Login login) {
		System.out.println("AccountDAOfindByLoginスタート");
		Account account = null;
		
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
			String sql = "SELECT * FROM `account` WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, login.getUserId());
			pSmt.setString(2, login.getPass());
			
			//SELECTを実行して結果表を取得
			ResultSet rs = pSmt.executeQuery();
			
			//結果表に格納されたレコードの内容をAccuontインスタンスに設定し、Accuontインスタンスに追加
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age= rs.getInt("AGE");
				System.out.println("if (rs.next())内");
				account = new Account(userId, pass, mail, name, age);
				System.out.println("Accountに追加");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

}
