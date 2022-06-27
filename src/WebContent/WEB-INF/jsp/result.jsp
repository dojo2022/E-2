<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>healthcare</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css" href="/healthcare/css/result.css">
</head>
<body>

	<div class="wrapper">
		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100" height="40">
		</header>
		<h2 class="pagetitle">エラー</h2>
		<div class="text">
			<p></p>
			<p class="boxes"><c:out value="${result.title}" /></p>
			<img class="image" src="/healthcare/img/お問い合わせ完了.png">
		</div>
		<div class="button">
			<input class="" type="button"
				onclick="location.href='${result.backTo}'" value="${result.message}">
		</div>
		<footer class="footer">
			<div class="footer_hone">
				<img src="/healthcare/img/footer.png">
			</div>
			&copy;Copyright SeHealthCare. All rights reserved.
		</footer>
	</div>
</body>
</html>