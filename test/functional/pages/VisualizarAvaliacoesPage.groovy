package pages

import geb.Page

class VisualizarAvaliacoesPage extends Page {
    static url = "/TA/avaliacao/index/"

    static at =  {
        title ==~ /Lista de Avaliações/
    }

}

