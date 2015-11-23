package ta

import commom.SheetBuilder
import commom.SheetImporter

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConceptController {
    SheetBuilder builder = new SheetBuilder()
    Sheet sheet;

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
        //sheet.validFileFormat();
        def f = request.getFile('datafile');

        sheet = new Sheet()
        String filename = params.datafile.getOriginalFilename()
        sheet.filename = filename
        //System.out.println("PARAMS: " + params.datafile.getOriginalFilename())

        if (!sheet.validFileFormat()) {
            flash.message = "Invalid file format!"
            render view: "upload"
            return
        }



        if (f.empty){
            flash.message = 'file cannot be empty'
            render(view: 'upload')
            return
        }

        File newFile = new File(filename)
        f.transferTo(newFile)
        //response.sendError(200,'Done')

        try {
            SheetImporter sheetImporter = new SheetImporter(filename)
            def name, login, criterion, concept
            List<Map> data = sheetImporter.getConcepts()
            println data

            criterion = sheetImporter.getCriterion()

            boolean criterionExists = EvaluationCriterion.findByName(criterion) != null

            def cont
            if (!criterionExists) {
                cont = new EvaluationCriterionController()
                cont.params << [name: criterion]
                cont.saveEvaluationCriterion(cont.createEvaluationCriterion())
                println "criou criterio " + criterion
            }

            for (Map m : data){
                println m
                name = m.get('aluno')
                login = m.get('login')
                concept = m.get(criterion)

                boolean studentExists = Student.findByLogin(login) != null

                cont = new StudentController()

                if (!studentExists){
                    println "criou estudante " + login + " " + name

                    cont.params << [login: login] << [name: name] << [evaluations: new HashMap<String, String>()]
                    cont.saveStudent(cont.createStudent())
                }

                cont.updateConcepts(login+" / "+criterion,concept)


            }


            StudentController.addConcepts(sheetImporter.getConcepts());


            //println sheetImporter.getConcepts();

            flash.message = 'Sheet uploaded!'



        } catch(IllegalArgumentException e) {
            flash.message = "Invalid file format!"
        }


        newFile.delete();

        render view: "upload"
        return



    }

    def importSheet(Sheet sheet){
        this.sheet = sheet;
    }

    def invalidFileFormatMessage(){
//        flash.message = "Invalid file format!"
    }

    def reset(){
        builder.removeSheet();
        this.sheet = null;
        return true;
    }
}


//def save(){
//    return this.sheet.save();
//}