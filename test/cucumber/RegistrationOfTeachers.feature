Feature: registration of teachers
As a professor
I want to add and remove teachers
So that many teachers can use the system
@ignore
Scenario: new teacher
Given the system doesn't have the teacher with cpf "111.111.111-11"
When i create the teacher "John" with cpf "111.111.111-11"
Then the teacher "John" is properly stored by the system
@ignore
Scenario: duplicate professor
Given the teacher with cpf "111.111.111-11" is stored in the system
When i try to create the teacher with cpf "111.111.111-11"
Then the teacher with cpf "111.111.111-11" is not stored twice
@ignore
Scenario: new teacher
Given i am at the "registration" menu
And the system doesn't have the teacher with cpf "111.111.111-11"
When i register the teacher with cpf �111.111.111-11� 
Then i can see a confirmation message
And i can see the saved teacher information
@ignore
Scenario: duplicate professor
Given i am at the "registration" menu
And the teacher with cpf "111.111.111-11" is stored in the system
When i try to register the teacher with cpf "111.111.111-11"
Then i can see an error message