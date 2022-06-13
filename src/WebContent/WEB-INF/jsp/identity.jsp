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

	<h2>本人確認</h2>
	<form id="form" method="POST" action="/healthcare/MypageServlet">
		<table class="">
			<tr>
				<td>メールアドレス<input type="text" name="mail"></td>
			</tr>

			<tr>
				<td>PW<input type="password" name="PW"></td>
			</tr>
		</table>

		<input class="button" type="submit" name="LOGIN" value="認証">
	</form>
	<p>
		<a href="/healthcare/MenuServlet">マイページに戻る</a>
	</p>

	<footer class="footer">
		<div class="">
			<img src="/healthcare/img/footer.png">
		</div>
		&copy;&copy;Copyright SeHealthCare. All rights reserved.
	</footer>
</body>
</html>