<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Edit Product</h2>

<form action="updateProduct" method="post">
    <input type="hidden" name="id" value="${product.id}">

    Name: <input type="text" name="name" value="${product.name}"><br>
    Price: <input type="text" name="price" value="${product.price}"><br>
    Quantity: <input type="text" name="quantity" value="${product.quantity}"><br>
    Category: <input type="text" name="category" value="${product.category}"><br>

    <input type="submit" value="Update Product">
</form>
</body>
</html>