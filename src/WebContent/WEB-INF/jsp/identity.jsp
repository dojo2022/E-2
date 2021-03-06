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
	href="/healthcare/css/identiity.css">
	<link rel="icon" href="/healthcare/img/favicon.ico" id="favicon">
<link rel="/healthcare/img/apple-touch-icon" sizes="180x180" href="/apple-touch-icon-180x180.png">
</head>
<body>
	<script defer src="/healthcare/js/identity.js" type="text/javascript"></script>
	<div class="wrapper">

		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100" height="40">
		</header>
		<div class="center">
			<h2 class="pagetitle">本人確認</h2>
			<form id="form" method="POST"
				action="/healthcare/IdentityServlet">
				<table id="identity">
					<tr>
						<td>ID</td>
						<td><input class="regi" id="email" type="text" name="ID"></td>
					</tr>

					<tr>
						<td>PW</td>
						<td><input class="regi" id="pw" type="password"
							name="PW"></td>
					</tr>

				</table>
				<span id="error_message" style="color: red"></span> <br>
				<table id="identity">
					<tr>
						<td><input class="button" type="submit" name="regist"
							value="認証"></td>
					</tr>
				</table>

			</form>
			<p class="back">
				<a href="/healthcare/MypageServlet">マイページに戻る</a>
			</p>

			<footer class="footer">
				<div class="footer_hone">
					<img src="/healthcare/img/footer.png">
				</div>
				&copy;Copyright SeHealthCare. All rights reserved.
			</footer>
		</div>
	</div>
</body>
</html>