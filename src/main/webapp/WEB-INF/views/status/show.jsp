<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Title: ${status.getTitle()}<br>
Description: ${status.getDescription()}<br>
Location: ${status.getLocation().getLocationName()}<br>
Privacy: ${status.getPrivacy()}<br>
Attachment:

<c:forEach var="image" items="${status.getStatusAttachmentList()}">
  <img src="/images/${image.getAttachmentPath()}" alt="" height="100px" width="100px"
       style="object-fit: cover"/>
</c:forEach>
<br>

</body>
</html>
