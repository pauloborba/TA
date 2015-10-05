package ta

class Notification {
	static belongsTo = [student : Student]
	static hasMany = [evaluationCriterions : EvaluationCriterions]
}