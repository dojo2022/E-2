<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI計算</title>
<link rel="stylesheet" type="text/css" href="/healthcare/css/bmi.css">
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100" height="40">
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
		<script src="/healthcare/js/common.js" type="text/javascript"></script>
		<script src="/healthcare/js/bmi.js" type="text/javascript"></script>
		<div class="bmi">
			<h2 class="pagetitle">BMI計算</h2>
			<img id="bmiimg" src="/healthcare/img/bmi.png" alt="">
		</div>

		<p>
			BMI(Body Masss Index)は、体重と身長から算出する肥満度を表す体格指数(栄養指数)<br>
			です。一般の18歳以上が対象で、筋肉量の多いアスリートの指数には用いられません。<br>
			幼児にはカウプ指数、童子には、ローレル指数が用いられます。
		</p>
		<div class="center">
			<p>空白に数値を入れて「計算」ボタンを押してください。</p>
			<div>BMI = 体重 ÷ (身長 × 身長)</div>

			<div class="">
				<p>
					身長<input class="text" type="text" id="height" value="">cm
				</p>
				<p>

					体重<input class="text" type="text" id="weight"value="${weight.weight}">kg

				</p>
			</div>

			<span id="error_message" style="color: red"></span><br>
			 <input
				class="buttoncolor" type="button" value="計算" id="btn"
				onclick="test()">
		</div>
		<br>
		<div  class="butbmi" id="butbmi">
		あなたのBMIは〇〇です
		</div>
		<div class=""></div>

		<table class="mg">
			<tr>
				<th id="t_name" colspan="2">日本肥満学会の肥満度判定基準</th>
			</tr>
			<tr id="i_name">
				<th>BMI</th>
				<th>判定</th>
			</tr>
			<tr>
				<td>18.5未満</td>
				<td>低体重(やせ)</td>
			</tr>
			<tr>
				<td>18.5～25未満</td>
				<td>普通体重</td>
			</tr>
			<tr>
				<td>25～30未満</td>
				<td>肥満(1度)</td>
			</tr>
			<tr>
				<td>30～35未満</td>
				<td>肥満(2度)</td>
			</tr>
			<tr>
				<td>35～40未満</td>
				<td>肥満(3度)</td>
			</tr>
			<tr>
				<td>40以上</td>
				<td>肥満(4度)</td>
			</tr>
		</table>
		<footer class="footer">
			<div class="footer_hone">
				<img src="/healthcare/img/footer.png">
			</div>
			&copy;&copy;Copyright SeHealthCare. All rights reserved.
		</footer>
	</div>
</body>
</html>