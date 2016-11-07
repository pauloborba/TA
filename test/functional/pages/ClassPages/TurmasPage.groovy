package pages.ClassPages

import geb.Page

/**
 * Created by dquei on 10/25/2016.
 */
class TurmasPage extends Page {

    static url = "turma/index"

    static at = {
        title ==~ /Turma List/
    }

    boolean confirmTurma(String id, String periodo){
        boolean r = false
        //def temp = $("tr").find("td")
        //(temp.has("a", text: id) && temp.has(text: periodo))
        //def coiso = $("tr")
        //def coiso2 = coiso.find("td").has("a",text: id)
        //def coiso3 = coiso.has("td", text: periodo).find("td").has("a", text: id)
        //boolean findTurma = $("tr").find($("td").has("a",text: id))
        boolean findTurma = $("tr").has("td", text: periodo).find("td").has("a", text: id)
        if(findTurma){
            r = true
        }
        return r
    }

    def assertNotDuplicateClass(id, periodo){

    }
}
