<%@ page import="ta.Sheet" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'concept.label', default: 'Sheet')}" />
	<title>Upload Sheet</title>
	<style type="text/css">
		.error{
			background-color: #DD2606;
			color: white;
			border: .1em solid black;
			margin: 2em 2em 1em;
			padding: 1em;
			width: 22em;
			border-radius: 0.6em;
		}
	</style>
</head>
<body>
<a href="#list-concept" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
	</ul>
</div>
<div>
	<h1>Upload Sheet</h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>

	<g:if test="${flash.error}">
		<div class="errors" role="status">${flash.error}</div>
	</g:if>

	<g:uploadForm controller="sheet" action = "submit">
		<input type="file" name = "datafile" size = "40"/>
		<g:submitButton  name="submit" value="submit"/>
	</g:uploadForm>
</div>
</body>
</html>
