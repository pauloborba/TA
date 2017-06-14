<%@ page import="ta.Turma" %>



<div class="fieldcontain ${hasErrors(bean: turmaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="turma.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${turmaInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: turmaInstance, field: 'matriculas', 'error')} ">
	<label for="matriculas">
		<g:message code="turma.matriculas.label" default="Matriculas" />
		
	</label>
	<g:select name="matriculas" from="${ta.Matricula.list()}" multiple="multiple" optionKey="id" size="5" value="${turmaInstance?.matriculas*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: turmaInstance, field: 'metas', 'error')} ">
	<label for="metas">
		<g:message code="turma.metas.label" default="Metas" />
		
	</label>
	<g:select name="metas" from="${ta.Meta.list()}" multiple="multiple" optionKey="id" size="5" value="${turmaInstance?.metas*.id}" class="many-to-many"/>

</div>

