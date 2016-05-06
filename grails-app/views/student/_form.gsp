<%@ page import="ta.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="student.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" required="" value="${studentInstance?.login}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="student.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="student.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${studentInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'evaluations', 'error')} ">
	<label for="evaluations">
		<g:message code="student.evaluations.label" default="Evaluations" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'finalGrades', 'error')} ">
	<label for="finalGrades">
		<g:message code="student.finalGrades.label" default="Final Grades" />
		
	</label>
	

</div>

