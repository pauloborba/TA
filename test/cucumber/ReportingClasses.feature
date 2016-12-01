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

  Scenario: Média da turma
    Given O sistema possui o aluno "Student" com login "student@email.com"
    And O aluno "Student1" com login "student1@email.com"
    And Possui um critério de nome "Critéio"
    And O Student1 possui uma avaliação "MPA" e o Student possui MA
    And A turma "ESS" de "2016.1" contém o aluno "student@email.com" e o "student1@email.com"
    When Eu visualizo o relatório da turma cadastrada
    Then A turma "2016.1" possuirá a média "7.5"

  Scenario: Sinalização de média baixa
    Given O sistema tem a turma "ESS1" de "2015.2" cadastradas com o aluno "student1@email.com"
    And Recria o critério de nome "Critéio"
    And Reavalia o estudante Student1 com "MPA" e o Student com MA
    When Eu visualizo o relatório das turmas
    Then A turma "2015.2" estará com o plano de fundo vermelho

  Scenario: Geração de gráfico
    Given Que o sistema possui pelo menos uma turma cadastrada
    When Eu visualizo o gráfico de turmas
    Then Será gerado um gráfico