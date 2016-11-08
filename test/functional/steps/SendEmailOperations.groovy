package steps

import ta.StudentController

/**
 * Created by Rodrigo on 07/11/2016.
 */
class SendEmailOperations {
    static public void SendEmail() {
        def send = new StudentController()
        send.sendNew()
    }
}
