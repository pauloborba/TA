
<%@ page import="ta.Turma" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'turma.label', default: 'Turma')}" />
		<title>Show Turma</title>
	</head>
	<body>
		<a href="#show-turma" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-turma" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list turma">
			
				<g:if test="${turmaInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="turma.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${turmaInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${turmaInstance?.matriculas}">
				<li class="fieldcontain">
					<span id="matriculas-label" class="property-label"><g:message code="turma.matriculas.label" default="Matriculas" /></span>
					
						<g:each in="${turmaInstance.matriculas}" var="m">
						<span class="property-value" aria-labelledby="matriculas-label"><g:link controller="matricula" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${turmaInstance?.metas}">
				<li class="fieldcontain">
					<span id="metas-label" class="property-label"><g:message code="turma.metas.label" default="Metas" /></span>
					
						<g:each in="${turmaInstance.metas}" var="m">
						<span class="property-value" aria-labelledby="metas-label"><g:link controller="meta" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:turmaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${turmaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link elementId="enviarEmailAlunosComProblemas" action="enviarEmailAlunosComProblemas" resource="${turmaInstance}">Envia email para alunos com problemas</g:link>
					<g:link elementId="enviarEmailAutoAvaliacao" action="enviarEmailAutoAvaliacao" resource="${turmaInstance}">Envia email para autoavaliação</g:link>

				</fieldset>
			</g:form>
		</div>
	</body>
</html>
