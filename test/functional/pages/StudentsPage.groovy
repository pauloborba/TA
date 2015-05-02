package pages

import geb.Page

class StudentsPage extends Page{

    static url = "/TA/students"

    static at = {
        title ==~ "Students"
    }
}
