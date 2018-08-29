<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<form action="addColleage" method="post">
		<div align="center">
			<table>
				<tr>
					<th colspan="2">请在下面填写需要添加的大学信息</th>
				</tr>
				<tr>
					<td>大学名称：</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>