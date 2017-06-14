Feature: Clonar Metas de Outras Turmas
  As a professor
  I want to be able to copy Metas from another Turma registered in the system
  So I can reuse


  # "A RECEBE B" significa recebimento de dados B na acao A via HTTP
  @ignore
  Scenario: clonar Metas de outra Turma
    Given Existe uma turma "if777" registrada com as metas "Entender Java, Entender JQuery, Entender o que é MPA, Entender o que é JVM"
    When acao TurmaController:appendMetas recebe metas "Entender Groovy, Entender Grails" para essa turma
    Then turma deve possuir 6 metas

  @ignore
  Scenario: clonar nenhuma Meta de outra Turma
    Given Existe uma turma "if777" registrada com as metas "Entender Java, Entender JQuery, Entender o que é MPA, Entender o que é JVM"
    When acao TurmaController:appendMetas recebe metas "" para essa turma
    Then turma deve possuir 4 metas

  @ignore
  Scenario: clonar Metas já existentes
    Given Existe uma turma "if777" registrada com as metas "Entender Java, Entender JQuery, Entender o que é MPA, Entender o que é JVM"
    When acao TurmaController:appendMetas recebe metas "Entender Java, Entender JQuery, Entender o que é MANA" para essa turma
    Then turma deve possuir 5 metas