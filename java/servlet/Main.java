package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Login;
import model.MojinumLogic;
import model.Mutter;
import model.PostMutterLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						// つぶやきリストをアプリケーションスコープから取得
						//ServletContext application = this.getServletContext();
						//List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
						//取得できなっかた場合は、つぶやきリストを新規作成してアプリケーションスコープに保存
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);	
		
		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
						//if(mutterList == null ) {
						//	mutterList = new ArrayList<>();
						//	application.setAttribute("mutterList", mutterList);
						//	}
						
						////ログインしているか確認の為セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		Login userId = (Login) session.getAttribute("userId");//変更
		
		if(userId == null) { //ログインしていない場合
			// リダイレクト
			response.sendRedirect("/docoTsubu2/");
		} else { //ログイン済み
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_sin3.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
	
		//入力値チェック
		if(text != null && text.length() != 0) {
							////アプリケーションスコープに保存されたつぶやきリストを取得
							//ServletContext application = this.getServletContext();
							//List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
			
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			//User loginUser = (User) session.getAttribute("loginUser");
			Login userId = (Login) session.getAttribute("userId");
			
			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(userId.getUserId(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter); //, mutterList削除
			MojinumLogic.mojinum(mutter);
			
							////アプリケーションスコープにつぶやきリストを保存
							//application.setAttribute("mutterList", mutterList);
							
							////文字数を引く
							//MojinumLogic.mojinum(mutter);
							//application.setAttribute("mutter", mutter);
							
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);		
		
		//メイン画面にフォワード
		//<jsp:include page="/webapp/WEB-INF/jsp/main.jsp" />
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_sin3.jsp");
		dispatcher.forward(request, response);
	}
	
}
