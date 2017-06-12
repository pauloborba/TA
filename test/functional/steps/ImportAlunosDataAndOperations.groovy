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
    static String path = AlunoController.servletContext.getRealPath('/')
    static AlunoController alunoCtrl = AlunoController
    static TurmaController turmaCtrl = TurmaController
    static Turma turma
    static PlanilhaAlunos planilha

    /**
     * Asserts file exists in given path
     * @param path
     */
    static void assertFileExists(String file) {
        assert new File(path, file).exists()
    }

    /**
     * Asserts cinUsername is in spreadsheet
     * @param fileName
     * @param cinUsername
     */
    static void assertStudentIsInSpreadsheet(String fileName, String cinUsername) {
        planilha = PlanilhaFactory.getPlanilha(path: fileName, tipoPlanilha:'addaluno')
        def aluno = planilha.alunos.find {
            it.loginCin.equals(cinUsername)
        }
        assert !aluno
    }

    /**
     * Creates class for which all students will be registered
     * @param className
     */
    static void createAndSaveClass(String className) {
        turmaCtrl = new TurmaController()
        turmaCtrl.params.turma.nome = className
        Turma ess = turmaCtrl.create()
        turmaCtrl.save(ess)
    }

    /**
     * Uploads spreadsheet to server and register all students to a class
     * @param path
     * @param className
     */
    static void uploadSpreadsheet(String path, String className) {
        turma = Turma.findByNome(className)
        alunoCtrl.request.addFile(new File(path) as MultipartFile)
        alunoCtrl.params.turma.id = turma.id
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
