document.getElementById('log_out').onclick = function() {
    if(window.confirm('ログアウトしますか')) {
      console.log('ログアウトしました');
    }else {
     console.log('キャンセルしました');
     return false;
    }
}

function con() {
    if(window.confirm('この内容で問い合わせますか')) {
      console.log('ログアウトしました');
    }else {
     console.log('キャンセルしました');
     return false;
    }
   }