<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ page import= "java.util.*;"%>   --%>//directive
<%!
  int coef = 3;    //declaration
  %>
   <h1> hello worldd </h1>
<%
   out.println(8+3);   //scriplet
%>
my fav number is <%= coef %> 
</body>
</html>