<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報の更新</title>
</head>
<body>

<div>
	<table>
	<tr>
		<td><a href="MemberInformation/views/register.jsp">登録</a></td>
	</tr>
	<tr>
		<td><a href="MemberInformation/views/update1.jsp">更新</a></td>
	</tr>
	<tr>
		<td><a href="MemberInformation/views/delete.jsp">削除</a></td>
	</tr>
</table>

</div>

<div>

	<%@page import = "java.io.PrintWriter" %>
	<%@page import = "jp.co.aforce.message.Messages" %>
	<%@page import = "jp.co.aforce.update.Update" %>
	<%
		Update update = new Update();

		Messages msg = new Messages();
		out.println(msg.message().get("203"));
	%>

</div>

</body>
</html>