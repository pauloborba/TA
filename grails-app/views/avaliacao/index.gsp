
<%@ page import="ta.Avaliacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'avaliacao.label', default: 'Avaliacao')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-avaliacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="importarAvaliacao" action="importarAvaliacao"><g:message code="Importar Avaliacao" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-avaliacao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
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
				<g:each in="${avaliacaoInstanceList}" status="i" var="avaliacaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${avaliacaoInstance.id}">${fieldValue(bean: avaliacaoInstance, field: "nome")}</g:link></td>
					
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
	</body>
</html>
