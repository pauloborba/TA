package pages.StudentPages

import geb.Page

class StudentPage extends Page {

    static url = "/TA/student/index"

    static at =  {
        title ==~ /Student Listagem/
    }

    def choose(String login){
        String id = "#"+login+"Compare"
        $(id).click()
    }

    boolean checkStudent(String login, String name){
        boolean ans = false;
        String idLogin = "#" + login
        String idName = "#" + login + "Name"

        if ( $(idLogin).text().equals(login) && $(idName).text().equals(name) ){
            ans = true;
        }
        return ans;
    }

    boolean checkCriteria(String login){
        boolean ans = false;
        String idCriteria = "#" + login + "Criteria"

        String test = $(idCriteria).text()

        if ( test.equals("{}") ){
            ans = true;
        }
        return ans;
    }

    boolean checkCriterionConcept(String login, String name, String concept = ""){
        boolean ans = false;
        String idLogin = "#" + login
        String idCriteria = "#" + login + "Criteria"
        String test = $(idCriteria).text()
        name = name + "="+concept

        if ( test.contains(name) ){
            ans = true;
        }
        return ans;
    }

    def hasErrors(){
        boolean has = $(".errors").text() != null && $(".errors").text() != ""
        return has
    }

    def checkElementTable(String criteria,String type,String Concept){
        String id = "#"+criteria+type
        return $(id).text().equals(Concept)
    }

    def checkStudentTable(String login){
        String id = "#"+login+"Head"
        return $(id).text()
    }

    def checkColor(String c){
        String id = "#"+c+"FinalRED"
        return !$(id).text().equals("");
    }

}
