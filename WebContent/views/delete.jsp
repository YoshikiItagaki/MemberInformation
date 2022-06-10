<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="header.html" %>
<title>登録情報の削除</title>

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
	<form action="../jp/co/aforce/delete/delete"  method="post">
	会員番号<input type="text" name="member_id">
	<input type="submit" value="削除">
	</form>
</div>



<%@ include file="footer.html" %>