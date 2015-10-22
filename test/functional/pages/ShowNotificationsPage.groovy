package pages

import geb.Page

class ShowNotificationsPage extends Page{
<<<<<<< HEAD
    static url = "/TA/notifications/index"

    static at = {
        title ==~ /Notification/
    }
=======
    static url = "/TA/notifications/show"

    static at = {
        title ==~ /Notifications/
stati c    }
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16

    def selectShowNotifications(){
        $("input", name:"show").click()
    }
<<<<<<< HEAD
=======

    static content = {
        flashmessage = {
            $("div", class: "message")
        }
    }
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
}
