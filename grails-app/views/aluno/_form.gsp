<%@ page import="ta.Aluno" %>



<div class="fieldcontain ${hasErrors(bean: alunoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="aluno.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${alunoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: alunoInstance, field: 'loginCin', 'error')} required">
	<label for="loginCin">
		<g:message code="aluno.loginCin.label" default="Login Cin" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="loginCin" required="" value="${alunoInstance?.loginCin}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: alunoInstance, field: 'loginSlack', 'error')} required">
	<label for="loginSlack">
		<g:message code="aluno.loginSlack.label" default="Login Slack" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="loginSlack" required="" value="${alunoInstance?.loginSlack}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: alunoInstance, field: 'loginGitHub', 'error')} required">
	<label for="loginGitHub">
		<g:message code="aluno.loginGitHub.label" default="Login Git Hub" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="loginGitHub" required="" value="${alunoInstance?.loginGitHub}"/>

</div>

