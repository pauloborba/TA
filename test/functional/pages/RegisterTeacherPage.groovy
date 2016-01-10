package pages.TeacherPages

import geb.Page

class RegisterTeacherPage extends Page {

    static url = "/TA/teacher/create"

    static at = {

        title ==~ /Register Teacher/

    }

    def fillCpf(String name, String cpf){

        $("form").name = name
        $("form").cpf = cpf

    }

    def showError(){}
    def showConfirmation(){}

}
