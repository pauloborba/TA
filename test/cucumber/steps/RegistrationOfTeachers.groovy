package steps

import ta.Teachers
import pages.RegisterTeacherPage

/*
* Given the system doesn't have the teacher with cpf "111.111.111-11"
* When I create the teacher "John" with the cpf "111.111.111-11"
* Then the teacher "John" is properly stored by the system
*/


//Given the system doesn't have the teacher with cpf "111.111.111-11"
Given (~'^the system doesn\'t have the teacher with cpf "([^"]*)"$'){
    String cpf ->
        assert Teachers.findByCpf(cpf) == null
}

//When I create the teacher "John" with the cpf "111.111.111-11"
When (~'^I create the teacher "([^"]*)" with the cpf "([^"]*)"$'){
    String teacher, cpf ->
        TeacherTestDataAndOperations.createTeacher(teacher, cpf)
}

//Then the teacher "John" is properly stored by the system
Then (~'^the teacher "([^"]*)" is properly stored by the system$'){
    String teacher ->
        assert Teachers.findByName(teacher) != null
}

/*
* Given the teacher with cpf "111.111.111-11" is stored in the system
* When I try to create the teacher with cpf "111.111.111-11"
* Then the teacher with cpf "111.111.111-11" is not stored twice
*/

//Given the teacher with cpf "111.111.111-11" is stored in the system
Given (~'^the teacher with cpf "([^"]*)" is stored in the system$'){
    String cpf ->
        TeacherTestDataAndOperations.createTeacher("John", cpf)
        assert Teachers.findByCpf(cpf) != null
}

//When I try to create the teacher with cpf "111.111.111-11"
When (~'^I try to create the teacher with cpf "([^"]*)"$'){
    String cpf ->
        TeacherTestDataAndOperations.createTeacher("Joe", cpf)
}

//Then the teacher with cpf "111.111.111-11" is not stored twice
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

//Given I am at the "registration" menu
Given (~'^I am at the "([^"]*)" menu$'){
    String registration ->
        to RegisterTeacherPage
        at RegisterTeacherPage
}

//And the system doesn't have the teacher with cpf "111.111.111-11"
And (~'^the system doesn\'t have the teacher with cpf "([^"]*)"$'){
    String cpf ->
        assert Teachers.findByCpf(cpf) == null
}

//When I register the teacher with cpf "111.111.111-11"
When (~'^I register the teacher with cpf "([^"]*)"$'){
    String cpf ->
        at RegisterTeacherPage
        page.fillCpf(cpf)
}

//Then I can see a confirmation message
Then (~'^I can see a confirmation message$'){
    ->
    at RegisterTeacherConfirmationPage
}

/*
* Given I am at the "registration" menu
* And the teacher with cpf "111.111.111-11" is stored in the system
* When I try to register the teacher with cpf "111.111.111-11"
* Then I can see an error message
*/

//Given I am at the "registration" menu
Given (~'^I am at the "([^"]*)" menu$'){
    String registration ->
        to RegisterTeacherPage
        at RegisterTeacherPage
}

//And the teacher with cpf "111.111.111-11" is stored in the system
And (~'^the teacher with cpf "([^"]*)" is stored in the system$'){
    String cpf ->
        TeacherTestDataAndOperations.createTeacher("John", cpf)
        assert Teachers.findByCpf(cpf) != null
}

//When I try to register the teacher with cpf "111.111.111-11"
When (~'^I try to register the teacher with cpf "([^"]*)"$'){
    String cpf ->
        at RegisterTeacherPage
        page.fillCpf(cpf)
}

//Then I can see an error message
Then (~'^I can see an error message$'){
    ->
    at RegisterTeacherErrorPage
}