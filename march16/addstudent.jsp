<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Add Student</title>
</head>
<body>
<h2>Student Registration</h2>
<form action="AddStudentServlet " method="post">
Name:
<input type="text" name ="name" required>
<br><br>

Email:
<input type="text" name ="email" required>
<br><br>

Course:
<input type="text" name ="course" required>
<br><br>

<input type="submit" value="Add Student">

</form>
<br>
<a href="viewStudents.jsp"> View Students</a>
</body>
</html>