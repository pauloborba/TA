<%@ page import="ta.Avaliacao" %>



<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="avaliacao.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nome" from="${avaliacaoInstance.constraints.nome.inList}" required="" value="${avaliacaoInstance?.nome}" valueMessagePrefix="avaliacao.nome"/>

</div>
<!--
<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'conceito', 'error')} required">
	<label for="conceito">
		<g:message code="avaliacao.conceito.label" default="Conceito" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="conceito" from="${avaliacaoInstance.constraints.conceito.inList}" required="" value="${avaliacaoInstance?.conceito}" valueMessagePrefix="avaliacao.conceito"/>

</div>-->

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'meta', 'error')} required">
	<label for="meta">
		<g:message code="avaliacao.meta.label" default="Meta" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="meta" name="meta.id" from="${ta.Meta.list()}" optionKey="id" required="" value="${avaliacaoInstance?.meta?.id}" class="many-to-one"/>

</div>
<!--
<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'resultados', 'error')} ">
	<label for="resultados">
		<g:message code="avaliacao.resultados.label" default="Resultados" />

	</label>
	<g:select name="resultados" from="${ta.Resultado.list()}" multiple="multiple" optionKey="id" size="5" value="${avaliacaoInstance?.resultados*.id}" class="many-to-many"/>

</div>-->

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'turma', 'error')} required">
	<label for="turma">
		<g:message code="avaliacao.turma.label" default="Turma" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="turma" name="turma.id" from="${ta.Turma.list()}" optionKey="id" required="" value="${avaliacaoInstance?.turma?.id}" class="many-to-one"/>

</div>

<div id="list-student" class="content scaffold-list" role="main">
	<h1><g:message code="default.list.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<table>
		<thead>
		<tr>

			<g:sortableColumn property="name" title="${message(code: 'aluno.nome.label', default: 'Name')}" />

			<g:sortableColumn property="login" title="${message(code: 'aluno.login.label', default: 'Login CIn')}" />

			<g:sortableColumn property="conceito" title="${message(code: 'avaliacao.conceito.label', default: 'Conceito')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${ta.Aluno.list()}" status="i" var="alunoInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

				<td><g:link action="show" id="${alunoInstance.id}">${fieldValue(bean: alunoInstance, field: "nome")}</g:link></td>

				<td>${fieldValue(bean: alunoInstance, field: "loginCin")}</td>

				<td>
                    <g:select name="conceito" from="${avaliacaoInstance.constraints.conceito.inList}" conceito="${avaliacaoInstance?.conceito}" conceitoMessagePrefix="avaliacao.conceito"/>
				</td>

			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<g:paginate total="${avaliacaoInstanceCount ?: 0}" />
	</div>
</div>