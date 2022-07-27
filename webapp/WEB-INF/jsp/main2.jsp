<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, model.MojinumLogic, java.util.List" %>    
<%
//セッションスコープに保存されたからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="./css/style.css">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<p class="pre">
<%= loginUser.getName() %>さん、ログイン中<br>
<a href="/docoTsubu/Logout">ログアウト</a><br>

</p>
<p class="pre"><a href="?docoTsubu/Main/">更新</a></p><br>
<form action="/docoTsubu/Main" method="post" class="pre">
<input type="text" name="text">
<input type="submit" value="つぶやく" class="button">
</form>
<% if(errorMsg != null) { %>
	<p><%= errorMsg %></p>
<% } %>
<style>
body {
	 height: <%= mutterList.size()*16+120 %>vh;
}
</style>
<%
	int lastIdx = mutterList.size() - 1;
%>
<% for(Mutter mutter : mutterList) {%>
	<% if(mutter == mutterList.get(0)) {%>
	<p><span style="background: linear-gradient(transparent 50%, #ffffff 80%)">残り文字数<%=
	String.valueOf(mutter.getMojinum())
	%>文字</span></p>
	<% } %>
	<p><%= mutter.getUsername() %>:<span style="background: linear-gradient(transparent 50%, #ffff66 80%)"><%= mutter.getText().replaceAll("(http://|https://){1}[\\w\\.\\-/:]+","<a href='$0'>$0</a>") %></span></p>
<% } %>
<jsp:include page="/footer.jsp" />
</body>
</html>