package steps

import ta.EvaluationCriterion
import ta.Notification
import ta.NotificationController
import ta.Student

class NotificationsTestDataAndOperations {

	public static boolean createNotification(String login) {
		def cont = new NotificationController()
		cont.params << [login: login] << [message: "Student " + login + "needs more attention."]
		boolean saved = cont.saveNotification(cont.saveNotification())
		cont.response.reset()
		return saved;
	}	

}