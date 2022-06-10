

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>登録情報の更新</title>
</head>
<body>

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

	<p>会員番号を入力してください</p>
	<form action="../jp/co/aforce/update/update"  method="post">
	会員番号	<input type="text" name="member_id" value ="${list[0].member_id}">
	<input type="submit" value="送信">
	</form>
<%-- ${list.member_id
 --%>
</div>

<div>


	<p>更新する情報を入力してください。</p>
	<form action="update2
	"  method="post">
		姓<br><input type="text" name="last_name"  value="${list[0].last_name }"><br>
		名<br><input type="text" name="first_name" value="${list[0].first_name }"><br>
		性別:<br><input type="radio" name="sex" value="1">
			<label for="male">男</label>
		<input type="radio" name = "sex" value="2">
			<label for="female">女</label><br><br>
		<div class="form-select-wrap">
			誕生年:${list[0].birth_year }
			<br><select name="birth_year" class="birth_year" ></select><br>
			誕生月:${list[0].birth_month }
			<br><select name="birth_month" class="birth_month"  ></select><br>
			誕生日:${list[0].birth_day }
			<br><select name="birth_day" class="birth_day" ></select><br>
		</div>

		職業:${list[6].job }<br>
		<select name="job">
			<option value="100">会社員</option>
			<option value="200">自営業</option>
			<option value="300">学生</option>
			<option value="400">その他</option>
		</select><br>
		電話番号<br><input type="number" name="phone_number" value="${list[0].phone_number }"><br>
		メールアドレス<br><input type="email" name="mail_address" value="${list[0].mail_address }"><br>
		<input type="hidden" name="member_id"  value="${list[9].member_id}" >

		<br><input type="submit" value="更新" >
	</form>




</div>



<footer></footer>
<script src="/MemberInformation/js/date-input-control.js"></script>

</body>
</html>



