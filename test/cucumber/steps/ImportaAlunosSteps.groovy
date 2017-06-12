package steps

import ta.*

/**
 * Created by wfeli on 12/06/2017.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

PlanilhaAlunos planilha = PlanilhaFactory.getPlanilha('../resources/alunos.xls', 'addaluno')

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
    ImportAlunosDataAndOperations.assertStudentsImported(cinUsername, className)
}