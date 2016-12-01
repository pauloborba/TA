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
        def x = aluno + "+" + conceito
        assert $("td", id:x)!= null
        if( $('.green').attr('id').equals(x)){
            return true
        }
    }

    boolean mediaVermelha(aluno, conceito){
        def x = aluno + "+" + conceito
        assert $("td", id:x)!= null
        if( $('.red').attr('id').equals(x)){
            return true
        }
    }
}
