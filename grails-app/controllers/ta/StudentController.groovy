package ta


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StudentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", authenticate: "POST"]

    def conceito = new HashMap<String, String>()

    def index(Integer max) {
//        redirect(action: "login", params: params)
        params.max = Math.min(max ?: 10, 100)
        respond Student.list(params), model: [studentInstanceCount: Student.count()]
    }

    def login() {}

    def authenticate(Student student) {
        if (request.method == 'POST') {
//            println(params)
            String[] login = params.login
            String password = params.password

            def user = Student.findByLoginAndPassword(login[0], password)

            if (user) {
                session.student = user
                flash.message = "Hello ${user.name}!"
                redirect(action: "login")

            } else {
                flash.message = "Sorry, ${params.login[0]}. Please try again."
                redirect(action: "login")
            }
        }
    }

    def logar(Student student){
        String login = student.login
        String password = student.password

        def user = Student.findByLoginAndPassword(login, password)

        if (user) {
            session.student = user
            flash.message = "Hello ${user.name}!"
            redirect(action: "login")

        } else {
            flash.message = "Sorry, ${params.login[0]}. Please try again."
            redirect(action: "login")
        }

    }

    def logout() {
        flash.message = "Goodbye ${session.student.name}"
        session.student = null
        redirect(action:"login")
    }



    def show(Student studentInstance) {
        respond studentInstance
    }

    def create() {
        respond new Student(params)
    }

    public Student createStudent() {
        if (student.password == null){
            params.password = params.login
        }

        Student student = new Student(params)

        student.afterCreateAddCriteria(EvaluationCriterion.findAll())
//        student.afterCreateAddAutoCriteria(AutoEvaluationCriterion.findAll())
//        student.afterCreateAddAutoEvaluationCriteria(EvaluationAutoEvaluationCriterion.findAll())
        return student
    }

    def list() {
        def students = Student.findAll()
        def criteria = EvaluationCriterion.findAll()

        render view: "manualInput", model: [students: students, criteria: criteria]
    }

    public boolean saveStudent(Student student) {
        if (Student.findByLogin(student.login) == null && student.password == null) {
            student.password = student.login
            student.save flush: true

            return true
        } else if(Student.findByLogin(student.login) == null){
            student.save flush: true
            return true
        }
        return false
    }

    public void updateStudentEvaluationCriteria() {
        for (Student student : Student.findAll()) {
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



        def isPasswordEmpty = studentInstance.password == null
        if(isPasswordEmpty){
            studentInstance.password = studentInstance.login
        }

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
    def updateConcepts(String login, String criterion, String concept) {
        if (!concept.isEmpty()) {

            Student student = Student.findByLogin(login)
            String currentConcept = student.evaluations.get(criterion);
            student.calculateFinalGrade(criterion, concept)
            concept = currentConcept + concept + " "
            student.evaluations.put(criterion, concept)

            student.save flush: true
        }
    }

    def updateCriteria() {
        String[] selector = params.selector
        String login = params.studentId
        String[] criteria = params.criterionName

        if ( EvaluationCriterion.findByName(criteria[0] ) == null  ) {
            String select = ""
            int size = selector.length
            for (int i = 0; i < size; i++) {
                select = select + selector[i]
            }
            String criterion = ""
            size = criteria.length
            for (int i = 0; i < size; i++) {
                criterion = criterion + criteria[i]
            }

            updateConcepts(login, criterion, select)
        } else {
            int size = criteria.length
            for (int i = 0; i < criteria.length; i++) {
                updateConcepts(login, criteria[i], selector[i])
            }
        }


        redirect action: index(10)
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
