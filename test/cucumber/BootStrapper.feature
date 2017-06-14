Feature: Povoar e Limpar banco de dados
  As um desenvolvedor
  I want to poder povoar e limpar o banco de dados a cada teste
  So Os testes sejam independentes


  # "A RECEBE B" significa recebimento de dados B na acao A via HTTP
@ignore
  Scenario: Gerar BD via bootstrapper
    Given gerar bd via bootstrapper
    When executo
    Then Deve-se encontrar 7 metas, 2 turmas e 5 estudantes

