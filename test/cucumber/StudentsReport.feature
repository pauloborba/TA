#Victor Augusto Pereira Porciúncula - vapp








Feature: Relatorio final dos Alunos
  As the teacher
  I want to generate the final report of the students
  So that I can see the final grades and status of the students


#GUI Scenario


  Scenario: visualização de aluno que tem média >= 7, < 7 e >= 5, < 5
    Given Eu crio os alunos "Joao", "Caio", "Henrique" de logins: "jkd", "caf", "herk"  respectivamente
    And Eu crio os criterios "Patterns", "Feature", "Scenario"
    And Eu avalio os criterios "Patterns", "Feature" e "Scenario" dos alunos com logins "jkd", "caf", "herk" como "MA", "MPA", "MANA", respectivamente para cada login repetido em cada criterio
    When Vejo o Relatório dos estudantes
    Then a linha do alunos de login "jkd", "caf", "herk" serao das cores "green", "yellow", "red" no Relatório de notas


  Scenario: visualização do total de critérios avaliados
    Given Eu crio o aluno "Ricardo" de login "rcc"
    And Eu crio os criterios "Patterns", "Feature", "Scenario" e "Refactoring"
    And Eu adiciono os conceitos para "Patterns", "Feature", "Scenario" e "Refactoring" do aluno de login "rcc" para "MA"
    When Checo o Relatório dos estudantes
    Then a coluna "Total de critérios avaliados" do aluno de login "rcc" será "4"


  Scenario: visualização do total de alunos aprovados por média, aprovados na final, reprovados por falta, reprovados por nota e total de alunos
    Given Eu crio os alunos "Joao", "Caio", "Henrique", "Juliano" de logins: "jkd", "caf", "herk", "jqo"  respectivamente
    And Eu crio os criterios "Patterns", "Scenario"
    And And Eu avalio os criterios "Patterns", e "Scenario" dos alunos com logins "jkd", "caf", "herk" e "jqo" como "MA", "MPA", "MANA", "MANA" e "MA", "MPA", "MANA", "--", respectivamente para cada login
    When Vou para o Relatório de notas
    Then Os campos "Total de aprovados por media", "Total de aprovados na final", "Total de reprovados por falta" ,"Total de reprovados por nota", "Total de alunos" serao iguais a "1", "1", "1", "1", "4", respectivamente



