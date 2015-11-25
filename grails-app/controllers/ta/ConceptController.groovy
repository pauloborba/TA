package ta

import commom.SheetImporter
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class ConceptController {
    public boolean hasImported

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Concept.list(params), model: [conceptInstanceCount: Concept.count()]
    }

    def show(Concept conceptInstance) {
        respond conceptInstance
    }

    def create() {
        respond new Concept(params)
    }

    @Transactional
    def save(Concept conceptInstance) {
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

    def edit(Concept conceptInstance) {
        respond conceptInstance
    }

    @Transactional
    def update(Concept conceptInstance) {
        if (conceptInstance == null) {
            notFound()
            return
        }

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
        def f = request.getFile('datafile');

        String filename = params.datafile.getOriginalFilename()

        if (f.empty){
            flash.error = 'file cannot be empty'
            render(view: 'upload')
            return
        }

        File newFile = new File(filename)
        f.transferTo(newFile)
        uploadSheet(filename)
        //response.sendError(200,'Done')
        newFile.delete()

    }

    def uploadSheet(String filename){
        File newFile = new File(filename)

        SheetImporter sheetImporter
        hasImported = false
        try {
            sheetImporter = new SheetImporter(filename)
            def validColumns = sheetImporter.hasValidColumns()

            if (!validColumns){
                flash.error = "Error! \nFirst column should be named 'aluno', \nsecond column sould be named 'login' \nand the third column should have a header"
            } else {

                def name, login, criterion, concept
                List<Map> data = sheetImporter.getConcepts()

                criterion = sheetImporter.getCriterion()

                boolean criterionExists = EvaluationCriterion.findByName(criterion) != null

                def cont
                if (!criterionExists) {
                    cont = new EvaluationCriterionController()
                    cont.params << [name: criterion]
                    cont.saveEvaluationCriterion(cont.createEvaluationCriterion())
                }

                for (Map m : data) {
                    name = m.get('aluno')
                    login = m.get('login')
                    concept = m.get(criterion)

                    boolean studentExists = Student.findByLogin(login) != null

                    cont = new StudentController()

                    if (!studentExists) {
                        println "criou estudante " + login + " " + name

                        cont.params << [login: login] << [name: name] << [evaluations: new HashMap<String, String>()]
                        cont.saveStudent(cont.createStudent())
                    }

                    cont.updateConcepts(login + " / " + criterion, concept)

                }

                hasImported = true
                flash.message = 'Sheet uploaded!'

            }

        } catch(IllegalArgumentException e) {
            flash.error = "Invalid file format!"
        }

        render view: "upload"
        return
    }

}
