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
	href="/healthcare/css/registchange.css">
</head>
<body>
	<div class="wrapper">

		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100"
				height="40">
		</header>

		<h2 class="pagetitle">登録変更</h2>
		<form method="POST" action="/healthcare/RegistcompleteServlet">
			<table id="regichan">
				<tr>
					<td>password</td>
					<td><input class ="regi" type="password" name="PW"></td>
				</tr>

				<tr>
					<td>password</td>
					<td><input class ="regi" type="password" name="PW"></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input class ="regi" type="text"value="${email.email }" name="email"></td>
				</tr>

				<tr>
					<td>身長</td>
					<td><input class ="regi" type="text" value="${height.height }" name="height"></td>
				</tr>
				<tr>
					<td>目標体重</td>
					<td><input class ="regi" type="text"value="${tagweight.targetweight }" name="targetweight"></td>
				</tr>
			</table>
			<div class="center">
				<p>
					<input class="buttoncolor" type="submit" name="change" value="変更">
				</p>
			</div>
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
</body>
</html>