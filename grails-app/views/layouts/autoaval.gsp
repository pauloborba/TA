<%--
  Created by IntelliJ IDEA.
  User: pedrotorchio
  Date: 05/06/17
  Time: 14:26
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form action="submit">
    <g:hiddenField name="login" value="${login}" />
    <g:hiddenField name="turma" value="${turma}" />

    <h1 class="text-left small">
        Auto Avaliação
    </h1>
    <h2 class="text-center" style="margin-bottom:1em">
        ${estudante.nomeCompleto}, escreva a sua opinião
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
                        <g:select name="${classificacao.id}" from="${notas + ["Avalie"]}" value="--" keys="${notas + ["--"]}"/>
                    </td>
                </g:each>
            </fieldset>
        </tr>

    </table>
    <g:actionSubmit value="Enviar" action="submit"/>
</g:form>
</body>
</html>