package ta


import static ta.MailerController.*

class Student {
    String name;
    String login;
    String email;
    double average;
    List<EvaluationsByCriterion> criteriaAndEvaluations
    static hasMany = [criteriaAndEvaluations:EvaluationsByCriterion]

    static constraints = {
        name blank : false
        login unique : true, blank:false
        email blank: true, nullable: true
    }

    static mapping = {
        sort "login"
        sort login: "asc"
    }

    public Student(String name, String login){
        this.name = name;
        this.login = login;
        this.criteriaAndEvaluations = [];
    }


    public Student(String name, String login,String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.criteriaAndEvaluations = [];
    }

    public void calcMedia() {
        StudentController sc = new StudentController()
        int qtdEvaluations = 0
        double tempMedia = 0
        List<Evaluation> evaluationsInCriterion
        for (int i = 0; i < this.criteriaAndEvaluations.size(); i++) {
            evaluationsInCriterion = this.criteriaAndEvaluations[i].getEvaluations()
            for (int j = 0; j < evaluationsInCriterion.size(); j++) {
                String eval = evaluationsInCriterion.get(j).value
                (qtdEvaluations, tempMedia) = sc.evaluate(eval, qtdEvaluations, tempMedia)
            }
        }
        if (qtdEvaluations > 0) {
            tempMedia /= qtdEvaluations
            this.average = tempMedia
        } else {
            this.average = 0
        }
    }

    boolean sendNewEvaluations(){
        String message="";
        this.criteriaAndEvaluations.each { EvaluationsByCriterion evByCriterion ->
            if (evByCriterion.getPendingMail()) {
                message += evByCriterion.newEvalToMessage()
                evByCriterion.setPendingMail(false)
            }
        }
        if(message.size()>0) {
            sendMail(this.email,"Grades","Your Grades are:\n"+this.name+"'s Grades:\n"+message)
            return true
        }else {
            return false
        }
    }
    /*public void addEvaluation(Evaluation evaluationInstance){
        for(int i = 0; i< this.criteriaAndEvaluations.size(); i++){
            if(this.criteriaAndEvaluations.get(i).getCriterion().getDescription().equals(evaluationInstance.criterion.description)){
                this.criteriaAndEvaluations.get(i).addEvaluation(evaluationInstance);
            }
        }
    }*/

    public void addEvaluation(Evaluation evaluationInstance){
        if(this.findEvaluationByCriterion(evaluationInstance.getCriterion().getDescription()) != null) {
            for (int i = 0; i < this.criteriaAndEvaluations.size(); i++) {
                if (this.criteriaAndEvaluations[i].getCriterion().getDescription().equals(evaluationInstance.criterion.description)) {
                    this.criteriaAndEvaluations[i].addEvaluation(evaluationInstance)
                }
            }
        }else {
            EvaluationsByCriterion newEvByCrit = new EvaluationsByCriterion(evaluationInstance.criterion)
            newEvByCrit.addEvaluation(evaluationInstance)
            newEvByCrit.save(flush: true)
            this.addToCriteriaAndEvaluations(newEvByCrit)
        }
        this.calcMedia()
    }


    public void deleteEvaluation(Evaluation evaluationInstance){
        for(int i = 0; i< this.criteriaAndEvaluations.size(); i++){
            if(this.criteriaAndEvaluations[i].getCriterion().getDescription().equals(evaluationInstance.criterion.description)){
                this.criteriaAndEvaluations[i].deleteEvaluation(evaluationInstance);
            }
        }
    }

    public EvaluationsByCriterion findEvaluationByCriterion(String criterionName){
        if (this.criteriaAndEvaluations != null) {
            for(int i =0; i<this.criteriaAndEvaluations.size(); i++){
                if(this.criteriaAndEvaluations[i].getCriterion().getDescription().equals(criterionName)){
                    return this.criteriaAndEvaluations[i];
                }
            }
            return null
        }
    }

    public void addEvaluationsByCriterion(EvaluationsByCriterion evCriterion){
        if(!this.findEvaluationByCriterion(evCriterion.getCriterion().getDescription())){
            this.addToCriteriaAndEvaluations(evCriterion);
        }
    }
}