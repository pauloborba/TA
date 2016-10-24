#Victor Augusto Pereira Porciúncula - vapp

  Feature: Relatorio final dos Alunos
    As the teacher
    I want to generate the final report of the students
    So that I can see the final grades and status of the students

#GUI Scenario

Scenario: tentar acessar o relatório de notas sem o preenchimento de notas estar completo.
  Given o item "Entender motivação e conceitos de requisitos" do aluno "Pedro" está vazio
  When tento gerar o Relatório de notas no menu principal
  Then é mostrada uma mensagem indicando que ainda não foram cadastradas todas as notas no menu principal

Scenario: visualização de aluno que tem média final >= 7, < 7 e >= 5, < 5
  Given a "Média Final" do aluno "João" é igual a "7"
  And a "Média Final" da aluna "Talita" é igual a "5"
  And a "Média Final" do aluno "Henrique" é "4.5"
  When tento gerar o Relatório de notas no menu principal
  Then a linha do aluno "João" será da cor "verde" no Relatório de notas
  And a coluna "Final" do aluno "João" será vazia
  And a linha da aluna "Talita" será da cor "amarela" no Relatório de notas
  And a linha do aluno "Henrique" será da cor "vermelha" no Relatório de notas

Scenario: visualização do total de critérios avaliados
  Given o aluno "Ricardo" teve "0" "MANAs Avaliadas"
  And o aluno "Ricardo" teve "1" "MPAs Avaliadas"
  And o aluno "Ricardo" teve "9" "MAs Avaliadas"
  When tento gerar o Relatório de notas no menu principal
  Then a coluna "Critérios Avaliados" do aluno "Ricardo" será "10"

Scenario: visualização do resultado da média final
  Given a aluna "Paloma" teve "Nota" igual a "4"
  And a aluna "Paloma" teve "Final" igual a "6"
  When tento gerar o Relatório de notas no menu principal
  Then a aluna "Paloma" terá a a coluna "Média Final" igual a "5"


Scenario: visualização do total de, aprovados, alunos, aprovados por média, aprovados na final, reprovados por nota,
  Given o aluno "Pietro" tem "Média Final" igual a "7"
  And o aluno "Carlos" tem "Média Final" igual a "6.5"
  And o aluno "Robson" tem "Média Final" igual a "4.5"
  And o aluno "Roberto" tem "Média Final" igual a "4"
  And a aluna "Roberta" tem "Média Final" igual a "10"
  And só há 5 alunos na turma
  When tento gerar o Relatório de notas no menu principal
  Then o "Total de aprovados" será igual a "3"
  And o "Total de alunos" será igual a "5"
  And o "Total de aprovados por média" será igual a "2"
  And o "Total de aprovados na final" será igual a "1"
  And o "Total de reprovados por nota" será igual a "2"

Scenario: visualização do total de reprovados por falta
  Given o número total de critérios cadastrados para a turma é "10"
  And a aluna "Rafaela" tem "Total de critérios avaliados" igual a "9"
  And a aluna "Pietra" tem "Total de critérios avaliados" igual a "10"
  And o aluno "Sérgio" tem "Total de critérios avaliados" igual a "7"
  And só há 3 alunos na turma
  When tento gerar o Relatório de notas no menu principal
  Then  o "Total de reprovados por falta" será igual a "2"
