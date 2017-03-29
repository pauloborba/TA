
<%@ page import="ta.ReportingClasses" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'reportingClasses.label', default: 'ReportingClasses')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>

	<asset:javascript src="ReportingClass.js"/>


	<style>
	table {
		border-collapse: collapse;
		width: 100% !important;
	}
	th, td {
		border-bottom: 1px solid #ddd;
	}
	tr {
		width: auto !important;
	}
	/*tr:nth-child(even) {
		background-color: #f2f2f2
	}*/
	</style>


	<script type="text/javascript">

		var averagesOfClasses = [];

		function compareClasses() {

			var _class = document.querySelectorAll('table tr');

			var difference = -1;
			var classes = ['', ''];

			for (var i = 1; i < _class.length; i++) {

				var td =  _class[i].getElementsByTagName('td');
				if (td[0].getElementsByTagName('input')[0].checked == true) {

					if (difference == -1) {
						difference = +td[5].innerHTML*10;
						classes[0] = td[1].innerHTML;
					} else {
						difference -= +td[5].innerHTML*10;
						classes[1] = td[1].innerHTML;
					}

				}
			}

			document.querySelector('#alertContent').innerHTML = 'The class "'+classes[0]+'" has a "'+difference+'%" difference from the class "'+classes[1]+'"';
			alert('The class "'+classes[0]+'" has a "'+difference+'%" difference from the class "'+classes[1]+'"');

		}

		window.onload = function() {
			var _class = document.querySelectorAll('form input[name="class"]');

			for (var i = 0; i < _class.length; i++) {
				(function(i) {

					_class[i].onclick = function() {

						var count = 0;
						for (var j = 0; j < _class.length; j++) {
							if (_class[j].checked == true) {
								count++;
							}
						}
						if (count > 2) {
							this.checked = false;
							document.querySelector('#alertContent').innerHTML = 'You can only compare two classes at a time';
							alert('You can only compare two classes at a time');
						}
						if (count >= 2) {
							document.compareClasses.compare.removeAttribute('disabled');
						} else {
							document.compareClasses.compare.disabled = 'disabled';
						}

					};

				})(i);
			}

		};

	</script>


</head>
<body>
<a href="#list-reportingClasses" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<!-- <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li> -->
	</ul>
</div>
<div id="list-reportingClasses" class="content scaffold-list" role="main" style="padding: 20px;">
	<!-- <h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if> -->



	<!-- MA = 9, MPA = 7, MANA = 3 -->

	<form name="compareClasses" action="javascript:compareClasses()" method="post" enctype="multipart/form-data">

		<input type="submit" name="compare" disabled="disabled" value="Compare">

		<br><br>

		<table>
			<tr>

				<th></th>
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
					<g:elseif test="${studante.average >= 7}">
						<g:set var="MPA" value="${MPA + 1}" />
					</g:elseif>
					<g:else>
						<g:set var="MANA" value="${MANA + 1}" />
					</g:else>

				</g:each>

				<g:set var="average" value="${average / counter}" />

				<tr>

					<td><input type="checkbox" name="class" value="${turmaInstance.id}"></td>
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

	<div id="alertContent" style="visibility: hidden"></div>



	<!-- <div class="pagination">
				<g:paginate total="${reportingClassesInstanceCount ?: 0}" />
			</div> -->
</div>
</body>
</html>
