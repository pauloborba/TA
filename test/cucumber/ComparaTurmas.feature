Feature: Estatistica da Turma
  Como um professor
  Eu quero ver como uma única turma se compara com as demais
  Para que eu possa medir se as mudanças aplicadas a didatica foram positivas ou negativas

 #Cenario Controller

  Scenario: Media de turma
    Given eu tenho a turma "2017.1"
    And o aluno "Pedro" esta matriculado em "2017.1"
    And "Pedro" possui media final "10"
    And o aluno "Douglas" esta matriculado em "2017.1"
    And "Douglas" possui media final "7"
    And o aluno "Jeff" esta matriculado em "2017.1"
    And "Jeff" possui media final "8"
    When eu seleciono a turma "2017.1"
    Then a media geral de "2017.1" e calculada

 #Cenario GUI

  Scenario: Exibir media geral
    Given eu estou na pagina de "Turmas List"
    And eu tenho a turma "2017.1"
    When eu seleciono a turma "2017.1"
    Then eu consigo ver a media geral de "2017.1"

 #Cenario Controller
  Scenario: Quantidade de turmas superadas
    Given eu tenho a turma "2017.1"
    And o aluno "Pedro" esta matriculado em "2017.1"
    And "Pedro" possui media final "9"
    And o aluno "Douglas" esta matriculado em "2017.1"
    And "Douglas" possui media final "7"
    And o aluno "Jeff" esta matriculado em "2017.1"
    And "Jeff" possui media final "5"
    And eu tenho a turma "2016.2"
    And o aluno "Pedro" esta matriculado em "2016.2"
    And "Pedro" possui media final "4"
    And o aluno "Dante" esta matriculado em "2016.2"
    And "Dante" possui media final "7"
    And o aluno "Vergil" esta matriculado em "2016.2"
    And "Vergil" possui media final "6"
    And eu tenho a turma "2016.1"
    And o aluno "Bill" esta matriculado em "2016.1"
    And "Bill" possui media final "8"
    And o aluno "Lucio" esta matriculado em "2016.1"
    And "Lucio" possui media final "3"
    And o aluno "Lucio" esta matriculado em "2016.1"
    And "Lucio" possui media final "6"
    And o aluno "Lloyd" esta matriculado em "2016.1"
    And "Lloyd" possui media final "2"
    When eu seleciono a turma "2017.1"
    Then o numero de turmas que possuem media geral, numero percentual de alunos aprovados e numeros percentual de alunos aprovados por media inferior a "2017.1" e calculado

 #Cenário GUI

  Scenario: Exibir comparacao
    Given eu estou na pagina de "Turmas List"
    And eu tenho a turma "2017.1"
    And eu tenho a turma "2016.2"
    And eu tenho a turma "2016.1"
    When eu seleciono a turma "2017.1"
    Then eu consigo ver o numero de turmas que "2017.1" supera em questão de media geral, numero percentual de alunos aprovados e numeros percentual de alunos aprovados por media em comparacao com o total de turmas cadastradas

