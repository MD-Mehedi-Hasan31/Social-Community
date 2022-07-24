<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mehedi
  Date: 7/12/22
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        table, th, td {
            border: 1px solid black;
            border-radius: 10px;
        }
        th, td {
            background-color: #96D4D4;
        }
    </style>
</head>
<body>

<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>SL</th>
        <th>Location Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="location" items="${locationList}" varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td>${location.locationName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
