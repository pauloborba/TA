package ta

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

class ClassController {

    def index(Integer max) {
        params.max = Math.min(max ?: 100, 100)
        respond Class.list(params), model:[classInstanceCount: Class.count()]
    }

    def create() {
        respond new Class(params)
    }

    def show(Class classInstance) {
        respond classInstance
    }

    public List<Class> getClassList() {
        return Class.list()
    }

    public Class get_Class() {
        def classInstance = new Class(params)
        return Class.findByClassIDAndPeriodo(classInstance.classID, classInstance.periodo)
    }

    /*def createAndSaveClass() {
        Class classInstance = new Class(params)
        if (Class.findByClassIDAndPeriodo(classInstance.classID, classInstance.periodo) == null) {
            if (classInstance.hasErrors()) {
                respond classInstance.errors, view: 'create'
                return
            }
            if(!classInstance.save(flush: true)){
                render(view: "create", model: [classInstance: classInstance])
                return
            }
            flash.message = message(code: 'default.created.message', args: [message(code: 'class.label', default: 'Class'), classInstance.classID])
            redirect(action: "show", id: classInstance.classID)
        }
    }*/

    @Transactional
    def save(Criterion classInstance) {
        if (classInstance == null) {
            notFound()
            return
        }

        if (classInstance.hasErrors()) {
            respond classInstance.errors, view:'create'
            return
        }

        classInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'class.label', default: 'Criterion'), classInstance.classID])
                redirect classInstance
            }
            '*' { respond classInstance, [status: CREATED] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'class.label', default: 'Class'), params.classID])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
