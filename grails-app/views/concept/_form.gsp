<%@ page import="ta.Concept" %>



<div class="fieldcontain ${hasErrors(bean: conceptInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="concept.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${conceptInstance?.nome}"/>

</div>

