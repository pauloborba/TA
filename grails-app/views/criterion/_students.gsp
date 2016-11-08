
    <tr>

        <td><g:link action="show" id="${student.id}">${student.name}</g:link></td>

        <td>${student.login}</td>

        <td>
            <g:select name="value_${student.id}" from="['MA','MPA','MNA']" required="" value="" valueMessagePrefix="${student.id}"/>



        </td>

    </tr>
