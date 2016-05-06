<%@ page import="ta.Teachers" %>



<div class="fieldcontain ${hasErrors(bean: teachersInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="teachers.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${teachersInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teachersInstance, field: 'cpf', 'error')} required">
	<label for="cpf">
		<g:message code="teachers.cpf.label" default="Cpf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cpf" required="" value="${teachersInstance?.cpf}"/>

</div>

