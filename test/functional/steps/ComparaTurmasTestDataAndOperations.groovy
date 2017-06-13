package steps

import ta.Turma
import ta.Matricula

/**
 * Created by Guigo on 12/06/2017.
 */

import ta.TurmaController
import ta.AlunoController
import ta.MatriculaController

class ComparaTurmasTestDataAndOperations {

    static void createTurma(String nomeT) {
        def controller = new TurmaController()
        controller.params << [nome:nomeT]
        controller.create()
        controller.save()
        controller.response.reset()
    }

    static Turma getTurma(String nomeT) {
        def controller = new TurmaController()
        controller.params << [nome: nomeT]
        controller.create()
        controller.save()
        return controller.getTurma()
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
