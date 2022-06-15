<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>healthcare</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/contact.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<img src="/healthcare/img/">
		</header>
		<nav>
			<ul id="nav">
				<li><a href="/healthcare/MypageServlet">MYページ</a></li>
				<li><a href="/healthcare/BmiServlet">BMI計算</a></li>
				<li><a href="/healthcare/SportServlet">運動計算</a></li>
				<li><a href="/healthcare/MealServlet">食事記録</a></li>
				<li><a href="/healthcare/ContactServlet">お問い合わせ</a></li>
				<li><a href="/healthcare/LoginServlet">ログアウト</a></li>
			</ul>
		</nav>
		<h2 class ="pagetitle">お問い合わせ</h2>
				<form name="myform" onsubmit="return false">
           <table class="center">
			<tr>
				<td>ID</td><td><input type="text" name="ID"readonly></td>
			</tr>

			<tr>
				<td>メールアドレス</td><td><input type="text" name="email"></td>
			</tr>
		</table>
				お問い合わせ内容
				<textarea></textarea>
		<br>＊1000文字以内で入力してください
			<input type="submit" onclick="alert()">
		</form>
		</div>
		<script>

		</script>
		<footer class="footer">
			<div class="footer_hone">
				<img src="/healthcare/img/footer.png">
			</div>
			&copy; &copy;Copyright SeHealthCare. All rights reserved.
		</footer>
</body>
</html>