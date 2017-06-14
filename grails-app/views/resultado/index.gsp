
<%@ page import="ta.Resultado" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'resultado.label', default: 'Resultado')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-resultado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-resultado" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="conceito" title="${message(code: 'resultado.conceito.label', default: 'Conceito')}" />
					
						<th><g:message code="resultado.meta.label" default="Meta" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${resultadoInstanceList}" status="i" var="resultadoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${resultadoInstance.id}">${fieldValue(bean: resultadoInstance, field: "conceito")}</g:link></td>
					
						<td>${fieldValue(bean: resultadoInstance, field: "meta")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${resultadoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
