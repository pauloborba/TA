<%@ page import="ta.Criterion" %>



<div class="fieldcontain ${hasErrors(bean: criterionInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="criterion.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${criterionInstance?.description}"/>

	<div class="fieldcontain ${hasErrors(bean: criterionInstance, field: 'turma', 'error')} required">
		<label for="turma">
			<g:message code="criterion.turma.label" default="Turma" />
			<span class="required-indicator">*</span>
		</label>
		<g:select id="turma" name="turma.id" from="${ta.Turma.list()}" optionKey="id" required="" optionValue="${{it.classID+'-'+it.periodo}}" value="${criterionInstance?.turma?.id}" class="many-to-one"/>

	</div>
</div>
