<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input type="hidden" name="id" value="${book.book_id}">
Title: <input name="title" value="${book.title}"><br>
Author: <input name="author" value="${book.author}"><br>
Category: <input name="category" value="${book.category}"><br>
Quantity: <input name="quantity" value="${book.quantity}"><br>
<input type="submit" value="Update">
</form>
</body>
</html>