<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SeHealthCare</title>
<link rel="stylesheet" type="text/css" href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css" href="/healthcare/css/login.css">
</head>
<body>
	<header>
		<img src="/healthcare/img/">
	</header>

	<h2 class="pagetitle">ログイン</h2>
	<form id="form" method="POST" action="/healthcare/LoginServlet" style="text-align:center">
		<table class="log">
			<tr>
				<td>ID</td><td><input type="text" name="ID"></td>
			</tr>

			<tr>
				<td>PW</td><td><input type="password" name="PW"></td>
			</tr>
		</table>

		<input class="button" type="submit" name="LOGIN" value="login">
	</form>

	<form id="form" method="POST" action="/healthcare/SignupServlet" style="text-align:center">
		<input type="submit" name="signup" value="新規登録">
	</form>


	<p style="text-align:center">ユーザーではない方は新規登録が必要です。</p>
	<footer class="footer">
		<div class="">
			<img src="/healthcare/img/footer.png">
		</div>
		&copy;&copy;Copyright SeHealthCare. All rights reserved.


	</footer>
</body>
</html>