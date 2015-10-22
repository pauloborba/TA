<%@ page import="ta.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="student.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="student.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" maxlength="20" required="" value="${studentInstance?.login}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="student.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${studentInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'active', 'error')} ">
	<label for="active">
		<g:message code="student.active.label" default="Active" />
		
	</label>
	<g:checkBox name="active" value="${studentInstance?.active}" />

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="student.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${studentInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'autoEvaluations', 'error')} ">
	<label for="autoEvaluations">
		<g:message code="student.autoEvaluations.label" default="Auto Evaluations" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'evaluations', 'error')} ">
	<label for="evaluations">
		<g:message code="student.evaluations.label" default="Evaluations" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'passwordHash', 'error')} required">
	<label for="passwordHash">
		<g:message code="student.passwordHash.label" default="Password Hash" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="passwordHash" required="" value="${studentInstance?.passwordHash}"/>

</div>

