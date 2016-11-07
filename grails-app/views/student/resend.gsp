
<%@ page import="ta.Student" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
	<title>${message(code:'default.resendEmail.label', default:	'Resend Evaluations')}</title>
</head>
<body>
	<div>There are no not sent evaluations, do you want to resend all?
		<li><g:link class="yes" action="sendAll"><g:message code="default.yes.label" default="Yes" /><!--talk to rodrigo--></g:link></li>
		<li><g:link class="no" action="index"><g:message code="default.no.label" default="No" /></g:link></li>
	</div>
</body>
</html>