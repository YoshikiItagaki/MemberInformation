<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規情報登録</title>
</head>
<body>

<div>
	<table>
	<tr>
		<td><a href="/MemberInformation/views/register.jsp">登録</a></td>
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
	<%
		Messages msg = new Messages();
		out.println(msg.message().get("201"));
	%>
</div>
</body>
</html>