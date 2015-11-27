<%--
  Created by IntelliJ IDEA.
  User: ess
  Date: 21/10/15
  Time: 12:08
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
    <title>Show Comparision</title>
</head>
<body>
<a href="#list-student" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>



<table>
    <thead>
    <th>

    </th>
    <g:each in="${criteria}">
        <th>
            ${it.name}
        </th>
    </g:each>
    </thead>
    <tr>
        <td>
            Professor
        </td>
        <g:each in="${criteria}" status="i" var="studentInstance">
         <td>
            ${student.finalGrades.get(studentInstance.name)}
         </td>
        </g:each>
    </tr>
    <tr>
        <td>
            Aluno
        </td>

        <g:each in="${criteria}" status="i" var="studentInstance">
          <td>
             ${student.autoEvaluations.get(studentInstance.name)}
          </td>
        </g:each>

    </tr>

</table>
</div>
</body>
</html>