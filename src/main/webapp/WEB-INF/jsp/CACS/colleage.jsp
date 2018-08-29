<%@page import="mvc.entity.Colleage"%>
<%@page import="mvc.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${chosenColleage.name }的主页面</title>
</head>
<body>
	<%
		Colleage colleage = (Colleage) session.getAttribute("chosenColleage");
		User lu = (User) session.getAttribute("loginUser");
		if (lu == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		/*if (colleage == null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}*/
	%>

	<div align="center">
		<table border="1">
			<tr>
				<td>学院名称</td>
				<td>学院已有班级</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${chosenColleage.academies}" var="a">
				<tr>
					<td>${a.name}</td>
					<td><a href="academy/${a.id }/jump">学院页面</a></td>
					<td><a href="academy/${a.id }/delete" class="deleteBtn">删除</a></td>
				</tr>
			</c:forEach>
		</table>

		<a href="addNewAcademy">添加学院</a>
	</div>

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

</body>
</html>