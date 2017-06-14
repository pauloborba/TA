package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TurmaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
            return
        }

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

    static boolean alunoEstaNaTurma(String loginCIn, Turma turma){

        def matriculas = turma.matriculas
        def sim = false

        for(int i=0; i<matriculas.size(); i++){

            Matricula aluno = matriculas.get(i)

            if(aluno.aluno.loginCin.equalsIgnoreCase(loginCIn)){
                sim = true
            }
        }

        return sim
    }

    static boolean metaEstaNaTurma(String meta, Turma turma){

        def metas = turma.metas
        def sim = false

        for(int i=0; i<metas.size(); i++){

            String m = metas.get(i)

            if(m.equalsIgnoreCase(meta)){
                sim = true
            }
        }

        return sim
    }

    def salvar(String nome){
        Turma turma = new Turma(nome)
        turma.save flush: true
    }

    boolean turmaExiste(String nome){
        return Turma.findByNome(nome)
    }


}
