
<%@ page import="ta.RegisteredStudent" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registeredStudent.label', default: 'RegisteredStudent')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-registeredStudent" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-registeredStudent" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list registeredStudent">
			
				<g:if test="${registeredStudentInstance?.criteriaAndEvaluations}">
				<li class="fieldcontain">
					<span id="criteriaAndEvaluations-label" class="property-label"><g:message code="registeredStudent.criteriaAndEvaluations.label" default="Criteria And Evaluations" /></span>
					
						<g:each in="${registeredStudentInstance.criteriaAndEvaluations}" var="c">
						<span class="property-value" aria-labelledby="criteriaAndEvaluations-label"><g:link controller="evaluationsByCriterion" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${registeredStudentInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="registeredStudent.student.label" default="Student" /></span>
					
						<span class="property-value" aria-labelledby="student-label"><g:link controller="student" action="show" id="${registeredStudentInstance?.student?.id}">${registeredStudentInstance?.student?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registeredStudentInstance?.turma}">
				<li class="fieldcontain">
					<span id="turma-label" class="property-label"><g:message code="registeredStudent.turma.label" default="Turma" /></span>
					
						<span class="property-value" aria-labelledby="turma-label"><g:link controller="turma" action="show" id="${registeredStudentInstance?.turma?.id}">${registeredStudentInstance?.turma?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:registeredStudentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${registeredStudentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
