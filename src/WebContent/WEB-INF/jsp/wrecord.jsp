<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>healthcare</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
	<link rel="stylesheet" type="text/css" href="/healthcare/css/wrecord.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100" height="40">
		</header>

		<div class="img">
			<h2 class="pagetitle">今日の体重記録</h2>
			<img id="image" src="/healthcare/img/contact.png">
		</div>
		<form method="POST" action="/healthcare/WrecordServlet">
			<table class="mo">
				<tr>
					<td>今日の体重を入力してください</td>
				</tr>
                <tr>
					<td><input class="regi" type="text" id="email" name="weight">kg</td>
				</tr>
			</table>
			<div class="center">
				<span id="error_message" style="color: red" style="textaligncenter"></span><br>
			</div>
			<div class="mo ">
				<input class="buttoncolor" type="submit" value="送信"
					onclick="return con()">
			</div>
		</form>
	</div>

	<footer class="footer">
		<div class="footer_hone">
			<img src="/healthcare/img/footer.png">
		</div>
		&copy;Copyright SeHealthCare. All rights reserved.
	</footer>
</body>
</html>
