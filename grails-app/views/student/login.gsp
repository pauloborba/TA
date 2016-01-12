<%@ page import="ta.Student" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="Teaching Assistant Login" />
    <title><g:message code="Teaching Assistant Log In" args="[entityName]" /></title>
</head>
<body>
<a href="#create-Student" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="logout"><g:message code="Logout" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="create-Student" class="content scaffold-create" role="main">
    <h1><g:message code="Teaching Assistant Log In" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${studentInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${studentInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="authenticate" >
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'login', 'error')} ">
                <label for="login">
                    <g:message code="student.login.label" default="Login" />

                </label>
                <g:textField name="login" value="${studentInstance?.login}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'password', 'error')} ">
                <label for="password">
                    <g:message code="student.password.label" default="Password" />

                </label>
                <g:field type="password" name="password" value="${studentInstance?.password}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="submit" class="save" value="Login" />
        </fieldset>
    </g:form>
</div>
</body>
</html>