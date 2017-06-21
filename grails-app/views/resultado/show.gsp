
<%@ page import="ta.Resultado" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'resultado.label', default: 'Resultado')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-resultado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-resultado" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list resultado">
			
				<g:if test="${resultadoInstance?.conceito}">
				<li class="fieldcontain">
					<span id="conceito-label" class="property-label"><g:message code="resultado.conceito.label" default="Conceito" /></span>
					
						<span class="property-value" aria-labelledby="conceito-label"><g:fieldValue bean="${resultadoInstance}" field="conceito"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${resultadoInstance?.meta}">
				<li class="fieldcontain">
					<span id="meta-label" class="property-label"><g:message code="resultado.meta.label" default="Meta" /></span>
					
						<span class="property-value" aria-labelledby="meta-label"><g:link controller="meta" action="show" id="${resultadoInstance?.meta?.id}">${resultadoInstance?.meta?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:resultadoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${resultadoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
