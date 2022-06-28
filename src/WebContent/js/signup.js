
let formObj = document.getElementById('form');
  let errorMessageObj = document.getElementById('error_message');

  formObj.onsubmit = function(event) {

    if (formObj.id.value === ""
		|| formObj.pw1.value === ""
		|| formObj.pw2.value === ""
		|| formObj.mail.value === ""
		|| formObj.gender.value === ""
		|| formObj.yaer.value === ""
		|| formObj.month.value === ""
		|| formObj.day.value === ""
		|| formObj.height.value === "") {
      errorMessageObj.textContent = '※必須項目をすべて入力してください';
      return false;
     }
     errorMessageObj.textContent = null;
  };
