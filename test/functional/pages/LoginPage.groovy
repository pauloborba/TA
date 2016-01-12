package pages

import geb.Page

class LoginPage extends Page {

    static url = "/TA/student/login"

    static at =  {
        title ==~ /Teaching Assistant Log In/
    }

    static content = {
        btnLogin { $("input.save") }
    }

    def fillLoginDetails(String login, String password) {
        $("form").login = login
        $("form").password = password
    }

    def selectLogin() {
        $("input", name: "login").click()
    }
    def login(){
        btnLogin.click()
    }
}
