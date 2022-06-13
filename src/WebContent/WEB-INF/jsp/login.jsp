<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SeHealthCare</title>
</head>
<body>
	<header>
		<img src="/healthcare/img/">
	</header>

	<h2>ログイン</h2>
	<form id="form" method="POST" action="/healthcare/LoginServlet">
		<table class="">
			<tr>
				<td>ID<input type="text" name="ID"></td>
			</tr>

			<tr>
				<td>PW<input type="password" name="PW"></td>
			</tr>
		</table>

		<input class="button" type="submit" name="LOGIN" value="login">
	</form>
	<p>
		<input type="reset" name="reset" value="新規登録">
	</p>

	<p>ユーザーではない方は新規登録が必要です。</p>
	<footer class="footer">
		<div class="">
			<img src="/healthcare/img/footer.png">
		</div>
		&copy;&copy;Copyright SeHealthCare. All rights reserved.


	</footer>
</body>
</html>