package steps

import cucumber.api.PendingException
import org.junit.Before
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
And(~/^I am at the Importar Alunos page$/) { ->
    to ImportarAlunosPage
    at ImportarAlunosPage
}
When(~/^I choose the class "([^"]*)" and the file "([^"]*)"$/) { String className, String file ->
    at ImportarAlunosPage
    page.openFileDialog()
}
Then(~/^I can see the list of all students$/) { ->

}

Given(~/^I am the "([^"]*)" page$/) { String arg1 ->
    to ImportarAlunosPage
    at ImportarAlunosPage
}
When(~/^I try to import without selecting a file$/) { ->
    to ImportarAlunosPage
    at ImportarAlunosPage
    page.importWithoutFile()
}
Then(~/^I can see a message asking to choose a file$/) { ->
    at ImportarAlunosPage
}
