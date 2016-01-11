
<%@ page import="ta.Student" %>
<!DOCTYPE html>
<html>
<head>
	<style>
	styleM1 {
		color: red;
	}
	</style>
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
		<li><g:link class="create" action="list"><g:message code="default.new.label" message="Manual Concept Input" /></g:link></li>
	</ul>
</div>
<div id="list-student" class="content scaffold-list" role="main">
	<h1><g:message code="default.list.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<g:if test="${flash.error}">
		<div class="errors" role="status">${flash.error}</div>
	</g:if>
	<table>
		<thead>
		<tr>

			<g:sortableColumn property="login" title="${message(code: 'student.login.label', default: 'Login')}" />

			<g:sortableColumn property="name" title="${message(code: 'student.name.label', default: 'Name')}" />

			<g:sortableColumn property="evaluations" title="${message(code: 'student.evaluations.label', default: 'Evaluations')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${studentInstanceList}" status="i" var="studentInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<g:form controller="student">
				<td><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "login")}</g:link></td>
				<g:hiddenField name="studentId" value="${studentInstance.login}"></g:hiddenField>

				<td id="${studentInstance.login}"><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "login")}</g:link></td>

				<td id="${studentInstance.login}Name">${fieldValue(bean: studentInstance, field: "name")}</td>

				<td id="${studentInstance.login}Criteria">${fieldValue(bean: studentInstance, field: "finalGrades")}</td>

				<td><g:actionSubmit value="Compare" action = "compareGrade" id="${studentInstance.login}Compare" ></g:actionSubmit></td>

				</g:form>
			</tr>
		</g:each>
		</tbody>
	</table>

<g:if test="${booleanWorked}">
	<g:render template="compare"/>
</g:if>

	<div class="pagination">
		<g:paginate total="${studentInstanceCount ?: 0}" />
	</div>
</div>
</body>
</html>