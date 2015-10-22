package ta

import commom.SheetBuilder
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConceptController {
    SheetBuilder builder = new SheetBuilder()
    Sheet sheet;

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Concept.list(params), model: [conceptInstanceCount: Student.Concept.count()]
    }

    def show(Student.Concept conceptInstance) {
        respond conceptInstance
    }

    def create() {
        respond new Student.Concept(params)
    }

    @Transactional
    def save(Student.Concept conceptInstance) {
        if (conceptInstance == null) {
            notFound()
            return
        }

        if (conceptInstance.hasErrors()) {
            respond conceptInstance.errors, view: 'create'
            return
        }

        conceptInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'concept.label', default: 'Concept'), conceptInstance.id])
                redirect conceptInstance
            }
            '*' { respond conceptInstance, [status: CREATED] }
        }
    }

    def edit(Student.Concept conceptInstance) {
        respond conceptInstance
    }

    @Transactional
    def update(Student.Concept conceptInstance) {
        if (conceptInstance == null) {
            notFound()
            return
        }

        if (conceptInstance.hasErrors()) {
            respond conceptInstance.errors, view: 'edit'
            return
        }

        conceptInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Concept.label', default: 'Concept'), conceptInstance.id])
                redirect conceptInstance
            }
            '*' { respond conceptInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Student.Concept conceptInstance) {

        if (conceptInstance == null) {
            notFound()
            return
        }

        conceptInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Concept.label', default: 'Concept'), conceptInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'concept.label', default: 'Concept'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def upload(){

    }

    def importSheet(Sheet sheet){
        this.sheet = sheet;
    }

    def reset(){
        builder.removeSheet();
        this.sheet = null;
        return true;
    }
}
