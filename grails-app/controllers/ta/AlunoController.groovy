package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AlunoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Aluno.list(params), model:[alunoInstanceCount: Aluno.count()]
    }

    def show(Aluno alunoInstance) {
        respond alunoInstance
    }

    def create() {
        respond new Aluno(params)
    }

    @Transactional
    def save(Aluno alunoInstance) {
        if (alunoInstance == null) {
            notFound()
            return
        }

        if (alunoInstance.hasErrors()) {
            respond alunoInstance.errors, view:'create'
            return
        }

        alunoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aluno.label', default: 'Aluno'), alunoInstance.id])
                redirect alunoInstance
            }
            '*' { respond alunoInstance, [status: CREATED] }
        }
    }

    def edit(Aluno alunoInstance) {
        respond alunoInstance
    }

    @Transactional
    def update(Aluno alunoInstance) {
        if (alunoInstance == null) {
            notFound()
            return
        }

        if (alunoInstance.hasErrors()) {
            respond alunoInstance.errors, view:'edit'
            return
        }

        alunoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Aluno.label', default: 'Aluno'), alunoInstance.id])
                redirect alunoInstance
            }
            '*'{ respond alunoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Aluno alunoInstance) {

        if (alunoInstance == null) {
            notFound()
            return
        }

        alunoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Aluno.label', default: 'Aluno'), alunoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aluno.label', default: 'Aluno'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def upload() {
        
    }
}
