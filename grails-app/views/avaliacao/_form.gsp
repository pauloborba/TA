<%@ page import="ta.Avaliacao" %>



<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="avaliacao.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${avaliacaoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'resultados', 'error')} ">
	<label for="resultados">
		<g:message code="avaliacao.resultados.label" default="Resultados" />
		
	</label>
	<g:select name="resultados" from="${ta.Resultado.list()}" multiple="multiple" optionKey="id" size="5" value="${avaliacaoInstance?.resultados*.id}" class="many-to-many"/>

</div>

