
<%@ page import="ta.Discipline" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'discipline.label', default: 'Discipline')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-discipline" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-discipline" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'discipline.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="concepts" title="${message(code: 'discipline.concepts.label', default: 'Concepts')}" />
					
						<g:sortableColumn property="teacher" title="${message(code: 'discipline.teacher.label', default: 'Teacher')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${disciplineInstanceList}" status="i" var="disciplineInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${disciplineInstance.id}">${fieldValue(bean: disciplineInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: disciplineInstance, field: "concepts")}</td>
					
						<td>${fieldValue(bean: disciplineInstance, field: "teacher")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${disciplineInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
