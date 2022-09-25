<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mehedi
  Date: 6/18/22
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<div>
    <div>
        <div>
            <%--@elvariable id="userDto" type="com.sc.dto.UserRequestDto"--%>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>SL</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Location</th>
                        <th>Picture</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${user.getUsername()}</td>
                            <td>${user.getEmail()}</td>
                            <td>${user.getLocation().getLocationName()}</td>
                            <td> <img src="/file/get/${user.getAttachment().getId()}" alt="image not found" width="100" height="auto"></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                    <div>
                         <input type="submit" class="btn btn-success" value="Save"></input>
                     </div>
        </div>
    </div>
</div>
</body>
</html>
