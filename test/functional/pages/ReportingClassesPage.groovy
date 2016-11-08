package pages

import geb.Page

/**
 * Created by Sentinela on 07/11/2016.
 */
class ReportingClassesPage extends Page {

    static url = "TA/reportingClasses/index"

    static at = {
        title ==~ /ReportingClasses Listagem/
    }


    def selectClass(String _class) {

        def tr = $('#list-reportingClasses table tr');
        for (def i = 1; i < tr.size(); i++) {
            if ($('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(1)').text() == _class) {
                $('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(0) input').click()
            }
        }

    }


    def selectClass(String _class, String average) {

        def tr = $('#list-reportingClasses table tr');
        for (def i = 1; i < tr.size(); i++) {

            if ($('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(1)').text() == _class) {
                if ($('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(5)').text()== average) {
                    $('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(0) input').click()
                }
            }

        }

    }

    def boolean checkClassSelected(String _class) {

        def tr = $('#list-reportingClasses table tr');
        for (def i = 1; i < tr.size(); i++) {

            if ($('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(1)').text() == _class) {
                if ($('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(0) input').attr('checked')) {
                    return true
                }
            }

        }

        return false
    }

    def setEvaluationToStudent(String loginStudent, String evaluation) {

        for (def i = 2; i < $('table tr').size(); i++) {
            if ($('table tr:nth-child('+i+') td:nth-child(2)').text() == loginStudent) {
                $('table tr:nth-child('+i+') td:nth-child(3) select').find("option").find{it.value().equals(evaluation)}.click()
            }
        }

    }

    def createClass(String id, String periodo, String loginStudent) {

        $("form").classID = id
        $("form").periodo = periodo
        $('select', name: 'students').find("option").find{it.value().equals(loginStudent)}.click()

    }


}
