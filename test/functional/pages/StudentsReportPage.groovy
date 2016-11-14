package pages

import geb.Page
import ta.Criterion
import ta.Student

class StudentsReportPage extends Page{

    static url = "/TA/student/studentsReport"

    static at = {
        title ==~ /StudentsReport List/
    }

    boolean isLoginColor(String login, String color) {
        String id = "#" + login
        String colorParameter = ""
        if(color.equals("green")) colorParameter = "rgb(65, 128, 0)"
        else if(color.equals("yellow")) colorParameter = "rgb(255, 255, 0)"
        else if(color.equals("red")) colorParameter = "rgb(255, 0, 0)"

        if($(id).jquery.css("background-color").equals(colorParameter)) return true
        else return false
    }

    def isColumnLoginValue(String criterio, String login, String value) {
        String complementId = ''
        if(criterio.equals("Total de critérios avaliados")) complementId = "total"
        String id = "#" + complementId + login
        if($(id).text().equals(value)) return true
        return false
    }

    def isColumnNumber(String coluna, String value) {
        String id = "#";
        if(coluna == "Total de aprovados por media") id += "aprovadosMedia"
        else if(coluna == "Total de aprovados na final") id += "aprovadosFinal"
        else if(coluna == "Total de reprovados por falta") id += "reprovadosFalta"
        else if(coluna == "Total de reprovados por nota") id += "reprovadosNota"
        else id += "totalAlunos"
        if($(id).text().equals(value)) return true
        return false
    }

}