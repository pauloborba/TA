package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EvaluationConceptController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EvaluationConcept.list(params), model:[evaluationConceptInstanceCount: EvaluationConcept.count()]
    }

    def show(EvaluationConcept evaluationConceptInstance) {
        respond evaluationConceptInstance
    }

    def create() {
        respond new EvaluationConcept(params)
    }

    @Transactional
    def save(EvaluationConcept evaluationConceptInstance) {
        if (evaluationConceptInstance == null) {
            notFound()
            return
        }

        if (evaluationConceptInstance.hasErrors()) {
            respond evaluationConceptInstance.errors, view:'create'
            return
        }

        evaluationConceptInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'evaluationConcept.label', default: 'EvaluationConcept'), evaluationConceptInstance.id])
                redirect evaluationConceptInstance
            }
            '*' { respond evaluationConceptInstance, [status: CREATED] }
        }
    }

    def edit(EvaluationConcept evaluationConceptInstance) {
        respond evaluationConceptInstance
    }

    @Transactional
    def update(EvaluationConcept evaluationConceptInstance) {
        if (evaluationConceptInstance == null) {
            notFound()
            return
        }

        if (evaluationConceptInstance.hasErrors()) {
            respond evaluationConceptInstance.errors, view:'edit'
            return
        }

        evaluationConceptInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EvaluationConcept.label', default: 'EvaluationConcept'), evaluationConceptInstance.id])
                redirect evaluationConceptInstance
            }
            '*'{ respond evaluationConceptInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EvaluationConcept evaluationConceptInstance) {

        if (evaluationConceptInstance == null) {
            notFound()
            return
        }

        evaluationConceptInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EvaluationConcept.label', default: 'EvaluationConcept'), evaluationConceptInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluationConcept.label', default: 'EvaluationConcept'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
