<%--
  Created by IntelliJ IDEA.
  User: Isaac Douglas
  Date: 11/06/17
  Time: 13:40
--%>


<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'avaliacao.label', default: 'Avaliacao')}" />
    <title>Importar Avaliacao</title>
</head>
<body>
<a href="#importar-avaliacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="create-avaliacao" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${avaliacaoInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${avaliacaoInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'nome', 'error')} required">
        <label for="nome">
            <g:message code="avaliacao.nome.label" default="Nome" />
            <span class="required-indicator">*</span>
        </label>
        <g:select name="nome" from="${avaliacaoInstance.constraints.nome.inList}" required="" value="${avaliacaoInstance?.nome}" valueMessagePrefix="avaliacao.nome"/>

    </div>

    <div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'turma', 'error')} required">
        <label for="turma">
            <g:message code="avaliacao.turma.label" default="Turma" />
            <span class="required-indicator">*</span>
        </label>
        <g:select id="turma" name="turma.id" from="${ta.Turma.list()}" optionKey="id" required="" value="${avaliacaoInstance?.turma?.id}" class="many-to-one"/>

    </div>

    <g:form enctype="multipart/form-data" url="[resource:path, action:'salvarAvaliacoes']" method="POST" >
        <fieldset class="form">
            <label for="fileInput">Escolha o arquivo de Planilha.xls</label>
            <input type="file" id="fileInput"  name="sheet" />
        </fieldset>

        <fieldset class="buttons">
            <g:submitButton name="upload" class="save" value="Upload And Create" />
        </fieldset>
    </g:form>

</div>
</body>
</html>


