package ta

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class NotificationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Notification.list(params), model:[notificationInstanceCount: Notification.count()]
    }

    def show(Notification notificationInstance) {
        respond notificationInstance
    }

    def create() {
        respond new Notification(params)
    }

    public boolean saveNotification(Notification notification) {
        if(Notification.findByName(notification.name) == null) {
            notification.save(flush: true)
            new StudentController().updateStudentEvaluationCriteria()
            return true
        }
        return false
    }
}
