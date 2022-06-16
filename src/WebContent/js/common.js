document.getElementById('log_out').onclick = function() {
    if(window.confirm('ログアウトしますか')) {
      console.log('ログアウトしました');
    }else {
     console.log('キャンセルしました');
     return false;
    }
}