<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Status</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/css">
</head>
<body>

        <div class="container-fluid">
             <div class="row">
                 <div class="col-md-9">

                     <%--@elvariable id="status" type="com.sc.dto.StatusDto"--%>
                     <form:form action="${pageContext.request.contextPath}/status/store" method="post"
                     modelAttribute="status" enctype="multipart/form-data">

                         <div class="form-group">
                             <label for="title">Title</label>
                             <form:input type="text" cssClass="form-control" id="title" placeholder="title" path="title"/>
                         </div>

                         <div class="form-group">
                             <label for="description">Description</label>
                             <form:input type="text" cssClass="form-control" id="description" placeholder="description" path="description"/>
                         </div>

                         <form:select cssClass="dropdown" path="location">
                             <form:option selected="true" value="Select Location" disabled="true"/>
                             <form:options items="${locationList}" />
                         </form:select>
                         <br>

                         <form:select cssClass="dropdown" path="privacy">
                             <form:option selected="true" value="Select Privacy" disabled="true"/>
                             <form:options items="${privacyList}" />
                         </form:select>
                         <br>

                         <input type="file"  name="images" multiple="multiple" accept="image/*"/>

                         <button type="submit" class="btn btn-primary">Create</button>

                     </form:form>


                 </div>

             </div>

        </div>
</body>
</html>
