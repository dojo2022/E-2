
let formObj = document.getElementById('form');
  let errorMessageObj = document.getElementById('error_message');

  formObj.onsubmit = function(event) {
    if (formObj.pw1.value !==  formObj.pw2.value ) {
      errorMessageObj.textContent = '※passwordと確認用passwordが一致しません';
      return false;
     }
     errorMessageObj.textContent = null;
  };