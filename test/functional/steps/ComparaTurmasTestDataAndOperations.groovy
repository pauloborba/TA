package steps

import ta.Turma
import ta.Aluno
import ta.Matricula

/**
 * Created by Guigo on 12/06/2017.
 */

import ta.TurmaController
import ta.AlunoController
import ta.MatriculaController

class ComparaTurmasTestDataAndOperations {

    // CREATE AND GET TURMA

    static void createTurma(String nomeT) {
        def controller = new TurmaController()
        controller.params << [nome:nomeT]
        controller.create()
        controller.createAndSave()
        controller.response.reset()
    }

    static Turma getTurma(String nomeT) {
        def controller = new TurmaController()
        controller.params << [nome: nomeT]
        return controller.getTurma()
    }

    // CREATE AND GET ALUNO

    static void createAluno(String nomeA) {
        def controller = new AlunoController()
        controller.params << [nome:nomeA]
        controller.create()
        controller.createAndSave()
        controller.response.reset()
    }

    static Aluno getAluno(String nomeT) {
        def controller = new AlunoController()
        controller.params << [nome: nomeT]
        return controller.getAluno()
    }

    // CREATE AND GET MATRICULA

    /*static void createMatricula(String id) {
        def controller = new TurmaController()
        controller.params << [id:id]
        controller.create()
        controller.createAndSave()
        controller.response.reset()
    }

    static Matricula getMatricula(String id) {
        def controller = new MatriculaController()
        controller.params << [id: id]
        return controller.getMatricula()
    }*/

    // INSERE MATRICULA EM TURMA

    static void insereEmTurma(String nomeA, nomeT){
        Aluno a = getAluno(nomeA)
        Turma t = getTurma(nomeT)
        t.inserir(a)
    }

    // CALCULA MEDIA DE TURMA

    public void calculaMedia(String nome){
        Turma tm = getTurma(nome)
        print(tm.id)
    }

}

    /*public static boolean checkAluno(String nomeT, String nomeA){
        def controllerT = new TurmaController()
        def controllerA = new AlunoController()
        def controllerM = new MatriculaController()
        controllerA.params << [nome: nomeA]
        controllerM.params << [aluno:controllerA]
        controllerT.params << [nome: nomeT, matriculas:[controllerM]]
        Turma t = controllerT.getTurma()
        Matricula m = controllerM.getMatricula()
        return controllerT.checkAluno(t, m)
    }

    public static String checkMedia(String nome){
        def controllerA = new AlunoController()
        def controllerM = new MatriculaController()
        controllerA.params << [nome: nome]
        controllerM.params << [aluno:controllerA]
        Matricula m = controllerM.getMatricula()
        return m.aprovacao
    }

    public void calculaMedia(String nome){
        def controllerA1 = new AlunoController()
        def controllerM1 = new MatriculaController()
        def controllerA2 = new AlunoController()
        def controllerM2 = new MatriculaController()
        def controllerA3 = new AlunoController()
        def controllerM3 = new MatriculaController()
        controllerA1.params << [nome: "Jeff"]
        controllerM1.params << [aluno:controllerA1, media: 10]
        controllerA2.params << [nome: "Fred"]
        controllerM2.params << [aluno:controllerA2, media: 6]
        controllerA3.params << [nome: "Bill"]
        controllerM3.params << [aluno:controllerA3, media: 8]
        def controllerT = new TurmaController()
        controllerT.params << [nome: nome, matriculas: [controllerM1, controllerM2, controllerM3]]
        controllerT.calcularMedia()
    }

    public void comparaMedia(){

    }

    public static void calcularMedia(){

    }

    public static void contAM(){

    }
}*/
