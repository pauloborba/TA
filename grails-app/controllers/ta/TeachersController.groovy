package ta

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TeachersController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(){
        params.max = Math.min(max ?: 10, 100)
        respond Teachers.list(params), model: [teacherInstanceCount: Teachers.count()]
    }

    def show(Teachers teacherInstance){
        respond theacherInstance
    }

    def create(){
        respond new Teachers(params)
    }

    def deleteTeacher(String cpf){
        Teachers teacher = Teachers.findByCpf(cpf)
        delete(teacher)
    }

    public Teachers createTeacher() {
        return new Teachers(params)
    }

    public boolean saveTeacher(Teachers teacher) {
        if (Teachers.findByName(teacher.name) == null) {
            teacher.save(flush: true)
            return true
        }
        return false
    }

    @Transactional
    def delete(Teachers teacherInstance) {

        if (teacherInstance == null) {
            notFound()
            return
        }

        teacherInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Teachers.label', default: 'Teacher'), teacherInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'teacher.label', default: 'Teacher'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

}