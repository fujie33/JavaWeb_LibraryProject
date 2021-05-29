<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    Class.forName("con.mysql.cj.jdbc.Driver");
    try (Connection conn = DriverManager.getConnection("")){
        String sql = "select * from borrow_card where username = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,username);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    if (password.equals(resultSet.getNString("password"))){
                        response.sendRedirect("./main.jsp");
                    }else{
                        %>
                           <jsp:forward page = "index.jsp"></jsp:forward>
                        <%
                    }
                }

            }
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
%>

</body>
</html>
