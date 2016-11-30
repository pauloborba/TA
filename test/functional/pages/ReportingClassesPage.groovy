package pages

import geb.Page

/**
 * Created by Sentinela on 07/11/2016.
 */
class ReportingClassesPage extends Page {

    static url = "/TA/reportingClasses/index"

    static at = {
        title ==~ /ReportingClasses List/
    }

    def boolean classesNotList() {
        return $('#list-reportingClasses table tr').size() == 1;
    }

    def boolean confirmAverage(String _class, String average) {

        def tr = $('#list-reportingClasses table tr');
        for (def i = 2; i <= tr.size(); i++) {

            if ($('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(1)').text() == _class) {
                if ($('#list-reportingClasses table tr:nth-child('+i+') td:nth-child(5)').text() == average) {
                    return true;
                }
            }

        }

        return false;
    }

    def boolean backgroundRed(String _class) {

        return $('#list-reportingClasses table tr[class="belowAverage"] td:nth-child(1)').text() == _class;

    }

    def boolean classGraph() {
        return $('#google-visualization-errors-all-1').size() == 0;
    }

}
