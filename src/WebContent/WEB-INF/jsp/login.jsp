<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SeHealthCare</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css" href="/healthcare/css/login.css">
</head>
<body>
	<script defer src="/healthcare/js/common.js" type="text/javascript"></script>
	<script defer src="/healthcare/js/login.js" type="text/javascript"></script>

	<div class="wrapper">


		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" alt="" width="100"
				height="40">
		</header>

		<h2 class="pagetitle">ログイン</h2>
		<form id="form" method="POST" action="/healthcare/MypageServlet"
			style="text-align: center">
			<table id="regichan">
				<tr>
					<td>ID</td>
					<td><input class="regi" type="text" id="id" name="ID"></td>
				</tr>

				<tr>
					<td>PW</td>
					<td><input class="regi" type="password" id="pw" name="PW"></td>
				</tr>
			</table>

			<p>
				<input class="buttoncolor" type="submit" name="submit" value="login">
			</p>
		</form>

		<form id="form" method="POST" action="/healthcare/SignupServlet"
			style="text-align: center">
			<p>
				<input class="buttoncolor" type="submit" name="submit" value="新規登録">
			</p>


			<span id="error_message" style="color: red"></span><br>
		</form>



		<p style="text-align: center">ユーザーではない方は新規登録が必要です。</p>
		<footer class="footer">
			<div class="footer_hone">
				<img src="/healthcare/img/footer.png">
			</div>
			&copy;&copy;Copyright SeHealthCare. All rights reserved.


		</footer>
	</div>

</body>
</html>