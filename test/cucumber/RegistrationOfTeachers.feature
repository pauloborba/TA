Feature: Registration of teachers
  As a professor
  I want to add and remove teachers
  So that many teachers can use the system

  Scenario: new teacher
    Given the system doesn't have the teacher with cpf "111.111.111-11"
    When I create the teacher "John" with cpf "111.111.111-11"
    Then the teacher "John" is properly stored by the system

  Scenario: duplicate professor
    Given the teacher with cpf "111.111.111-11" is stored in the system
    When I try to create the teacher with name "Joe" and cpf "111.111.111-11"
    Then the teacher with name "Joe" and cpf "111.111.111-11" is not stored twice

  Scenario: new teacher
    Given I am at the registration menu
    And the system doesn't have the teacher with cpf "111.111.111-11"
    When fill the form with name "John" and cpf "111.111.111-11"
    Then I can see a confirmation message

  Scenario: duplicate professor
    Given I am at the registration menu
    And the teacher with cpf "111.111.111-11" is stored in the system
    When fill the form with name "John" and cpf "111.111.111-11"
    Then I can see an error message on the screen

  Scenario: atualizar cpf
    Given o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
    And nenhum professor com o cpf "222.222.222-22" está cadastrado no sistema
    When eu atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
    Then o cpf de "John" é atualizado com sucesso

  Scenario: atualização de cpf inválida
    Given o professor "John" com o cpf "333.333.333-333" está cadastrado no sistema
    And o professor "Joe" com o cpf "222.222.222-22" está cadastrado no sistema
    When eu tentar atualizar o cpf de "John" de "111.111.111-11" para "222.222.222-22"
    Then o cpf de "John" não é atualizado
  @ignore
  Scenario: atualizar professor
    Given eu estou no menu de atualização de dados
    And o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
    And nenhum professor com o cpf "222.222.222-22" está cadastrado no sistema
    When eu preencher o formulário de atualização de "111.111.111-11" para "222.222.222-22"
    Then eu posso ver uma mensagem de confirmação
  @ignore
  Scenario: atualização inválida
    Given eu estou no menu de atualização de dados
    And o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
    And o professor "Joe" com o cpf "222.222.222-22" está cadastrado no sistema
    When eu preencher o formulário de atualização de "111.111.111-11" para "222.222.222-22"
    Then eu posso ver uma mensagem de erro

   Scenario: atualizar nome
     Given o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
     And nenhum professor com o nome "Joe" está cadastrado no sistema
     When eu atualizar o nome do professor com cpf "111.111.111-11" para "Joe"
     Then o nome do professor é atualizado para "Joe" com sucesso

   Scenario: atualizaçao de nome invalida
     Given o professor "John" com o cpf "111.111.111-11" está cadastrado no sistema
     And o professor "Joe" com o cpf "222.222.222-22" está cadastrado no sistema
     When eu atualizar o nome do professor com cpf "111.111.111-11" para "Joe"
     Then o nome do professor não é atualizado para "Joe" com sucesso