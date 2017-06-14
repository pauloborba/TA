Feature: Send email
  As the teacher
  I want send emails to students by some criteries
  So I can send emails

#Controller Scenario
  Scenario: Enviar email para alunos com problemas
    Given que o sistema tem o aluno "Ricardo" matriculado na turma "ESS 2017.1"
    And o aluno "Ricardo" tem conceito "MA" na meta "Definição de requisitos" e conceito "MA" na meta "Gerência de projetos" na avaliação "MP1"
    And o sistema tem o aluno "Robson" matriculado na turma "ESS 2017.1"
    And o aluno "Robson" tem conceito "MANA" na meta "Definição de requisitos" e conceito "MANA" na meta "Gerência de projetos" na avaliação "MP1"
    And o sistema tem o aluno "José" matriculado na turma "ESS 2017.1"
    And o aluno "José" tem conceito "MA" na meta "Definição de requisitos" e conceito "MPA" na meta "Gerência de projetos" na avaliação "MP1"
    And o sistema tem o aluno "Pedro" matriculado na turma "ESS 2017.1"
    And o aluno "Pedro" tem conceito "MPA" na meta "Definição de requisitos" e conceito "MA" na meta "Gerência de projetos" na avaliação "MP1"
    And o sistema tem o aluno "Leonardo" matriculado na turma "ESS 2017.1"
    And o aluno "Leonardo" tem conceito "MANA" na meta "Definição de requisitos" e conceito "MANA" na meta "Gerência de projetos" na avaliação "MP1"
    When eu solicitar o envio de email para alunos com problemas para a turma "ESS 2017.1"
    Then será enviado um email para os alunos "Robson" e "Leonardo" da turma "ESS 2017.1", apenas

  Scenario: Enviar link para Autoavaliação
    Given que o sistema tem o aluno "Ricardo" matriculado na turma "ESS 2017.2"
    And o sistema tem o aluno "Robson" matriculado na turma "ESS 2017.2"
    And o sistema tem o aluno "Isaac" matriculado na turma "ESS 2017.2"
    When eu solicitar o envio de email de autoavaliação para a turma "ESS 2017.2"
    Then será enviado um email com link de autoavaliação para os alunos email "Ricardo", o aluno "Robson" e o aluno "Isaac" da turma "ESS 2017.2"

#GUI Scenario
  Scenario: GUI Enviar email para alunos com problemas
    Given que eu estou na pagina de visualizar as turmas e tenho a turma "ESS2018-1" cadastrada
    When eu seleciono a turma "ESS2018-1"
    And eu escolho enviar email para alunos com problemas na turma "ESS2018-1"
    Then eu vejo a lista dos alunos com problemas da turma "ESS2018-1" que receberam os emails

  Scenario: GUI Enviar link para Autoavaliação
    Given que eu estou na pagina de visualizar as turmas e tenho a turma "ESS2018-2" cadastrada
    When eu seleciono a turma "ESS2018-2"
    And eu escolho enviar email de autoavaliacao para alunos da turma "ESS2018-2"
    Then eu vejo a lista dos alunos da turma "ESS2018-2" que receberam os emails de autoavaliacao