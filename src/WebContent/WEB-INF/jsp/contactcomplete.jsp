<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>healthcare</title>
<link rel="stylesheet" type="text/css" href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css" href="/healthcare/css/contactcomplete.css">
</head>
<body>
<div class="wrapper">
<header>
<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100"
				height="40">
</header>
<h2>お問い合わせ完了</h2>
<div class="text">
<p></p>
<p class = "boxes regi">お問い合わせが完了しました。<br>
内容を確認の上、改めてご連絡いたします。</p>
<img class="image" src="/healthcare/img/お問い合わせ完了.png">
</div>
<div class="button">
<input class="buttoncolor" type="button" onclick="location.href='/healthcare/ContactServlet'"value="お問い合わせ画面に戻る">
<input class="buttoncolor" type="button" onclick="location.href='/healthcare/MypageServlet'"value="マイページに戻る">
</div>
<footer class ="footer">
          <div class ="footer_hone">
          <img src="/healthcare/img/footer.png" >
          </div>
       &copy; &copy;Copyright SeHealthCare. All rights reserved.
  </footer>
  </div>
</body>
</html>