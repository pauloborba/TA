package ta

import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.MultipartRequest

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AlunoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Aluno.list(params), model:[alunoInstanceCount: Aluno.count()]
    }

    def show(Aluno alunoInstance) {
        respond alunoInstance
    }

    def create() {
        respond new Aluno(params)
    }

    @Transactional
    def save(Aluno alunoInstance) {
        if (alunoInstance == null) {
            notFound()
            return
        }

        if (alunoInstance.hasErrors()) {
            respond alunoInstance.errors, view:'create'
            return
        }

        alunoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aluno.label', default: 'Aluno'), alunoInstance.id])
                redirect alunoInstance
            }
            '*' { respond alunoInstance, [status: CREATED] }
        }
    }

    def edit(Aluno alunoInstance) {
        respond alunoInstance
    }

    @Transactional
    def update(Aluno alunoInstance) {
        if (alunoInstance == null) {
            notFound()
            return
        }

        if (alunoInstance.hasErrors()) {
            respond alunoInstance.errors, view:'edit'
            return
        }

        alunoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Aluno.label', default: 'Aluno'), alunoInstance.id])
                redirect alunoInstance
            }
            '*'{ respond alunoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Aluno alunoInstance) {

        if (alunoInstance == null) {
            notFound()
            return
        }

        alunoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Aluno.label', default: 'Aluno'), alunoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aluno.label', default: 'Aluno'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def importAlunos() {
        respond('importAlunos')
    }

    def upload() {
        def content = request.getContentType()
        def path

        if(content.contains("multipart/form-data") || (request instanceof MultipartHttpServletRequest)) {
            def file = request.getFile('file')
            //request.getFileNames().each {print(it)}
            if(!file) {
                flash.message = "Nenhuma planilha escolhida!"
                redirect action:"index", method:"GET"
            } else {
                def completePath = servletContext.getRealPath('/')
                File spreadsheet = new File(completePath, 'spreadsheet.xls')
                file.transferTo(spreadsheet)

                path = spreadsheet.getAbsolutePath()
            }
        } else {
            flash.message = "Houve um erro ao carregar a planilha :("
            redirect action:"index", method:"GET"
        }

        if(path) {
            PlanilhaAlunos planilhaAlunos = PlanilhaFactory.getPlanilha(path, "addaluno")
            def turma = Turma.findByNome(params.turma)
            planilhaAlunos.alunos.each {
                it.save()
                
            }
        }
        redirect action:"index", method:"GET"
    }
}
