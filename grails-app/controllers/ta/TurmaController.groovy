package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TurmaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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

    def edit(Turma turmaInstance) {
        respond turmaInstance
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


    //testes
    Turma getTurma() {
        def turmaInstance = new Turma(params)
        return Turma.findByClassIDAndPeriodo(turmaInstance.classID, turmaInstance.periodo)
    }

    @Transactional
    def createAndSaveTurma() {
        Turma turmaInstance = new Turma(params)
        if (Turma.findByClassIDAndPeriodo(turmaInstance.classID, turmaInstance.periodo) == null) {
            if (turmaInstance.hasErrors()) {
                respond turmaInstance.errors, view: 'create'
                return
            }
            if(!turmaInstance.save(flush: true)){
                render(view: "create", model: [turmaInstance: turmaInstance])
                return
            }
            flash.message = message(code: 'default.created.message', args: [message(code: 'turma.label', default: 'Turma'), turmaInstance.id])
            redirect(action: "show", id: turmaInstance.id)
        }
    }

    public boolean onlyTurma() {
        def turmaInstance = new Turma(params)
        List t = Turma.findAllByClassIDAndPeriodoLike(turmaInstance.classID, turmaInstance.periodo)
        if (t.size() > 1 || t.size() == 0){
            return false
        }
        return true;
    }
}
