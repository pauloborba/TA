import pages.TurmaPages.CreateTurmaPage
import pages.TurmaPages.TurmasPage
import steps.ClassTestDataAndOperations
import ta.Turma

/**
 * Created by dquei on 11/2/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Turma t

Given(~/^the system has no class named "([^"]*)" and semester "([^"]*)"$/) { String id, String periodo ->
    assert ClassTestDataAndOperations.getTurma(id, periodo) == null
}
When(~/^I add a class with ID "([^"]*)" and semester "([^"]*)"$/) { String id, String periodo ->
    ClassTestDataAndOperations.createClass(id, periodo)
    t = ClassTestDataAndOperations.getTurma(id, periodo)
    assert t != null
}
Then(~/^the class "([^"]*)" with semester "([^"]*)" is properly stored in the system$/) { String id, String periodo ->
    assert ClassTestDataAndOperations.compatibleTo(id, periodo, t)
}

Given(~/^the system already has a class with ID "([^"]*)" and semester "([^"]*)"$/) { String id, String periodo ->
    ClassTestDataAndOperations.createClass(id, periodo)
    t = ClassTestDataAndOperations.getTurma(id, periodo)
    assert t != null
}
Then(~/^the class "([^"]*)" with semester "([^"]*)" is not stored twice in the system$/) { String id, String periodo ->
    assert ClassTestDataAndOperations.onlyTurma(id, periodo)
}

Given(~/^I am at the Create Class page$/) { ->
    to CreateTurmaPage
    at CreateTurmaPage

}
When(~/^I fill the class details with name "([^"]*)", semester "([^"]*)" and save it$/) { String id, String periodo ->
    at CreateTurmaPage
    page.fillTurmaDetails(id, periodo)
    page.selectCreateTurma()
}
Then(~/^I can see the information for class "([^"]*)", semester "([^"]*)" at the Turma Listagem page$/) { String id, String periodo ->
    to TurmasPage
    at TurmasPage
    assert page.confirmTurma(id, periodo)
}

Given(~/^the system already has a class with name "([^"]*)" and semester "([^"]*)"$/) { String id, String periodo ->
    to CreateTurmaPage
    at CreateTurmaPage
    page.fillTurmaDetails(id, periodo)
    page.selectCreateTurma()

}
Then(~/^I see an error message$/) { ->
    at CreateTurmaPage
    page.checkForErrors()

}