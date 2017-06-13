package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AvaliacaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Avaliacao.list(params), model:[avaliacaoInstanceCount: Avaliacao.count()]
    }

    def show(Avaliacao avaliacaoInstance) {
        respond avaliacaoInstance
    }

    def create() {
        respond new Avaliacao(params)
    }

    @Transactional
    def save(Avaliacao avaliacaoInstance) {
        if (avaliacaoInstance == null) {
            notFound()
            return
        }

        if (avaliacaoInstance.hasErrors()) {
            respond avaliacaoInstance.errors, view:'create'
            return
        }

        avaliacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'avaliacao.label', default: 'Avaliacao'), avaliacaoInstance.id])
                redirect avaliacaoInstance
            }
            '*' { respond avaliacaoInstance, [status: CREATED] }
        }
    }

    @Transactional
    def createAndSaveAvaliacao() {
        Avaliacao avaliacaoInstance = new Avaliacao(params)
        if (avaliacaoInstance.hasErrors()) {
            respond avaliacaoInstance.errors, view: 'create'
            return
        }
        if(!avaliacaoInstance.save(flush: true)){
            render(view: "create", model: [classInstance: avaliacaoInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'avaliacao.label', default: 'Class'), avaliacaoInstance.nome])
        redirect(action: "show", id: avaliacaoInstance.nome)
    }

    def edit(Avaliacao avaliacaoInstance) {
        respond avaliacaoInstance
    }

    @Transactional
    def update(Avaliacao avaliacaoInstance) {
        if (avaliacaoInstance == null) {
            notFound()
            return
        }

        if (avaliacaoInstance.hasErrors()) {
            respond avaliacaoInstance.errors, view:'edit'
            return
        }

        avaliacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Avaliacao.label', default: 'Avaliacao'), avaliacaoInstance.id])
                redirect avaliacaoInstance
            }
            '*'{ respond avaliacaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Avaliacao avaliacaoInstance) {

        if (avaliacaoInstance == null) {
            notFound()
            return
        }

        avaliacaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Avaliacao.label', default: 'Avaliacao'), avaliacaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'avaliacao.label', default: 'Avaliacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    public Avaliacao getAvaliacao() {
        def avaliacaoInstance = new Avaliacao(params)
        return Avaliacao.findByNomeAndMatricula(avaliacaoInstance.nome,avaliacaoInstance.matricula)
    }

    public int count(){
        return Avaliacao.all.size()
    }
}

