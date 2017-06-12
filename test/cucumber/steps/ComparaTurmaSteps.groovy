import javafx.beans.binding.When
import org.spockframework.compiler.model.ThenBlock

/*Cenário Controller
Scenario: Quantidade de turmas superadas

Given eu tenho uma turma "2017.1" cadastrada
And o aluno "Pedro" esta matriculado em "2017.1"
And "Pedro" possui media final
And o aluno "Douglas" esta matriculado em "2017.1"
And "Douglas" possui media final
And o aluno "Jeff" esta matriculado em "2017.1"
And "Jeff" possui media final

And eu tenho uma turma "2016.2"
And o aluno "Pedro" esta matriculado em "2016.2"
And "Pedro" possui media final
And o aluno "Dante" esta matriculado em "2016.2"
And "Dante" possui media final
And o aluno "Vergil" esta matriculado em "2016.2"
And "Vergil" possui media final

And eu tenho uma turma "2016.1"
And o aluno "Bill" esta matriculado em "2016.1"
And "Bill" possui media final
And o aluno "Lucio" esta matriculado em "2016.1"
And "Lucio" possui media final
And o aluno "Lucio" esta matriculado em "2016.1"
And "Lucio" possui media final
And o aluno "Lloyd" esta matriculado em "2016.1"
And "Lloyd" possui media final

When eu seleciono a turma "2017.1"

Then o numero de turmas que possuem media geral, numero percentual de alunos aprovados e numeros percentual
de alunos aprovados por media inferior a "2017.1" e calculado*/

/*
2017.1
 */

Given(~'^eu tenho uma turma "[(^")*]" cadastrada$'){
        String nome ->
    }
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}

/*
2016.2
 */

And(~'^eu tenho uma turma "[(^")*]" cadastrada$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}

/*2016.1*/

And(~'^eu tenho uma turma "[(^")*]" cadastrada$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]"possui media final$'){
    String nome ->
}
And(~'^o aluno "[(^")*]" esta matriculado em "[(^")*]"$'){
    String nome, String nomeA  ->
}
And(~'^"[(^")*]" possui media final$'){
    String nome ->
}


/*
When
 */


When(~'^eu seleciono a turma "[(^")*]"$'){
        String nome ->
    }
Then(~'^o numero de turmas que possuem media geral, numero percentual de alunos aprovados e numeros percentual\n' +
        'de alunos aprovados por media inferior a "[(^")*]" e calculado$'){
        String nome ->
    }

/*ta.Matricula.aluno.nome nome

 */

/*#Cenário GUI
Scenario: Exibir comparacao
Given eu estou na pagina de "Turmas List"
And eu tenho a turma "2017.1"
And eu tenho a turma "2016.2"
And eu tenho a turma "2016.1"
When eu seleciono a turma "2017.1" para ver os alunos
Then eu consigo ver o numero de turmas que "2017.1" supera em questão de media geral, numero percentual de alunos
aprovados e numeros percentual de alunos aprovados por media em comparacao com o total de turmas cadastradas*/



Given(~'^eu estou na pagina de "[(^")*]"$'){
    String page ->
}
And(~'^eu tenho a turma "[(^")*]"$'){
    String nome ->
}
And(~'^eu tenho a turma "[(^")*]"$'){
    String nome ->
}
And(~'^eu tenho a turma "[(^")*]"$'){
    String nome ->
}
When(~'^eu seleciono a turma "[(^")*]" para ver os alunos$' ){
    String nome ->
}
Then(~'^eu consigo ver o numero de turmas que "[(^")*]" supera em questão de media geral, numero percentual de alunos\n' +
        'aprovados e numeros percentual de alunos aprovados por media em comparacao com o total de turmas cadastradas$'){
    String nome ->
}