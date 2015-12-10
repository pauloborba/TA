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
@ignore
Scenario: atualizar professor
  Given o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
  And nenhum professor com o cpf "222.222.222-22" está cadastrado no sistema
  When eu atualizar o cpf de "John" para "222.222.222-22"
  Then o cpf de "John" é atualizado com sucesso
@ignore
Scenario: atualização inválida
  Given o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
  And o professor "Joe" com o cpf "222.222.222-22" está cadastrado no sistema
  When eu tentar atualizar o cpf de "John" para "222.222.222-22"
  Then o cpf de "John" não é atualizado
@ignore
Scenario: atualizar professor
  Given eu estou no menu de atualização de dados
  And o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
  And nenhum professor com o cpf "222.222.222-22" está cadastrado no sistema
  When eu atualizar o cpf de "John" para "222.222.222-22"
  Then eu posso ver uma mensagem de confirmação
  And eu posso ver as informações salvas do professor
@ignore
Scenario: atualização inválida
  Given eu estou no menu de atualização de dados
  And o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
  And o professor "Joe" com o cpf "222.222.222-22" está cadastrado no sistema
  When eu tentar atualizar o cpf de "John" para "222.222.222-22"
  Then eu posso ver uma mensagem de erro
