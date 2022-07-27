package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic2;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index2.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		//ログインの処理の実行
		Login login = new Login(userId, pass);
		LoginLogic2 bo = new LoginLogic2();
		boolean result = bo.execute(login);
		System.out.println("ログイン実行中1");
		//
		if(result) { 
			System.out.println("ログイン実行中2_if文");
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId",login);//loginに変えた
			System.out.println("ログイン成功！！");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginResult2.jsp");
			dispatcher.forward(request, response);
			
		} else {
			System.out.println("ログイン失敗");
			//リダイレクト
			response.sendRedirect("/docoTsubu2/LoginServlet");
		}
	}

}
