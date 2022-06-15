<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<input type="button" value="登録内容変更">
	</header>
	<nav>
		<ul>
			<li><a href="/healthcare/MypageServlet">MYページ</a></li>
			<li><a href="/healthcare/BmiServlet">BMI計算</a></li>
			<li><a href="/healthcare/SportServlet">運動計算</a></li>
			<li><a href="/healthcare/MealServlet">食事記録</a></li>
			<li><a href="/healthcare/ContactServlet">お問い合わせ</a></li>
			<li><a href="/healthcare/LoginServlet">ログアウト</a></li>
		</ul>
	</nav>

	<h1>マイページ</h1>
	<h2>目標体重</h2>
	<h2> あなたは○日連続ログインです。</h2>
	<p>体重の推移(折れ線グラフ)</p>
	<p> 消費カロリーの推移</p>
</body>
</html>