package ta

import ta.commom.EvaluationBuilder
import taL.Evaluation

class UEvaluation {

	// responsavel por contruir a avaluacao
	EvaluationBuilder builder = new EvaluationBuilder()
	String pageMessage
	/*
	def index() {
		// redirect to list action
	}

	def list() {
		// list evaluations

	}
	*/
	def getByTitle(String title) {
		// look for evaluation by it title
		Evaluation.find(("from Evaluation as e where e.title=?", [title]))
	}

	def rippenEvaluation(String title, String questionDescription = "", String questionAnswer = "", String questionAlternative = "") {
		
		try {
			builder.createEvaluation()
			builder.setEvaluationTitle(title)
			int quesitonIndex = builder.addEvaluationQuestion(questionDescription)
			builder.setQuestionAnswer(questionIndex, questionAnswer)
			builder.addQuestionAlternative(questionIndex, questionAlternative)

			Evaluation evaluation = builder.getEvaluation()
			saveEvaluation(evaluation)
			
			pageMessage = "Avaliação registrada."

		} catch (Exception e) {
			pageMessage = "Ocorreu um erro."
		}
	}

	def saveEvaluation(Evaluation evaluation) {
		evaluation.save()
	}
}