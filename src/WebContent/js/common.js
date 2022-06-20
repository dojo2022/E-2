
let formObj = document.getElementById('form');
  let errorMessageObj = document.getElementById('error_message');

  formObj.onsubmit = function(event) {
    if (formObj.id.value === "" || formObj.pw.value === "") {
      errorMessageObj.textContent = '※IDとpasswordを両方入力してください';
      return false;
     }
     errorMessageObj.textContent = null;
  };

document.getElementById('log_out').onclick = function() {
	if (window.confirm('ログアウトしますか')) {
		console.log('ログアウトしました');
	} else {
		console.log('キャンセルしました');
		return false;
	}
};


function con() {
	if (window.confirm('この内容で問い合わせますか')) {
		console.log('ログアウトしました');
	} else {
		console.log('キャンセルしました');
		return false;
	}
}