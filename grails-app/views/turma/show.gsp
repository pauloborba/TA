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
    <title></title>
    <meta name="whois" content="turma-show">
    <style>
    #modal_overlay{

    }
        .modal-overlay{
            z-index: 999;
            display: none;
            color: white;
            line-height:15em;
            font-size:2em;
            text-transform: uppercase;
            text-align: center;
        }
        .loading
        {
            background-image: url("${assetPath(src: 'loading-icon.gif')}");
        }
        h3{
            text-align: center;
        }
        ol{
            width: 50%;
            margin: 0 auto;
        }
        li
        {
            box-shadow: 0 0 4px 0px black;
            margin: 1em;
            padding: .25em;
        }
    </style>
    <script>
        $(function(){
            $("#clone_bt").click(function(e){
                var loading = $("#modal .loading")
                var metasUl = $("#metas-lista")
                var messang = $("#modal #modal_message")

                loading.fadeIn(400, function(){

                    var query = ""
                    var metas = $("input[name='metas[]']:checked").serialize()

                    query += "turma=${turma.cod}" + (metas? "&" + metas : "")
                    console.log("enviando dados\n" + query)
                    $.ajax({
                        url:  "${createLink(controller: "Turma", action: "appendMetasRequest")}",
                        data: query,
                        success: function(data){
                            console.log("resposta:\n" + JSON.stringify(data))
                            if(data == "OK!"){
                                reload("#metas-lista")
                            }
                            loading.fadeOut(400, function(){
                                closeModal()
                            })
                        },
                        error: function(){
                            messang.html("Erro Inserindo Metas")
                            loading.fadeOut(400, function(){
                                messang.fadeIn(400, function(){
                                    setTimeout(function(){
                                        messang.fadeOut(400, function(){
                                            closeModal()
                                        })
                                    }, 1000)
                                })
                            })
                        }
                    })

                })
            })
        })
    </script>
</head>

<body>
<h1>${turma.cod}</h1>
<h3>Metas</h3>
<ol id="metas-lista">
    <g:each var="meta" in="${turma.metas}" status="i">
        <li title="meta-${i}">
            ${meta}
        </li>
    </g:each>
</ol>
<div class="inline-content">

    <a href="#" id="modal_bt">
        <div>Clonar Metas</div>
    </a>
    <g:link action="edit" id="${turma.id}">
        <div>Edit</div>
    </g:link>

</div>
<div id="modal" class="fullscreen">
    <div id="metas" class="content">
        <div class="fullscreen loading bg-center modal-overlay" id="modal_loading"></div>
        <div class="fullscreen bg-center modal-overlay" id="modal_message"></div>
        <h2>
            Copiar quais metas?
        </h2>
        <fieldset name="metas">

            <g:each in="${turmas}" var="turma" status="i">
                <g:if test="${turma && turma.metas}">
                <h3 class="text-left">
                    ${turma}
                </h3>
                <g:each in="${turma.metas}" var="meta" status="j">
                    <p>
                        <g:checkBox name="metas[]" value="${meta.id}" checked="false"/> ${meta}
                    </p>
                </g:each>
                </g:if>
            </g:each>

        </fieldset>
        <div class="inline-content">
            <a href="#" id="clone_bt">
                <div>Clonar</div>
            </a>
            <a href="#" id="modalclose_bt">
                <div>Cancelar</div>
            </a>
        </div>
    </div>

</div>
</body>
</html>