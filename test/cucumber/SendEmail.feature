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
    When eu solicitar o envio de email para alunos com problemas
    Then será enviado um email para os alunos "Robson" e "Leonardo", apenas
