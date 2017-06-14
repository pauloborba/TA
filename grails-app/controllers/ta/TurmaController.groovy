package ta

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TurmaController {

    static allowedMethods = [update: "PUT"]//, delete: "DELETE"]
    // save: "POST" foi retirado porque dá problema com o cucumber, que
    // provavelmente simula a chamada dessa ação como um GET

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Turma.list(params), model:[turmaInstanceCount: Turma.count()]
    }

    def show(Turma turmaInstance) {
        respond turmaInstance
    }

    def create() {
        respond new Turma(params)
    }

    @Transactional
    def save(Turma turmaInstance) {
        if (turmaInstance == null) {
            notFound()
            return
        }

        if (turmaInstance.hasErrors()) {
            respond turmaInstance.errors, view:'create'
            return
        }

        turmaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'turma.label', default: 'Turma'), turmaInstance.id])
                redirect turmaInstance
            }
            '*' { respond turmaInstance, [status: CREATED] }
        }
    }

    @Transactional
    def createAndSaveTurma() {
        Turma turmaInstance = new Turma(params)
        if (turmaInstance == null) {
            notFound()
            return
        }

        if (turmaInstance.hasErrors()) {
            respond turmaInstance.errors, view:'create'
            return
        }

        turmaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'turma.label', default: 'Turma'), turmaInstance.id])
                redirect turmaInstance
            }
            '*' { respond turmaInstance, [status: CREATED] }
        }
    }

    def edit(Turma turmaInstance) {
        respond turmaInstance
    }

    def enviarEmailAlunosComProblemas(){
        respond model:[alunos: EnviarEmailController.enviarAlunosComProblemas("")]
    }

    def enviarEmailAutoAvaliacao(){
        respond model:[alunos: EnviarEmailController.enviarAutoavaliacao("")]
    }


    @Transactional
    def update(Turma turmaInstance) {
        if (turmaInstance == null) {
            notFound()
            return
        }

        if (turmaInstance.hasErrors()) {
            respond turmaInstance.errors, view:'edit'
            return
        }

        turmaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Turma.label', default: 'Turma'), turmaInstance.id])
                redirect turmaInstance
            }
            '*'{ respond turmaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Turma turmaInstance) {

        if (turmaInstance == null) {
            notFound()
            return
        }

        turmaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Turma.label', default: 'Turma'), turmaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'turma.label', default: 'Turma'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    public Turma getTurma() {
        //def alunoInstance = new Aluno(params)
        return Turma.findByNome(params.nome)
    }

    public void matricular(Turma turma, Matricula matricula) {
        Turma turmaAux = Turma.findById(turma.id)
        turmaAux.matriculas.add(matricula)
        turmaAux.save()
    }
}
