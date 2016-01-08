<%@ page import="ta.Teacher" %>



<div class="fieldcontain ${hasErrors(bean: teacherInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="teacher.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${teacherInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teacherInstance, field: 'cpf', 'error')} required">
	<label for="cpf">
		<g:message code="teacher.cpf.label" default="CPF" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cpf" required="" value="${teacherInstance?.cpf}"/>

</div>

