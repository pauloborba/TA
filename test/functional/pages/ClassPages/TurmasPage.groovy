package pages.ClassPages

import geb.Page

/**
 * Created by Avell on 13/06/2017.
 */
class TurmasPage extends Page{
    static url = "class/index"

    static at = {
        title ==~ /Class Listagem/
    }

    def assertClass(id, periodo){

    }

    def assertNotDuplicateClass(id, periodo){

    }

    boolean confirmTurma(String id, String periodo) {
        boolean r = false
        boolean findTurma = $("tr").has("td", text: periodo).find("td").has("a", text: id)

        if (findTurma) {
            r = true
        }

        return r
    }
}
