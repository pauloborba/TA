
<%@ page import="ta.StudentsReport" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studentsReport.label', default: 'StudentsReport')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-studentsReport" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<!-- <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li> -->
			</ul>
		</div>
		<div id="list-studentsReport" class="content scaffold-list" role="main">
			<!-- <h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if> -->
			<!-- <table>
			<thead>
					<tr>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${studentsReportInstanceList}" status="i" var="studentsReportInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					</tr>
				</g:each>
				</tbody>
			</table> -->
			<!-- <div class="pagination">
				<g:paginate total="${studentsReportInstanceCount ?: 0}" />
			</div> -->

			<table style="width:100%">
				<tr>
					<th colspan="9">Relatório - Notas dos Alunos</th>
				</tr>
				<tr>
					<th>Nome</th>
					<th>Login</th>
					<th>MANA's Avaliados</th>
					<th>MPA's Avaliados</th>
					<th>MA's Avaliados</th>
					<th>Total de critérios avaliados</th>
					<th>Nota</th>
				</tr>
			<g:each var="student" in="${ta.Student.list()}">
				${student.calcMaMpaMana()}
				<g:if test="${student.average >= 7}">
					<tr id="${student.login}"; style="text-align: center; background-color: #418000">
				</g:if>
				<g:elseif test="${student.average < 7 && student.average >= 5}">
					<tr id="${student.login}"; style="text-align: center; background: yellow">
				</g:elseif>
				<g:elseif test="${student.average < 5}">
					<tr id="${student.login}"; style="text-align: center; background: red">
				</g:elseif>
					<td id="name${student.login}"> ${student.name}</td>
					<td id="login${student.login}"> ${student.login}</td>
					<td id="mana${student.login}"> ${student.mana}</td>
					<td id="mpa${student.login}"> ${student.mpa}</td>
					<td id="ma${student.login}"> ${student.ma}</td>
					<td id="total${student.login}"> ${student.total}</td>
					<td id="nota${student.login}"> ${student.average}</td>
				</tr>
			</g:each>
			</table>

			<br><br>

			<table style="width:100%">
				<tr>
					<th colspan="9">Relação geral dos alunos</th>
				</tr>
				<tr>
					<th>Aprovados por média</th>
					<th>Aprovados na Final</th>
					<th>Reprovados por falta</th>
					<th>Reprovados por nota</th>
					<th>Total de alunos</th>
				</tr>
				<g:set var="studentController" value="${new ta.StudentController()}" />
				<g:set var="totalAprovados" value="${studentController.getTotalAprovacoesReprovacoes("aprovados")}" />
				<g:set var="totalAprovadosFinal" value="${studentController.getTotalAprovacoesReprovacoes("aprovadosFinal")}" />
				<g:set var="totalReprovadosNota" value="${studentController.getTotalAprovacoesReprovacoes("reprovadosNota")}" />
				<g:set var="totalReprovadosFalta" value="${studentController.getTotalAprovacoesReprovacoes("reprovadosFalta")}" />
				<g:set var="totalAlunos" value="${ta.Student.list().size()}" />

				<tr style="text-align: center">
					<td id="aprovadosMedia">${totalAprovados}</td>
					<td id="aprovadosFinal">${totalAprovadosFinal}</td>
					<td id="reprovadosFalta">${totalReprovadosFalta}</td>
					<td id="reprovadosNota">${totalReprovadosNota}</td>
					<td id="totalAlunos">${totalAlunos}</td>
				</tr>
			</table>


		</div>
	</body>
</html>
