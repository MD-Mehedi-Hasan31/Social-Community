<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mehedi
  Date: 6/18/22
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Lacation</title>
</head>
<body>
<%--@elvariable id="location" type="com.sc.entity.Location"--%>
<form:form
        action="/saveLocation"
        method="post"
        modelAttribute="location"
>
    Location:
    <form:input
             path="locationName"
             cssClass="form-control"
             type="text"
             value="${location.locationName}"
             required="true"
    />
    <br/>

    <button type="submit" class="btn btn-primary">Save</button>
</form:form>
</body>
</html>
