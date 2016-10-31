<%@ page import="ta.Class" %>

<div class="fieldcontain ${hasErrors(bean: classInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="class.classID.label" default="Identificador" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="identificador" required="" value="${classInstance?.classID}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: classInstance, field: 'periodo', 'error')} required">
	<label for="periodo">
		<g:message code="class.periodo.label" default="Periodo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="periodo" required="" value="${classInstance?.periodo}"/>

</div>

