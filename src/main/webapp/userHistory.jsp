<%@ page import="com.fujie.edu.javabean.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fujie.edu.dao.BookDao" %><%--
  Created by IntelliJ IDEA.
  User: 付洁
  Date: 2021/5/24
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userHistory</title>
</head>
<body>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default bootstrap-admin-no-table-panel">
            <div class="panel-heading">
                <div class="text-muted bootstrap-admin-box-title">图书借阅信息</div>
            </div>

        </div>
    </div>
</div>


<div class="row">
    <div class="col-lg-12">
        <table id="data_list" class="table table-hover table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>图书号</th>
                <th>图书名称</th>
                <th>图书作者</th>
                <th>种类</th>
                <th>描述</th>
<%--                <th>截止还书日期</th>--%>
<%--                <th>操作</th>--%>

            </tr>
            </thead>


            			<!---在此插入信息-->
            			<%
            				ArrayList<Book> bookdata = new ArrayList<Book>();
            				bookdata = (ArrayList<Book>)request.getAttribute("data");
            				if(bookdata==null){
            					BookDao bookdao = new BookDao();
            					bookdata = (ArrayList<Book>)bookdao.get_HistoryListInfo2(1);
            				}
            				for (Book bean : bookdata){
            			%>
            			<tbody>
            			<td><%= bean.getId() %></td>
            			<td><%= bean.getName() %></td>
            			<td><%= bean.getAuthor() %></td>
            			<td><%= bean.getSort() %></td>
            			<td><%= bean.getDescription() %></td>
<%--            			<td><%= bean.getStore %></td>--%>
<%--            			<td><button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#updateModal"--%>
<%--            						id="btn_update" onclick="haibook(<%= bean.getHid() %>)">还书</button>--%>
            			</td>
            			</tbody>
            			<%} %>
        </table>
    </div>
</div>
</div>
</body>
</html>
