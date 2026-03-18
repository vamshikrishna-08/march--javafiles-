<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="com.student.DBConnection" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Students </title>
</head>
<body>
<h2> Students</h2>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<% 
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from students");
while (rs.next()){
 %>
<tr>
<td><%=rs.getInt("id") %></td>
<td><%=rs.getString("name") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getString("course") %></td>
<td>
<a href="editStudent.jsp?id=<%=rs.getInt("id")%>">Edit</a>
</td>
<td>
<a href="DeleteStudentServlet?id=<%=rs.getInt("id") %>"> Delete</a>
</td>
</tr>
<%
 }
%>
</table>
<br>
<a href="addstudent.jsp">Add Student</a>

</body>
</html>