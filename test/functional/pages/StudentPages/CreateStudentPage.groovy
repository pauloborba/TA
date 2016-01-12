package pages.StudentPages

import geb.Page
import pages.GetPageTitle

class CreateStudentPage extends Page {

    static url = "/TA/student/create"

    static at =  {
        String model = "Student"
        String msg = GetPageTitle.getMessage("default.create.label", "Student")
        title ==~ msg
//        title ==~ /Criar Student/
//        title ==~ /Create Student/
    }

    def fillStudentDetails(String login, String name) {
        $("form").login = login
        $("form").name = name
    }

    def fillStudentDetails(String login, String name, String password) {
        $("form").login = login
        $("form").name = name
        $("form").password = password
    }

    def selectCreateStudent() {
        $("input", name: "create").click()
    }
}
