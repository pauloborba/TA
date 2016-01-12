package pages

import geb.Page

class ManualInputPage extends Page {

    static url = "/TA/student/list"

    static at = {
        title ==~ /Manual Concept Input/
    }

    void adjustCriterion(String criterion){
        if(criterion.indexOf(" ") != -1 ){
            criterion = criterion.replaceAll(" ", "\\\\\\\\ ");
        }
    }

    def fillConceptDetails(String login, String criterion, String concept) {
        adjustCriterion(criterion)
        String id = "#" + login + criterion
        $(id).value(concept)

    }

    def click(String login){
        String id = "#" + login + "Submit"
        $(id).click()
    }

    boolean checkCriterion(String name){
        adjustCriterion(name)
        boolean ans = false;
        String id = "#" + name;
        String text = $(id).text()

        if ( text.contains(name) ){
            ans = true
        }

        return ans
    }

    boolean checkError() {
        boolean ans = false;

        String text = $("#EmptyError").text()

        if (!text.isEmpty()) {
            ans = true
        }

        return ans;
    }
}
