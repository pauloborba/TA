package pages
 
import geb.Page
 
class RegisterTeacherPage extends Page {
 
    static url = "/TA/teachers/create"
 
    static at = {
        String model = "Teachers"
        String msg = GetPageTitle.getMessage("default.create.label", "Teachers")
        title ==~ msg
    }
 
    def fillCpf(String name, String cpf){
 
        $("form").name = name
        $("form").cpf = cpf
 
    }
 
    def showError(){}
    def showConfirmation(){}
 
}
