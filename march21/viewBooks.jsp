<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.model.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr><th>ID</th><th>Title</th><th>Author</th><th>Category</th><th>Qty</th><th>Action</th></tr>

<%
List<Book> list = (List<Book>)request.getAttribute("list");
for(Book b:list){
%>
<tr>
<td><%=b.getBook_id()%></td>
<td><%=b.getTitle()%></td>
<td><%=b.getAuthor()%></td>
<td><%=b.getCategory()%></td>
<td><%=b.getQuantity()%></td>
<td>
<a href="delete?id=<%=b.getBook_id()%>">Delete</a>
</td>
</tr>
<% } %>
</table>
<form action="search" method="get">
<input type="text" name="title" placeholder="Search by title">
<input type="submit" value="Search">
</form>

</body>
</html>