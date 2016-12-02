package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RegisteredStudentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RegisteredStudent.list(params), model:[registeredStudentInstanceCount: RegisteredStudent.count()]
    }

    def show(RegisteredStudent registeredStudentInstance) {
        respond registeredStudentInstance
    }

    def create() {
        respond new RegisteredStudent(params)
    }

    @Transactional
    def save(RegisteredStudent registeredStudentInstance) {
        if (registeredStudentInstance == null) {
            notFound()
            return
        }

        if (registeredStudentInstance.hasErrors()) {
            respond registeredStudentInstance.errors, view:'create'
            return
        }

        registeredStudentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'registeredStudent.label', default: 'RegisteredStudent'), registeredStudentInstance.id])
                redirect registeredStudentInstance
            }
            '*' { respond registeredStudentInstance, [status: CREATED] }
        }
    }

    def edit(RegisteredStudent registeredStudentInstance) {
        respond registeredStudentInstance
    }

    @Transactional
    def update(RegisteredStudent registeredStudentInstance) {
        if (registeredStudentInstance == null) {
            notFound()
            return
        }

        if (registeredStudentInstance.hasErrors()) {
            respond registeredStudentInstance.errors, view:'edit'
            return
        }

        registeredStudentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RegisteredStudent.label', default: 'RegisteredStudent'), registeredStudentInstance.id])
                redirect registeredStudentInstance
            }
            '*'{ respond registeredStudentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RegisteredStudent registeredStudentInstance) {

        if (registeredStudentInstance == null) {
            notFound()
            return
        }

        registeredStudentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RegisteredStudent.label', default: 'RegisteredStudent'), registeredStudentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'registeredStudent.label', default: 'RegisteredStudent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
