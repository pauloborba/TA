package ta


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StudentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def conceito = new HashMap<String, String>()

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Student.list(params), model: [studentInstanceCount: Student.count()]
    }

    def show(Student studentInstance) {
        respond studentInstance
    }

    def create() {
        respond new Student(params)
    }

    public Student createStudent() {
        Student student = new Student(params)
        student.afterCreateAddCriteria(EvaluationCriterion.findAll())
//        student.afterCreateAddAutoCriteria(AutoEvaluationCriterion.findAll())
//        student.afterCreateAddAutoEvaluationCriteria(EvaluationAutoEvaluationCriterion.findAll())
        return student
    }

    def list(){
        def students = Student.findAll()
        def criteria = EvaluationCriterion.findAll()

        render view: "manualInput", model:[students: students, criteria: criteria]
    }

    def listAutoEvaluation(){
        def students = Student.findAll()
        def criteria = EvaluationCriterion.findAll()

        render view: "autoEvaluation", model:[students: students, criteria: criteria]
    }

    public boolean saveStudent(Student student) {
        if(Student.findByLogin(student.login) == null) {
            student.save flush: true
            return true
        }
        return false
    }

    public void updateStudentEvaluationCriteria() {
        for(Student student : Student.findAll()) {
            for (EvaluationCriterion evCriterion : EvaluationCriterion.findAll()) {
                student.addCriterion(evCriterion)
                student.save flush: true
            }

//            for (AutoEvaluationCriterion autoEvCriterion : AutoEvaluationCriterion.findAll()) {
//                student.addAutoCriterion(autoEvCriterion)
//                student.save flush: true
//            }

        }
    }

    @Transactional
    def save(Student studentInstance) {
        if (studentInstance == null) {
            notFound()
            return
        }

        if (studentInstance.hasErrors()) {
            respond studentInstance.errors, view: 'create'
            return
        }

        studentInstance.afterCreateAddCriteria(EvaluationCriterion.findAll())

        studentInstance.save flush: true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'student.label', default: 'Student'), studentInstance.id])
                redirect studentInstance
            }
            '*' { respond studentInstance, [status: CREATED] }
        }
    }

    def edit(Student studentInstance) {
        respond studentInstance
    }

    @Transactional
    def update(Student studentInstance) {
        if (studentInstance == null) {
            notFound()
            return
        }

        if (studentInstance.hasErrors()) {
            respond studentInstance.errors, view: 'edit'
            return
        }

        studentInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Student.label', default: 'Student'), studentInstance.id])
                redirect studentInstance
            }
            '*' { respond studentInstance, [status: OK] }
        }
    }


    @Transactional
    def updateAutoEvaluation(String login, String studentCriterion, String concept) {
        if (!concept.isEmpty()) {
            Student student = Student.findByLogin(login)
            student.autoEvaluations.put(studentCriterion, concept)

            student.save flush: true
        }
    }

    def updateCriteriaAutoEvaluation(){
        String[] selector = params.selector
        String login = params.studentId
        String[] criteria = params.criterionName

        int size = criteria.length
        for( int i = 0; i < criteria.length; i++ ){
            updateAutoEvaluation(login, criteria[i], selector[i])
        }

        redirect action: index(100)
    }


    @Transactional
    def delete(Student studentInstance) {

        if (studentInstance == null) {
            notFound()
            return
        }

        studentInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Student.label', default: 'Student'), studentInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'student.label', default: 'Student'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
