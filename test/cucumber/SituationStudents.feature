#Lavinia Paganini

  Feature: Situation Students
    As the teacher
    I want to see the situation of student
    So I can have a better control of students

    #Controle
    Scenario: Visualizar a nota do aluno
      Given o aluno “João Vasconcelos”, com login "jvsn", possui conceitos “MA”, “MPA” e “MA” em “Requisitos de sistemas”
      And o aluno "João Vasconcelos", com login "jvsn", possui media “MA” em “Requisitos de Sistemas”
      When eu solicito a visualização da situação do aluno "João Vasconcelos" com login "jvsn"
      Then a média de “João Vasconcelos”, com login "jvsn", em “Requisitos de Sistema” continua sendo “MA”


    #GUI
    Scenario: Visualizar media positiva dos alunos
      Given eu estou na página "Home"
      And o aluno "João Vasconcelos", com login "jvsn", possui media "MA" em "Requisitos de Sistemas"
      When eu solicito a página "Visualização"
      Then a média do aluno "João Vasconcelos", com login "jvsn", em "Requisitos de Sistemas" aparece verde e com uma seta para cima


    #GUI
    Scenario: Visualizar media negativa dos alunos
      Given eu estou na página "Home"
      And o aluno "Ivan Cardoso", com login "isn", possui media "MANA" em "Requisitos de Sistemas"
      When eu solicito a página "Visualização"
      Then a média do aluno "Ivan Cardoso", com login "isn", em "Requisitos de Sistemas" aparece vermelho e com uma seta para baixo

    #GUI
    Scenario: Alunos repetentes na pagina de visualização
      Given eu estou na página "Home"
      And o aluno "Ivan Cardoso", com login "isn", possui uma nota cadastrada em "2015"
      When eu vou para a página "Visualização"
      Then o nome de "Ivan Cardoso", com login "isn", aparece em roxo