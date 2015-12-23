package pages.StudentPages

import geb.Page
import pages.GetPageTitle

class StudentPage extends Page {

    static url = "/TA/student/index"

    static at =  {
        String model = "Student"
        String msg = GetPageTitle.getMessage("default.list.label", "Student")
        title ==~ msg
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

    // Para teste de falta de critérios
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

    def choose(String login){
        String id = "#"+login+"Compare"
        $(id).click()
    }


}
