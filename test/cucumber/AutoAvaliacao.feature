Feature: Obter Autoavaliação do aluno
  As        um estudante
  I want to registrar minha auto avaliação para todas as Metas da Turma
  So        Eu possa entregar minha opinião sobre o quanto acredito que aprendi em cada tópico


  # "A RECEBE B" significa recebimento de dados B na acao A via HTTP

  Scenario: auto avaliacao com copia
    Given Existe uma turma "if666" registrada AND Nesta turma estão registradas as metas "Entender Groovy, Entender Grails, Entender o que é MANA" AND estudante "Pedro Torchio" esta matriculado com o login "pt" na turma
    When acao AutoAvaliacaoController:concluir recebe notas "MA, MPA, MA", referentes as metas da turma AND "com" copia para aluno
    Then Servidor de email deve possuir 2 emails na fila de envio

  Scenario: auto avaliacao sem copia
    Given Existe uma turma "if777" registrada AND Nesta turma estão registradas as metas "Entender Java, Entender JQuery, Entender o que é MPA, Entender o que é JVM" AND estudante "Pedro Torchio" esta matriculado com o login "pt" na turma
    When acao AutoAvaliacaoController:concluir recebe notas "MA, MPA, --, --", referentes as metas da turma AND "sem" copia para aluno
    Then Servidor de email deve possuir 1 emails na fila de envio

  Scenario: auto avaliacao com copia
    Given Existe uma turma "if666" registrada AND Nesta turma estão registradas as metas "Entender Groovy, Entender Grails, Entender o que é MANA" AND estudante "Pedro Torchio" esta matriculado com o login "pt" na turma
    When acao AutoAvaliacaoController:concluir recebe notas "MA, MPA, MA", referentes as metas da turma AND "com" copia para aluno
    Then Servidor de email deve possuir 2 emails na fila de envio


    # -- GUI --

  @ignore
  Scenario: Abrir auto avaliacao
    Given Existe uma turma "if777" registrada AND Nesta turma estão registradas as metas "Entender Java, Entender JQuery, Entender o que é MPA, Entender o que é JVM" AND Eu, o estudante "Pedro Torchio", estou matriculado com o login "pt" na turma
    When Entro na pagina de auto avaliacao
    Then Eu vejo um select de nota para cada meta
  @ignore
  Scenario: Submeter auto avaliacao
    Given Existe uma turma "if777" registrada AND Nesta turma estão registradas as metas "Entender Java, Entender JQuery, Entender o que é MPA, Entender o que é JVM" AND Eu, o estudante "Pedro Torchio", estou matriculado com o login "pt" na turma AND estou na pagina de auto avaliaco
    When  Altero as notas de "Entender JQuery, Entender o que é MPA" para "MA, MPA" AND submeto formulario
    Then  Vejo pagina de confirmacao

