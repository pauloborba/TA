
<%@ page import="ta.EvaluationConcept" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'evaluationConcept.label', default: 'EvaluationConcept')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-evaluationConcept" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-evaluationConcept" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'evaluationConcept.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="concepts" title="${message(code: 'evaluationConcept.concepts.label', default: 'Concepts')}" />
					
						<g:sortableColumn property="n_concepts" title="${message(code: 'evaluationConcept.n_concepts.label', default: 'Nconcepts')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${evaluationConceptInstanceList}" status="i" var="evaluationConceptInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${evaluationConceptInstance.id}">${fieldValue(bean: evaluationConceptInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: evaluationConceptInstance, field: "concepts")}</td>
					
						<td>${fieldValue(bean: evaluationConceptInstance, field: "n_concepts")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${evaluationConceptInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
