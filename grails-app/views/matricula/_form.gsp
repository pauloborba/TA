<%@ page import="ta.Matricula" %>



<div class="fieldcontain ${hasErrors(bean: matriculaInstance, field: 'aluno', 'error')} required">
	<label for="aluno">
		<g:message code="matricula.aluno.label" default="Aluno" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="aluno" name="aluno.id" from="${ta.Aluno.list()}" optionKey="id" required="" value="${matriculaInstance?.aluno?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matriculaInstance, field: 'avaliacoes', 'error')} ">
	<label for="avaliacoes">
		<g:message code="matricula.avaliacoes.label" default="Avaliacoes" />
		
	</label>
	<g:select name="avaliacoes" from="${ta.Avaliacao.list()}" multiple="multiple" optionKey="id" size="5" value="${matriculaInstance?.avaliacoes*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matriculaInstance, field: 'turma', 'error')} required">
	<label for="turma">
		<g:message code="matricula.turma.label" default="Turma" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="turma" name="turma.id" from="${ta.Turma.list()}" optionKey="id" required="" value="${matriculaInstance?.turma?.id}" class="many-to-one"/>

</div>

