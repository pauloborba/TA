
<%@ page import="ta.Concept" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'concept.label', default: 'Concept')}" />
		<title>Upload Sheet</title>
	</head>
	<body>
		<a href="#list-concept" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div>
			<h1>Upload Sheet</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

<<<<<<< HEAD
<<<<<<< HEAD
			<input type="file" name = "datafile" size = "40"/>
			<input type="submit" value="Upload" name ="submit"/>
=======
=======
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
			<g:uploadForm controller="concept" action = "submit">

				<input type="file" name = "datafile" size = "40"/>
				%{--<g:actionSubmit  name="submit" value="submit"/>--}%
				<g:submitButton  name="submit" value="submit"/>
			</g:uploadForm>
<<<<<<< HEAD
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
=======
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
		</div>
	</body>
</html>
