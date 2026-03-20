<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<%@ page import="com.employee.Employee"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Employee List</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Department</th>
<th>Salary</th>
<th>Delete</th>
</tr>

<%
List<Employee> list = (List<Employee>) request.getAttribute("employeeList");

if(list != null && !list.isEmpty()){
    for(Employee e : list){
%>

<tr>
<td><%= e.getEmp_id() %></td>
<td><%= e.getEmp_name() %></td>
<td><%= e.getDepartment() %></td>
<td><%= e.getSalary() %></td>

<td>
<a href="DeleteEmployeeServlet?id=<%=e.getEmp_id()%>">Delete</a>
</td>

</tr>

<%
    }
}else{
%>

<tr>
<td colspan="5">No Employees Found</td>
</tr>

<%
}
%>

</table>

<br>

<a href="addEmployee.jsp">Add Employee</a>

</body>
</html>