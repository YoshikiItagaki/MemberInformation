<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規情報登録</title>
<link rel="stylesheet" type="text/css" href="../css/date-input-style.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">

</head>
<body>

<%@ page contentType="text/html; charset=UTF-8"%>

<div>
	<table>
	<tr>
		<td><a href="register.jsp">登録</a></td>
	</tr>
	<tr>
		<td><a href="update1.jsp">更新</a></td>
	</tr>
	<tr>
		<td><a href="delete.jsp">削除</a></td>
	</tr>
</table>

</div>


<div>
	<p>新たに登録する情報を入力してください。</p>
	<form action="../jp/co/aforce/register/register"  method="post">
		姓<br><input type="text" name="last_name"><br>
		名<br><input type="text" name="first_name"><br>
		性別<br><input type="radio" name="sex" value="1">
			<label for="male">男</label>
		<input type="radio" name = "sex" value="2">
			<label for="female">女</label><br><br>
		<div class="form-select-wrap">
			誕生年<br><select name="birth_year" class="birth_year" ></select><br>
			誕生月<br><select name="birth_month" class="birth_month" ></select><br>
			誕生日<br><select name="birth_day" class="birth_day" ></select><br>
		</div>

		職業<br><select name="job">
			<option value="100">会社員</option>
			<option value="200">自営業</option>
			<option value="300">学生</option>
			<option value="400">その他</option>
		</select><br>
		電話番号<br><input type="number" name="phone_number" id="phone_number"><br>
		メールアドレス<br><input type="email" name="mail_address"><br>
				<br><input type="submit" value="登録" >

	</form>
</div>




<footer></footer>
<script src="../js/date-input-control.js"></script>
<script src="MemberInformation

/js/phone-number-input-control.js"></script>

</body>

