package ta

import org.fusesource.jansi.AnsiConsole

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StudentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def worked = false;

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Student.list(params), model: [studentInstanceCount: Student.count()]
    }

    def show(Student studentInstance) {
        respond studentInstance
    }

    def create() {
        Student student = new Student(params)
        student.afterCreateAddCriteria(EvaluationCriterion.findAll())
        respond student
    }

    def deleteAfterTest(login) {
        Student student = Student.findByLogin(login)
        delete(student)
    }

    public Student createStudent() {
        Student student = new Student(params)
        student.afterCreateAddCriteria(EvaluationCriterion.findAll())
        //student = student.merge()
//        student.afterCreateAddAutoCriteria(AutoEvaluationCriterion.findAll())
//        student.afterCreateAddAutoEvaluationCriteria(EvaluationAutoEvaluationCriterion.findAll())
        return student
    }

    def list() {
        def students = Student.findAll()
        def criteria = EvaluationCriterion.findAll()

        render view: "manualInput", model: [students: students, criteria: criteria]
    }

    def listAutoEvaluation() {
        def students = Student.findAll()
        def criteria = EvaluationCriterion.findAll()

        render view: "autoEvaluation", model: [students: students, criteria: criteria]

//        def students = Student.findAll()
//        def criteria = EvaluationCriterion.findAll()
//
//        render view: "manualInput", model: [students: students, criteria: criteria]
    }

    public boolean saveStudent(Student student) {
        if (Student.findByLogin(student.login) == null) {
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

    def compareGrade() {
        String login = params.studentId
        def criteria = EvaluationCriterion.findAll()
        Student student = Student.findByLogin(login)
        HashMap<String, String> auto = student.getAutoEvaluations()
        HashMap<String, String> fin = student.getFinalGrades()
        boolean sent = sentAuto(login)
        if (!sent) {
            worked = false;
            flash.error = "Erro: o aluno escolhido não enviou a auto avaliação"
            redirect action: index(10)
        } else {
            worked = true;
        }

        render view: "compare", model: [criteria: criteria, student: student]
    }

    def compareGrades(String login) {
        def criteria = EvaluationCriterion.findAll()
        Student student = Student.findByLogin(login)
        HashMap<String, String> auto = student.getAutoEvaluations()
        HashMap<String, String> fin = student.getFinalGrades()
        boolean sent = sentAuto(login)
        if (!sent) {
            worked = false;
            flash.error = "Erro: o aluno escolhido não enviou a auto avaliação"
            redirect action: index(10)
        } else {
            worked = true;
        }

        render view: "compare", model: [criteria: criteria, student: student]
    }

    public boolean sentAuto(String login) {
        boolean sent = false;
        Student student = Student.findByLogin(login)
        HashMap<String, String> auto = student.getAutoEvaluations()
        for (EvaluationCriterion evCriterion : EvaluationCriterion.findAll()) {
            if (!auto.get(evCriterion.name).isEmpty()) {
                sent = true;
            }
        }
        return sent
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
            println login
            Student student = Student.findByLogin(login)
            student.autoEvaluations.put(studentCriterion, concept)

            student.save flush: true
        }
    }

    def updateCriteriaAutoEvaluation() {
        String[] selector = params.concepts
        String login = params.selector
        String[] criteria = params.criterionName

        int a = 0;
        for (int i = 0; i < selector.size(); i++) {
            if (selector[i].equalsIgnoreCase("")) {
                a = a + 1;
            }
        }


        if (login.equalsIgnoreCase("")) {
            flash.error = "Choose a student"
            render view: "autoEvaluation"
        } else if (a > 0) {
            flash.error = "Evaluate yourself for all criteria"
            render view: "autoEvaluation"
        } else if (EvaluationCriterion.findByName(criteria[0]) == null) {
            for (int i = 1; i < criteria.size(); i++) {
                criteria[0] = criteria[0] + criteria[i]
            }
            for (int i = 1; i < selector.size(); i++) {
                selector[0] = selector[0] + selector[i]
            }

            updateAutoEvaluation(login, criteria[0], selector[0])

            redirect action: index(100)
        } else {
            for (int i = 0; i < criteria.length; i++) {
                updateAutoEvaluation(login, criteria[i], selector[i])
            }
            redirect action: index(100)
        }
    }

    def updateConcepts(String login, String criterion, String concept) {
        if (!concept.isEmpty()) {
            Student student = Student.findByLogin(login)
            String currentConcept = student.evaluations.get(criterion);
            student.calculateFinalGrade(criterion, concept)
            concept = currentConcept + concept + " "
            student.evaluations.put(criterion, concept)
//            student.calculateCrispGrade(student.finalGrades)

            student.save flush: true
        }
    }

    def updateCriteria() {
        String[] selector = params.selector
        String login = params.studentId
        String[] criteria = params.criterionName

        if (EvaluationCriterion.findByName(criteria[0]) == null) {
            String select = ""
            int size = selector.length
            for (int j = 0; j < size; j++) {
                select = select + selector[j]
            }
            String criterion = ""
            size = criteria.length
            for (int j = 0; j < size; j++) {
                criterion = criterion + criteria[j]
            }

            updateConcepts(login, criterion, select)
        } else {
            int size = criteria.length
            for (int j = 0; j < criteria.length; j++) {
                updateConcepts(login, criteria[j], selector[j])
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
