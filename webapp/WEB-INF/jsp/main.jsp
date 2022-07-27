<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

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
<c:out value="${loginUser.name }" />さん、ログイン中<br>
<a href="/docoTsubu/Logout">ログアウト</a><br>

</p>
<p class="pre"><a href="?docoTsubu/Main/">更新</a></p><br>
<form action="/docoTsubu/Main" method="post" class="pre">
<input type="text" name="text">
<input type="submit" value="つぶやく" class="button">
</form>
<c:if test="${not empty errorMsg }">
	<p>${errorMsg}</p>
</c:if>

<c:forEach var="mutter" items="${mutterList}">

	<c:if test="${mutter == mutterList.get(0)}">
	<p><span style="background: linear-gradient(transparent 50%, #ffffff 80%)">残り文字数
	${String.valueOf(mutter.mojinum)}
	文字</span></p>
	</c:if>
	<p><c:out value="${mutter.username}" />:<span style="background: linear-gradient(transparent 50%, #ffff66 80%)"><c:out value="${mutter.text}" /></span></p>
</c:forEach>
<style>
body {
	 height: ${mutterList.size()*16+120}vh;
	 
}
</style>

<jsp:include page="/footer.jsp" />
</body>
</html>