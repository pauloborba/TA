package steps

import ta.Aluno;
import ta.AlunoController;

/**
 * Created by rrms on 13/06/2017.
 */
class AlunoTestDataAndOperations {
    public static void criarAluno(String nomeAluno){
        def alunoController = new AlunoController()
        alunoController.params << [nome: nomeAluno]
        alunoController.createAndSaveAluno()
        alunoController.response.reset()
    }

    public static Aluno getAluno(String nomeAluno) {
        def controller = new AlunoController()
        controller.params << [nome: nomeAluno]
        return controller.getAluno()
    }

    public static boolean compatibleTo(String nome, Aluno aluno) {
        if (nome == aluno.nome ) return true
        return false
    }

    public static boolean onlyAluno(String nome, String period){
        def alunoController = new AlunoController()
        alunoController.params << [nome: nome]
        return alunoController.onlyAluno()
    }

    public static int countAluno(){
        def alunoController = new AlunoController()
        return alunoController.onlyAluno()
    }
}
