package steps

import ta.ConceptController

/**
 * Created by João Vasconcelos on 06/11/2016.
 */
class ConceptDataAndOperation {
    public static void createConcept(String name){
        def controller = new ConceptController()
        controller.params << [nome: name]
        controller.createAndSaveConcept()
        controller.response.reset()
    }
}
