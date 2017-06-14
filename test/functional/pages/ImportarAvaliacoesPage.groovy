package pages

import geb.Page

class ImportarAvaliacoesPage extends Page {
    static url = "/TA/avaliacao/importarAvaliacao/"

    static at =  {
        title ==~ /Importar Avaliacao/
    }

    def origem(String nome){
        $('form').nome = nome
    }

    def turma(String nome){
        $('form').turma = nome
    }

}

