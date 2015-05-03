<%@page import="UVisualizeEvaluation"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>VisualizeEvaluation</title>
</head>
<body>
	<g:form name = "searchForm" action = "search">
		<input name="title">
		<g:submitButton name =  "searchButton" id = "search" value = "Search">
	</g:form>

	<ul>
		<g:each var="e" in = "${novaLista}">
			<li id="${e.title}">
				<g:link action="show" params="[title: ${e.title}]">
					${e.title}
				</g:link>
			</li> 

		</g:each>
	</ul>

	<div>
		<h3>${evaluationTitle}</h3>
		<g:each var="q" in = "${questions}">
			<h4>${q.question}</h4>
			<h5>resposta: ${q.answer}</h5>
			<g:each var="a" in = "${alternatives}">
				<h6>${a}</h6>
			</g:each>
		</g:each>

	</div>
</body>
</html>