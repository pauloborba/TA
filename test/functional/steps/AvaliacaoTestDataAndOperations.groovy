package steps

import ta.Avaliacao
import ta.AvaliacaoController
import ta.Matricula
import ta.MatriculaController
import ta.ResultadoController

/**
 * Created by rrms on 13/06/2017.
 */
class AvaliacaoTestDataAndOperations {
    public static void criarAvaliacao(String nomeAvaliacao, Matricula matricula){
        def matriculaController = new MatriculaController()
        matriculaController.cadastrarAvaliacao(matricula, nomeAvaliacao)
    }

    public static Avaliacao getAvaliacao(String nomeAvaliacao, Matricula matricula) {
        return matricula.avaliacoes.find{((Avaliacao)it).nome == nomeAvaliacao}
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
