/**
 * Created by Lavinia Paganini on 03/11/2016.
 */

package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

/*
    #Controle
    Scenario: Visualizar a nota do aluno
      Given o aluno “João Vasconcelos”, com login "jvsn", possui conceitos “MA”, “MPA” e “MA” em “Requisitos de Sistemas”
      And o aluno "João Vasconcelos", com login "jvsn", possui media “MA” em “Requisitos de Sistemas”
      When eu solicito a visualização da situação do aluno "João Vasconcelos" com login "jvsn"
      Then a média de “João Vasconcelos”, com login "jvsn", em “Requisitos de Sistemas” continua sendo “MA”
 */

Given(~'o aluno "([^"]*)", com login "([^"]*)" possui conceitos "([^"]*)", "([^"]*)" e "([^"]*)" em "([^"]*)"'){
    String aluno, String login, String conceito1, String conceito2, String conceito3, String materia ->
        SituationStudentsTestDataAndOperation.AddAlunoConceitosAndMateria(aluno, login, materia, conceito1)
        SituationStudentsTestDataAndOperation.AddAlunoConceitosAndMateria(aluno, login, materia, conceito2)
        SituationStudentsTestDataAndOperation.AddAlunoConceitosAndMateria(aluno, login, materia, conceito3)
}

And(~'o aluno "([^"]*)", com login "([^"]*)", possui media "([^"]*)" em "([^"]*)"'){
    String aluno, String aluno, String media, String conceito ->
        SituationStudentsTestDataAndOperation.AddMediaAluno(aluno, login, media, conceito)
}

When(~'eu solicito a visualização da situação do aluno "([^"]*)" com login "([^"]*)"'){
    String aluno, String login ->
        SituationStudentsTestDataAndOperation.verSituacao(aluno, login)
}
Then(~'a média de "([^"]*)", com login "([^"]*)", em "([^"]*)" continua sendo "([^"]*)"'){
    String aluno, String login, String conceito, String media ->
        SituationStudentsTestDataAndOperation.verificar(aluno,login,conceito,media)
}