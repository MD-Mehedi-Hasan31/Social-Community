<%--
  Created by IntelliJ IDEA.
  User: mehedi
  Date: 6/13/22
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>WELCOME TO THH SOCIAL COMMUNITY</h1> </br>

<h4>Location</h4>
<a href="${pageContext.request.contextPath}/location/createLocation" target="_blank">Create Location</a> <br>
<a href="${pageContext.request.contextPath}/location/show" target="_blank">Location List</a> <br><br>
<h4>User</h4>
<a href="${pageContext.request.contextPath}/user/addUser" target="_blank">Create User</a> <br>
<a href="${pageContext.request.contextPath}/user/users" target="_blank">User List</a> <br><br>
<h4>Status</h4>
<a href="${pageContext.request.contextPath}/status/create" target="_blank">Create Status</a> <br>
<a href="${pageContext.request.contextPath}/status/list" target="_blank">Status List</a> <br><br>


</body>
</html>
