package ta


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DisciplineController {


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Discipline.list(params), model:[DisciplineInstanceCount: Discipline.count()]
    }

    def show(Discipline DisciplineInstance) {
        respond DisciplineInstance
    }

    def edit(Discipline DisciplineInstance) {
        respond DisciplineInstance
    }

    def create() {
        respond new Discipline(params)
    }

    public Discipline createDiscipline() {
        return new Discipline(params)
    }

    public boolean saveDiscipline(Discipline discipline) {
        if(Discipline.findByName(discipline.name) == null) {
            discipline.save(flush:true)
            return true
        }
        return false
    }

    @Transactional
    def save(Discipline DisciplineInstance) {
        if (DisciplineInstance == null) {
            notFound()
            return
        }

        if (DisciplineInstance.hasErrors()) {
            respond DisciplineInstance.errors, view: 'create'
            return
        }

        DisciplineInstance.save flush:true

        //////////////////////////////////
        new DisciplineController().saveDiscipline(DisciplineInstance)
        //////////////////////////////////

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'discipline.label', default: 'Discipline'), DisciplineInstance.id])
                redirect DisciplineInstance
            }
            '*' { respond DisciplineInstance, [status: CREATED] }
        }
    }

    @Transactional
    def update(Discipline DisciplineInstance) {
        if (DisciplineInstance == null) {
            notFound()
            return
        }

        if(DisciplineInstance.hasErrors()) {
            respond DisciplineInstance.errros, view: 'edit'
            return
        }

        DisciplineInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'discipline.label', default: 'Discipline'), DisciplineInstance.id])
                redirect DisciplineInstance
            }
            '*'{ respond DisciplineInstance, [status: OK]}
        }
    }

    @Transactional
    def delete(Discipline DisciplineInstance) {
        if (DisciplineInstance == null) {
            notFound()
            return
        }

        DisciplineInstance.delete flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'discipline.label', default: 'Discipline'), DisciplineInstance.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'discipline.label'). params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}