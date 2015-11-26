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
    <title>Manual Concept Input</title>
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

    <g:if test="${students.size() == 0 || criteria.size() == 0}">
        <div id="EmptyError">O sistema não possui nenhum estudante ou critérios cadastrados, volte mais tarde!</div>
    </g:if>
    <g:else>
    <g:each in="${students}" status="i" var="studentInstance">
        <g:if test="${i == 0}">
            <thead>
            <th>
                Login
            </th>
            <g:each in="${criteria}">
                <th>
                    ${it.name}
                </th>
            </g:each>
            <th>
                Actions
            </th>
            </thead>
        </g:if>
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "login")}</g:link></td>

            <g:form controller="student">
                <g:hiddenField name="studentId" value="${studentInstance.login}"></g:hiddenField>
                <g:each in="${criteria}" var="evCriterion">
                    <g:hiddenField name="criterionName" value="${evCriterion.name}"></g:hiddenField>
                <td>
                    <g:select id="${studentInstance.login}${evCriterion.name}" name="selector"
                              from="${ta.Student.Concept.CONCEPTS}"
                              noSelection="['':'Concepts']"/>
                </td>
            </g:each>
            <td>
            <g:actionSubmit value="Submeter" action="updateCriteria"  id="${studentInstance.id}"></g:actionSubmit>
            </td>
            </g:form>
        </tr>
    </g:each>
    </g:else>
</table>
</body>
</html>