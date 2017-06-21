<%@ page import="ta.Resultado" %>



<div class="fieldcontain ${hasErrors(bean: resultadoInstance, field: 'conceito', 'error')} required">
	<label for="conceito">
		<g:message code="resultado.conceito.label" default="Conceito" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="conceito" from="${resultadoInstance.constraints.conceito.inList}" required="" value="${resultadoInstance?.conceito}" valueMessagePrefix="resultado.conceito"/>

</div>

<div class="fieldcontain ${hasErrors(bean: resultadoInstance, field: 'meta', 'error')} required">
	<label for="meta">
		<g:message code="resultado.meta.label" default="Meta" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="meta" name="meta.id" from="${ta.Meta.list()}" optionKey="id" required="" value="${resultadoInstance?.meta?.id}" class="many-to-one"/>

</div>

