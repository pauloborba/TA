<%--
  Created by IntelliJ IDEA.
  User: pedrotorchio
  Date: 05/06/17
  Time: 12:11
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
    <script>
    </script>
    <style>
        li{
            display: block
        }
        li h2{
            text-align: center
        }
        td, th{
            text-align:center
        }
        input[name='mailme']{
            width:2em;
        }
    </style>
</head>

<body>
<g:form action="confirm">
    <g:hiddenField name="login" value="${login}" />
    <g:hiddenField name="turma" value="${turma}" />

    <h1 class="text-left small">
        Auto Avaliação
    </h1>
    <h2 class="text-center" style="margin-bottom:1em">
        ${estudante.nomeCompleto}, suas alterações
    </h2>
    <ul>
        <g:each in="${alteracoes}" var="alteracao" status="i">

                <li class="alt_${i} text-center">
                    <table>
                            <tr>
                                <th>
                                    ${alteracao.auto.getDescricao()}
                                </th>
                            </tr>
                            <tr>
                                <td>
                                    <span class="red">${alteracao.auto.getValor()}</span>/<span class="black transparent">${alteracao.prof.getValor()}</span>
                                </td>
                            </tr>

                    </table>
                </li>

        </g:each>
    </ul>
    <g:checkBox name="copia" value="true" />Me envie uma cópia da minha auto avaliação
    <g:actionSubmit value="Confirmar" action="confirm"/>
</g:form>
</body>
</html>