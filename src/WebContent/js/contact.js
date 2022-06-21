
function con() {
	let email = document.getElementById('email').value;
	let contents = document.getElementById('contents').value;
	let errorMessageObj = document.getElementById('error_message');

	if (email === "" || contents === "") {
		errorMessageObj.textContent = '※メールアドレスまたはお問い合わせ内容が入力されていません';
		return false;
	}
	if (window.confirm('この内容で問い合わせますか')) {
		console.log('ログアウトしました');
	} else {
		console.log('キャンセルしました');
		return false;
	}
}