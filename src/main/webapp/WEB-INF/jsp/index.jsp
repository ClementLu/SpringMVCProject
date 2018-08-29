<%@page import="mvc.entity.User"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${loginUser.username }的页面</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/my.css">
</head>

<body>
	<%
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
	%>
	<div align="center">
		<h1>你好，${loginUser.username }</h1>

		<table border="1">
			<tr>
				<td>大学名称</td>
				<td>大学所在城市</td>
				<td>入口</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${colleages}" var="c">
				<tr>
					<td>${c.name}</td>
					<td>${c.address}</td>
					<td><a href="../colleage/${c.id }/jump">大学页面</a></td>
					<td><a href="../colleage/${c.id }/delete" class="deleteBtn">删除</a></td>
				</tr>
			</c:forEach>
		</table>

		<a href="/springMVCStudy/colleage/add">添加大学</a> <a href="logout">退出</a> <br>

		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery.min.js"></script>

		<script type="text/javascript">
			$(function() {
				$(".deleteBtn").click(function() {
					if (!confirm("确定删除学校吗？")) {
						return false;
					}
				})
			})
		</script>
	</div>
</body>
</html>