package pages

import geb.Page

class ManualInputPage extends Page {

    static url = "/TA/student/list"

    static at = {
        title ==~ /Manual Sheet Input/
    }

    def fillConceptDetails(String login, String criterion, String concept) {
        String id = "#" + login + criterion
        $(id).value(concept)
    }

    def click(String login){
        String id = "#" + login + "Submit"
        $(id).click()
    }

    boolean checkError(){
        boolean ans = false;

        String test = $("#EmptyError").text()

        if ( !test.isEmpty() ){
            ans = true
        }

        return ans;
    }

}
