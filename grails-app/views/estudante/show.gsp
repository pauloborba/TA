<%--
  Created by IntelliJ IDEA.
  User: pedrotorchio
  Date: 06/06/17
  Time: 23:00
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Estudante</title>

    <style>
        .classificacao{
            margin: .25em
        }
        .classificacao > h4, .classificacao > p{

        }
    header{
        margin: 1em 0 ;
    }
    </style>
</head>

<body>
<header>
    <h1>
        Nome: ${estudante.nomeCompleto}
    </h1>
    <p class="">
        Turma: ${estudante.turma.cod}
    </p>
</header>

    <p>
        <h3 class="black">Notas</h3>
        <div class="inline-content">
            <g:each var="classificacao" in="${estudante.classificacoes}">
                <div class="classificacao">
                    <h4 class="text-center green">${classificacao.getDescricao()}</h4>
                    <p class="text-center">${classificacao.getValor()}</p>
                </div>
            </g:each>
        </div>
    </p>

    <div class="inline-content">
        <g:link uri="/autoaval/${estudante.turma.cod}/${estudante.login}">
            <div>
                Auto Avaliação
            </div>
        </g:link>
        <g:link controller="AutoAvaliacao" action="offer">
            <div>
                Enviar Link
            </div>
        </g:link>
        <g:link action="edit" id="${estudante.id}">
            <div>Editar</div>
        </g:link>


        <g:link action="delete" id="${estudante.id}">
            <div>Deletar</div>
        </g:link>
    </div>
</body>
</html>