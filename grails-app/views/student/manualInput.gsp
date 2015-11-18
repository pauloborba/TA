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
    <title><g:message code="default.list.label" args="[entityName]" /></title>
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
    <td>
        Login
    </td>
    <g:each in="${criteria}">
        <td>
            ${it.name}
        </td>
    </g:each>
    </thead>
    <g:each in="${students}" status="i" var="studentInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "login")}</g:link></td>

            <g:each in="${criteria}" var="evCriterion">
                <td>
                    %{--value="${studentInstance.evaluations.get(evCriterion.name)}"--}%
                    <g:select id="${studentInstance.login}+/+${evCriterion.name}" name="selector"
                              from="${ta.Student.Concept.CONCEPTS}"

                              onchange="${remoteFunction(
                                      action: 'updateConcepts',
                                      params:'\'studentCriterion=\' + this.id + \'&concept=\' + this.value'
                              )}"
                              noSelection="['':'Concepts']"/>
                </td>
            </g:each>
        </tr>
    </g:each>
</table>
</div>
</body>
</html>