
<%@ page import="ta.Matricula" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'matricula.label', default: 'Matricula')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-matricula" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-matricula" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list matricula">
			
				<g:if test="${matriculaInstance?.aluno}">
				<li class="fieldcontain">
					<span id="aluno-label" class="property-label"><g:message code="matricula.aluno.label" default="Aluno" /></span>
					
						<span class="property-value" aria-labelledby="aluno-label"><g:link controller="aluno" action="show" id="${matriculaInstance?.aluno?.id}">${matriculaInstance?.aluno?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>

				<div><h1></h1></div>

				<div id="list-avaliacao" class="content scaffold-list" role="main">

					<table>
						<thead>
						<tr>
							<g:sortableColumn property="nome" title="${message(code: 'avaliacao.nome.label', default: 'Nome')}" />
							<g:sortableColumn property="conceito" title="${message(code: 'avaliacao.conceito.label', default: 'Conceito')}" />
							<th><g:message code="avaliacao.meta.label" default="Meta" /></th>
							<th><g:message code="avaliacao.turma.label" default="Turma" /></th>
						</tr>
						</thead>
						<tbody>
						<g:each in="${matriculaInstance?.avaliacoes}" status="i" var="avaliacaoInstance">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

								<td><g:link controller="avaliacao"action="show" id="${avaliacaoInstance.id}">${fieldValue(bean: avaliacaoInstance, field: "nome")}</g:link></td>

								<td>${fieldValue(bean: avaliacaoInstance, field: "conceito")}</td>

								<td>${fieldValue(bean: avaliacaoInstance, field: "meta")}</td>

								<td>${fieldValue(bean: avaliacaoInstance, field: "turma")}</td>

							</tr>
						</g:each>
						</tbody>
					</table>
					<div class="pagination">
						<g:paginate total="${avaliacaoInstanceCount ?: 0}" />
					</div>
				</div>
			
			</ol>
			<g:form url="[resource:matriculaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${matriculaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
