<%--
  Created by IntelliJ IDEA.
  User: pedrotorchio
  Date: 04/06/17
  Time: 22:22
--%>

<%@ page import="grails.converters.JSON" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${estudante.nomeCompleto} - Auto Avaliação</title>
    <meta name="whois" content="autoaval-form">
    <style>
        h1{
            padding:.2em .5em;
        }
        h2{

        }
        h3 {
            color: rgba(0,0,0, .25);
        }

        table select {
            line-height: 1em;
            font-size: 1.4em;
            margin: .5em auto;
            display: block;
            width:80%
        }
        th{white-space: nowrap}
    </style>
</head>

<body>

<g:form action="submit">
    <g:hiddenField name="login" value="${login}" />
    <g:hiddenField name="turma" value="${turma}" />

    <h1 class="text-left small" style="margin-left:.5em">
        Auto Avaliação
    </h1>
    <h2 class="text-center" style="margin-bottom:1em">
        ${estudante.nomeCompleto}, nos dê a sua avaliação
    </h2>
    <table>
        <tr>
        <g:each in="${classificacoes}" var="classificacao" status="i">
            <th class="text-center">
                ${classificacao.getDescricao()}
                <span class="transparent black">
                    ${" (" + classificacao.getValor() + ")"}
                </span>
            </th>
        </g:each>
        </tr>
        <tr>
            <fieldset name="classificacoes">
                <g:each in="${classificacoes}" var="classificacao" status="i">
                    <td class="text-center content-middle">
                        <g:select name="${classificacao.id}" title="${classificacao.getDescricao()}" from="${notas + ["Avalie"]}" value="--" keys="${notas + ["--"]}"/>
                    </td>
                </g:each>
            </fieldset>
        </tr>

    </table>
    <g:actionSubmit value="Enviar" action="submit"/>
</g:form>
</body>
</html>