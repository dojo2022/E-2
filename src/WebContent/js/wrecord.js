let formObj = document.getElementById('form');
let errorMessageObj = document.getElementById('error_message');



formObj.onsubmit = function(event) {
	//let id = 0;

	// 未入力（空文字）のとき
	if (formObj.id.value === "") {
		errorMessageObj.textContent = '※体重を入力してください';
		return false;

	// 文字が入力されたとき
	} else if (isNaN(formObj.id.value)) {
		errorMessageObj.textContent = '※数値を入力してください';
		return false;

	// 正しく入力されたとき
	} else {
		errorMessageObj.textContent = null;
	}
}
