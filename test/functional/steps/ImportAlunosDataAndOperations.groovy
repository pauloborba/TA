package steps

import org.springframework.web.multipart.MultipartFile
import ta.AlunoController
import ta.Matricula
import ta.MatriculaController
import ta.PlanilhaAlunos
import ta.PlanilhaFactory
import ta.Turma
import ta.TurmaController

/**
 * Created by wellington.felix on 6/12/17.
 */
class ImportAlunosDataAndOperations {
    static AlunoController alunoCtrl = new AlunoController()
    static TurmaController turmaCtrl = new TurmaController()
    static String path = "C:\\Users\\wfeli\\IdeaProjects\\TA\\test\\resources\\alunos.xls"
    static Turma turma
    static PlanilhaAlunos planilha

    /**
     * Asserts file exists in given path
     * @param path
     */
    static void assertFileExists(String file) {
        //print("FULL_PATH: " + new File().getAbsoluteFile())
        assert new File(path).exists()
    }

    /**
     * Asserts cinUsername is in spreadsheet
     * @param fileName
     * @param cinUsername
     */
    static void assertStudentIsInSpreadsheet(String fileName, String cinUsername) {
        planilha = PlanilhaFactory.getPlanilha(path, 'addaluno')
        def aluno = planilha.alunos.find {
            (it.loginCin == cinUsername)
        }
        assert aluno
    }

    /**
     * Creates class for which all students will be registered
     * @param className
     */
    static void createAndSaveClass(String className) {
        turmaCtrl = new TurmaController()
        turmaCtrl.params.nome = className
        Turma ess = turmaCtrl.create()
        assert ess.nome == "ESS 2016-2"
        turmaCtrl.save(ess)
    }

    /**
     * Uploads spreadsheet to server and register all students to a class
     * @param path
     * @param className
     */
    static void uploadSpreadsheet(String file, String className) {
        turma = Turma.findByNome(className)
        alunoCtrl.request.addFile(new File('sheet') as MultipartFile)
        alunoCtrl.params.file = path
        alunoCtrl.params.turma = turma
        alunoCtrl.upload()
    }

    /**
     * Checks whether the students is now added to the system
     * @param cinUsername
     * @param className
     */
    static void assertStudentsImported(String name, String className) {
        assert Matricula.findByAlunoAndTurma(name, className)
    }

}
