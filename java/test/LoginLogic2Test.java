package test;

import model.Login;
import model.LoginLogic2;

public class LoginLogic2Test {

	public static void main(String[] args) {
		testExecute1(); //ログイン成功テスト
		testExecute2(); //ログイン失敗テスト

	}
	public static void testExecute1() {
		Login login = new Login("minato", "1234");
		LoginLogic2 bo = new LoginLogic2();
		boolean result = bo.execute(login);
		if(result) { 
			System.out.println("testExecute1:成功しました");
		} else {
			System.out.println("testExecute1:失敗しました");
		}
			
	}
	public static void testExecute2() {
		Login login = new Login("minato", "12345");
		LoginLogic2 bo = new LoginLogic2();
		boolean result = bo.execute(login);
		if(!result) {
			System.out.println("testExecute2:成功しました");
		} else {
			System.out.println("testExecute2:失敗しました");
		}
	}
}
