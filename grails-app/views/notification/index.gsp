<%--
  Created by IntelliJ IDEA.
  User: ess
  Date: 20/10/15
  Time: 14:28
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Notifications</title>
</head>

<body>
    <g:actionSubmit value="Read Notifications" action="show"/>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
</body>
</html>