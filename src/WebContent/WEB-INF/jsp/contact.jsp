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
			<img class="image" src="/healthcare/img/.png">
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
		<div class ="img">
		<h2 class = "pagetitle"> お問い合わせ</h2>
		<img class="image" src="/healthcare/img/contact.png">
		</div>
				<form name="myform" onsubmit="return false">
        <table class="center">
			<tr>
				<td>ID</td><td><input type="text" name="ID"readonly></td>
			</tr>
			<tr>
				<td>メールアドレス</td><td><input type="text" name="email"></td>
			</tr>
			</table>
			<table class = "moji">
			<tr><td>お問い合わせ内容</td>
           <td><textarea></textarea></td></tr>
               </table>
		              <p class ="moj">＊1000文字以内で入力してください</p>
			<div class ="mo"><input type="submit" value ="この内容で問い合わせる" onclick="alert()"></div>
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