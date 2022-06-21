function sportcalc() {
	let mets = document.getElementById('mets').value;
	let time = document.getElementById('time').value;
	let weight = document.getElementById('weight').value;
	let total = document.getElementById('caloriesout').value;
	let errorMessageObj = document.getElementById('error_message');
	if (time === "" || weight === "" || mets === "") {
		errorMessageObj.textContent = '※運動・生活、時間または体重が入力されていません';
		return false;
	} else {
		errorMessageObj.textContent = null;
		mets = Number(mets);
		weight = Number(time); // 入力された文字列を数値に変換する
		height = Number(weight);
		total = Number(total);
		let kcal = mets * weight * (time * 1.05); // 運動強度を計算
		console.log(kcal);
		kcal = parseInt(kcal,10);
		document.form.mets.value = mets;
		document.form.calorieout.value = kcal;
				total = total + kcal;
		console.log(total);
		document.form.caloriesout.value = total;
	}
}

var type1Arr = [
	{ value: "", label: "▼生活" },
	{ value: "1.8", label: "立位(会話、電話、読書)、皿洗い" },
	{ value: "2.0", label: "ゆっくりした歩行、食事の準備、洗濯" },
	{ value: "2.2", label: "子供と遊ぶ(座位、軽度)" },
	{ value: "2.3", label: "ガーデニング、動物の世話、ピアノの演奏" },
	{ value: "2.5", label: "植物の水やり、子供の世話、仕立て作業" },
	{ value: "2.8", label: "子供・動物とアゾ部(立位、軽度)" },
	{ value: "3.0", label: "普通歩行、ペットの散歩、台所の手伝い" },
	{ value: "3.3", label: "フロア掃き、フロア掃き、体の動きを伴うスポーツ観戦" },
	{ value: "3.5", label: "階段を降りる、軽い荷物運び、子供と遊ぶ(歩く/走る)" },
	{ value: "4.0", label: "自転車に乗る(通勤など)、階段を上る、動物と遊ぶ(歩く/走る)" },
	{ value: "4.3", label: "競歩、苗木の植栽" },
	{ value: "4.5", label: "耕作、家の修理" },
	{ value: "5.0", label: "走る、動物と走る" },
	{ value: "5.5", label: "シャベルで土や泥をすくう" },
	{ value: "5.8", label: "家具に・家財道具の移動・運搬" },
	{ value: "6.0", label: "スコップで雪かきをする" },
	{ value: "7.8", label: "農作業" },
	{ value: "8.0", label: "運搬(重い荷物)" },
	{ value: "8.3", label: "荷物を上の階に運ぶ" },
	{ value: "8.8", label: "階段を走って上る" },
];
var type2Arr = [
	{ value: "", label: "▼運動　* 試合の場合" },
	{ value: "2.3", label: "ストレッチング" },
	{ value: "2.5", label: "ヨガ、ビリヤード" },
	{ value: "2.8", label: "座って行うラジオ体操" },
	{ value: "3.0", label: "ボウリング、バレーボール、社交ダンス、太極拳" },
	{ value: "3.5", label: "自転車エルゴメーター(30～50ワット)、軽い筋トレ、カヌー" },
	{ value: "3.8", label: "全身を使ったテレビゲーム(スポーツ・ダンス)" },
	{ value: "4.0", label: "卓球、パワーヨガ、ラジオ体操第1" },
	{ value: "4.3", label: "競歩、ゴルフ" },
	{ value: "4.5", label: "テニス(ダブルス)*、水中歩行(中等度)、ラジオ体操第2" },
	{ value: "4.8", label: "水泳(ゆっくりとした背泳ぎ)" },
	{ value: "5.0", label: "走る、野球、ソフトボール、サーフィン、バレエ" },
	{ value: "5.3", label: "水泳(ゆっくりとした平泳ぎ、スキー、アクアビスク)" },
	{ value: "5.5", label: "バトミントン" },
	{ value: "6.0", label: "ゆっくりとしたジョギング、ウェイトトレーニング(高強度)、バスケ" },
	{ value: "6.5", label: "山登り(約0～4.1kgの荷物)" },
	{ value: "6.8", label: "自転車エルゴメーター(90～100ワット)" },
	{ value: "7.0", label: "ジョギング、サッカー、スキー、スケート、ハンドボール*" },
	{ value: "7.3", label: "エアロビクス、テニス(シングルス)*、山登り(約4.5～9.0kgの荷物)" },
	{ value: "8.0", label: "サイクリング(約20km/時)" },
	{ value: "8.3", label: "ランニング(134m/分)、水泳(クロール、普通、46m/分未満)、ラグビー*" },
	{ value: "9.0", label: "ランニング(139m/分)" },
	{ value: "9.8", label: "ランニング(161m/分)" },
	{ value: "10.0", label: "水泳(クロール、速い、69m/分)" },
	{ value: "10.3", label: "ブドウ・武術(柔道、柔術、空手、キックボクシング、テコンドー)" },
	{ value: "11.0", label: "ランニング(188m/分)、自転車エルゴメーター(161～200ワット)" },
];

function setOption(radio) {
	let target;
	let pullObj;
	let i;
	if ((radio.value) == 'type1') {
		target = type1Arr;
	} else if ((radio.value) == 'type2') {
		target = type2Arr;
	}
	pullObj = document.getElementById('mets');
	while (pullObj.lastChild) {
		pullObj.removeChild(pullObj.lastChild);
	}
	for (i = 0; i < target.length; i++) {
		let option = document.createElement('option');
		option.value = target[i].value;
		option.text = target[i].label;
		pullObj.appendChild(option);
	}
}
