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


    def close(){
        String id = "#"+"Close"
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

    // Para teste de falta de critérios
    boolean checkCriteria(String login){
        boolean ans = false;
        String idCriteria = "#" + login + "Criteria"
        String text = $(idCriteria).text()

        if ( text.equals("{}") ){
            ans = true;
        }
        return ans;
    }

    boolean checkCriterionConcept(String login, String name, String concept = ""){
        boolean ans = false;
        String idLogin = "#" + login
        String idCriteria = "#" + login + "Criteria"
        String text = $(idCriteria).text()
        name = name + "="+concept

        if ( text.contains(name) ){
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
        String resp=""
        String debug = $(id).text()
        if($(id).text().equals("")||$(id).text()==null){
            resp="black"
        }else{
            resp="red"
        }
        return resp
    }
    
	def choose(String login){
        String id = "#"+login+"Compare"
        $(id).click()
    }


}