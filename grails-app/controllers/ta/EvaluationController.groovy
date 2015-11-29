package ta

import commom.EvaluationBuilder
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class EvaluationController {

    EvaluationBuilder builder = new EvaluationBuilder()
    String pageMessage

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def beforeInterceptor = [action:this.&auth]

    def scaffold=true

    def auth() {
        if(!session.student) {
            redirect(controller:"Student", action:"login")
            return false
        }
    }


    def index(Integer max) {
//        redirect(action: "list")
        params.max = Math.min(max ?: 10, 100)
        respond Evaluation.list(params), model: [evaluationInstanceCount: Evaluation.count()]
    }


    def show(Evaluation evaluationInstance) {
        respond evaluationInstance
    }

    def create() {
        respond new Evaluation(params)
    }

    @Transactional
    def save(Evaluation evaluationInstance) {
        if (evaluationInstance == null) {
            notFound()
            return
        }

        if (evaluationInstance.hasErrors()) {
            respond evaluationInstance.errors, view: 'create'
            return
        }

        evaluationInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), evaluationInstance.id])
                redirect evaluationInstance
            }
            '*' { respond evaluationInstance, [status: CREATED] }
        }
    }

    def edit(Evaluation evaluationInstance) {
        respond evaluationInstance
    }

    @Transactional
    def update(Evaluation evaluationInstance) {
        if (evaluationInstance == null) {
            notFound()
            return
        }

        if (evaluationInstance.hasErrors()) {
            respond evaluationInstance.errors, view: 'edit'
            return
        }

        evaluationInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Evaluation.label', default: 'Evaluation'), evaluationInstance.id])
                redirect evaluationInstance
            }
            '*' { respond evaluationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Evaluation evaluationInstance) {

        if (evaluationInstance == null) {
            notFound()
            return
        }

        evaluationInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Evaluation.label', default: 'Evaluation'), evaluationInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    //////////////////////////////////////////

    def rippenEvaluation(String title, String questionDescription, String questionAnswer, String questionAlternative) {

        try {
            builder.createEvaluation()
            if (title != null) {
                builder.setEvaluationTitle(title)
                int quesitonIndex = builder.addEvaluationQuestion(questionDescription)
                builder.setQuestionAnswer(questionIndex, questionAnswer)
                builder.addQuestionAlternative(questionIndex, questionAlternative)

                Evaluation evaluation = builder.getEvaluation()
                saveEvaluation(evaluation)

                pageMessage = "Avalia��o registrada."

            } else {
                pageMessage = "Campo de t�tulo � obrigat�rio. Nenhuma avalia��o foi registrada."
            }

        } catch (Exception e) {
            pageMessage = "Ocorreu um erro."
        }
    }

    def saveEvaluation(Evaluation evaluation) {
        if (Evaluation.findByTitle(evaluation.title) == null)
            evaluation.save()
    }
}
