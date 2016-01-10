package pages.TeacherPages

import geb.Page

class UpdateTeacherPage extends Page {

    static url = "/TA/teacher/edit"

    static at = {

        title ==~ /Update Teacher/

    }

    def fillEditCpf(String name, String oldCpf, String newCpf){

        $("form").name = name
        $("form").oldCpf = oldCpf
        $("form").newCpf = newCpf

    }

    def showError(){}
    def showConfirmation(){}

}
