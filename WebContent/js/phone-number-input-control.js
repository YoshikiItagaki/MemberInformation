function num_check(phone_number){
	var phone_number = document.getElementById('phone_number').phone_number.value;
	var isCorrect = true;
	var result = "";
	var num = phone_number.value;
	result = /[^\d-.]/.test(num);
	if (result){
		isCorrect=false;
		setTimeout(function(){str.focus();}, 0);
		alert("半角数字以外入力不可です。");
	} else if(result = /-+/.test(num)) {
		isCorrect=false;
		return isCorrect;
	} else if(result = /[.]+/.test(num)){
		isCorrect=false;
		return isCorrect;
	} else{
		isCorrect=false;
		return isCorrect;
	}
}