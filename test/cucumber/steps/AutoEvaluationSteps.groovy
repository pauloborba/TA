package steps

import ta.AutoEvaluationController
import pages.AutoEvaluationPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//Scenario: edit the auto evaluation before the time limit has ended

Given (~'that the time limit for the auto evaluation of the criterion "([^"]*)" has not ended yet$'){ String criterion ->
    autoEvaluationController = new AutoEvaluationController()
    assert autoEvaluationController.checkAvailability(criterion)
}

When (~'the user inputs a new concept "([^"]*)" of the criterion "([^"]*)"$'){ String concept, criterion
    autoEvaluationController.input(concept, criterion)
}

Then (~'the new concept will be saved in the system$'){
    autoEvaluationController.save()
}

//Scenario: edit the auto evaluation after the time limit has ended

Given (~'that the time limit for the auto evaluation of the criterion "([^"]*)" has ended$'){ String criterion ->
    autoEvaluationController = new AutoEvaluationController()
    assert autoEvaluationController.checkAvailability(criterion)
}

Then (~'The system does nothing'){

}

// Scenario web: edit the auto evaluation before the time limit has ended

Given (~'I am at the auto evaluation page$'){
    to AutoEvaluationPage
    at AutoEvaluationPage
}

When (~'I choose the criterion "([^"]*)"$'){String criterion ->
    at AutoEvaluationPage
    page.choose(criterion)
}

And (~'I put the new concept"([^"]*)"$'){String concept ->
    at AutoEvaluationPage
    page.fillConcept(concept)
}

And (~'I click the button to confirm$'){
    at AutoEvaluationPage
    page.click()
}

Then(~'the concept for that criterion is updated$'){
    at AutoEvaluationPage
    page.update()
}

// Scenario web: edit the auto evaluation after the time limit has ended

Given (~'I am at the auto evaluation page$'){
    to AutoEvaluationPage
    at AutoEvaluationPage
}

When (~'I choose the criterion "([^"]*)"$'){String criterion ->
    at AutoEvaluationPage
    page.choose(criterion)
}

Then(~'a warning will appear'){
    at AutoEvaluationPage
    page.displayWarning()
}