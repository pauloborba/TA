package pages

import geb.Page

class NotificationPage extends Page{

    static url = "/TA/notification/index"

    static at = {
        title ==~ /Notification/
    }

    def selectShowNotifications(){
        $("input", name:"show").click()
    }

	def update() {
	
	}

    static content = {
        flashmessage = {
            $("div", class: "message")
        }
    }
}
