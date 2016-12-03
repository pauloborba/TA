package pages

import geb.Page

/**
 * Created by dquei on 10/25/2016.
 */
class TurmasPage extends Page {

    static url = "/TA/turma/index"

    static at = {
        title ==~ /Turma List/
    }

    boolean confirmTurma(String id, String periodo){
        boolean r = false
        boolean findTurma = $("tr").has("td", text: periodo).find("td").has("a", text: id)
        if(findTurma){
            r = true
        }
        return r
    }

}
