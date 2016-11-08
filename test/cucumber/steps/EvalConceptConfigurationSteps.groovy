package cucumber.steps

import cucumber.api.PendingException
import pages.ConceptPages.AddConceptPage
import pages.ConceptPages.EditConceptPage
import pages.ConceptPages.ShowConceptPage
import pages.EvaluationConceptPages.AddEvaluationConceptPage
import pages.EvaluationConceptPages.EditEvaluationConceptPage
import pages.EvaluationConceptPages.ShowEvaluationConceptPage
import steps.EvalConceptDataAndOperations
import ta.Concept
import ta.EvaluationConcept

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
/**
 * Created by João Vasconcelos on 02/11/2016.
 */


Given(~/^The evaluation concept is "([^"]*)"$/) { String nome ->
    EvaluationConcept.all
    List<String> conceitos = ["MA", "MPA", "MANA"]
    EvalConceptDataAndOperations.createEvalConcept(nome, conceitos)
    def eval = EvaluationConcept.findByNome(nome)
    EvaluationConcept.all
    assert eval != null
}
When(~/^I update the "([^"]*)" concept to "([^"]*)" concept$/) { String inicial, String proximo ->
    def toUpdate =  EvaluationConcept.findByNome(inicial)
    assert toUpdate != null
    toUpdate.setNome(proximo)
    assert toUpdate.nome == proximo
    EvalConceptDataAndOperations.updateEvalConcept(toUpdate)
    def eval = EvaluationConcept.findByNome(proximo)
    assert eval != null
}
Then(~/^The evaluation concept "([^"]*)" is set$/) { String nome ->
    def eval = EvaluationConcept.findByNome(nome)
    assert eval != null
}

When(~/^I update the "([^"]*)" concept to "([^"]*)" evaluation concept with no concepts$/) { String antigo, String novo ->
    def toUpdate = EvaluationConcept.findByNome(antigo)
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
Given(~/^The "([^"]*)" evaluation concept is set$/) { String ini ->
    String[] conceitos = ini.split(", ")
    for(conceito in conceitos){
        to AddConceptPage
        at AddConceptPage
        page.fillConceptDetails(conceito)
        page.selectCreate()
    }
    to AddEvaluationConceptPage
    at AddEvaluationConceptPage
    page.fillNameEvalCon(ini)
    page.selectConcepts(conceitos)
    page.createEvalConcept()
}

When(~/^I edit the "([^"]*)" evaluation concept with a invalid number of concepts$/) { String arg1 ->
    at ShowEvaluationConceptPage
    page.editEvalConcept()
    at EditEvaluationConceptPage
    page.editEvalConceptWithoutConcept()
    at ShowEvaluationConceptPage
}

Then(~/^The concepts of "([^"]*)" are the same\.$/) { String entr ->
    assert page.testConcepts(entr.split(", ").sort())
}

When(~/^I edit the "([^"]*)" field to "([^"]*)" evaluation concept$/) { String antigo, String novo ->
    at ShowEvaluationConceptPage
    page.btnEditConcept(antigo)
    at ShowConceptPage
    page.editButton()
    at EditConceptPage
    page.fillConceptName(novo)
    page.btnUpdateConcept()
    at ShowConceptPage
}

Then(~/^I can see the concept "([^"]*)"$/) { String concept ->
    assert page.matchConcept(concept)
}
And(~/^I can't see the concept "([^"]*)"\.$/) { String concept_fail ->
    assert !page.matchConcept(concept_fail)
}