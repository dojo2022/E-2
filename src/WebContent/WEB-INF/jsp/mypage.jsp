<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css" href="/healthcare/css/mypage.css">
</head>
<body onload="test()">
	<div class="wrapper">
		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100"
				height="40">
			<input class="btn buttoncolor" type="button" onclick="location.href='/healthcare/IdentityServlet'"value="登録内容変更">
		</header>
		<nav>
			<ul id="nav">
				<li><a href="/healthcare/MypageServlet">MYページ</a></li>
				<li><a href="/healthcare/BmiServlet">BMI計算</a></li>
				<li><a href="/healthcare/SportServlet">運動計算</a></li>
				<li><a href="/healthcare/MealServlet">食事記録</a></li>
				<li><a href="/healthcare/ContactServlet">お問い合わせ</a></li>
				<li><a href="/healthcare/LoginServlet" id="log_out">ログアウト</a></li>
			</ul>
		</nav>

		<h2 class="pagetitle">MYページ</h2>
		<div class="heading">
			<h3>目標体重<br><c:out value="${tagweight.targetweight}"/>kg</h3>
			<h3>
				あなたは<c:out value="${daily.daily }"/>日連続<br>&emsp;ログインです。
			</h3>
		</div>
		<div class="center">
			<img id="mypageimg" src="/healthcare/img/mypage_sport.png" alt="">
		</div>
		<div class="chart">
			<p class="c_title">体重の推移(折れ線グラフ)</p>
			<p class="c_title">消費カロリーの推移</p>
		</div>
		<div class="chart">
		<div style="width: 500px;">
			<canvas id="chart"></canvas>
		</div>
		<div style="width: 500px;">
			<canvas id="chart"></canvas>
		</div>
		</div>
		<footer class="footer">
			<div class="footer_hone">
				<img src="/healthcare/img/footer.png">
			</div>
			&copy;&copy;Copyright SeHealthCare. All rights reserved.
		</footer>
		<script src="/healthcare/js/common.js" type="text/javascript"></script>
		<script src="/healthcare/js/mypage.js" type="text/javascript"></script>
	</div>
</body>
</html>