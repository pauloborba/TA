package pages

import geb.Page
import ta.Criterion
import ta.Student

class StudentsReportPage extends Page{

    static url = "/TA/student/studentsReport"

    static at = {
        title ==~ /StudentsReport List/
    }

    boolean isColor(String login, String color) {
        String id = "#" + login
        println("AQUIIIIIIIIIIIII")
        println($(id).jquery.css("background-color"))
        if(color.equals("green") && $(id).jquery.css("background-color").equals("rgb(65, 128, 0)")) return true
        else if(color.equals("yellow") && $(id).jquery.css("background-color").equals("rgb(255, 255, 0)")) return true
        else if(color.equals("red") && $(id).jquery.css("background-color").equals("rgb(255, 0, 0)")) return true
        return false
    }

    def isColumn(String criterio, String login, String value) {
        String complementId = ''
        if(criterio.equals("Total de critérios avaliados")) complementId = "total"
        String id = "#" + complementId + login
        if($(id).text().equals(value)) return true
        return false
    }

    def isColumnGeneral(String coluna, String value) {
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
