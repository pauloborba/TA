package ta

/**
 * Created by wellington.felix on 6/9/17.
 */
class PlanilhaAlunos extends Planilha {
    List<Aluno> alunos

    PlanilhaAlunos(String url) {
        super(url)
        alunos = []
        fillData()
    }

    void fillData() {
        (1..<sizeLinha).each { i ->
            def linha = getLinha(i)
            def nome = linha.get(0)
            def cin = linha.get(1)
            def github = linha.get(2)
            def slack = linha.get(3)
            def aluno = new Aluno(nome: nome, loginCin: cin, loginGitHub: github, loginSlack: slack)
            if(aluno)
                alunos.add(aluno)
        }
    }
}
