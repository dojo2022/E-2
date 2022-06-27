let formObj = document.getElementById('form');
let errorMessageObj = document.getElementById('error_message');


formObj.onsubmit = function(event) {
	if (formObj.id.value === "") {
		errorMessageObj.textContent = '※体重を入力してください';
		return false;
	}
	else if (parseInt(id)) {
		errorMessageObj.textContent = null;

	} else {
		errorMessageObj.textContent = '※数値を入力してください';
		return false;
	}
}
