package pages.TeacherPages

import geb.Page

class RegisterTeacherPage extends Page {

    static url = "/TA/teacher/create"

    static at = {

        title ==~ /Register Teacher/

    }

    def fillCpf(String cpf){

        $("form").name = "John"
        $("form").cpf = cpf

    }

}
