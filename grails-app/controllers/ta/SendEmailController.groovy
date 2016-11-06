package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SendEmailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SendEmail.list(params), model:[sendEmailInstanceCount: SendEmail.count()]
    }

    def show(SendEmail sendEmailInstance) {
        respond sendEmailInstance
    }

    def create() {
        respond new SendEmail(params)
    }

    @Transactional
    def save(SendEmail sendEmailInstance) {
        if (sendEmailInstance == null) {
            notFound()
            return
        }

        if (sendEmailInstance.hasErrors()) {
            respond sendEmailInstance.errors, view:'create'
            return
        }

        sendEmailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sendEmail.label', default: 'SendEmail'), sendEmailInstance.id])
                redirect sendEmailInstance
            }
            '*' { respond sendEmailInstance, [status: CREATED] }
        }
    }

    def edit(SendEmail sendEmailInstance) {
        respond sendEmailInstance
    }

    @Transactional
    def update(SendEmail sendEmailInstance) {
        if (sendEmailInstance == null) {
            notFound()
            return
        }

        if (sendEmailInstance.hasErrors()) {
            respond sendEmailInstance.errors, view:'edit'
            return
        }

        sendEmailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SendEmail.label', default: 'SendEmail'), sendEmailInstance.id])
                redirect sendEmailInstance
            }
            '*'{ respond sendEmailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SendEmail sendEmailInstance) {

        if (sendEmailInstance == null) {
            notFound()
            return
        }

        sendEmailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SendEmail.label', default: 'SendEmail'), sendEmailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sendEmail.label', default: 'SendEmail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
