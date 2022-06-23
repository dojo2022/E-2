<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>運動計算</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css" href="/healthcare/css/sports.css">
</head>
<body onload="today()">
	<div class="wrapper">
		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100" height="40">
		</header>
		<nav>
			<ul id="nav">
				<li><a href="/healthcare/MypageServlet">MYページ</a></li>
				<li><a href="/healthcare/BmiServlet">BMI計算</a></li>
				<li><a href="/healthcare/SportServlet">運動計算</a></li>
				<li><a href="/healthcare/MealServlet">食事記録</a></li>
				<li><a href="/healthcare/ContactServlet">お問い合わせ</a></li>
				<li><a href="/healthcare/LoginServlet" id="log_out">ログアウト</a></li>
			</ul>
		</nav>
		<script src="/healthcare/js/common.js" type="text/javascript"></script>
		<script src="/healthcare/js/sport.js" type="text/javascript"></script>
		<div class="sports">
			<h2 class="pagetitle">運動計算</h2>
			<img id="sportsimg" src="/healthcare/img/sport.png" alt="">
		</div>
		<p class="text">
			計算式: 消費カロリー(kcal)＝メッツ*体重(kg)*(運動時間*1.05)<br>
			メッツ値は運動による消費エネルギー量が、安静時の何倍にあたるかを示す値です。<br>
			メッツ値は厚生労働省の「健康づくりのための身体活動基準2013」の値を使用しています。

		</p>
		<form>
			<div class="center">
				<p>
					<input type="radio" name="radio" id="radio1" value="type1"
						checked="checked" onchange="setOption(this);"><label
						for="radio1">生活</label> <input type="radio" name="radio"
						id="radio2" value="type2" onchange="setOption(this);"><label
						for="radio2">運動</label><br> *消費カロリーは小数点切り捨てを行っています
				</p>
				<select class="regi" name="category" id="mets">
					<option value="">▼生活</option>
					<option value="1.8">立位(会話、電話、読書)、皿洗い</option>
					<option value="2.0">ゆっくりした歩行、食事の準備、洗濯</option>
					<option value="2.2">子供と遊ぶ(座位、軽度)</option>
					<option value="2.3">ガーデニング、動物の世話、ピアノの演奏</option>
					<option value="2.5">植物の水やり、子供の世話、仕立て作業</option>
					<option value="2.8">子供・動物とアゾ部(立位、軽度)</option>
					<option value="3.3">普通歩行、ペットの散歩、台所の手伝い</option>
					<option value="3.5">フロア掃き、フロア掃き、体の動きを伴うスポーツ観戦</option>
					<option value="4.5">階段を降りる、軽い荷物運び、子供と遊ぶ(歩く/走る)</option>
					<option value="4.0">自転車に乗る(通勤など)、階段を上る、動物と遊ぶ(歩く/走る)</option>
					<option value="4.3">競歩、苗木の植栽</option>
					<option value="4.5">耕作、家の修理</option>
					<option value="5.0">走る、動物と走る</option>
					<option value="5.5">シャベルで土や泥をすくう</option>
					<option value="5.8">家具に・家財道具の移動・運搬</option>
					<option value="6.0">スコップで雪かきをする</option>
					<option value="7.8">農作業</option>
					<option value="8.0">運搬(重い荷物)</option>
					<option value="8.3">荷物を上の階に運ぶ</option>
					<option value="8.8">階段を走って上る</option>
				</select>
				<p>
					時間<input class="regi" type="text" id="time" name="time">分
				</p>
				<p>
					体重<input class="regi" type="text" id="weight"
						value="${weight.weight}" name="weight">kg
				</p>
				<span id="error_message" style="color: red"></span><br> <input
					class="buttoncolor" type="button" value="計算" id="btn"
					onclick="sportcalc()"> <input class="buttoncolor"
					type="reset" value="クリア">
			</div>
		</form>
		<hr>
		<form method="POST" action="/healthcare/SportServlet" name="form">
			<div class="center">
				<p>
					運動強度<input class="regi" name="mets" id="exe" type="text"
						disabled="disabled">(メッツ)
				</p>
				<p id="out">
					消費カロリー<input class="regi" name="calorieout" id="calorieout"
						type="text" readonly="readonly">kcal
				</p>


				<select name="year" id="id_year" class="regi">
					<!-- option要素がjavascriptのプログラムにより挿入される、id_year -->
				</select>
				<select name="month" id="id_month" class="regi">
					<!-- option要素がjavascriptのプログラムにより挿入される、id_month -->
				</select>
				<select name="day" id="id_day" class="regi">
					<!-- option要素がjavascriptのプログラムにより挿入される、id_day -->
				</select>
				<p class="box buttoncolor">
					総消費カロリーは<input class="regi" name="calories" id="caloriesout"
						type="text" value="${caloriesout.caloriesout}" readonly="readonly">です。
				</p>

				<input class="buttoncolor" type="submit" name="SUBMIT" value="保存">
				<input class="buttoncolor" type="reset" value="リセット">
			</div>
		</form>
		<footer class="footer">
			<div class="footer_hone">
				<img src="/healthcare/img/footer.png">
			</div>
			&copy; &copy;Copyright SeHealthCare. All rights reserved.
		</footer>
	</div>
</body>
</html>