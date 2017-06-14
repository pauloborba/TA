package steps

import ta.AutoAvaliacaoController

/**
 * Created by pedrotorchio on 10/06/17.
 */
class AutoAvaliacaoDoer{
    AutoAvaliacaoController controller

    AutoAvaliacaoDoer(){
        controller = new AutoAvaliacaoController()
    }
    void submit(params){
        controller.concluir(params)
    }
}
