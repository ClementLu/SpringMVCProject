<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<form action="user/register" method="post">
		<div align="center">
			<table>
				<tr>
					<th colspan="2">欢迎来到注册页面</th>
				</tr>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>昵称：</td>
					<td><input type="text" name="nickname"></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>