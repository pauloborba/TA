package ta

import com.novadge.novamail.MessagingService

class MailerController {

    def index() { }
    public static void sendMail(String mail,String subject,String message){
        def messagingService=new MessagingService()
        messagingService.sendEmail(
                "Gmail",
                "taprojmailer@gmail.com",
                "1234mail",
                "taprojmailer@gmail.com",
                mail,
                subject,
                message,
                true,
                null
        )
    }
}
