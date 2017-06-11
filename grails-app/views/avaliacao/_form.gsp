<%@ page import="ta.Avaliacao" %>



<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="avaliacao.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nome" from="${avaliacaoInstance.constraints.nome.inList}" required="" value="${avaliacaoInstance?.nome}" valueMessagePrefix="avaliacao.nome"/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'conceito', 'error')} required">
	<label for="conceito">
		<g:message code="avaliacao.conceito.label" default="Conceito" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="conceito" from="${avaliacaoInstance.constraints.conceito.inList}" required="" value="${avaliacaoInstance?.conceito}" valueMessagePrefix="avaliacao.conceito"/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'meta', 'error')} required">
	<label for="meta">
		<g:message code="avaliacao.meta.label" default="Meta" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="meta" name="meta.id" from="${ta.Meta.list()}" optionKey="id" required="" value="${avaliacaoInstance?.meta?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'resultados', 'error')} ">
	<label for="resultados">
		<g:message code="avaliacao.resultados.label" default="Resultados" />
		
	</label>
	<g:select name="resultados" from="${ta.Resultado.list()}" multiple="multiple" optionKey="id" size="5" value="${avaliacaoInstance?.resultados*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'turma', 'error')} required">
	<label for="turma">
		<g:message code="avaliacao.turma.label" default="Turma" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="turma" name="turma.id" from="${ta.Turma.list()}" optionKey="id" required="" value="${avaliacaoInstance?.turma?.id}" class="many-to-one"/>

</div>

