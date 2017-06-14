<%@ page import="ta.Matricula" %>



<div class="fieldcontain ${hasErrors(bean: matriculaInstance, field: 'aluno', 'error')} required">
	<label for="aluno">
		<g:message code="matricula.aluno.label" default="Aluno" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="aluno" name="aluno.id" from="${ta.Aluno.list()}" optionKey="id" required="" value="${matriculaInstance?.aluno?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matriculaInstance, field: 'media', 'error')} required">
	<label for="media">
		<g:message code="matricula.media.label" default="Media" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="media" value="${fieldValue(bean: matriculaInstance, field: 'media')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: matriculaInstance, field: 'aprovacao', 'error')} required">
	<label for="aprovacao">
		<g:message code="matricula.aprovacao.label" default="Aprovacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="aprovacao" from="${matriculaInstance.constraints.aprovacao.inList}" required="" value="${matriculaInstance?.aprovacao}" valueMessagePrefix="matricula.aprovacao"/>

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

