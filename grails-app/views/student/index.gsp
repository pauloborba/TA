
<%@ page import="ta.Student" %>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
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
		<li><g:link class="create" action="list"><g:message code="default.new.label" message="Manual Concept Input" /></g:link></li>
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

			<g:sortableColumn property="login" title="${message(code: 'student.login.label', default: 'Login')}" />

			<g:sortableColumn property="name" title="${message(code: 'student.name.label', default: 'Name')}" />

			<g:sortableColumn property="evaluations" title="${message(code: 'student.evaluations.label', default: 'Evaluations')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${studentInstanceList}" status="i" var="studentInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

				<td><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "login")}</g:link></td>

				<td>${fieldValue(bean: studentInstance, field: "name")}</td>

				<td>${fieldValue(bean: studentInstance, field: "evaluations")}</td>

			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<g:paginate total="${studentInstanceCount ?: 0}" />
	</div>
</div>
<!--Eu que fiz essa parte-->
%{--<div>--}%
%{--<table>--}%
%{--<thead>--}%
%{--<tr>--}%

%{--<g:sortableColumn property="login" title="${message(code: 'student.login.label', default: 'Login')}" />--}%

%{--<g:sortableColumn property="name" title="${message(code: 'student.name.label', default: 'Name')}" />--}%

%{--<g:each in="${EvaluationCriterion.findAll()}" var="evCriterion">--}%
%{--<g:sortableColumn property="evaluations" title="${evCriterion.name}" />--}%
%{--</g:each>--}%
%{--</tr>--}%
%{--</thead>--}%
%{--<tbody>--}%
%{--<g:each in="${studentInstanceList}" status="i" var="studentInstance">--}%
%{--<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">--}%

%{--<td><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "login")}</g:link></td>--}%

%{--<td>${fieldValue(bean: studentInstance, field: "name")}</td>--}%

%{--<g:each in="${EvaluationCriterion.findAll()}" var="evCriterion">--}%
%{--<td>--}%
%{--<g:select id="${studentInstance.login}+/+${evCriterion.name}" name="selector"--}%
%{--from="${ta.Student.Concept.CONCEPTS}"--}%
%{--value="${studentInstance.evaluations.get(evCriterion.name)}"--}%
%{--onchange="${remoteFunction(--}%
%{--action: 'updateConcepts',--}%
%{--params:'\'studentCriterion=\' + this.id + \'&concept=\' + this.value'--}%
%{--)}"--}%
%{--/>--}%
%{--</td>--}%
%{--</g:each>--}%
%{--</tr>--}%
%{--</g:each>--}%
%{--</tbody>--}%
%{--</table>--}%
%{--</div>--}%
</body>
</html>
=======
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
					
						<g:sortableColumn property="name" title="${message(code: 'student.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="login" title="${message(code: 'student.login.label', default: 'Login')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'student.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="active" title="${message(code: 'student.active.label', default: 'Active')}" />
					
						<g:sortableColumn property="enabled" title="${message(code: 'student.enabled.label', default: 'Enabled')}" />
					
						<g:sortableColumn property="autoEvaluations" title="${message(code: 'student.autoEvaluations.label', default: 'Auto Evaluations')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${studentInstanceList}" status="i" var="studentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: studentInstance, field: "login")}</td>
<<<<<<< HEAD
					
						<td>${fieldValue(bean: studentInstance, field: "email")}</td>
					
						<td><g:formatBoolean boolean="${studentInstance.active}" /></td>
					
						<td><g:formatBoolean boolean="${studentInstance.enabled}" /></td>
					
=======
					
						<td>${fieldValue(bean: studentInstance, field: "email")}</td>
					
						<td><g:formatBoolean boolean="${studentInstance.active}" /></td>
					
						<td><g:formatBoolean boolean="${studentInstance.enabled}" /></td>
					
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
						<td>${fieldValue(bean: studentInstance, field: "autoEvaluations")}</td>
					
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
<<<<<<< HEAD
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
=======
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
