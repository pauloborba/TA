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
            <fieldset class="dropdown">
                
            </fieldset>
            <fieldset class="form">
                <input type="file" name="file" />
            </fieldset>
            <fieldset class="buttons">
                <g:submitButton name="upload" class="save" value="Upload" />
            </fieldset>
        </g:uploadForm>
    </div>
</body>
</html>