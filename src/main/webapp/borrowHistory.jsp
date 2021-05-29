
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>借阅历史</title>
	<link rel="stylesheet" href="./layui/css/layui.css" />
</head>
<body>
<table class="layui-table" style="table-layout:fixed">
	<colgroup>
		<col width="150">
		<col width="150">
		<col width="200">
		<col>
		<col width="180">
	</colgroup>
	<thead>
	<tr>
		<th>书名</th>
		<th>作者</th>
		<th>分类</th>
		<th>描述</th>
<%--		<th>操作</th>--%>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="book" items="${sessionScope.BORROW_BOOKS}"
			   varStatus="status">
		<tr>
			<td>${book.name}</td>
			<td>${book.author}</td>
			<td>${book.sort}</td>
			<td class="wrap-td">
				<div class="wrap-div">${book.description}</div>
			</td>
			<td>

<%--				<button--%>
<%--						class="layui-btn layui-btn-primary layui-btn-xs detail"--%>
<%--						id="info" index="${status.index}">查看--%>
<%--				</button>--%>
<%--				<button class="layui-btn layui-btn-xs borrow"--%>
<%--						id="borrow" index="${book.id}">还书--%>
<%--				</button>--%>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>
