package cucumber.steps

import cucumber.api.PendingException
import pages.ConceptPages.AddConceptPage
import steps.EvalConceptDataAndOperations
import ta.EvaluationConcept

/**
 * Created by João Vasconcelos on 02/11/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

EvaluationConcept toUpdate

Given(~/^The evaluation concept is "([^"]*)"$/) { String nome ->
    List<String> conceitos = ["MA", "MPA", "MANA"]
    EvalConceptDataAndOperations.createEvalConcept(nome, conceitos)
    assert  EvaluationConcept.findByNome(nome) != null
}
When(~/^I update the "([^"]*)" concept to "([^"]*)" concept$/) { String inicial, String proximo ->
    toUpdate =  EvaluationConcept.findByNome(inicial)
    assert toUpdate != null
    toUpdate.setNome(proximo)
    assert toUpdate.nome == proximo
    EvalConceptDataAndOperations.updateEvalConcept(toUpdate)
    //EvaluationConcept.all
    //EvaluationConcept aux = EvaluationConcept.findByNome(proximo)
    assert EvaluationConcept.findByNome(proximo)!= null
}
Then(~/^The evaluation concept "([^"]*)" is set$/) { String nome ->
    assert EvaluationConcept.findByNome(nome) != null
}
/*

And(~/^the "([^"]*)" doesn't have any concept$/) { String new_concept ->
    n_previous = toUpdate.n_concepts
    EvalConceptDataAndOperations.updateConcept(toUpdate.name, new_concept, 0, {""})
    assert toUpdate.n_concepts == 0.intValue()

}
Then(~/^The atual concept doesn't change$/) { ->
    EvalConceptDataAndOperations.updateConcept(toUpdate.name, name_previous, n_previous, concepts_previous)
    assert toUpdate.name == name_previous
}*/

When(~/^I update the "([^"]*)" concept to "([^"]*)" evaluation concept with no concepts$/) { String antigo, String novo ->
    toUpdate = EvaluationConcept.findByNome(antigo)
    assert toUpdate != null
    toUpdate.nome = novo
    toUpdate.conceitos = []
    assert toUpdate.conceitos.empty
    EvalConceptDataAndOperations.updateEvalConcept(toUpdate)
    EvaluationConcept atual = EvaluationConcept.findByNome(antigo)
    assert atual != null
}

Then(~/^The atual concept is "([^"]*)"$/) { String nome ->
    EvaluationConcept eval = EvaluationConcept.findByNome(nome)
    assert eval != null
    assert eval.hasErrors()
}
Given(~/^The "([^"]*)" evaluation concept is set$/) { String arg1 ->
    to AddConceptPage
    at AddConceptPage

}