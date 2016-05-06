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
        $("input", name: "submit").click()
    }
    def login(){
        btnLogin.click()
    }

    boolean checkMessage(String name){
        boolean ans = false
        String expected = "Hello " + name + "!"

        if ( $(".message").text().equals(expected)){
            ans = true;
        }
        return ans
    }

    boolean checkErrorMessage(String login) {
        boolean ans = false
        String expected = "Sorry, " + login + ". Please try again."

        if ( $(".message").text().equals(expected)){
            ans = true;
        }
        return ans


    }


}
