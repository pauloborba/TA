package cucumber.steps

import cucumber.api.PendingException
import steps.EvalConceptDataAndOperations
import ta.EvaluationConcept

/**
 * Created by João Vasconcelos on 02/11/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

EvaluationConcept ToCompare, toUpdate
String name_previous
int n_previous
String[] concepts_previous

Given(~/^The evaluation concept is "([^"]*)"$/) { String ini_concept ->
    EvalConceptDataAndOperations.createEvalConcept(ini_concept, 3, {"MA"; "MPA"; "MANA"})
    ToCompare = EvaluationConcept.findByName(ini_concept) /*Como eu só terei um conceito de avaliação, o nome
                                                                    Será único*/
    assert ToCompare.name == ini_concept
}
When(~/^I update the "([^"]*)" concept to "([^"]*)" concept$/) { String ini_concept, String new_concept ->
    toUpdate = EvaluationConcept.findByName(ini_concept)
    name_previous = toUpdate.name
    concepts_previous = toUpdate.concepts
    EvalConceptDataAndOperations.updateConcept(toUpdate, new_concept, toUpdate.n_concepts, toUpdate.concepts)
}
Then(~/^The evaluation concept is set$/) { ->
    assert toUpdate.name == new_concept
}

And(~/^the "([^"]*)" doesn't have any concept$/) { String new_concept ->
    n_previous = toUpdate.n_concepts
    EvalConceptDataAndOperations.updateConcept(toUpdate.name, new_concept, 0, {""})
    assert toUpdate.n_concepts == 0.intValue()

}
Then(~/^The atual concept doesn't change$/) { ->
    EvalConceptDataAndOperations.updateConcept(toUpdate.name, name_previous, n_previous, concepts_previous)
    assert toUpdate.name == name_previous
}