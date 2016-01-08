package ta

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TeachersController {

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

}