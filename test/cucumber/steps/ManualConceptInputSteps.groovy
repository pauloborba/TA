package steps

import ta.ManualConceptInputController;
import pages.ManualConceptInputPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Spreadsheet with at least one student and one criterion
Given (~'that the spreadsheet contains at least one student and one criterion$') { ->
    manualInputController = new ManualConceptInputController()

    assert manualInputController.checkCriteria() && manualInputController.checkStudents()

}

When (~'the user input manually a new concept "([^"]*)" with a description "([^"]*)" into a cell"([^"]*)"$'){ String concept, description, cell ->
    manualInputController.inputConcept(concept, description, cell)
}

Then (~'the final criterion concept is updated in the system$'){ ->
    assert  manualInputController.save()
}

//Scenario: Spreadsheet without students or criteria
Given (~'that the spreadsheet does not contain students or criteria$') { ->
    manualInputController = new ManualConceptInputController()

    assert !manualInputController.checkStudents()
}

And (~'there is at least one criterion'){->
    manualInputController = new ManualConceptInputController()

    assert manualInputController.checkCriteria()
}

When (~'the user try to input manually a new concept "([^"]*)" with a description "([^"]*)" into a cell"([^"]*)"$'){ String concept, description, cell ->
    manualInputController.inputConcept(concept, description, cell)
}


Then (~'the system returns a exception$'){ ->
    boolean exception = false
    try {
        manualInputController.save()
    } catch ( Exception e ){
        exception = true;
    }
    assert exception
}

//Scenario: Spreadsheet with at least one student and one criterion
Given(~'that I am on the Manual Concept Input Page$'){ ->
    to ManualConceptInputPage
    at ManualConceptInputPage
}

And (~'And there are at least one student and one criterion on the spreadsheet$'){->
    at ManualConceptInputPage
    assert page.checkStudents() &&  page.checkCriteria()
}

When (~'I choose a cell "([^"]*)"$'){ String cell ->
    at ManualConceptInputPage
    page.choose(cell)
}

And (~'I fill it with a new concept "([^"]*)" with a description "([^"]*)"$'){ String concept, description->
    at ManualConceptInputPage
    page.fillConceptDetails(concept, description)
}

And (~'I click the button to confirm the operation$'){->
    at ManualConceptInputPage
    page.click()
}

Then (~'the final concept in that criterion is updated$'){->
    at ManualConceptInputPage
    assert page.update()
}

And (~'there are no students$'){->
    at ManualConceptInputPage
    assert !page.checkStudentes()
}

And (~'there is at least one criterion$'){->
    at ManualConceptInputPage
    assert page.checkCriteria()
}

When (~'I try to choose the cell "([^"]*)"$'){ String cell ->
    at ManualConceptInputPage
    page.choose(cell)
}

Then (~'The page displays a error message$'){->
    at ManualConceptInputPage
    assert page.displayError()
}
