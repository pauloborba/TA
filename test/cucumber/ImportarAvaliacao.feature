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
  Scenario: Importar Avaliação de uma Planilha
    Given existe uma planilha "/Users/isaacdouglas1/git/TA/test/resources/arq.xls" com os conceitos da meta "Escrever bem requisitos" de um "Formulário"
    And o aluno "idrn" tem o conceito "MA"
    And o aluno "wfmf" tem o conceito "MPA"
    When eu tento salvar as avaliações com os conceitos da meta "Escrever bem requisitos" do "Formulário"
    Then o aluno "idrn" fica com o conceito "MA" na meta "Escrever bem requisitos"
    And o aluno "wfmf" fica com o conceito "MPA" na meta "Escrever bem requisitos"


#GUI Scenario
  Scenario: Ver avaliações importadas
    Given eu estou na pagina "Importar Avaliacoes"
    When eu salvo as avaliações da planilha "/Users/isaacdouglas1/git/TA/test/resources/arq.xls"
    Then eu consigo ver as avaliações salvas na pagina "Listar Avaliacoes"
