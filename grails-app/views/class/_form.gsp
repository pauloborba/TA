<%@ page import="ta.Class" %>



<div class="fieldcontain ${hasErrors(bean: classInstance, field: 'classID', 'error')} required">
	<label for="classID">
		<g:message code="class.classID.label" default="Class ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="classID" required="" value="${classInstance?.classID}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: classInstance, field: 'periodo', 'error')} required">
	<label for="periodo">
		<g:message code="class.periodo.label" default="Periodo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="periodo" required="" value="${classInstance?.periodo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: classInstance, field: 'students', 'error')} ">
	<label for="students">
		<g:message code="class.students.label" default="Students" />
		
	</label>
	<g:select name="students" from="${ta.Student.list()}" multiple="multiple" optionKey="id" size="5" optionValue="login" value="${classInstance?.students*.id}" class="many-to-many"/>

</div>

