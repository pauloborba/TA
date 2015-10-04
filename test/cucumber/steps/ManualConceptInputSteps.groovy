package steps

import ta.ManualConceptInputController;
import pages.ManualConceptInputPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Spreadsheet with at least one student and one criterion
Given (~'that the spreadsheet contains at least one student and one criterion$') { ->
    manualInputController = new ManualConceptInputController()
    criteria = manualInputController.checkCriteria()
    students = manualInputController.checkStudents()

    assert manualInputController.checkSpreadsheet(criteria, students)

}

When (~'the user input manually a new concept "([^"]*)" with a description "([^"]*)" into a cell$'){ String concept, description ->
    manualInputController.inputConcept(concept, description)
}


Then (~'the final criterion concept is updated in the system$'){ ->
    manualInputController.save()
}

//Scenario: Spreadsheet without students or criteria
Given (~'that the spreadsheet does not contain students or criteria$') { ->
    manualInputController = new ManualConceptInputController()
    criteria = manualInputController.checkCriteria()
    students = manualInputController.checkStudents()

    assert manualInputController.checkSpreadsheet(criteria, students)
}

Then (~'the system does nothing$'){ ->

}

//Scenario: Spreadsheet with at least one student and one criterion
Given(~'that I am on the Manual Concept Input Page$'){ ->
    to ManualConceptInputPage
    at ManualConceptInputPage
}

And (~'there are at least one student and one criterion on the spreeadsheet$'){->

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
    page.update()
}

//Scenario: Spreadsheet without students or criteria
Given(~'that I am on the Manual Concept Input Page$'){ ->
    to ManualConceptInputPage
    at ManualConceptInputPage
}

And (~'there are no student or criteria on the spreeadsheet$'){->

}

Then (~'I can not choose a cell to add a new concept$'){->

}

And (~'The page displays a error message$'){->
    at ManualConceptInputPage
    page.displayError()
}