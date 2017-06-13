package steps

import ta.Avaliacao
import ta.Meta
import ta.Resultado
import ta.ResultadoController

/**
 * Created by rrms on 13/06/2017.
 */
class ResultadoTestDataAndOperations {
    public static void criarResultado(String conceito, Meta meta, Avaliacao avaliacao){
        def resultadoController = new ResultadoController()
        resultadoController.params << [conceito: conceito, meta: meta, avaliacao:avaliacao]
        resultadoController.createAndSaveResultado()
        resultadoController.response.reset()
    }

    public static Resultado getResultado(Meta meta,Avaliacao avaliacao) {
        def controller = new ResultadoController()
        controller.params << [meta: meta, avaliacao:avaliacao]
        Resultado resultado = controller.getResultado()
        controller.response.reset()
        return resultado
    }

    public static boolean compatibleTo(String meta, String conceito, Resultado resultado) {
        if (meta == resultado.meta.nome && conceito == resultado.conceito) return true
        return false
    }

    public static int countResultado(){
        def resultadoController = new ResultadoController()
        return resultadoController.count()
    }
}
