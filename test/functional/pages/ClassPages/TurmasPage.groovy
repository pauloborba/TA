package pages.ClassPages

import geb.Page

/**
 * Created by Avell on 13/06/2017.
 */
class TurmasPage extends Page{
    static url = "class/turmas"

    static at = {
        title ==~ /Turmas/
    }

    def assertClass(id, periodo){

    }

    def assertNotDuplicateClass(id, periodo){

    }

}
