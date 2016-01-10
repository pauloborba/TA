package steps

import pages.RegisterTeacherPage
import pages.UpdateTeacherPage
import ta.Teachers

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

/*
* Given the system doesn't have the teacher with cpf "111.111.111-11"
* When I create the teacher "John" with the cpf "111.111.111-11"
* Then the teacher "John" is properly stored by the system
*/

Given (~'^the system doesn\'t have the teacher with cpf "([^"]*)"$'){
    String cpf ->
        assert Teachers.findByCpf(cpf) == null
}

When (~'^I create the teacher "([^"]*)" with the cpf "([^"]*)"$'){
    String teacher, cpf ->
        TeacherTestDataAndOperations.createTeacher(teacher, cpf)
}

Then (~'^the teacher "([^"]*)" is properly stored by the system$'){
    String teacher ->
        assert Teachers.findByName(teacher) != null
}

/*
* Given the teacher with cpf "111.111.111-11" is stored in the system
* When I try to create the teacher with cpf "111.111.111-11"
* Then the teacher with cpf "111.111.111-11" is not stored twice
*/

Given (~'^the teacher with cpf "([^"]*)" is stored in the system$'){
    String cpf ->
        TeacherTestDataAndOperations.createTeacher("John", cpf)
        assert Teachers.findByCpf(cpf) != null
}

When (~'^I try to create the teacher with cpf "([^"]*)"$'){
    String cpf ->
        TeacherTestDataAndOperations.createTeacher("Joe", cpf)
}

Then (~'^the teacher with cpf "([^"]*)" is not stored twice$'){
    String cpf ->
        assert Teachers.findByName(teacher) == null
}

/*
* Given I am at the "registration" menu
* And the system doesn't have the teacher with cpf "111.111.111-11"
* When I register the teacher with cpf �111.111.111-11�
* Then I can see a confirmation message
*/

Given (~'^I am at the "([^"]*)" menu$'){
    String registration ->
        to RegisterTeacherPage
        at RegisterTeacherPage
}

And (~'^the system doesn\'t have the teacher with cpf "([^"]*)"$'){
    String cpf ->
        assert Teachers.findByCpf(cpf) == null
}

When (~'^I register the teacher with cpf "([^"]*)"$'){
    String cpf ->
        at RegisterTeacherPage
        page.fillCpf("John", cpf)
}

Then (~'^I can see a confirmation message$'){
    ->
    at RegisterTeacherPage
    page.showConfirmation()
}

/*
* Given I am at the "registration" menu
* And the teacher with cpf "111.111.111-11" is stored in the system
* When I try to register the teacher with cpf "111.111.111-11"
* Then I can see an error message
*/

Given (~'^I am at the "([^"]*)" menu$'){
    String registration ->
        to RegisterTeacherPage
        at RegisterTeacherPage
}

And (~'^the teacher with cpf "([^"]*)" is stored in the system$'){
    String cpf ->
        TeacherTestDataAndOperations.createTeacher("John", cpf)
        assert Teachers.findByCpf(cpf) != null
}

When (~'^I try to register the teacher with cpf "([^"]*)"$'){
    String cpf ->
        at RegisterTeacherPage
        page.fillCpf("John", cpf)
}

Then (~'^I can see an error message$'){
    ->
    at RegisterTeacherPage
    page.showError()
}

/*
* Given o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
* And nenhum professor com o cpf "222.222.222-22" está cadastrado no sistema
* When eu atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
* Then o cpf de "John" é atualizado com sucesso
*/

Given (~'^o professor "([^"]*)" com o cpf "([^"]*)" está cadastrado no sistema$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
        assert Teachers.findByCpf(cpf) != null
}

And (~'^nenhum professor com o cpf "([^"]*)" está cadastrado no sistema$'){
    String cpf ->
        assert Teachers.findByCpf(cpf) == null
}

When (~'^eu atualizar o cpf de "([^"]*)" de "([^"]*)" para "([^"]*)"$'){
    String name, oldCpf, newCpf ->
        TeacherTestDataAndOperations.editCpf(oldCpf, newCpf)
}

Then (~'^o cpf de "([^"]*)" é atualizado com sucesso$'){
    String name ->
        assert Teachers.findByName(name) != null //!
}

/*
* Given o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
* And o professor "Joe" com o cpf "222.222.222-22" está cadastrado no sistema
* When eu tentar atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
* Then o cpf de "John" não é atualizado
*/

Given (~'^o professor "([^"]*)" com o cpf "([^"]*)" está cadastrado no sistema$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
        assert Teachers.findByCpf(cpf) != null
}

And (~'^o professor "([^"]*)" com o cpf "([^"]*)" está cadastrado no sistema$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
        assert Teachers.findByCpf(cpf) != null
}

When (~'^eu tentar atualizar o cpf de "([^"]*)" de "([^"]*)" para "([^"]*)"$'){
    String name, oldCpf, newCpf ->
        TeacherTestDataAndOperations.editCpf(oldCpf, newCpf)
}

Then (~'^o cpf de "([^"]*)" não é atualizado com sucesso$'){
    String name ->
        assert Teachers.findByName(name) != null //!
}

/*
* Given eu estou no menu de atualização de dados
* And o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
* And nenhum professor com o cpf "222.222.222-22" está cadastrado no sistema
* When eu atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
* Then eu posso ver uma mensagem de confirmação
*/

Given (~'^eu estou no menu de atualização de dados$'){
    String registration ->
        to UpdateTeacherPage
        at UpdateTeacherPage
}

And (~'^o professor "([^"]*)" com o cpf "([^"]*)" está cadastrado no sistema$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
        assert Teachers.findByCpf(cpf) != null
}

And (~'^nenhum professor com o cpf "([^"]*)" está cadastrado no sistema$'){
    String cpf ->
        assert Teachers.findByCpf(cpf) == null
}

When (~'^eu atualizar o cpf de "([^"]*)" de "([^"]*)" para "([^"]*)"$'){
    String name, oldCpf, newCpf ->
        at UpdateTeacherPage
        page.fillEditCpf(name, oldCpf, newCpf)
}

Then (~'^eu posso ver uma mensagem de confirmação$'){
    ->
    at UpdateTeacherPage
    page.showConfirmation()
}

/*
* Given eu estou no menu de atualização de dados
* And o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
* And o professor "Joe" com o cpf "222.222.222-22" está cadastrado no sistema
* When eu tentar atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
* Then eu posso ver uma mensagem de erro
*/

Given (~'^eu estou no menu de atualização de dados$'){
    String registration ->
        to UpdateTeacherPage
        at UpdateTeacherPage
}

And (~'^o professor "([^"]*)" com o cpf "([^"]*)" está cadastrado no sistema$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
        assert Teachers.findByCpf(cpf) != null
}

And (~'^o professor "([^"]*)" com o cpf "([^"]*)" está cadastrado no sistema$'){
    String name, cpf ->
        TeacherTestDataAndOperations.createTeacher(name, cpf)
        assert Teachers.findByCpf(cpf) != null
}

When (~'^eu tentar atualizar o cpf de "([^"]*)" de "([^"]*)" para "([^"]*)"$'){
    String name, oldCpf, newCpf ->
        at UpdateTeacherPage
        page.fillEditCpf(name, oldCpf, newCpf)
}

Then (~'^eu posso ver uma mensagem de erro$'){
    ->
    at UpdateTeacherPage
    page.showError()
}