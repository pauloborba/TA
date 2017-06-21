package steps

import ta.Meta
import ta.MetaController

/**
 * Created by rrms on 13/06/2017.
 */
class MetaTestDataAndOperations {
    public static void criarMeta(String nomeMeta){
        def metaController = new MetaController()
        metaController.params << [nome: nomeMeta]
        metaController.createAndSaveMeta()
        metaController.response.reset()
    }

    public static Meta getMeta(String nomeMeta) {
        def controller = new MetaController()
        controller.params << [nome: nomeMeta]
        return controller.getMeta()
    }

    public static boolean compatibleTo(String nome, Meta meta) {
        if (nome == meta.nome ) return true
        return false
    }

    public static boolean onlyMeta(String nome){
        def metaController = new MetaController()
        metaController.params << [nome: nome]
        return metaController.onlyMeta()
    }

    public static int countMeta(){
        def metaController = new MetaController()
        return metaController.onlyMeta()
    }
}
