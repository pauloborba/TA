package ta

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TurmaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    //inicio de testes

    Turma getTurma() {
        def turmaInstance = new Turma(params)
        return Turma.findByNome(turmaInstance.nome)
    }








































    /*boolean checkAluno(Turma t, Matricula m){
        for(int i = 0; i < t.matriculas.size(); i++){
            if (t.matriculas[i] == m){
                return true
            }
        }
        return false
    }

    def calcularMedia(){
        for(int i=0; i < matriculas.size(); i++){
            mediaGeral = mediaGeral + matriculas[i].media
        }
        totalTurma = matriculas.size()
        mediaGeral = mediaGera.div(totalTurma)
    }

    def contAM(){
        for(int i = 0; i < matriculas.size(); i++){
            if (matriculas[i].aprovacao == "AP"){
                numAM = numAM + 1
            }
        }
        totalTurma = matriculas.size()
        numAM = (numAM * 100) / totalTurma
    }

    def contA(){
        for(int i = 0; i < matriculas.size(); i++){
            if (matriculas[i].aprovacao == "A"){
                numA = numA + 1
            }
        }
        totalTurma = matriculas.size()
        numA = (numA * 100) / totalTurma
    }

    // fim de testes*/




















    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Turma.list(params), model:[turmaInstanceCount: Turma.count()]
    }

    def show(Turma turmaInstance) {
        respond turmaInstance
    }

    def create() {
        respond new Turma(params)
    }

    @Transactional
    def save(Turma turmaInstance) {
        if (turmaInstance == null) {
            notFound()
        }
            return

        if (turmaInstance.hasErrors()) {
            respond turmaInstance.errors, view:'create'
            return
        }

        turmaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'turma.label', default: 'Turma'), turmaInstance.id])
                redirect turmaInstance
            }
            '*' { respond turmaInstance, [status: CREATED] }
        }
    }

    def createAndSave() {
        Turma turmaInstance = new Turma(params)
        if (Turma.findByNome(turmaInstance.nome) == null) {
            if (turmaInstance.hasErrors()) {
                respond turmaInstance.errors, view: 'create'
                return
            }
            if(!turmaInstance.save(flush: true)){
                render(view: "create", model: [turmaInstance: turmaInstance])
                return
            }
            flash.message = message(code: 'default.created.message', args: [message(code: 'turma.label', default: 'Turma'), turmaInstance.id])
            redirect(action: "show", id: turmaInstance.id)
        }
    }


    def edit(Turma turmaInstance) {
        respond turmaInstance
    }

    @Transactional
    def update(Turma turmaInstance) {
        if (turmaInstance == null) {
            notFound()
            return
        }

        if (turmaInstance.hasErrors()) {
            respond turmaInstance.errors, view:'edit'
            return
        }

        turmaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Turma.label', default: 'Turma'), turmaInstance.id])
                redirect turmaInstance
            }
            '*'{ respond turmaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Turma turmaInstance) {

        if (turmaInstance == null) {
            notFound()
            return
        }

        turmaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Turma.label', default: 'Turma'), turmaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'turma.label', default: 'Turma'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
