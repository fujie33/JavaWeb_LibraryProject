<%--
  Created by IntelliJ IDEA.
  User: 付洁
  Date: 2021/5/25
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏列表</title>
    <link rel="stylesheet" href="./layui/css/layui.css" />
    <style>
        .wrap-div {
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 3;
            overflow: hidden;
            float: left;
            width: 100%;
            word-break: break-all;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body>
<b>收藏列表</b>

<div class="layui-form" id="content">
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
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${sessionScope.books}"
                   varStatus="status">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.sort}</td>
                <td class="wrap-td">
                    <div class="wrap-div">${book.description}</div>
                </td>
                <td>
                    <button
                            class="layui-btn layui-btn-primary layui-btn-xs detail"
                            id="info" index="${status.index}">查看
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div id="page" style="display: flex;justify-content: center;">
</div>

</body>
</html>
