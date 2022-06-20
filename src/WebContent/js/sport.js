function sportcalc(){
	let mets = document.getElementById('mets').value;
	let time = document.getElementById('time').value;
	let weight = document.getElementById('weight').value;
	let errorMessageObj = document.getElementById('error_message');
	if (time === "" || weight === "") {
    errorMessageObj.textContent = '※時間または体重が入力されていません';
    return false;
	}else {
		errorMessageObj.textContent = null;
		mets = Number(mets);
    	weight = Number(weight); // 入力された文字列を数値に変換する
   		height = Number(height);
    	var kcal = met * weight * (time * 1.05); // BMIを計算
    	document.getElementById('exe').innerHTML = mets;
		document.getElementById('calorieout').innerHTML = kcal;
	}


}
