
<%@ page import="ta.Class" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'class.label', default: 'Class')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-class" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-class" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list class">
			
				<g:if test="${classInstance?.classID}">
				<li class="fieldcontain">
					<span id="classID-label" class="property-label"><g:message code="class.classID.label" default="Class ID" /></span>
					
						<span class="property-value" aria-labelledby="classID-label"><g:fieldValue bean="${classInstance}" field="classID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${classInstance?.periodo}">
				<li class="fieldcontain">
					<span id="periodo-label" class="property-label"><g:message code="class.periodo.label" default="Periodo" /></span>
					
						<span class="property-value" aria-labelledby="periodo-label"><g:fieldValue bean="${classInstance}" field="periodo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${classInstance?.students}">
				<li class="fieldcontain">
					<span id="students-label" class="property-label"><g:message code="class.students.label" default="Students" /></span>
					
						<g:each in="${classInstance.students}" var="s">
						<span class="property-value" aria-labelledby="students-label"><g:link controller="student" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:classInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${classInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
