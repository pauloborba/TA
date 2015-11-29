
<%@ page import="ta.Discipline" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'discipline.label', default: 'Discipline')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-discipline" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-discipline" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list discipline">
			
				<g:if test="${disciplineInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="discipline.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${disciplineInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${disciplineInstance?.concepts}">
				<li class="fieldcontain">
					<span id="concepts-label" class="property-label"><g:message code="discipline.concepts.label" default="Concepts" /></span>
					
						<span class="property-value" aria-labelledby="concepts-label"><g:fieldValue bean="${disciplineInstance}" field="concepts"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${disciplineInstance?.teacher}">
				<li class="fieldcontain">
					<span id="teacher-label" class="property-label"><g:message code="discipline.teacher.label" default="Teacher" /></span>
					
						<span class="property-value" aria-labelledby="teacher-label"><g:fieldValue bean="${disciplineInstance}" field="teacher"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:disciplineInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${disciplineInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
