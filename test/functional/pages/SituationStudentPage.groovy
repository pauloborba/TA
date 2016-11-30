package pages

import geb.Page
/**
 * Created by lavinia on 25/11/2016.
 */
class SituationStudentPage extends Page{
    static url = "/TA/situationStudents/index"

    static at =  {
        //title ==~ /SituationStudents List/
        title ==~ /Create property Listagem/
    }

    boolean mediaVerde(aluno, conceito){
        String x = aluno+"+"+conceito
        if($('#'+ x).attr('class').equals("green")){
            return true
        }
    }
}
