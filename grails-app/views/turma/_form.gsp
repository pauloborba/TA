<%@ page import="ta.Turma" %>



<div class="fieldcontain ${hasErrors(bean: turmaInstance, field: 'classID', 'error')} required">
	<label for="classID">
		<g:message code="turma.classID.label" default="Class ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="classID" required="" value="${turmaInstance?.classID}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: turmaInstance, field: 'periodo', 'error')} required">
	<label for="periodo">
		<g:message code="turma.periodo.label" default="Periodo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="periodo" required="" value="${turmaInstance?.periodo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: turmaInstance, field: 'students', 'error')} ">
	<label for="students">
		<g:message code="turma.students.label" default="Students" />

	</label>
	<g:select name="students" from="${ta.Student.list()}" multiple="multiple" optionKey="id" size="5" optionValue="login" value="${turmaInstance?.students*.id}" class="many-to-many"/>

</div>

