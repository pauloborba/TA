
<%@ page import="ta.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
    <title>Auto Evaluation</title>
</head>
<body>
<a href="#list-student" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="list"><g:message code="default.new.label" message="Manual Concept Input" /></g:link></li>
    </ul>
</div>
<table>
<div class="autoEvaluation">


        <g:if test="${criteria.size() == 0}">
            <div id="EmptyError">O sistema não possui nenhum critério cadastrado, volte mais tarde!</div>
        </g:if>
        <g:else>

            <g:form controller = "student">
                <g:select name="selector" from="${Student.list()}" optionKey="login" optionValue="login" noSelection="${["":'Select One']}"></g:select>

                <g:each in="${0..1}" status = "i" var="evCriterion">
                    <g:if test="${i==0}">
                        <thead>
                        <g:each in="${criteria}">
                        <th>
                            ${it.name}
                        </th>
                        </g:each>
                        <th>
                            Actions
                        </th>
                        </thead>
                    </g:if>
                    <g:else>

                            <g:each in="${criteria}" var="evaluationCriterion">
                                <g:hiddenField name="criterionName" value="${evaluationCriterion.name}"></g:hiddenField>

                                <td>
                                <g:select name="concepts"
                                          from="${ta.Student.Concept.CONCEPTS}"
                                          noSelection="${["":'Concepts']}"></g:select>
                                </td>
                            </g:each>


                        <td>
                            <g:actionSubmit value="Send" action="updateCriteriaAutoEvaluation"></g:actionSubmit>
                        </td>
                    </g:else>
                </g:each>
            </g:form>
        </g:else>
    </table>

</div>


</body>
</html>