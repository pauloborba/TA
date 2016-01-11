package pages

import geb.Page

class ShowComparisonPage extends Page{

    static url = "/TA/student/compare"

    static at = {
        title ==~ /Show Comparison/
    }

    def goBack(){
        String id = "a.list"
        $(id).click()
    }

    def checkColor(String c){
       //https://learn.jquery.com/using-jquery-core/faq/how-do-i-test-whether-an-element-exists/
        //pq n funciona?
        String id = "#"+c+"FinalRED"
        return $(id).lenght
    }
}
