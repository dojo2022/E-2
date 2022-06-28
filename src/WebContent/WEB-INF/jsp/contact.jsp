<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SeHealthCare</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/contact.css">
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
		<div class="img">
			<h2 class="pagetitle">お問い合わせ</h2>
			<img class="image" src="/healthcare/img/contact.png">
		</div>
		<form method="POST" action="/healthcare/ContactcompleteServlet">
			<table class="center">
				<tr>
					<td>ID</td>
					<td><input class="regi" type="text" name="ID"value="${userid.userid }" readonly></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input class="regi" type="text" id="email"value="${email.email}" name="EMAIL"></td>
				</tr>
			</table>
			<table class="moji">
				<tr>
					<td>お問い合わせ内容</td>
				<tr>
					<td><textarea name="TEXT" id="contents" class="regi"></textarea></td>
				</tr>
			</table>
			<p class="moj">＊1000文字以内で入力してください</p>
			<div class="center">
				<span id="error_message" style="color: red" style="textalign:center"></span><br>
			</div>
			<div class="mo ">
				<input class="buttoncolor" type="submit" value="この内容で問い合わせる"
					onclick="return con()">
			</div>
		</form>
	</div>
	<script src="/healthcare/js/common.js" type="text/javascript"></script>
	<script src="/healthcare/js/contact.js" type="text/javascript"></script>
	<footer class="footer">
		<div class="footer_hone">
			<img src="/healthcare/img/footer.png">
		</div>
		&copy;Copyright SeHealthCare. All rights reserved.
	</footer>
</body>
</html>