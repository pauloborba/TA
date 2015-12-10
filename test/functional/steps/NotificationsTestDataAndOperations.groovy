package steps

import ta.EvaluationCriterion
import ta.Notification
import ta.NotificationController
import ta.Student

class NotificationsTestDataAndOperations {

	public static boolean createNotification(String login) {
		def cont = new NotificationController()
		String message = "Student " + login + "needs more attention.";
		cont.params << [login: login] << [message: message]
		boolean saved = cont.saveNotification(cont.create())
		cont.response.reset()
		return saved;
	}	

}