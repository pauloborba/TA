<%@ page import="ta.Turma" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'turma.label', default: 'Turma')}" />
		<title>Enviar Email</title>
	</head>
	<body>
		<a href="#edit-turma" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-turma" class="content scaffold-edit" role="main">
			<g:each in="${alunos}" status="i" var="aluno">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

					<td>${aluno.nome}</td>

				</tr>
			</g:each>
		</div>
	</body>
</html>
