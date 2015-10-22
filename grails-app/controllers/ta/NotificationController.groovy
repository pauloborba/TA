package ta

/**
 * Created by imvm on 05/10/15.
 */
class NotificationController {

    def create() {
<<<<<<< HEAD
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
=======
        //respond new Notification(params)
    }

    public boolean save(Notification n) {
        /*if(Notification.findByStudent(n.student) == null) {
            n.save(flush: true)
        }*/
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
        return false
    }

}
