package pages.ClassPages

import geb.Page

/**
 * Created by dquei on 10/25/2016.
 */
class TurmasPage extends Page {

    static url = "class/turmas"

    static at = {
        title ==~ /Turmas/
    }

    def assertClass(id, periodo){

    }

    def assertNotDuplicateClass(id, periodo){

    }
}
