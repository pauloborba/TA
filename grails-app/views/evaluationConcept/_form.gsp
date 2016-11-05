<%@ page import="ta.EvaluationConcept" %>



<div class="fieldcontain ${hasErrors(bean: evaluationConceptInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="evaluationConcept.name.label" default="Concepts" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${evaluationConceptInstance?.name}"/>

</div>

%{--<div class="fieldcontain ${hasErrors(bean: evaluationConceptInstance, field: 'concepts', 'error')} required">--}%
	%{--<label for="concepts">--}%
		%{--<g:message code="evaluationConcept.concepts.label" default="Concepts" />--}%
		%{--<span class="required-indicator">*</span>--}%
	%{--</label>--}%
	%{----}%

%{--</div>--}%

<div class="fieldcontain ${hasErrors(bean: evaluationConceptInstance, field: 'n_concepts', 'error')} required">
	<label for="n_concepts">
		<g:message code="evaluationConcept.n_concepts.label" default="Number of Concepts" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="n_concepts" type="number" value="${evaluationConceptInstance.n_concepts}" required=""/>

</div>

