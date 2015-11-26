package pages.StudentPages

import geb.Page

class StudentPage extends Page {

    static url = "/TA/student/index"

    static at =  {
        title ==~ /Student List/
    }

    boolean checkStudent(String login, String name){
        $(login).value() == login
        $(name).value() == name
    }
}
