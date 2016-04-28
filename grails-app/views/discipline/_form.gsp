<%@ page import="ta.Discipline" %>



<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="discipline.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${disciplineInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'concepts', 'error')} required">
	<label for="concepts">
		<g:message code="discipline.concepts.label" default="Concepts" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="concepts" required="" value="${disciplineInstance?.concepts}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'teacher', 'error')} required">
	<label for="teacher">
		<g:message code="discipline.teacher.label" default="Teacher" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="teacher" required="" value="${disciplineInstance?.teacher}"/>

</div>

