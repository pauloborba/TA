package cucumber.steps

import cucumber.api.PendingException
import ta.EvaluationConcept

/**
 * Created by João Vasconcelos on 02/11/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

EvaluationConcept conceptToCompare

Given(~/^The evaluation concept is "([^"]*)"$/) { String ini_concept ->
    EvalConceptDataAndOperations.createEvalConcept(ini_concept, 3, {"MA"; "MPA"; "MANA"})
    conceptToCompare = EvaluationConcept.findByName(ini_concept) /*Como eu só terei um conceito de avaliação, o nome
                                                                    Será único*/
    assert conceptToCompare.name == ini_concept
}
When(~/^I update the "([^"]*)" concept to "([^"]*)" concept$/) { String ini_concept, String new_concept ->
    EvaluationConcept toUpdate = EvaluationConcept.findByName(ini_concept)
    EvalConceptDataAndOperations.updateConcept(toUpdate, new_concept)
}
Then(~/^The evaluation concept is set$/) { ->
    assert toUpdate.name == new_concept
}