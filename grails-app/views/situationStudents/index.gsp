<%--
  Created by IntelliJ IDEA.
  User: lavinia
  Date: 07/11/2016
  Time: 09:13
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="ta.Student" %>
<%@ page import="ta.Criterion" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Ver Situacao Controller</title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>
<div id="list-student" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="login" title="${message(code: 'student.login.label', default: 'Login')}" defaultOrder ="asc"/>

            <g:each in="${ta.Criterion.list()}" var="criterion">
                <g:sortableColumn property="average" title="${criterion.description}" />
            </g:each>
        </tr>
        </thead>
        <tbody>
        <g:each in="${studentInstanceList}" status="i" var="studentInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>${fieldValue(bean: studentInstance, field: "login")}</td>
                <g:each in="${studentInstance.criteriaAndEvaluations}"  status="j" var="criterion">
                    <td>${studentInstance.criteriaAndEvaluations[j].criterionAverage}</td>
                </g:each>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${studentInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>