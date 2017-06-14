package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MatriculaController {

    static allowedMethods = [update: "PUT"]//, delete: "DELETE"]
    // save: "POST" foi retirado porque dá problema com o cucumber, que
    // provavelmente simula a chamada dessa ação como um GET

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Matricula.list(params), model:[matriculaInstanceCount: Matricula.count()]
    }

    def show(Matricula matriculaInstance) {
        respond matriculaInstance
    }

    def create() {
        respond new Matricula(params)
    }

    @Transactional
    def save(Matricula matriculaInstance) {
        if (matriculaInstance == null) {
            notFound()
            return
        }

        if (matriculaInstance.hasErrors()) {
            respond matriculaInstance.errors, view:'create'
            return
        }

        matriculaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'matricula.label', default: 'Matricula'), matriculaInstance.id])
                redirect matriculaInstance
            }
            '*' { respond matriculaInstance, [status: CREATED] }
        }
    }

    @Transactional
    def createAndSaveMatricula() {
        Matricula matriculaInstance = new Matricula(params)
        if (matriculaInstance == null) {
            notFound()
            return
        }

        if (matriculaInstance.hasErrors()) {
            respond matriculaInstance.errors, view:'create'
            return
        }

        matriculaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'matricula.label', default: 'Matricula'), matriculaInstance.id])
                redirect matriculaInstance
            }
            '*' { respond matriculaInstance, [status: CREATED] }
        }
    }

    @Transactional
    def updateMatricula() {
        Matricula matriculaInstance = new Matricula(params)

        if (matriculaInstance == null) {
            notFound()
            return
        }

        if (matriculaInstance.hasErrors()) {
            respond matriculaInstance.errors, view:'edit'
            return
        }

        matriculaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Matricula.label', default: 'Matricula'), matriculaInstance.id])
                redirect matriculaInstance
            }
            '*'{ respond matriculaInstance, [status: OK] }
        }
    }

    def edit(Matricula matriculaInstance) {
        respond matriculaInstance
    }

    @Transactional
    def update(Matricula matriculaInstance) {
        if (matriculaInstance == null) {
            notFound()
            return
        }

        if (matriculaInstance.hasErrors()) {
            respond matriculaInstance.errors, view:'edit'
            return
        }

        matriculaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Matricula.label', default: 'Matricula'), matriculaInstance.id])
                redirect matriculaInstance
            }
            '*'{ respond matriculaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Matricula matriculaInstance) {

        if (matriculaInstance == null) {
            notFound()
            return
        }

        matriculaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Matricula.label', default: 'Matricula'), matriculaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'matricula.label', default: 'Matricula'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    public Matricula getMatricula() {
        //def alunoInstance = new Aluno(params)
        return Matricula.findByAluno(params.aluno)
    }

    public int count(){
        return Matricula.all.size()
    }

    public void cadastrarAvaliacao(Matricula matricula,String nomeAvaliacao){
        matricula.avaliacoes.add(new Avaliacao(nome: nomeAvaliacao))
        matricula.save()
    }
}
