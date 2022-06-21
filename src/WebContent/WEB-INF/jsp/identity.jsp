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
				action="/healthcare/RegistchangeServlet">
				<table id="identity">
					<tr>
						<td>メールアドレス</td>
						<td><input class="regi" id="email" type="text" name="email"></td>
					</tr>

					<tr>
						<td>PW</td>
						<td><input class="regi" id="pw" type="password"
							name="password"></td>
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