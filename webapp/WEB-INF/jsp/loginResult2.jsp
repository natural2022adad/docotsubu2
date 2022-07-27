<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Login" %>    
<%
//セッションスコープからユーザー情報取得
Login userId = (Login) session.getAttribute("userId");
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
<h1>どこつぶログイン</h1>
<% if(userId != null) { %>
<P>ログインに成功しました</P>
<p>ようこそ<%= userId.getUserId() %>さん</p>
<a href="/docoTsubu2/Main" class="pre">つぶやき投稿・閲覧へ</a>
<% } else { %>
<p class="pre">ログインに失敗しました</p>
<a href="/docoTsubu/WelcomeServlet" class="pre">TOPへ</a>
<% } %>
<jsp:include page="/footer.jsp" />
</body>
</html>