package pages

import geb.Page

class ShowNotificationsPage extends Page{
    static url = "/TA/notifications/show"

    static at = {
        title ==~ /Notifications/
    }

    def selectShowNotifications(){
        $("input", name:"show").click()
    }
}
