package steps

import ta.EvaluationCriterion
import ta.Notification
import ta.NotificationController
import ta.Student

class NotificationsTestDataAndOperations {

	public static void createNotification(Student s, EvaluationCriterion savedCriteria1, EvaluationCriterion savedCriteria2, EvaluationCriterion savedCriteria3) {
		def cont = new NotificationController()
		//cont.params << [student : s] << [evaluationCriterions : savedCriteria1, savedCriteria2, savedCriteria3]
		cont.save(cont.create())
		cont.response.reset()
	}	

}