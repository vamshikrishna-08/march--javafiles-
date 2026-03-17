<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 response.setHeader("Cache-Control","no-Cache,no-store,must-revalidate");  //http 1.1
 response.setHeader("Pragma","no-Cache");  //http 1.0
 response.setHeader("Expries", "0");  //proxies
 if(session.getAttribute("username")==null){
	 response.sendRedirect("login.jsp");
 }
 %>
 
 welcome... ${username}
 <a href="vedios.jsp">vedio here</a>
 
 <form action="logout">
 <input type ="submit"value="logout">
 </form>
</body>
</html>