package steps
/**
 * Created by Deyvson on 18/04/2015.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

import ta.*
import static cucumber.api.groovy.EN.*

Given(~'^I do not have a evaluation with the name "([^"]*)"$') { String title ->
    evaluation = Evaluation.findByTitle(title)
    assert evaluation == null
}

Given(~'^I have a evaluation with the name "([^"]*)"$') { String title ->
    evaluation = Evaluation.findByTitle(title)
    assert evaluation != null
}

Given(~'^i\'m visualising the evaluation "([^"]*)"$') { String name ->
    evaluation = Evaluation.findByTitle(name)
    assert evaluation != null
}

When(~'^I rename the evaluation "([^"]*)" for "([^"]*)"$'){String nameCurrent, String name ->
    evaluation = Evaluation.findByTitle(nameCurrent)
    evaluationII = Evaluation.findByTitle(name)
    assert evaluationII == null && evaluation != null
    evaluation.setTitle(name)
}

Then(~'^I gonna be the evaluation "([^"]*)" in my system$'){ String name ->
    evaluation = Evaluation.findByTitle(name)
    assert evaluation != null
}

Then(~'^not gonna be the evaluation "([^"]*)" in my system$'){ String name ->
    evaluation = Evaluation.findByTitle(name)
    assert evaluation == null
}

When(~'^I insert the question "([^"]*)" in this evaluation with the answer "([^"]*)"$'){ String question, String answer ->
    assert evaluation.addQuestion(question, answer)

}

Then(~'^I gonna be in my system the evaluation "([^"]*)" having the question "([^"]*)" with answer "([^"]*)"$'){ String name, String question, String answer ->
    evaluation = Evaluation.findByTitle(name)
    assert evaluation != null
    assert evaluation.verifyQuestions(question, answer)
}
