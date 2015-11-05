package steps

import ta.EvaluationCriterion
import ta.Notification
import ta.NotificationController
import ta.Student

class NotificationsTestDataAndOperations {

	public static void createNotification(Student s, ArrayList evalList) {
		def cont = new NotificationController()
		cont.params << [student : s] << [evaluationCriterions : evalList]
		cont.save(cont.create())
		cont.response.reset()
	}	

}