
let formObj = document.getElementById('form');
  let errorMessageObj = document.getElementById('error_message');

  formObj.onsubmit = function(event) {
    if (formObj.email.value === "" || formObj.pw.value === "") {
      errorMessageObj.textContent = '※メールアドレスとpasswordを両方入力してください';
      return false;
     }
     errorMessageObj.textContent = null;
  };
