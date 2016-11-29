package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConceptController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Concept.list(params), model:[conceptInstanceCount: Concept.count()]
    }

    def show(Concept conceptInstance) {
        respond conceptInstance
    }

    def create() {
        respond new Concept(params)
    }

    @Transactional
    def save(Concept conceptInstance) {
        if (conceptInstance == null) {
            notFound()
            return
        }

        if (conceptInstance.hasErrors()) {
            respond conceptInstance.errors, view:'create'
            return
        }

        conceptInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'Concept.label', default: 'Concept'), conceptInstance.id])
                redirect conceptInstance
            }
            '*' { respond conceptInstance, [status: CREATED] }
        }
    }

    def edit(Concept conceptInstance) {
        respond conceptInstance
    }

    @Transactional
    def update(Concept conceptInstance) {
        if (conceptInstance == null) {
            notFound()
            return
        }

        if (conceptInstance.hasErrors()) {
            respond conceptInstance.errors, view:'edit'
            return
        }

        conceptInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Concept.label', default: 'Concept'), conceptInstance.id])
                redirect conceptInstance
            }
            '*'{ respond conceptInstance, [status: OK] }
        }
    }

    @Transactional
    def createAndSaveConcept(){
        Concept instanceConcept = new Concept(params)
        if(Concept.findByNome(instanceConcept.getNome()) == null){
            if(instanceConcept.hasErrors()){
                respond instanceConcept.errors, view: "create"
                return
            }
            if(!instanceConcept.save(flush: true)){
                render(view: "create", model: [instanceConcept: instanceConcept])
                return
            }
            flash.message = message(code: 'default.created.message', args: [message(code: 'Concept.label', default: 'Concept'), instanceConcept.id])
            redirect(action: "show", id: instanceConcept.id)
        }
    }

    @Transactional
    def delete(Concept conceptInstance) {

        if (conceptInstance == null) {
            notFound()
            return
        }

        if(EvaluationConcept.count){
            EvaluationConcept atual = EvaluationConcept.first();
            if(atual.conceitos.contains(conceptInstance)){
                flash.message = message(code: 'linkedConcept.message', args:[atual.getNome()])
                redirect (controller: "EvaluationConcept", action: "index")
                return
            }
        }

        conceptInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Concept.label', default: 'Concept'), conceptInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'Concept.label', default: 'Concept'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
