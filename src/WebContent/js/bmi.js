function test() {
  let height = document.getElementById('height').value;
  let weight = document.getElementById('weight').value;
  let errorMessageObj = document.getElementById('error_message');

  if (height === "" || weight === "") {
    errorMessageObj.textContent = '※身長または体重が入力されていません';
    return false;
  } else {
    errorMessageObj.textContent = null;
    weight = Number(weight); // 入力された文字列を数値に変換する
    height = Number(height);
    var bmi = weight / (height * height) * 10000; // BMIを計算
    var bmi = parseInt(bmi,10);
    document.getElementById('butbmi').innerHTML = "あなたのBMIは" + bmi + "です" // 結果を表示
  }
}