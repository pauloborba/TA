package steps

import ta.Avaliacao
import ta.AvaliacaoController
import ta.Matricula
import ta.ResultadoController

/**
 * Created by rrms on 13/06/2017.
 */
class AvaliacaoTestDataAndOperations {
    public static void criarAvaliacao(String nomeAvaliacao, Matricula matricula){
        def avaliacaoController = new AvaliacaoController()
        avaliacaoController.params << [nome: nomeAvaliacao, matricula:matricula]
        avaliacaoController.createAndSaveAvaliacao()
        avaliacaoController.response.reset()
    }

    public static Avaliacao getAvaliacao(String nomeAvaliacao, Matricula matricula) {
        def controller = new AvaliacaoController()
        controller.params << [nome: nomeAvaliacao,matricula:matricula]
        return controller.getAvaliacao()
    }

    public static boolean compatibleTo(String nome, Avaliacao avaliacao) {
        if (nome == avaliacao.nome ) return true
        return false
    }

    public static int countAvaliacao(){
        def avaliacaoController = new AvaliacaoController()
        return avaliacaoController.count()
    }
}
