
<%@ page import="ta.Avaliacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'avaliacao.label', default: 'Avaliacao')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-avaliacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-avaliacao" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list avaliacao">
			
				<g:if test="${avaliacaoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="avaliacao.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${avaliacaoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${avaliacaoInstance?.conceito}">
				<li class="fieldcontain">
					<span id="conceito-label" class="property-label"><g:message code="avaliacao.conceito.label" default="Conceito" /></span>
					
						<span class="property-value" aria-labelledby="conceito-label"><g:fieldValue bean="${avaliacaoInstance}" field="conceito"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${avaliacaoInstance?.meta}">
				<li class="fieldcontain">
					<span id="meta-label" class="property-label"><g:message code="avaliacao.meta.label" default="Meta" /></span>
					
						<span class="property-value" aria-labelledby="meta-label"><g:link controller="meta" action="show" id="${avaliacaoInstance?.meta?.id}">${avaliacaoInstance?.meta?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${avaliacaoInstance?.resultados}">
				<li class="fieldcontain">
					<span id="resultados-label" class="property-label"><g:message code="avaliacao.resultados.label" default="Resultados" /></span>
					
						<g:each in="${avaliacaoInstance.resultados}" var="r">
						<span class="property-value" aria-labelledby="resultados-label"><g:link controller="resultado" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${avaliacaoInstance?.turma}">
				<li class="fieldcontain">
					<span id="turma-label" class="property-label"><g:message code="avaliacao.turma.label" default="Turma" /></span>
					
						<span class="property-value" aria-labelledby="turma-label"><g:link controller="turma" action="show" id="${avaliacaoInstance?.turma?.id}">${avaliacaoInstance?.turma?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:avaliacaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${avaliacaoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
