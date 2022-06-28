<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SeHealthCare</title>
<link rel="stylesheet" type="text/css" href="/healthcare/css/meal.css">
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
	<link rel="icon" href="/healthcare/img/favicon.ico" id="favicon">
<link rel="/healthcare/img/apple-touch-icon" sizes="180x180" href="/apple-touch-icon-180x180.png">
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
	<script src="/healthcare/js/common.js" type="text/javascript"></script>


	</div>
	<div class="meal">
	<h2>食事記録</h2>
	</div>
	<c:choose>
	<c:when test="${empty day}">
	<body onload="today()">
	</c:when>
	<c:otherwise>
	<body onload="day(${year},${month},${day})">
	</c:otherwise>
	</c:choose>
	<div class="center">
	<select name="year" id="id_year" class="regi">
					<!-- option要素がjavascriptのプログラムにより挿入される、id_year -->
				</select>
				<select name="month" id="id_month" class="regi">
					<!-- option要素がjavascriptのプログラムにより挿入される、id_month -->
				</select>
				<select name="day" id="id_day" class="regi">
					<!-- option要素がjavascriptのプログラムにより挿入される、id_day -->
				</select>
		<a href="/healthcare/MealServlet"><input type="submit" value="決定"></a>
</div>
	<script src="/healthcare/js/meal.js" type="text/javascript"></script>
	<div class="center">
	<p>あなたの一日の食事を記録してください。</p>
	<p>0% ：食べてない。</p>
	<p>25% ：少しだけ食べた。</p>
	<p>50% ：少し食べた。</p>
	<p>75% ：ちょうどいい。</p>
	<p>100% ：少し食べすぎ。</p>
	<p>120%以上：食べすぎた。</p>
	</div>
	<form method="post" enctype="multipart/form-data" action="/healthcare/MealServlet" name="form1">
	<table>
		<tr>
			<td class="center"><h3>朝食</h3></td>
			<td class="center"><input type="radio" name="color1" value="0%" onchange="clickBtn1()"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color1" value="25%" onchange="clickBtn1()"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color1" value="50%" onchange="clickBtn1()"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color1" value="75%" onchange="clickBtn1()"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color1" value="100%" onchange="clickBtn1()"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color1" value="120%" onchange="clickBtn1()"></td>
			<td class="center"><h3>約120%以上</h3></td>
		</tr>
		</table>
		<table>
		<tr>
			<td><canvas id="preview1" style="width: 500px; height: 300px;"></canvas></td>
			<td class="center"><p id="result"></p><p id="comment"></p></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/*" onchange="previewImage1(this);"></td>
			<td><button type="submit" name="foodnumber" value=1>保存</button></td>
		</tr>
	</table>
	</form>
	<form method="post" enctype="multipart/form-data" action="/healthcare/MealServlet" name="form2">
	<table>
		<tr>
			<td class="center"><h3>昼食</h3></td>
			<td class="center"><input type="radio" name="color2" value="0%" onchange="clickBtn2()"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color2" value="25%" onchange="clickBtn2()"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color2" value="50%" onchange="clickBtn2()"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color2" value="75%" onchange="clickBtn2()"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color2" value="100%" onchange="clickBtn2()"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color2" value="120%" onchange="clickBtn2()"></td>
			<td class="center"><h3>約120%以上</h3></td>
		</tr>
		</table>
		<table>
		<tr>
			<td><canvas id="preview2" style="width: 500px; height: 300px;"></canvas></td>
			<td class="center"><p id="result2"></p><p id="comment2"></p></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/*" onchange="previewImage2(this);"></td>
			<td><button type="submit" name="foodnumber" value=1>保存</button></td>
		</tr>
	</table>
	</form>
	<form method="post" enctype="multipart/form-data" action="/healthcare/MealServlet" name="form3">
	<table>
		<tr>
			<td class="center"><h3>夕食</h3></td>
			<td class="center"><input type="radio" name="color3" value="0%" onchange="clickBtn3()"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color3" value="25%" onchange="clickBtn3()"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color3" value="50%" onchange="clickBtn3()"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color3" value="75%" onchange="clickBtn3()"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color3" value="100%" onchange="clickBtn3()"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color3" value="120%" onchange="clickBtn3()"></td>
			<td class="center"><h3>約120%以上</h3></td>
		</tr>
		</table>
			</form>
		<form action="/healthcare/MealresultServlet" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td><canvas id="preview3" style="width: 500px; height: 300px;"></canvas></td>
			<td class="center"><p id="result3"></p><p id="comment3"></p></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/*" onchange="previewImage3(this);"></td>
			<td><button type="submit" name="foodnumber" value=1>保存</button></td>
		</tr>
	</table>
	</form>
	<form method="post" enctype="multipart/form-data" action="/healthcare/MealServlet" name="form4">
	<table>
		<tr>
			<td class="center"><h3>間食</h3></td>
			<td class="center"><input type="radio" name="color4" value="0%" onchange="clickBtn4()"></td>
			<td class="center"><h3>0%</h3></td>
			<td class="center"><input type="radio" name="color4" value="25%" onchange="clickBtn4()"></td>
			<td class="center"><h3>約25%</h3></td>
			<td class="center"><input type="radio" name="color4" value="50%" onchange="clickBtn4()"></td>
			<td class="center"><h3>約50%</h3></td>
			<td class="center"><input type="radio" name="color4" value="75%" onchange="clickBtn4()"></td>
			<td class="center"><h3>約75%</h3></td>
			<td class="center"><input type="radio" name="color4" value="100%" onchange="clickBtn4()"></td>
			<td class="center"><h3>約100%</h3></td>
			<td class="center"><input type="radio" name="color4" value="120%" onchange="clickBtn4()"></td>
			<td class="center"><h3>約120%以上</h3></td>
		</tr>
		</table>
		<table>
		<tr>
			<td><canvas id="preview4" style="width: 500px; height: 300px;"></canvas></td>
			<td class="center"><p id="result4"></p><p id="comment4"></p></td>
		</tr>
		<tr>
			<td><input type="file" name="IMAGE" accept="image/*" onchange="previewImage4(this);"></td>
			<td><button type="submit" name="foodnumber" value=1>保存</button></td>
		</tr>
	</table>
	</form>
	<footer class="footer">
		<div class="footer_hone">
			<img src="img/footer.png" alt="">
		</div>
		&copy;Copyright SeHealthCare.All rights reserved.
	</footer>
	</div>
	<script>
	function previewImage1(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview1');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
	}

	function previewImage2(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview2');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
	}

	function previewImage3(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview3');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
	}

	function previewImage4(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview4');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
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
	    document.getElementById("result2").textContent = "あなたはその昼食を"+ str +"食べました。";
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
	    document.getElementById("result3").textContent = "あなたはその夕食を"+ str +"食べました。";
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
	    document.getElementById("result4").textContent = "あなたはその間食を"+ str +"食べました。";
	    document.getElementById("comment4").textContent = rul;
	  }
 	</script>
</body>
</html>