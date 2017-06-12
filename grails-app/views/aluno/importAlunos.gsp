<%--
  Created by IntelliJ IDEA.
  User: wfmf
--%>

<%@ page import="ta.Aluno" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'aluno.label', default: 'Aluno')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
    <div class="nav" role="navigation">
        <ul><li><g:link class="home" action="index"><g:message code="default.home.label"/></g:link></li></ul>
    </div>
    <div class="content scaffold-create" role="main">
        <h1><g:message code="importAlunos.title" args="[entityName]"/></h1>
        <g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
        <g:uploadForm action="upload">
            <div class="content" role="form">
                <div class="fieldcontain required">
                    <label for="turma">
                        <g:message code="importAlunos.turmas" default="Turmas" />
                        <span class="required-indicator">*</span>
                    </label>
                </div>
                <g:select id="turma" name="turma.id" from="${ta.Turma.list()}" optionKey="id" required="" class="many-to-one"/>
                <fieldset class="form">
                    <input type="file" name="file" />
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="upload" class="save" value="Upload" />
                </fieldset>
            </div>
        </g:uploadForm>

    </div>
</body>
</html>