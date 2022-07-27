<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>    
<%
//セッションスコープからユーザー情報取得
User loginUser = (User) session.getAttribute("loginUser");
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
<% if(loginUser != null) { %>
<P>ログインに成功しました</P>
<p>ようこそ<%= loginUser.getName() %>さん</p>
<a href="/docoTsubu2/Main" class="pre">つぶやき投稿・閲覧へ</a>
<% } else { %>
<p class="pre">ログインに失敗しました</p>
<a href="/docoTsubu/" class="pre">TOPへ</a>
<% } %>
<jsp:include page="/footer.jsp" />
</body>
</html>