
<%@ page import="ta.ReportingClasses" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'reportingClasses.label', default: 'ReportingClasses')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>

	%{--<asset:javascript src="ReportingClass.js"/>--}%

	<style type="text/css">
	.belowAverage {
		background-color: #f7cfce;
	}
	</style>

	<script type="text/javascript">
		var averagesOfClasses = [];
	</script>

</head>
<body>
<a href="#list-reportingClasses" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		%{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
	</ul>
</div>
<div id="list-reportingClasses" class="content scaffold-list" role="main" style="padding: 20px;">
	%{--<h1><g:message code="default.list.label" args="[entityName]" /></h1>--}%
	%{--<g:if test="${flash.message}">--}%
	%{--<div class="message" role="status">${flash.message}</div>--}%
	%{--</g:if>--}%



	<!-- MA = 9, MPA = 6, MANA = 3 -->

	<form name="compareClasses" action="javascript:compareClasses()" method="post" enctype="multipart/form-data">

		<table>
			<tr>

				<th>Classes</th>
				<th>MA</th>
				<th>MPA</th>
				<th>MANA</th>
				<th>Class average</th>

			</tr>

			<g:each in="${ta.Turma.list()}" status="i" var="turmaInstance">

				<g:set var="average" value="${0}" />
				<g:set var="counter" value="${0}" />

				<g:set var="MA" value="${0}" />
				<g:set var="MPA" value="${0}" />
				<g:set var="MANA" value="${0}" />

				<g:each in="${turmaInstance.students}" var="studante">

					<g:set var="average" value="${average + studante.average}" />
					<g:set var="counter" value="${counter + 1}" />

					<g:if test="${studante.average >= 9}">
						<g:set var="MA" value="${MA + 1}" />
					</g:if>
					<g:elseif test="${studante.average >= 6}">
						<g:set var="MPA" value="${MPA + 1}" />
					</g:elseif>
					<g:else>
						<g:set var="MANA" value="${MANA + 1}" />
					</g:else>

				</g:each>

				<g:set var="average" value="${average / counter}" />

				<g:if test="${average < 7}">
					<tr class="belowAverage">
				</g:if>
				<g:else>
					<tr>
				</g:else>

					<td>${fieldValue(bean: turmaInstance, field: "periodo")}</td>
					<td>${MA}</td>
					<td>${MPA}</td>
					<td>${MANA}</td>
					<td>${average}</td>

				</tr>

				<g:javascript>
					averagesOfClasses.push(['${turmaInstance.periodo}', ${average}]);
				</g:javascript>

			</g:each>

		</table>

	</form>

	<br><br><br>

	<div id="linechart_material" style="width: 100%; height: 500px"></div>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', {'packages':['line']});
		google.charts.setOnLoadCallback(drawChart);

		function drawChart() {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Classes');
			data.addColumn('number', 'Averages');

			data.addRows(averagesOfClasses);

			var options = {
				chart: {
					title: 'Graphical statistics',
					subtitle: 'comparison between classes'
				}
			};

			var chart = new google.charts.Line(document.getElementById('linechart_material'));

			chart.draw(data, options);
		}
	</script>





	%{--<div class="pagination">--}%
	%{--<g:paginate total="${reportingClassesInstanceCount ?: 0}" />--}%
	%{--</div>--}%
</div>
</body>
</html>
