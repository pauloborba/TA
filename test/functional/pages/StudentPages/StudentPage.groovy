package pages.StudentPages

import geb.Page
import pages.GetPageTitle
import ta.EvaluationCriterion
import ta.Student

class StudentPage extends Page {

    static url = "/TA/student/index"

    static at =  {
        //title ==~ /Student Listagem/
        //title ==~ /Student List/

        GetPageTitle gp = new GetPageTitle()
        def current = gp.msg("default.list.label",[gp.msg("default.student.label")])

//        def currentBook = gp.getMessageServerLocale("default.book.label")
//       def currentTitle = currentBook + " " + gp.getMessageServerLocale("default.button.list.label")
//        title ==~ currentTitle

        title ==~ current
    }

    boolean checkStudent(String login, String name){
        boolean ans = false;
        String idLogin = "#" + login
        String idName = "#" + login + "Name"
//        String idCriteria = "#" + login + "Criteria"

        if ( $(idLogin).text().equals(login) && $(idName).text().equals(name) ){
            ans = true;
        }
        return ans;
    }

    boolean checkCriterion(String login, String name){
        boolean ans = false;
        String idLogin = "#" + login
        String idCriteria = "#" + login + "Criteria"

        if ( $(idCriteria).text().contains(name) ){
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

    boolean checkConcept(String login, String name){
        boolean ans = false;
        String idLogin = "#" + login
        String idCriteria = "#" + login + "Criteria"

        String test = $(idCriteria).text()

        if ( !test.contains(",") ){
            name = name + "="
        } else {
            name = name + "=,"
        }

        if ( test.contains(name) ){
            ans = true;
        }
        return ans;
    }

    boolean checkConcept(String login, String name, String concept){
        boolean ans = false;
        String idLogin = "#" + login
        String idCriteria = "#" + login + "Criteria"

        String test = $(idCriteria).text()

        if ( !test.contains(",") ){
            name = name+ "="+concept
        } else {
            name = name+ "="+concept+","
        }

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
