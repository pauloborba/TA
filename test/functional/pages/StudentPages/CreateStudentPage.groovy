package pages.StudentPages

import geb.Page
import pages.GetPageTitle

class CreateStudentPage extends Page {

    static url = "/TA/student/create"

    static at =  {
        String model = "Student"
        String msg = GetPageTitle.getMessage("default.create.label", "Student")
        title ==~ msg
    }

    def fillStudentDetails(String login, String name) {
        $("form").login = login
        $("form").name = name
    }

    def selectCreateStudent() {
        $("input", name: "create").click()
    }
}