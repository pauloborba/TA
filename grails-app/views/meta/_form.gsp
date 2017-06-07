<%@ page import="ta.Meta" %>



<div class="fieldcontain ${hasErrors(bean: metaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="meta.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${metaInstance?.nome}"/>

</div>

