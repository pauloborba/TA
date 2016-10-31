<%@ page import="ta.Class" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'class.label', default: 'Class')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>
<a href="#show-class" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="show-class" class="content scaffold-show" role="main">
    <h1>Student details</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list class">

        <g:if test="${classInstance?.classID}">
            <li class="fieldcontain">
                <span id="id-label" class="property-label"><g:message code="class.classID.label" default="ID" /></span>

                <span class="property-value" aria-labelledby="id-label"><g:fieldValue bean="${classInstance}" field="id"/></span>

            </li>
        </g:if>

        <g:if test="${classInstance?.periodo}">
            <li class="fieldcontain">
                <span id="periodo-label" class="property-label"><g:message code="class.periodo.label" default="Periodo" /></span>

                <span class="property-value" aria-labelledby="periodo-label"><g:fieldValue bean="${classInstance}" field="periodo"/></span>

            </li>
        </g:if>

        <div id="list-evaluation" class="content scaffold-list" role="main">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <div class="pagination">
                <g:paginate total="${evaluationInstanceCount ?: 0}" />
            </div>
        </div>

    </ol>
</div>

</body>
</html>