<%--
  Created by IntelliJ IDEA.
  User: ess
  Date: 21/10/15
  Time: 12:08
--%>

<table>
    <thead>
    <th>

    </th>
    <g:each in="${criteria}">
        <th>
            ${it.name}
        </th>
    </g:each>
    </thead>
    <tr>
        <td>
            Professor:
        </td>
        <g:each in="${criteria}" status="i" var="studentInstance">
            <g:if test="${student.finalGrades.get(studentInstance.name).equals(student.autoEvaluations.get(studentInstance.name))}" >
                <td id="${studentInstance.name}Final">
                    ${student.finalGrades.get(studentInstance.name)}
                </td>
            </g:if>
            <g:else>
                <g:if test="${student.autoEvaluations.get(studentInstance.name).equals("")}">
                    <td id="${studentInstance.name}Final">
                        ${student.finalGrades.get(studentInstance.name)}
                    </td>
                </g:if>
                <g:else>
                    <td id="${studentInstance.name}FinalRED">
                        <styleM1>${student.finalGrades.get(studentInstance.name)}</styleM1>
                    </td>
                </g:else>

            </g:else>
        </g:each>
    </tr>
    <tr>
        <td id="${student.getLogin()}Head">
            ${student.getName()}:
        </td>

        <g:each in="${criteria}" status="i" var="studentInstance">
            <g:if test="${student.finalGrades.get(studentInstance.name).equals(student.autoEvaluations.get(studentInstance.name))}" >
                <td id="${studentInstance.name}Auto">
                    ${student.autoEvaluations.get(studentInstance.name)}
                </td>            </g:if>
            <g:else>
                <g:if test="${student.autoEvaluations.get(studentInstance.name).equals("")}">
                    <td id="${studentInstance.name}Auto">
                        ${student.autoEvaluations.get(studentInstance.name)}
                    </td>
                </g:if>
                <g:else>
                    <td id="${studentInstance.name}AutoRED">
                        <styleM1>${student.autoEvaluations.get(studentInstance.name)}</styleM1>
                    </td>
                </g:else>
            </g:else>
        </g:each>

    </tr>

</table>
