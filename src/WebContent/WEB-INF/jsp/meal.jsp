<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/healthcare/css/meal.css">
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
</head>
<body>
<div class="wrapper">
	<header>
		<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100"
				height="40">
	</header>
	<div class="wrapper">
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
	</div>
	<div class="meal">
	<h2>食事記録</h2>
	</div>
	<div class="center">
		<select name="year">
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
		</select> <select name="month">
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
		</select> <select name="day">
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
		</select> <a href="/healthcare/MealServlet"><input type="submit" value="決定"></a>
	</div>
	<div class="center">
	<p>あなたの一日の食事を記録してください。</p>
	<p>0% ：食べてない。</p>
	<p>25% ：少しだけ食べた。</p>
	<p>50% ：少し食べた。</p>
	<p>75% ：ちょうどいい。</p>
	<p>100% ：少し食べすぎ。</p>
	<p>120%以上：食べすぎた。</p>
	</div>
	<form name="form1">
	<table>
		<tr>
			<td class="center"><h3>朝食</h3></td>
			<td class="center"><input type="radio" name="color1" value="0%"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color1" value="25%"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color1" value="50%"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color1" value="75%"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color1" value="100%"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color1" value="120%"></td>
			<td class="center"><h3>約120%以上</h3></td>
			<td class="center"><input type="button" value="決定" onclick="clickBtn1()"></td>
		</tr>
		</table>
		<div class="center">
		<p id="result"></p>
		<p id="comment"></p>
		</div>
			</form>
		<form action="/healthcare/MealServlet" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td><canvas id="preview" width="100" height="100"></canvas></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/png, image/jpeg"></td>
			<td><input type="button" value="保存" onchange="previewImage(this);"></td>
		</tr>
	</table>
	</form>
	<form name="form2">
	<table>
		<tr>
			<td class="center"><h3>昼食</h3></td>
			<td class="center"><input type="radio" name="color2" value="0%"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color2" value="25%"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color2" value="50%"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color2" value="75%"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color2" value="100%"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color2" value="120%"></td>
			<td class="center"><h3>約120%以上</h3></td>
			<td class="center"><input type="button" value="決定" onclick="clickBtn2()"></td>
		</tr>
		</table>
		<div class="center">
		<p id="result2"></p>
		<p id="comment2"></p>
		</div>
			</form>
		<form action="/healthcare/MealServlet" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td><canvas id="preview" width="100" height="100"></canvas></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/png, image/jpeg"></td>
			<td><input type="button" value="保存" onchange="previewImage(this);"></td>
		</tr>
	</table>
	</form>
	<form name="form3">
	<table>
		<tr>
			<td class="center"><h3>夕食</h3></td>
			<td class="center"><input type="radio" name="color3" value="0%"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color3" value="25%"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color3" value="50%"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color3" value="75%"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color3" value="100%"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color3" value="120%"></td>
			<td class="center"><h3>約120%以上</h3></td>
			<td class="center"><input type="button" value="決定" onclick="clickBtn3()"></td>
		</tr>
		</table>
		<div class="center">
		<p id="result3"></p>
		<p id="comment3"></p>
		</div>
			</form>
		<form action="/healthcare/MealServlet" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td><canvas id="preview" width="100" height="100"></canvas></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/png, image/jpeg"></td>
			<td><input type="button" value="保存" onchange="previewImage(this);"></td>
		</tr>
	</table>
	</form>
	<form name="form4">
	<table>
		<tr>
			<td class="center"><h3>間食</h3></td>
			<td class="center"><input type="radio" name="color4" value="0%"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color4" value="25%"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color4" value="50%"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color4" value="75%"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color4" value="100%"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color4" value="120%"></td>
			<td class="center"><h3>約120%以上</h3></td>
			<td class="center"><input type="button" value="決定" onclick="clickBtn4()"></td>
		</tr>
		</table>
		<div class="center">
		<p id="result4"></p>
		<p id="comment4"></p>
		</div>
			</form>
		<form action="/healthcare/MealServlet" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td><canvas id="preview" width="100" height="100"></canvas></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/png, image/jpeg"></td>
			<td><input type="button" value="保存" onchange="previewImage(this);"></td>
		</tr>
	</table>
	</form>
	<footer class="footer">
		<div class="footer_hone">
			<img src="img/footer.png" alt="">
		</div>
		&copy;&copy;Copyright SeHealthCare.All rights reserved.
	</footer>
	</div>
	<script>
	function previewImage(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			}
		}
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
	}
	</script>
	<script>
  //満腹度
  let arr = ["しっかり食べましょう","もう少し食べてエネルギーつけましょう","もう少し食べましょう","ちょうどよい量です","少し食べすぎです","食べすぎです。もう少し抑えましょう"];
  function clickBtn1() {
    let str = "";
    let rul = "";
    const color1 = document.form1.color1;

    for (let i = 0; i < color1.length; i++) {
      if (color1[i].checked) {//(color1[i].checked === true)と同じ
        str = color1[i].value;
        rul = arr[i];
        break;
      }
    }
    document.getElementById("result").textContent = "あなたはその朝食を"+ str +"食べました。";
    document.getElementById("comment").textContent = rul;
  }
  function clickBtn2() {
	    let str = "";
	    let rul = "";
	    const color2 = document.form2.color2;

	    for (i = 0; i < color2.length; i++) {
	      if (color2[i].checked) {//(color1[2].checked === true)と同じ
	        str = color2[i].value;
	        rul = arr[i];
	        break;
	      }
	    }
	    document.getElementById("result2").textContent = "あなたはその朝食を"+ str +"食べました。";
	    document.getElementById("comment2").textContent = rul;
	  }
  function clickBtn3() {
	    let str = "";
	    let rul = "";
	    const color3 = document.form3.color3;

	    for (i = 0; i < color3.length; i++) {
	      if (color3[i].checked) {//(color1[i].checked === true)と同じ
	        str = color3[i].value;
	        rul = arr[i];
	        break;
	      }
	    }
	    document.getElementById("result3").textContent = "あなたはその朝食を"+ str +"食べました。";
	    document.getElementById("comment3").textContent = rul;
	  }
  function clickBtn4() {
	    let str = "";
	    let rul = "";
	    const color4 = document.form4.color4;

	    for (i = 0; i < color4.length; i++) {
	      if (color4[i].checked) {//(color1[i].checked === true)と同じ
	        str = color4[i].value;
	        rul = arr[i];
	        break;
	      }
	    }
	    document.getElementById("result4").textContent = "あなたはその朝食を"+ str +"食べました。";
	    document.getElementById("comment4").textContent = rul;
	  }
  </script>
</body>
</html>