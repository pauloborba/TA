package ta
/**
 * Created by dlr4 on 12/05/2016.
 */
class EvaluationsByCriterion {
    Criterion criterion
    List<Evaluation> evaluations
    static hasMany = [evaluations:Evaluation]
    double criterionAverage
    boolean PendingMail
    static constraints = {
        criterion nullable: false
        evaluations nullable : false
    }

    public EvaluationsByCriterion(Criterion criterion){
        this.criterion = criterion;
        this.evaluations = []
        this.criterionAverage = 0;
        this.PendingMail = false
    }

    public void addEvaluation(Evaluation evaluationInstance) {
        addToEvaluations(evaluationInstance)
        doMedia();
        if(!evaluationInstance.sent)this.PendingMail = true
    }

    public void doMedia(){
        StudentController sc = new StudentController()
        double tempMedia = 0;
        int qtdEvaluations = 0;
        if (evaluations.size() > 0) {
            for(int i = 0; i < evaluations.size(); i++){
                String eval = evaluations[i].value
                (qtdEvaluations, tempMedia) = sc.evaluate(eval, qtdEvaluations, tempMedia)
            }
            this.criterionAverage = (tempMedia/qtdEvaluations);
        } else {
            this.criterionAverage = 0
        }
    }

    String newEvalToMessage(){
        String s=""
        evaluations.each{Evaluation ev->
            if(!ev.sent)s+=" "+ev.value+","
            ev.sent=true
        }
        return FormatMessage(s)
    }

    private String FormatMessage(String s) {
        if (s.length() == 0) return ""
        s = s.substring(0, s.length() - 1)
        return " *" + criterion.getDescription() + ": " + s + "\n"
    }
    /*  ------------------------
      | MÉTODOS USADOS EM TESTES |
        ------------------------  */

    public void deleteEvaluation(Evaluation evaluationInstance) {
        for (int i = 0; i < this.evaluations.size(); i++) {
            if (this.evaluations[i].compatibleTo(evaluationInstance)) {
                removeFromEvaluations(evaluationInstance)
            }
        }
    }

    public Evaluation findSpecificEvaluation(Evaluation evaluationInstance) {
        for (int i = 0; i < this.evaluations.size(); i++) {
            if (this.evaluations[i].compatibleTo(evaluationInstance)) {
                return this.evaluations[i]
            }
        }
       	return null
    }
}
