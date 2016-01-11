package pages

import geb.Page

class ManualInputPage extends Page {

    static url = "/TA/student/list"

    static at = {
        title ==~ /Manual Concept Input/
    }

    def fillConceptDetails(String login, String criterion, String concept) {
        if(criterion.indexOf(" ") != -1 ){
            criterion = criterion.replaceAll(" ", "\\\\\\\\ ");
        }
        String id = "#" + login + criterion
        $(id).value(concept)

    }

    def click(String login){
        String id = "#" + login + "Submit"
        $(id).click()
    }

    boolean checkError() {
        boolean ans = false;

        String test = $("#EmptyError").text()

        if (!test.isEmpty()) {
            ans = true
        }

        return ans;
    }
}