<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/healthcare/css/comstyle.css">
<link rel="stylesheet" type="text/css" href="/healthcare/css/mypage.css">
 <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.bundle.min.js" integrity="sha256-eA+ych7t31OjiXs3fYU0iWjn9HvXMiCLmunP2Gpghok=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-annotation@0.5.7/chartjs-plugin-annotation.min.js" integrity="sha256-Olnajf3o9kfkFGloISwP1TslJiWUDd7IYmfC+GdCKd4=" crossorigin="anonymous"></script>
</head>
<body onload="test1(${tagweight.targetweight},<c:forEach var="find" items="${findlist}">
					list = ${find.weight},
					</c:forEach>), test2(<c:forEach var="find" items="${findout}">
					list = ${find.caloriesout},
					</c:forEach>)">
	<div class="wrapper">
		<header>
			<img src="/healthcare/img/ハートのヘッダー.jpeg" width="100"
				height="40">
			<input class="btn buttoncolor" type="button" onclick="location.href='/healthcare/IdentityServlet'"value="登録内容変更">
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

		<h2 class="pagetitle">MYページ</h2>
		<div class="heading">
			<h3>目標体重<br><c:out value="${tagweight.targetweight}"/>kg</h3>
			<h3>
				あなたは<c:out value="${daily.daily }"/>日連続<br>&emsp;ログインです。
			</h3>
		</div>
		<div class="center">
			<img id="mypageimg" src="/healthcare/img/mypage_sport.png" alt="">
		</div>
		<div class="chart">
			<p class="c_title">体重の推移(折れ線グラフ)</p>
			<p class="c_title">消費カロリーの推移</p>
		</div>
		<div class="chart">
		<div style="width: 350px;">
			<canvas id="canvas1"></canvas>
		</div>
		<div style="width: 350px;">
			<canvas id="canvas2"></canvas>
		</div>
		 <script>
		 function test1(tag,...list){
		 var ctx = document.getElementById('canvas1').getContext('2d');
            var myChart = new Chart(ctx, {
                // The type of chart we want to create
                type: 'line',

                // The data for our dataset
                data: {
                    labels: ['1', '2', '3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14','15',
                    '16', '17', '18', '19', '20', '21','22', '23', '24', '25', '26', '27', '28', '29', '30' ,'31'],
                    datasets: [{
                        label: '1ヶ月の体重',
                        backgroundColor: 'rgb(255, 99, 132)',
                        borderColor: 'rgb(255, 99, 132)',
                        fill: false,
                        data: [...list]
                    }]
                },

                // Configuration options go here
                options: {
                  scales: {
            yAxes: [{
                ticks: {
                  suggestedMin: 40,
           suggestedMax: 70,
           stepSize: 10
                }
            }]
        },
        annotation: {
        drawTime: 'afterDatasetsDraw',
        annotations: [
            {
                id: 'hline',
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-0',
                value: tag,
                borderColor: 'black',
                borderWidth: 2,
                label: {
                    backgroundColor: "red",
                    content: "目標体重",
                    enabled: true
                },
            },
        ]
    }
    }
            });
		 }</script>
            <script>
            function test2(...list){
            var ctx = document.getElementById('canvas2').getContext('2d');
            var myChart = new Chart(ctx, {
                // The type of chart we want to create
                type: 'line',

                // The data for our dataset
                data: {
                    labels: ['1', '2', '3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14','15',
                    '16', '17', '18', '19', '20', '21','22', '23', '24', '25', '26', '27', '28', '29', '30' ,'31'],
                    datasets: [{
                        label: '1ヶ月の消費カロリー',
                        backgroundColor: 'rgb(255, 99, 132)',
                        borderColor: 'rgb(255, 99, 132)',
                        fill: false,
                        data: [...list]
                    }]
                },

                // Configuration options go here
                options: {
                  scales: {
            yAxes: [{
                ticks: {
                  suggestedMin:5000,
           suggestedMax: 1000,
           stepSize: 1000
                }
            }]
        }
    }
            });
            }</script>
		</div>
		<div>
		<c:forEach var="find" items="${findList}">
					<c:out value="${find.weight}"></c:out>
					</c:forEach>
					</div>
		<footer class="footer">
			<div class="footer_hone">
				<img src="/healthcare/img/footer.png">
			</div>
			&copy;&copy;Copyright SeHealthCare. All rights reserved.
		</footer>
		<script src="/healthcare/js/common.js" type="text/javascript"></script>
		<script src="/healthcare/js/mypage.js" type="text/javascript"></script>
	</div>
</body>
</html>