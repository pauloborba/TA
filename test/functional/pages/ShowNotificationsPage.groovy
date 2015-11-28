package pages

import geb.Page

class ShowNotificationsPage extends Page{

    static url = "/TA/notifications/index"

    static at = {
        title ==~ /Notification/
    }

    def selectShowNotifications(){
        $("input", name:"show").click()
    }


    static content = {
        flashmessage = {
            $("div", class: "message")
        }
    }
}
