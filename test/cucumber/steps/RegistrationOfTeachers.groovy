package steps

import pages.RegistrationPage
import pages.ConfirmationPage
import ta.Controller

/*
* Given the system doesn't have the teacher with cpf "111.111.111-11"
* When I create the teacher "John" with the cpf "111.111.111-11"
* Then the teacher "John" is properly stored by the system
* */

//Given the system doesn't have the teacher with cpf "111.111.111-11"
Given (~'^the system doesn\'t have the teacher with cpf "([^"]*)"$'){
    String cpf ->
        assert Controller.findByCpf(cpf) == null
}

//When I create the teacher "John" with the cpf "111.111.111-11"
When (~'^I create the teacher "([^"]*)" with the cpf "([^"]*)"$'){
    String teacher, cpf ->
        def newTeacher = Controller.builder.Teacher()
        newTeacher.setTeacherName(teacher)
        newTeacher.setTeacherCpf(cpf)

        Controller.builder.createTeacher(newTeacher)
}

//Then the teacher "John" is properly stored by the system
Then (~'^the teacher "([^"]*)" is properly stored by the system$'){
    String teacher ->
        assert Controller.findByName(teacher) != null
}

/*
* Given the teacher with cpf "111.111.111-11" is stored in the system
* When I try to create the teacher with cpf "111.111.111-11"
* Then the teacher with cpf "111.111.111-11" is not stored twice
* */

//Given the teacher with cpf "111.111.111-11" is stored in the system
Given (~'^the teacher with cpf "([^"]*)" is stored in the system$'){
    String cpf ->
        def newTeacher = Controller.builder.Teacher()
        newTeacher.setTeacherCpf(cpf)
        Controller.builder.createTeacher(newTeacher)

        assert Controller.findByCpf(cpf) != null
}

//When I try to create the teacher with cpf "111.111.111-11"
When (~'^I try to create the teacher with cpf "([^"]*)"$'){
    String cpf ->
        def newTeacher = Controller.builder.Teacher()
        newTeacher.setTeacherCpf(cpf)
        Controller.builder.createTeacher(newTeacher)
}

//Then the teacher with cpf "111.111.111-11" is not stored twice
Then (~'^the teacher with cpf "([^"]*)" is not stored twice$'){
    String cpf ->
        //?
}

/*
* Given I am at the "registration" menu
* And the system doesn't have the teacher with cpf "111.111.111-11"
* When I register the teacher with cpf “111.111.111-11”
* Then I can see a confirmation message
* And I can see the saved teacher information
* */

//Given I am at the "registration" menu
Given (~'^I am at the "([^"]*)" menu$'){
    String registration ->
        to RegistrationPage
        at RegistrationPage
}

//And the system doesn't have the teacher with cpf "111.111.111-11"
And (~'^the system doesn\'t have the teacher with cpf "([^"]*)"$'){
    String cpf ->
        assert Controller.findByCpf(cpf) == null
}

//When I register the teacher with cpf “111.111.111-11”
When (~'^I register the teacher with cpf “([^"]*)”$'){
    String cpf ->
        at RegistrationPage
        page.fillCpf(cpf)
}

//Then I can see a confirmation message
Then (~'^I can see a confirmation message$'){
    ->
    Controller.builder.showConfirmationMessage()
}

//And I can see the saved teacher information
And (~'^I can see the saved teacher information$'){
    ->
    at ConfirmationPage
}

/*
* Given I am at the "registration" menu
* And the teacher with cpf "111.111.111-11" is stored in the system
* When I try to register the teacher with cpf "111.111.111-11"
* Then I can see an error message
* */

//Given I am at the "registration" menu
Given (~'^I am at the "([^"]*)" menu$'){
    String registration ->
        to RegistrationPage
        at RegistrationPage
}

//And the teacher with cpf "111.111.111-11" is stored in the system
And (~'^the teacher with cpf "([^"]*)" is stored in the system$'){
    String cpf ->
        def newTeacher = Controller.builder.Teacher()
        newTeacher.setTeacherCpf(cpf)
        Controller.builder.createTeacher(newTeacher)

        assert Controller.findByCpf(cpf) != null
}

//When I try to register the teacher with cpf "111.111.111-11"
When (~'^I try to register the teacher with cpf "([^"]*)"$'){
    String cpf ->
        def newTeacher = Controller.builder.Teacher()
        newTeacher.setTeacherCpf(cpf)
        Controller.builder.createTeacher(newTeacher)
}

//Then I can see an error message
Then (~'^I can see an error message$'){
    ->
    Controller.builder.showErrorMessage()
}