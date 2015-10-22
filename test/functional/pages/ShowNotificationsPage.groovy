package pages

import geb.Page

class ShowNotificationsPage extends Page{
<<<<<<< HEAD
<<<<<<< HEAD
    static url = "/TA/notifications/index"

    static at = {
        title ==~ /Notification/
    }
=======
=======
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
    static url = "/TA/notifications/show"

    static at = {
        title ==~ /Notifications/
stati c    }
<<<<<<< HEAD
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
=======
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16

    def selectShowNotifications(){
        $("input", name:"show").click()
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16

    static content = {
        flashmessage = {
            $("div", class: "message")
        }
    }
<<<<<<< HEAD
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
=======
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
}
