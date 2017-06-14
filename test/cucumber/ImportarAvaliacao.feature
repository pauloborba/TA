#Isaac Douglas


#Cenario antigo
#Scenario: Importar Avaliação de uma planilha
#Given existe uma planilha "ESS 2017-1_MP.xls" com as notas da mini-prova da turma "ESS 2017-1"
#And o aluno "Gabriel" tem a nota "MPA" na planilha
#And o aluno "Marcos" tem a nota "MA" na planilha
#And tem uma turma "ESS 2017-1" cadastrada no sistema
#When eu tento importar a planilha "ESS 2017-1_MP.xls" para a turma "ESS 2017-1"
#Then as notas da planilha "ESS 2017-1_MP.xls" é importada para a turma "ESS 2017-1"
#And as notas são salvas nos respectivos alunos da turma "ESS 2017-1"
#And o aluno "Gabriel" fica com a nota "MPA"
#And o aluno "Marcos" fica com a nota "MA"

#Scenario: Importar Avaliação de uma Planilha
#Given existe uma planilha "ESS 2017-1_MP.xls" com as metas e conceitos da mini-prova da turma "ESS 2017-1"
#And o aluno "Gabriel" tem o conceito "MPA" na meta "Escrever bem requisitos"
#And o aluno "Gabriel" tem o conceito "MA" na meta "Entender conceitos de gerência de projetos"
#And existe uma turma "ESS 2017-1" cadastrada no sistema
#When eu tento salvar as avaliações com as metas e conceitos de cada aluno na turma "ESS 2017-1"
#Then as avaliações com as metas e conceitos de cada aluno da planilha "ESS 2017-1_MP.xls" é salva na turma "ESS 2017-1"
#And o aluno "Gabriel" fica com o conceito "MPA" na meta "Escrever bem requisitos"
#And o aluno "Gabriel" fica com o conceito "MA" na meta "Entender conceitos de gerência de projetos"


Feature: Importar Avaliação


#Controller Scenario
  Scenario: Importar Avaliacao de uma Planilha
    Given existe uma planilha "arq.xls" com os conceitos da meta "Escrever bem requisitos" de um "Formulário" da turma "ESS"
    And o aluno "idrn" tem o conceito "MA" na meta "Escrever bem requisitos"
    And o aluno "wfmf" tem o conceito "MPA" na meta "Escrever bem requisitos"
    When eu tento salvar as avaliações com os conceitos da meta "Escrever bem requisitos" do "Formulário" da turma "ESS"
    Then o aluno "idrn" fica com o conceito "MA" na meta "Escrever bem requisitos"
    And o aluno "wfmf" fica com o conceito "MPA" na meta "Escrever bem requisitos"

#Controller Scenario
  Scenario: Importar Todas as Avaliacoes de uma Planilha
    Given existe uma planilha "arq.xls" com os conceitos de varias metas de uma "Prova" da turma "ESS"
    And o aluno "idrn" tem o conceito "MA" na meta "Escrever bem requisitos"
    And o aluno "idrn" tem o conceito "MANA" na meta "Entender conceitos de gerencia de projetos"
    And o aluno "wfmf" tem o conceito "MPA" na meta "Escrever bem requisitos"
    And o aluno "wfmf" tem o conceito "MA" na meta "Entender conceitos de gerencia de projetos"
    When eu tento salvar as avaliações com os conceitos de todas as metas da "Prova" da turma "ESS"
    Then o aluno "idrn" fica com o conceito "MA" na meta "Escrever bem requisitos"
    And o aluno "idrn" fica com o conceito "MANA" na meta "Entender conceitos de gerencia de projetos"
    And o aluno "wfmf" fica com o conceito "MPA" na meta "Escrever bem requisitos"
    And o aluno "wfmf" fica com o conceito "MA" na meta "Entender conceitos de gerencia de projetos"

#GUI Scenario
  Scenario: Ver avaliações importadas
    Given eu estou na pagina Importar Avaliacoes
    And eu seleciono a avaliacao "Mini-prova" para a turma "ESS" e escolho a planilha "arq.xls" para importar
    When eu tento salvar as avaliações com os conceitos de todas as metas da "Mini-prova" da turma "ESS"
    Then eu consigo ver as avaliações salvas na pagina "Listar Avaliacoes"
