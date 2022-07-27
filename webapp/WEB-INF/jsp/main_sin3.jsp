<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, model.MojinumLogic, model.Login, java.util.List" %>    
<%
//セッションスコープに保存されたからユーザー情報を取得
Login userId = (Login) session.getAttribute("userId");
//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
System.out.println("アプリケーションスコープに保存されたつぶやきリストを取得");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
String logoUrl = "https://book.impress.co.jp/items/img/stamp_sukkiri-05.png";
String iconUrl = "https://book.impress.co.jp/items/img/stamp_sukkiri-01.png";
String logo2Url = "<img src='layout/stamp_sukkiri-01.png' alt='logo' class='naka'>";
String icon2Url = "<img src='layout/stamp_sukkiri-05.png' alt='icon' >";
String coppe2Url = "<img src='layout/stamp_sukkiri-10.png' alt='icon' >";
String rei2Url = "<img src='layout/stamp_sukkiri-24.png' alt='icon' >";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="./css/style2.css">
<title>どこつぶ</title>
</head>
<body>
<main>
<div class="left_wap">
      <div class="clear1"></div>
      <!--ロゴ-->
        <div class="logo">
           <form action="/docoTsubu2/Main" method="post" class="">
              <button type="submit" value="<%= logo2Url %>" class="b2" name="text"></button>
              </form>
        </div><!--class="logo"-->

        <!--アイコン-->
        <div class="userIcon">
           
              <form action="/docoTsubu2/Main" method="post" class="">
              <button type="submit" value="<%= icon2Url %>" class="b1" name="text"></button>
              </form>
       
        </div><!--class="userIcon"-->
        <div class="coppeIcon">
           
              <form action="/docoTsubu2/Main" method="post" class="">
              <button type="submit" value="<%= coppe2Url %>" class="b3" name="text"></button>
              </form>
       
        </div><!--class="userIcon"-->
        <div class="reiIcon">
           
              <form action="/docoTsubu2/Main" method="post" class="">
              <button type="submit" value="<%= rei2Url %>" class="b4" name="text"></button>
              </form>
       
        </div><!--class="userIcon"-->
    </div><!--class="left_wap"-->


<div class="main_wap">

      <div class="profile_post">
				<h1>どこつぶへようこそ</h1>
				<p class="pre">
				<%= userId.getUserId() %>さん、ログイン中<br>
				</p>
				<form action="/docoTsubu2/Main" method="post" class="pre">
				<input type="text" name="text">
				<input type="submit" value="つぶやく" class="button">
				</form>
				
				
				<% if(errorMsg != null) { %>
					<p><%= errorMsg %></p>
				<% } %>
				
				
					<% for(Mutter mutter : mutterList) {%>
						<div class="postMain">
							<% if(mutter == mutterList.get(0)) {%>
							<p class="pre"><span style="background: linear-gradient(transparent 50%, #ffffff 80%)">残り文字数<%=
							String.valueOf(mutter.getMojinum())
							%>文字</span></p>
							<% } %>
						</div>
						<div class="postMain">
							<p class="pre2"><%= mutter.getUsername() %>:</p><p class="naka2"><span style="background: linear-gradient(transparent 50%, #ffff66 80%)"><%= mutter.getText().replaceAll("(http://|https://){1}[\\w\\.\\-/:]+","<a href='$0'>$0</a>") %></span></p>
						</div>
					<% } %>
				

			</div><!--class="profile_post"-->
        
        <jsp:include page="/footer.jsp" />
        <div class="clear2"></div>
    </div><!--class="main_wap"-->
    
      <div class="right1_wap">
      <!--メニュー-->
           
            <div id="post-area">

                
        	</div>
		</div><!--class="right1_wap"-->


        <div class="right2_wap">

            <p class="search-btn"><img src="layout/search_icon.png" alt="検索"></p>
	            <div id="search-area">
	                <form action="search.php" method="get"  class="search_container" >
	                    <input type="text" name="search" size="25" placeholder="キーワード検索" >
	                    <input type="submit" value="&#xf002">
	                </form>
	            </div><!--class="search-btn"-->
	            <ul>
	              <li><a href="/docoTsubu2/Main"><img src="./layout/koushin.png" alt="Koushin" class="koushin"></a></li>
	              <li><a href="/docoTsubu2/Logout"><img src="./layout/dengen.png" alt="Sign out" class="sign_out"></a></li>
	              <li><a href="https://navi.gifubus.co.jp/Frm_0280.aspx?ge=u9_1l9_35k_4ow_5gs_68h_7rz&id=1su3xq&ia=1su4nl&d=1&t=1455&a=1&r=6hfif&tt=1&kk=1e13uecv_1e15wrwk&cm=1&adcm=1&bkcm=1&ds=%e3%83%86%e3%82%af%e3%83%8e%e3%83%97%e3%83%a9%e3%82%b6%ef%bc%88%ef%bc%b6%ef%bc%b2%e3%83%86%e3%82%af%e3%83%8e%e3%82%b8%e3%83%a3%e3%83%91%e3%83%b3%ef%bc%89&as=%e4%b8%89%e6%9f%bf%e9%87%8e%e9%a7%85&inpym=2022%2f07&inpymd=2022%2f07%2f07&inpt=1455&inpa=1&tgcnt=1"><img src="./layout/bus.png" alt="Sign out" class="sign_out"></a></li>
	              
	            </ul>
         </div><!--class="right2_wap"-->
    <div class="clear"></div>
  </main>

</body>
</html>