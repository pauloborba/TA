package ta

/**
 * Created by wellington.felix on 6/9/17.
 */
class PlanilhaAlunos extends Planilha {
    List<Aluno> alunos

    PlanilhaAlunos(String url) {
        super(url)
        fillData()
    }

    void fillData() {
        1..<sizeLinha.each { i ->
            def linha = getLinha(i)
            def nome = linha.get(0)
            def logins = linha.get(1).split(" :: ")
            alunos = new Aluno(nome: nome, loginCin: logins[0], loginGitHub: logins[1], loginSlack: logins[2])
        }
    }
}
