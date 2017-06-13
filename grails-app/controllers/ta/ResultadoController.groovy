package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ResultadoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Resultado.list(params), model:[resultadoInstanceCount: Resultado.count()]
    }

    def show(Resultado resultadoInstance) {
        respond resultadoInstance
    }

    def create() {
        respond new Resultado(params)
    }

    @Transactional
    def save(Resultado resultadoInstance) {
        if (resultadoInstance == null) {
            notFound()
            return
        }

        if (resultadoInstance.hasErrors()) {
            respond resultadoInstance.errors, view:'create'
            return
        }

        resultadoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'resultado.label', default: 'Resultado'), resultadoInstance.id])
                redirect resultadoInstance
            }
            '*' { respond resultadoInstance, [status: CREATED] }
        }
    }


    @Transactional
    def createAndSaveResultado() {
        Resultado resultadoInstance = new Resultado(params)
        if (resultadoInstance == null) {
            notFound()
            return
        }

        if (resultadoInstance.hasErrors()) {
            respond resultadoInstance.errors, view:'create'
            return
        }

        resultadoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'resultado.label', default: 'Resultado'), resultadoInstance.id])
                redirect resultadoInstance
            }
            '*' { respond resultadoInstance, [status: CREATED] }
        }
    }

    def edit(Resultado resultadoInstance) {
        respond resultadoInstance
    }

    @Transactional
    def update(Resultado resultadoInstance) {
        if (resultadoInstance == null) {
            notFound()
            return
        }

        if (resultadoInstance.hasErrors()) {
            respond resultadoInstance.errors, view:'edit'
            return
        }

        resultadoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Resultado.label', default: 'Resultado'), resultadoInstance.id])
                redirect resultadoInstance
            }
            '*'{ respond resultadoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Resultado resultadoInstance) {

        if (resultadoInstance == null) {
            notFound()
            return
        }

        resultadoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Resultado.label', default: 'Resultado'), resultadoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultado.label', default: 'Resultado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    public static boolean onlyResultado(String nome){
        def resultadoController = new ResultadoController()
        resultadoController.params << [nome: nome]
        return resultadoController.onlyResultado()
    }

    public static int count(){
        return Resultado.all.size()
    }

    public Resultado getResultado() {
        def resultadoInstance = new Resultado(params)
        return Resultado.findByMetaAndAvaliacao(resultadoInstance.meta,resultadoInstance.avaliacao)
    }
}
