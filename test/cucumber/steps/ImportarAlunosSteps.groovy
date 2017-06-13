package steps

import cucumber.api.PendingException
import org.junit.Ignore
import pages.ImportarAlunosPage
import geb.Page
import pages.TurmaPage

/**
 * Created by wfeli on 12/06/2017.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

/**
 *
 * As etapas marcadas com @Ignore correspondem ao teste de controlador que não funcionou apesar da implementação correta
 */

Given(~/^I have the file "([^"]*)" which contains the students names and user names$/) { String path ->
     ImportAlunosDataAndOperations.assertFileExists(path)
}

And(~/^the file "([^"]*)" has the student "([^"]*)" with cin username "([^"]*)"$/) { String path, String name, String cinUsername ->
    ImportAlunosDataAndOperations.assertStudentIsInSpreadsheet(path, cinUsername)
}

And(~/^the system has the class "([^"]*)"$/) { String className ->
    ImportAlunosDataAndOperations.createAndSaveClass(className)
}

When(~/^I import the file "([^"]*)" for the "([^"]*)" class$/) { String path, String className ->
    ImportAlunosDataAndOperations.uploadSpreadsheet(path, className)
}

Then(~/^the system adds the student "([^"]*)" with cin username "([^"]*)" to the class "([^"]*)"$/) { String name, String cinUsername, String className ->
    ImportAlunosDataAndOperations.assertStudentsImported(name, className)
}

//GUI test
Given(~/^I have the class "([^"]*)"$/) { String className ->
    to TurmaPage
    at TurmaPage
    page.createAndSaveClass(className)
}
And(~/^I am at the "([^"]*)" page$/) { String page ->
    //ImportarAlunosPage.gotoImportarAlunos()

}
And(~/^the class "([^"]*)" is registered in the system$/) { String className ->
}
When(~/^I choose the class "([^"]*)" and the file "([^"]*)"$/) { String className, String file ->
    //ImportarAlunosPage.selectClass()
}
Then(~/^I can see the list of all students$/) { ->

}

//GUI test
Given(~/^I'm at the "([^"]*)" page$/) { String page ->
    
}
When(~/^I try to import a \.txt file$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^I can a message saying that I cannot upload the file$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

//GUI test
Given(~/^I am the "([^"]*)" page$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^I try to import without selecting a file$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^I can see a message asking to choose a file$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}