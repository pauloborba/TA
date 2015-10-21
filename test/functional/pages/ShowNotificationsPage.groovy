package pages

import geb.Page

class ShowNotificationsPage extends Page{
    static url = "/TA/notifications/show"

    static at = {
        title ==~ /Notifications/
stati c    }

    def selectShowNotifications(){
        $("input", name:"show").click()
    }

    static content = {
        flashmessage = {
            $("div", class: "message")
        }
    }
}
