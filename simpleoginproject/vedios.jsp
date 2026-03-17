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
 
<iframe width="560" height="315" src="https://www.youtube.com/embed/bm0OyhwFDuY?si=yi_KRoUy_FwWq9mj" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
</body>
</html>