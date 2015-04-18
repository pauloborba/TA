package ta

class UEvaluation {

	// responsavel por contruir a avaluacao
	EvaluationBuilder builder = new EvaluationBuilder()

	def index() {
		// redirect to list action
	}

	def list() {
		// list evaluations
	}

	def getByTitle(String title) {
		// look for evaluation by it type
	}

	def saveEvaluation(Evaluation evaluation) {
		evaluation.save()
	}
}