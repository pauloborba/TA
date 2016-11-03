#Lavinia Paganini

  Feature: Situation Students
    As the teacher
    I want to see the situation of student
    So I can have a better control of students

    #Controle
    Scenario: Visualizar a nota do aluno
      Given o aluno “João Vasconcelos” possui conceitos “MA”, “MPA” e “MA” em “Requisitos de sistemas”
      And o aluno "João Vasconcelos" possui média “MA” em “Requisitos de Sistemas”
      When eu solicito a visualização da situação do aluno "João Vasconcelos"
      Then a média de “João Vasconcelos” em “Requisitos de Sistema” continua sendo “MA”


    #GUI
    Scenario: Visualizar média positiva dos alunos
      Given eu estou na página "Home"
      And o aluno "João Vasconcelos" possui média "MA" em "Requisitos de Sistemas"
      When eu solicito a página "Visualização"
      Then a média do aluno "João Vasconcelos" em "Requisitos de Sistemas" aparece verde e com uma seta para cima


    #GUI
    Scenario: Visualizar média negativa dos alunos
      Given eu estou na página "Home"
      And o aluno "Ivan Cardoso" possui média "MANA" em "Requisitos de Sistemas"
      When eu solicito a página "Visualização"
      Then a média do aluno "Ivan Cardoso" em "Requisitos de Sistemas" aparece vermelho e com uma seta para baixo

    #GUI
    Scenario: Alunos repetentes na página de visualização
      Given eu estou na página "Home"
      And o aluno "Ivan Cardoso" possui uma nota cadastrada em "2015"
      When eu vou para a página "Visualização"
      Then o nome de "Ivan Cardoso" aparece em roxo