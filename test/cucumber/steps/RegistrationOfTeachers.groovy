/**
 * Created by ess on 11/01/16.
 */
package steps

import pages.RegisterTeacherPage
import pages.UpdateTeacherPage
import ta.Teachers

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

/*
* new teacher
*/

//Given the system doesn't have the teacher with cpf "111.111.111-11"
Given (~'^the system doesn\'t have the teacher with cpf "([^"]*)"$'){
    String cpf ->
        TeacherTestDataAndOperations.deleteTeacher(cpf)
        assert Teachers.findByCpf(cpf) == null
}

//When I create the teacher "John" with cpf "111.111.111-11"
When (~'^I create the teacher "([^"]*)" with cpf "([^"]*)"$'){
    String teacher, cpf ->
        TeacherTestDataAndOperations.createTeacher(teacher, cpf)
}

//Then the teacher "John" is properly stored by the system
Then (~'^the teacher "([^"]*)" is properly stored by the system$'){
    String teacher ->
        assert Teachers.findByName(teacher) != null
}

/*
* duplicate professor
*/

//Given the teacher with cpf "111.111.111-11" is stored in the system
Given (~'^the teacher with cpf "([^"]*)" is stored in the system$'){
    String cpf ->
        TeacherTestDataAndOperations.createTeacher("John", cpf)
        assert Teachers.findByCpf(cpf) != null
}

//When I try to create the teacher with name "Joe" and cpf "111.111.111-11"
When (~'^I try to create the teacher with name "([^"]*)" and cpf "([^"]*)"$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
}

//Then the teacher with name "Joe" and cpf "111.111.111-11" is not stored twice
Then (~'^the teacher with name "([^"]*)" and cpf "([^"]*)" is not stored twice$'){
    String name, cpf ->
        assert Teachers.findByName(name) == null && Teachers.findByCpf(cpf) != null
}

/*
* new teacher GUI
*/

//Given I am at the registration menu
Given (~'^I am at the registration menu$'){
    ->
    to RegisterTeacherPage
    at RegisterTeacherPage
}

//When fill the form with name "John" and cpf "111.111.111-11"
When (~'^fill the form with name "([^"]*)" and cpf "([^"]*)"$'){
    String name, cpf ->
        at RegisterTeacherPage
        page.fillCpf(name, cpf)
}

//Then I can see a confirmation message
Then (~'^I can see a confirmation message$'){
    ->
    at RegisterTeacherPage
    page.showConfirmation()
}

/*
* duplicate professor GUI
*/

//Then I can see an error message on the screen
Then (~'^I can see an error message on the screen'){
    ->
    at RegisterTeacherPage
    page.showError()
}

/*
* atualizar cpf
*/

//Given o professor "John" com o cpf "333.333.333-33" está cadastrado no sistema
Given (~'^o professor "([^"]*)" com o cpf "([^"]*)" está cadastrado no sistema$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
}

//And nenhum professor com o cpf "222.222.222-22" está cadastrado no sistema
And (~'^nenhum professor com o cpf "([^"]*)" está cadastrado no sistema$'){
    String cpf ->
        assert Teachers.findByCpf(cpf) == null
}

//When eu atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
When (~'^eu atualizar o cpf de "([^"]*)" de "([^"]*)" para "([^"]*)"$'){
    String name, oldCpf, newCpf ->
        TeacherTestDataAndOperations.editCpf(name, oldCpf, newCpf)
}

//Then o cpf de "John" é atualizado com sucesso
Then (~'^o cpf de "([^"]*)" é atualizado com sucesso$'){
    String name ->
        assert Teachers.findByName(name) != null //!
}

/*
* atualização de cpf inválida
*/

//When eu tentar atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
When (~'^eu tentar atualizar o cpf de "([^"]*)" de "([^"]*)" para "([^"]*)"$'){
    String name, oldCpf, newCpf ->
        TeacherTestDataAndOperations.editCpf(name, oldCpf, newCpf)
}

//Then o cpf de "John" não é atualizado
Then (~'^o cpf de "([^"]*)" não é atualizado$'){
    String name ->
        assert Teachers.findByName(name) != null //!
}

/*
* @ignore
* atualizar professor GUI
*/

//Given eu estou no menu de atualização de dados
Given (~'^eu estou no menu de atualização de dados$'){
    ->
    to UpdateTeacherPage
    at UpdateTeacherPage
}

//When eu preencher o formulário de atualização de "111.111.111-11" para "222.222.222-22"
When (~'^eu preencher o formulário de atualização de "([^"]*)" para "([^"]*)"$'){
    String oldCpf, newCpf ->
        at UpdateTeacherPage
        page.fillEditCpf(oldCpf, newCpf)
}

//Then eu posso ver uma mensagem de confirmação
Then (~'^eu posso ver uma mensagem de confirmação$'){
    ->
    at UpdateTeacherPage
    page.showConfirmation()
}

/*
* @ignore
* atualização inválida GUI
*/

//Then eu posso ver uma mensagem de erro
Then (~'^eu posso ver uma mensagem de erro$'){
    ->
    at UpdateTeacherPage
    page.showError()
}

/*
* atualizar nome
*/

//And nenhum professor com o nome "Joe" está cadastrado no sistema
And (~'^nenhum professor com o nome "([^"]*)" está cadastrado no sistema$'){
    String name ->
        assert Teachers.findByName(name) == null
}

//When eu atualizar o nome do professor com cpf "111.111.111-11" para "Joe"
When (~'^eu atualizar o nome do professor com cpf "([^"]*)" para "([^"]*)"$'){
    String cpf, newName ->
        TeacherTestDataAndOperations.editName(cpf, newName)
}

//Then o nome do professor é atualizado para "Joe" com sucesso
Then (~'^o nome do professor é atualizado para "([^"]*)" com sucesso$'){
    String newName->
    assert Teachers.findByName(newName) != null //!
}

/*
* atualizaçao de nome invalida
*/

//Then o nome do professor não é atualizado para "Joe" com sucesso
Then (~'^o nome do professor não é atualizado para "([^"]*)" com sucesso'){
    String newName ->
        assert Teachers.findByName(newName) != null //!
}