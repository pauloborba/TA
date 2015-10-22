package ta

import commom.SheetBuilder
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

<<<<<<< HEAD
<<<<<<< HEAD
=======
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
=======
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
@Transactional(readOnly = true)
class ConceptController {
    SheetBuilder builder = new SheetBuilder()
    Sheet sheet;

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
<<<<<<< HEAD
<<<<<<< HEAD
        respond Concept.list(params), model: [conceptInstanceCount: Student.Concept.count()]
    }

    def show(Student.Concept conceptInstance) {
=======
=======
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
        respond Concept.list(params), model: [conceptInstanceCount: Concept.count()]
    }

    def show(Concept conceptInstance) {
<<<<<<< HEAD
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
=======
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
        respond conceptInstance
    }

    def create() {
<<<<<<< HEAD
<<<<<<< HEAD
        respond new Student.Concept(params)
    }

    @Transactional
    def save(Student.Concept conceptInstance) {
=======
=======
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
        respond new Concept(params)
    }

    @Transactional
    def save(Concept conceptInstance) {
<<<<<<< HEAD
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
=======
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
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

<<<<<<< HEAD
<<<<<<< HEAD
    def edit(Student.Concept conceptInstance) {
=======
    def edit(Concept conceptInstance) {
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
=======
    def edit(Concept conceptInstance) {
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
        respond conceptInstance
    }

    @Transactional
<<<<<<< HEAD
<<<<<<< HEAD
    def update(Student.Concept conceptInstance) {
=======
    def update(Concept conceptInstance) {
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
        if (conceptInstance == null) {
            notFound()
            return
        }
<<<<<<< HEAD

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

=======
    def update(Concept conceptInstance) {
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
        if (conceptInstance == null) {
            notFound()
            return
        }

<<<<<<< HEAD
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

=======

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

=======
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

>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
    @Transactional
    def delete(Concept conceptInstance) {

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
    def submit() {
        //sheet.validFileFormat();
        sheet = new Sheet()
        sheet.filename = params.datafile.getOriginalFilename()
        //System.out.println("PARAMS: " + params.datafile.getOriginalFilename())

        if (!sheet.validFileFormat()) {
            flash.message = "Invalid file format!"
        }
        render view: "upload"
    }

    def importSheet(Sheet sheet){
        this.sheet = sheet;
    }

    def invalidFileFormatMessage(){
//        flash.message = "Invalid file format!"
    }

<<<<<<< HEAD
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
=======
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
    def reset(){
        builder.removeSheet();
        this.sheet = null;
        return true;
    }
}


//def save(){
//    return this.sheet.save();
<<<<<<< HEAD
//}
=======
//}
>>>>>>> 6e87b84962abbf18b068e9aef5aa0b8ae9cb1c47
