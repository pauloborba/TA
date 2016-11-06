<%@ page import="ta.EvaluationConcept" %>



<div class="fieldcontain ${hasErrors(bean: evaluationConceptInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="evaluationConcept.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${evaluationConceptInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: evaluationConceptInstance, field: 'conceitos', 'error')} ">
	<label for="conceitos">
		<g:message code="evaluationConcept.conceitos.label" default="conceitos" />
		
	</label>
	<g:select name="conceitos" from="${ta.Concept.list()}" multiple="multiple" optionKey="id" size="5" value="${evaluationConceptInstance?.conceitos*.id}" class="many-to-many"/>

</div>

