#Jádson Lucena

Feature: Reporting Classes
  As a Professor, desenvolvedor e as turmas
  I want to Criar Relatórios
  so that Gerar um comparativo de desempenho entre as turmas


#GUI Scenario:

  Scenario: Nenhuma turma cadastrada
    Given O sistema não tem nenhuma turma cadastrada
    When Eu tento visualizar o relatórios e o gráfico das turmas
    Then Nenhuma turma será listada


  Scenario: Uma única turma cadastrada
    Given O sistema tem apenas a turma "2016.1" cadastrada
    When Eu tento fazer uma comparação somente com a turma "2016.1"
    Then Não será permitida fazer a comparação somente com a turma "2016.1"


  Scenario: Várias turmas cadastradas
    Given O sistema tem as turmas "2015.1", "2015.2" e "2016.1" cadastradas
    When Eu irei fazer uma comparação entre a turma "2016.1" com média "9" e "2015.2" com média "7"
    Then Será exibido um relatório onde informa que a turma "2016.1" teve uma diferença de "2%" em relação a turma "2015.2"


  Scenario: Comparar mais de duas turmas simultaneamente
    Given O sistema tem as turmas "2015.1", "2015.2" e "2016.1" previamente cadastradas
    When Eu tento comparar as turmas "2015.1", "2015.2" e "2016.1" simultaneamente
    Then Não será permitida a seleção da turma "2016.1"