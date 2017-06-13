package ta

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
/**
 * Created by Avell on 13/06/2017.
 */

class ClassController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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

    @Transactional
    def createAndSaveClass() {
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
  }

        @Transactional
        def save(Class classInstance) {
            if (classInstance == null) {
                notFound()
                return
            }

            if (classInstance.hasErrors()) {
                respond classInstance.errors, view: 'create'
                return
            }

            classInstance.save flush: true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'class.label', default: 'Criterion'), classInstance.classID])
                    redirect classInstance
                }
                '*' { respond classInstance, [status: CREATED] }
            }
        }

        def edit(Class classInstance) {
            respond classInstance
        }

        @Transactional
        def update(Class classInstance) {
            if (classInstance == null) {
                notFound()
                return
            }

            if (classInstance.hasErrors()) {
                respond classInstance.errors, view: 'edit'
                return
            }

            classInstance.save flush: true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.updated.message', args: [message(code: 'Class.label', default: 'Class'), classInstance.classID])
                    redirect classInstance
                }
                '*' { respond classInstance, [status: OK] }
            }
        }

        @Transactional
        def delete(Class classInstance) {
            if (classInstance == null) {
                notFound()
                return
            }

            classInstance.delete flush: true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.deleted.message', args: [message(code: 'Class.label', default: 'Class'), classInstance.classID])
                    redirect action: "index", method: "GET"
                }
                '*' { render status: NOT_FOUND }
            }
        }

        protected void notFound() {
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.not.found.message', args: [message(code: 'class.label', default: 'Class'), params.classID])
                    redirect action: "index", method: "GET"
                }
                '*' { render status: NOT_FOUND }
            }
        }
        public Class get_Class() {
            def classInstance = new Class(params)
            return Class.findByClassIDAndPeriodo(classInstance.classID, classInstance.periodo)
        }

        public boolean onlyClass() {
            def classInstance = new Class(params)
            List t = Class.findAllByClassIDAndPeriodoLike(classInstance.classID, classInstance.periodo)
            if (t.size() > 1 || t.size() == 0) {
                return false
            }
            return true;
        }

    }