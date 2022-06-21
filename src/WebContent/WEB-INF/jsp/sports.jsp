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
<body>
	<div class="wrapper">
	<header>
	<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100"
				height="40">
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
		<input type="radio" name="radio" id="radio1" value="type1" checked="checked" onchange="setOption(this);"><label for="radio1">生活</label>
		<input type="radio" name="radio" id="radio2" value="type2" onchange="setOption(this);"><label for="radio2">運動</label><br>
		*消費カロリーは小数点切り捨てを行っています
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
		時間<input class="regi" type="text"id="time" name="time">分
	</p>
	<p>
		体重<input class="regi" type="text" id="weight" value="${weight.weight}" name="weight">kg
	</p>
	<span id="error_message" style="color: red"></span><br>
	<input class="buttoncolor" type="button" value="計算" id="btn" onclick="sportcalc()">
	<input class="buttoncolor" type="reset" value="クリア">
	</div>
	</form>
	<hr>
	<form method="POST" action="/healthcare/SportServlet" name="form">
	<div class="center">
	<p>
		運動強度<input class="regi" name="mets" id="exe" type="text" disabled="disabled" >(メッツ)
	</p>
	<p id = "out">
		消費カロリー<input class="regi"name="calorieout" id="calorieout" type="text"readonly="readonly"  >kcal
	</p>
	<select class="regi" name="year">
		<option value="1922">1922年</option>
		<option value="1923">1923年</option>
		<option value="1924">1924年</option>
		<option value="1925">1925年</option>
		<option value="1926">1926年</option>
		<option value="1927">1927年</option>
		<option value="1928">1928年</option>
		<option value="1929">1929年</option>
		<option value="1930">1930年</option>
		<option value="1931">1931年</option>
		<option value="1932">1932年</option>
		<option value="1933">1933年</option>
		<option value="1934">1934年</option>
		<option value="1935">1935年</option>
		<option value="1936">1936年</option>
		<option value="1937">1937年</option>
		<option value="1938">1938年</option>
		<option value="1939">1939年</option>
		<option value="1940">1940年</option>
		<option value="1941">1941年</option>
		<option value="1942">1942年</option>
		<option value="1943">1943年</option>
		<option value="1944">1944年</option>
		<option value="1945">1945年</option>
		<option value="1946">1946年</option>
		<option value="1947">1947年</option>
		<option value="1948">1948年</option>
		<option value="1949">1949年</option>
		<option value="1950">1950年</option>
		<option value="1951">1951年</option>
		<option value="1952">1952年</option>
		<option value="1953">1953年</option>
		<option value="1954">1954年</option>
		<option value="1955">1955年</option>
		<option value="1956">1956年</option>
		<option value="1957">1957年</option>
		<option value="1958">1958年</option>
		<option value="1959">1959年</option>
		<option value="1960">1960年</option>
		<option value="1961">1961年</option>
		<option value="1962">1962年</option>
		<option value="1963">1963年</option>
		<option value="1964">1964年</option>
		<option value="1965">1965年</option>
		<option value="1966">1966年</option>
		<option value="1967">1967年</option>
		<option value="1968">1968年</option>
		<option value="1969">1969年</option>
		<option value="1970">1970年</option>
		<option value="1971">1971年</option>
		<option value="1972">1972年</option>
		<option value="1973">1973年</option>
		<option value="1974">1974年</option>
		<option value="1975">1975年</option>
		<option value="1976">1976年</option>
		<option value="1977">1977年</option>
		<option value="1978">1978年</option>
		<option value="1979">1979年</option>
		<option value="1980">1980年</option>
		<option value="1981">1981年</option>
		<option value="1982">1982年</option>
		<option value="1983">1983年</option>
		<option value="1984">1984年</option>
		<option value="1985">1985年</option>
		<option value="1986">1986年</option>
		<option value="1987">1987年</option>
		<option value="1988">1988年</option>
		<option value="1989">1989年</option>
		<option value="1990">1990年</option>
		<option value="1991">1991年</option>
		<option value="1992">1992年</option>
		<option value="1993">1993年</option>
		<option value="1994">1994年</option>
		<option value="1995">1995年</option>
		<option value="1996">1996年</option>
		<option value="1997">1997年</option>
		<option value="1998">1998年</option>
		<option value="1999">1999年</option>
		<option value="2000">2000年</option>
		<option value="2001">2001年</option>
		<option value="2002">2002年</option>
		<option value="2003">2003年</option>
		<option value="2004">2004年</option>
		<option value="2005">2005年</option>
		<option value="2006">2006年</option>
		<option value="2007">2007年</option>
		<option value="2008">2008年</option>
		<option value="2009">2009年</option>
		<option value="2010">2010年</option>
		<option value="2011">2011年</option>
		<option value="2012">2012年</option>
		<option value="2013">2013年</option>
		<option value="2014">2014年</option>
		<option value="2015">2015年</option>
		<option value="2016">2016年</option>
		<option value="2017">2017年</option>
		<option value="2018">2018年</option>
		<option value="2019">2019年</option>
		<option value="2020">2020年</option>
		<option value="2021">2021年</option>
		<option value="2022">2022年</option>
	</select>

	<select class="regi" name="month">
		<option value="jan">1月</option>
		<option value="feb">2月</option>
		<option value="mar">3月</option>
		<option value="apr">4月</option>
		<option value="may">5月</option>
		<option value="jun">6月</option>
		<option value="jul">7月</option>
		<option value="aug">8月</option>
		<option value="sep">9月</option>
		<option value="oct">10月</option>
		<option value="nov">11月</option>
		<option value="dec">12月</option>
	</select>

	<select class="regi" name="day">
		<option value="1">1日</option>
		<option value="2">2日</option>
		<option value="3">3日</option>
		<option value="4">4日</option>
		<option value="5">5日</option>
		<option value="6">6日</option>
		<option value="7">7日</option>
		<option value="8">8日</option>
		<option value="9">9日</option>
		<option value="10">10日</option>
		<option value="11">11日</option>
		<option value="12">12日</option>
		<option value="13">13日</option>
		<option value="14">14日</option>
		<option value="15">15日</option>
		<option value="16">16日</option>
		<option value="17">17日</option>
		<option value="18">18日</option>
		<option value="19">19日</option>
		<option value="20">20日</option>
		<option value="21">21日</option>
		<option value="22">22日</option>
		<option value="23">23日</option>
		<option value="24">24日</option>
		<option value="25">25日</option>
		<option value="26">26日</option>
		<option value="27">27日</option>
		<option value="28">28日</option>
		<option value="29">29日</option>
		<option value="30">30日</option>
		<option value="31">31日</option>
	</select>
	<p name="caloriesout" class="box buttoncolor">総消費カロリーは <c:out value=""/>です。</p>
	<input class="buttoncolor" type="submit"  name="SUBMIT" value="保存">
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