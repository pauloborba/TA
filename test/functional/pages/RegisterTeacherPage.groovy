package pages

import geb.Page

class RegisterTeacherPage extends Page {

    static url = "/TA/teachers/create"

    static at = {

        title ==~ /Create Teachers/

    }

    def fillCpf(String name, String cpf){

        $("form").name = name
        $("form").cpf = cpf

    }

    def showError(){}
    def showConfirmation(){}

}
