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
	if (window.prompt('今日の体重を入力してください')) {
		console.log('ログアウトしました');
	} else {
		console.log('キャンセルしました');
		return false;
	}
}

