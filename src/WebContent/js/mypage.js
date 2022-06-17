function writeweigh() {
	let today = new Date();
	let a = 0;//仮設定
	if (a < today.getFullYear()) {
		if (a < today.getMonth()) {
			if (a < today.getDate()) {
				if (window.prompt('文字列を入力してください')) {

				} else {

					return false;
				}
			}
		}
	}
}

function test() {
	if (window.prompt('この内容で問い合わせますか')) {
		console.log('ログアウトしました');
	} else {
		console.log('キャンセルしました');
		return false;
	}
}