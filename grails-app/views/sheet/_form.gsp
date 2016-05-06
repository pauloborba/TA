<%@ page import="ta.Sheet" %>



<div class="fieldcontain ${hasErrors(bean: conceptInstance, field: 'concept', 'error')} required">
	<label for="concept">
		<g:message code="concept.concept.label" default="Concept" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="concept" required="" value="${conceptInstance?.concept}"/>

</div>
