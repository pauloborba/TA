#Lavinia Paganini

  Feature: Situation Students
    As the teacher
    I want to see the situation of student
    So I can have a better control of students

    #Controle
    Scenario: Visualizar a nota do aluno
      Given o aluno "João Vasconcelos", com login "jvsn", possui conceitos "MA", "MPA" e "MA" em "RS"
      And o aluno "João Vasconcelos", possui media "8" em "RS"
      When eu solicito a situação do aluno "João Vasconcelos"
      Then a média de "João Vasconcelos" em "RS" continua sendo "8"

    #GUI
    Scenario: Visualizar media positiva dos alunos
      Given o aluno "João Vasconcelos", com login "jvsn", possui média "9" em "Requisitos de Sistemas"
      When eu solicito a página "SituationStudentPage"
      Then a média do aluno de login "jvsn" em "Requisitos de Sistemas" aparece verde e com uma seta para cima

   #GUI
    Scenario: Visualizar media negativa dos alunos
      Given o aluno "Ivan Cardoso", com login "isn", possui media "3" em "Requisitos de Sistemas"
      When eu solicito a página "Visualização"
      Then a média do aluno de login "isn" em "Requisitos de Sistemas" aparece vermelho e com uma seta para baixo
 ##

    #GUI
    #Scenario: Alunos repetentes na pagina de visualização
     # Given eu estou na página "Home"
      #And o aluno "Ivan Cardoso", com login "isn", possui uma nota cadastrada em "2015"
      #When eu vou para a página "Visualização"
      #Then o nome de "Ivan Cardoso", com login "isn", aparece em roxo
