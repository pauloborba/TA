package pages

import geb.Page

class LoginPage extends Page {

    static url = "/TA/student/login"

    static at =  {
        title ==~ /Teaching Assistant Login/
    }

    static content = {
        btnLogin { $("input.save") }
    }

    def fillLoginDetails(String login) {
        $("form").login = login
        $("form").password = login
    }

    def selectCreateStudent() {
        $("input", name: "create").click()
    }
    def login(){
        btnLogin.click()
    }
}
