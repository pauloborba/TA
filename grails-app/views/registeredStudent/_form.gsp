<%@ page import="ta.RegisteredStudent" %>



<div class="fieldcontain ${hasErrors(bean: registeredStudentInstance, field: 'criteriaAndEvaluations', 'error')} ">
	<label for="criteriaAndEvaluations">
		<g:message code="registeredStudent.criteriaAndEvaluations.label" default="Criteria And Evaluations" />
		
	</label>
	<g:select name="criteriaAndEvaluations" from="${ta.EvaluationsByCriterion.list()}" multiple="multiple" optionKey="id" size="5" value="${registeredStudentInstance?.criteriaAndEvaluations*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: registeredStudentInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="registeredStudent.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${ta.Student.list()}" optionKey="id" required="" value="${registeredStudentInstance?.student?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: registeredStudentInstance, field: 'turma', 'error')} required">
	<label for="turma">
		<g:message code="registeredStudent.turma.label" default="Turma" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="turma" name="turma.id" from="${ta.Turma.list()}" optionKey="id" required="" value="${registeredStudentInstance?.turma?.id}" class="many-to-one"/>

</div>

