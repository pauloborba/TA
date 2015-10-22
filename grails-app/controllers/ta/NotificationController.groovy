package ta

/**
 * Created by imvm on 05/10/15.
 */
class NotificationController {

    def create() {
        respond new Notification(params)
    }

    def show() {
        def list = Notification.getAll()
        if (list.empty) {
            flash.message = "There are no new notifications."
        }
        return list;
    }

    public boolean save(Notification n) {
        if(Notification.findByStudent(n.student) == null) {
            n.save(flush: true)
        }
        return false
    }

}
