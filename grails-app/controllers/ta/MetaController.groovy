package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MetaController {

    static allowedMethods = [update: "PUT"]//, delete: "DELETE"]
    // save: "POST" foi retirado porque dá problema com o cucumber, que
    // provavelmente simula a chamada dessa ação como um GET

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Meta.list(params), model:[metaInstanceCount: Meta.count()]
    }

    def show(Meta metaInstance) {
        respond metaInstance
    }

    def create() {
        respond new Meta(params)
    }

    @Transactional
    def save(Meta metaInstance) {
        if (metaInstance == null) {
            notFound()
            return
        }

        if (metaInstance.hasErrors()) {
            respond metaInstance.errors, view:'create'
            return
        }

        metaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'meta.label', default: 'Meta'), metaInstance.id])
                redirect metaInstance
            }
            '*' { respond metaInstance, [status: CREATED] }
        }
    }


    @Transactional
    def createAndSaveMeta() {
        Meta metaInstance = new Meta(params)
        if (metaInstance == null) {
            notFound()
            return
        }

        if (metaInstance.hasErrors()) {
            respond metaInstance.errors, view:'create'
            return
        }

        metaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'meta.label', default: 'Meta'), metaInstance.id])
                redirect metaInstance
            }
            '*' { respond metaInstance, [status: CREATED] }
        }
    }

    def edit(Meta metaInstance) {
        respond metaInstance
    }

    @Transactional
    def update(Meta metaInstance) {
        if (metaInstance == null) {
            notFound()
            return
        }

        if (metaInstance.hasErrors()) {
            respond metaInstance.errors, view:'edit'
            return
        }

        metaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Meta.label', default: 'Meta'), metaInstance.id])
                redirect metaInstance
            }
            '*'{ respond metaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Meta metaInstance) {

        if (metaInstance == null) {
            notFound()
            return
        }

        metaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Meta.label', default: 'Meta'), metaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'meta.label', default: 'Meta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    public static int count(){
        return Meta.all.size()
    }

    public Meta getMeta() {
        //def alunoInstance = new Aluno(params)
        return Meta.findByNome(params.nome)
    }
}
