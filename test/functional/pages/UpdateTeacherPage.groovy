package pages

import geb.Page

class UpdateTeacherPage extends Page {

    static url = "/TA/teachers/edit"

    static at = {

        title ==~ /Edit Teachers/

    }

    def fillEditCpf(String oldCpf, String newCpf){}
    def showError(){}
    def showConfirmation(){}

}
