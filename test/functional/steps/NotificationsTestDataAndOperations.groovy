package steps

import ta.EvaluationCriterion
import ta.Notification
import ta.NotificationController
import ta.Student

class NotificationsTestDataAndOperations {

<<<<<<< HEAD
<<<<<<< HEAD
	public static void createNotification(Student s, ArrayList evalList) {
		def cont = new NotificationController()
		cont.params << [student : s] << [evaluationCriterions : evalList]
=======
	public static void createNotification(Student s, Set<EvaluationCriterion> e) {
		def cont = new NotificationController()
		cont.params << [student : s] << [evaluationCriterions : e]
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
=======
	public static void createNotification(Student s, Set<EvaluationCriterion> e) {
		def cont = new NotificationController()
		cont.params << [student : s] << [evaluationCriterions : e]
>>>>>>> 35391b6974a1be2133b0fef32c93aec7e9e58e16
		cont.save(cont.create())
		cont.response.reset()
	}	

}