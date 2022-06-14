<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>healthcare</title>
<link rel="stylesheet" type="text/css" href="/healthcare/css/comstyle.css">
</head>
<body>
<header>
<img src="/healthcare/img/">
</header>
<h1>お問い合わせ</h1>
  	<p>ID</p>
						<input type="password" name="ID">
  	<p>メールアドレス</p>
  	                     <input type="text" name="メールアドレス">
  	<p>お問い合わせ内容</p>
  	  					<textarea></textarea>
  	 <p>＊1000文字以内で入力してください</p>
<form name="myform" onsubmit="return false">
<input type="submit" onclick="alert()">
</form>
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
		<script>
          </script>
          <footer class ="footer">
          <div class ="footer_hone">
          <img src="/healthcare/img/footer.png" >
          </div>
        &copy; &copy;Copyright SeHealthCare. All rights reserved.
        </footer>
</body>
</html>