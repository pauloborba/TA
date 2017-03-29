import pages.ClassPages.CreateClassPage
import steps.ClassTestDataAndOperations

/**
 * Created by dquei on 11/2/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


/*
#Controller scenario
Scenario: new class
Given the system has no class named "ESS" and periodo "2016.2"
When I add a class with ID "ESS" and periodo "2016.2"
Then the class "ESS" with periodo "2016.2" is properly stored in the system
*/

Given(~/^the system has no class named "([^"]*)" and periodo "([^"]*)"$/) { String id, String periodo ->
    assert ClassTestDataAndOperations.getTurma(id, periodo) == null
}
When(~/^I add a class with ID "([^"]*)" and periodo "([^"]*)"$/) { String id, String periodo ->
    ClassTestDataAndOperations.createClass(id, periodo)
}
Then(~/^the class "([^"]*)" with periodo "([^"]*)" is properly stored in the system$/) { String id, String periodo ->
    def cl = ClassTestDataAndOperations.getTurma(id, periodo)
    assert ClassTestDataAndOperations.compatibleTo(id, periodo, cl)
}

/*
#Controller scenario
Scenario: new class with duplicate ID and periodo
Given the system already has a class with ID "GDI" and periodo "2016.1"
When I add a class with ID "GDI" and periodo "2016.1"
Then the class "GDI" with periodo "2016.1" is not stored twice in the system
*/

Given(~/^the system already has a class with ID "([^"]*)" and periodo "([^"]*)"$/) { String id, String periodo ->
    ClassTestDataAndOperations.createClass(id, periodo)
    assert ClassTestDataAndOperations.getTurma(id, periodo) != null
}
Then(~/^the class "([^"]*)" with periodo "([^"]*)" is not stored twice in the system$/) { String id, String periodo ->
    // Write code here that turns the phrase above into concrete actions
}

/*
#GUI scenario
Scenario: new class
Given I am at the Create Turma page
When I fill the class details with name "ESS", periodo "2016.2"
And I save the class
Then I can see a confirmation message
And I can see the information for class "ESS", periodo "2016.2" at the Turmas page
*/

Given(~/^I am at the Create Class page$/) { ->
    to CreateClassPage
    at CreateClassPage

}
When(~/^I fill the class details with name "([^"]*)", periodo "([^"]*)"$/) { String id, String periodo ->
    at CreateClassPage
    page.fillClassDetails(id, periodo)
}
And(~/^I save the class$/) { ->
    at CreateClassPage
    page.selectCreateClass()
}
Then(~/^I can see a confirmation message$/) { ->
    // Write code here that turns the phrase above into concrete actions

}
And(~/^I can see the information for class "([^"]*)", periodo "([^"]*)" at the "([^"]*)" page$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions

}

/*
#GUI scenario
 Given the system already has a class with name "GDI" and periodo "2016.1"
 And I am at the Create Turma page
 When I fill the class details with name "GDI" and periodo "2016.1"
 And I save the class
 Then I see an error message
  And I am taken to the Turmas page where class "GDI", periodo "2016.1" is not listed twice
*/

Given(~/^the system already has a class with name "([^"]*)" and periodo "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions

}
When(~/^I fill the class details with name "([^"]*)" and periodo "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions

}
Then(~/^I see an error message$/) { ->
    // Write code here that turns the phrase above into concrete actions

}
And(~/^I am taken to the "([^"]*)" page where class "([^"]*)", periodo "([^"]*)" is not listed twice$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions

}