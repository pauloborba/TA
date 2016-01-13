package pages
 
import geb.Page
 
class UpdateTeacherPage extends Page {
 
    static url = "/TA/teachers/edit"
 
    static at = {
 
        String model = "Teachers"
        String msg = GetPageTitle.getMessage("default.edit.label", "Teachers")
        title ==~ msg
 
    }
 
    def fillEditCpf(String oldCpf, String newCpf){}
    def showError(){}
    def showConfirmation(){}
 
}
