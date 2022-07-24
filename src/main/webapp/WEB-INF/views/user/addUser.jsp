<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mehedi
  Date: 7/17/22
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="user" type=""--%>
<form:form action="/saveUser" enctype="multipart/form-data" method="post" modelAttribute="user">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Name</label>
                <form:input path="username" type="text" class="form-control" required="true"></form:input>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Email</label>
                <form:input path="email" type="text" class="form-control" required="true"></form:input>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Password</label>
                <form:input path="password" type="password" class="form-control" required="true"></form:input>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="location">Location</label>
                <br/>
                <from:select path="locationId" class="form-select form-control" name="location_id" id="location">
                    <option selected disabled>Select Location</option>
                    <c:forEach var="location" items="${locationList}">
                        <option value="${location.getId()}">${location.getLocationName()}</option>
                    </c:forEach>
                </from:select>
            </div>
        </div>
<%--
        <div class="col-md-6">
            <div class="form-group file-field">
                <input class="form-control" type="file" name="attachment" id="contact-attachment">
                <label class="form-label" for="contact-attachment">
                    <i class="fas fa-folder mr-2"></i>
                    Upload Profile Picture...
                </label>
            </div>
        </div>

    </div>
--%>
    <div class="form-group">
        <input type="submit" class="btn btn-success" value="Save">
    </div>
</form:form>
</body>
</html>
