
<%@ page import="ta.Aluno" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'aluno.label', default: 'Aluno')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-aluno" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-aluno" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list aluno">
			
				<g:if test="${alunoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="aluno.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${alunoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alunoInstance?.loginCin}">
				<li class="fieldcontain">
					<span id="loginCin-label" class="property-label"><g:message code="aluno.loginCin.label" default="Login Cin" /></span>
					
						<span class="property-value" aria-labelledby="loginCin-label"><g:fieldValue bean="${alunoInstance}" field="loginCin"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alunoInstance?.loginSlack}">
				<li class="fieldcontain">
					<span id="loginSlack-label" class="property-label"><g:message code="aluno.loginSlack.label" default="Login Slack" /></span>
					
						<span class="property-value" aria-labelledby="loginSlack-label"><g:fieldValue bean="${alunoInstance}" field="loginSlack"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alunoInstance?.loginGitHub}">
				<li class="fieldcontain">
					<span id="loginGitHub-label" class="property-label"><g:message code="aluno.loginGitHub.label" default="Login Git Hub" /></span>
					
						<span class="property-value" aria-labelledby="loginGitHub-label"><g:fieldValue bean="${alunoInstance}" field="loginGitHub"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:alunoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${alunoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
