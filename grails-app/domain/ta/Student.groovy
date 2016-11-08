package ta

class Student {
    String name;
    String login;
    double average;
    int ma, mpa, mana, total
    boolean reprovado
    List criteriaAndEvaluations
    boolean firstCalc
    int lastCrit
    static hasMany = [criteriaAndEvaluations:EvaluationsByCriterion]

    static constraints = {
        name blank : false
        login unique : true, blank:false;
    }

    static mapping = {
        sort "login"
        sort login: "asc"
    }

    public Student(String name, String login){
        this.name = name;
        this.login = login;
        this.criteriaAndEvaluations = [];
        this.reprovado = false
        this.firstCalc = true
        this.lastCrit = 0
    }

    public void calcMaMpaMana() {
        this.ma = 0
        this.mana = 0
        this.mpa = 0
        List<Evaluation> evaluationsInCriterion
        for (int i = 0; i < this.criteriaAndEvaluations.size(); i++) {
            evaluationsInCriterion = this.criteriaAndEvaluations[i].getEvaluations()
            for (int j = 0; j < evaluationsInCriterion.size(); j++) {
                String eval = evaluationsInCriterion.get(j).value
                if (eval.equals("MA")) {
                    this.ma++
                } else if (eval.equals("MANA")) {
                    this.mana++
                } else if (eval.equals("MPA")) this.mpa++
                else reprovado = true
            }
        }
    }

    public void calcMedia() {
        StudentController sc = new StudentController()
        int qtdEvaluations = 0
        double tempMedia = 0
        int count
        List<Evaluation> evaluationsInCriterion
        for (int i = 0; i < this.criteriaAndEvaluations.size(); i++) {
            evaluationsInCriterion = this.criteriaAndEvaluations[i].getEvaluations()
            for (int j = 0; j < evaluationsInCriterion.size(); j++) {
                String eval = evaluationsInCriterion.get(j).value
                String ori = evaluationsInCriterion.get(j).origin
                (qtdEvaluations, tempMedia) = sc.evaluate(eval, qtdEvaluations, tempMedia)
            }

        }
        this.total = qtdEvaluations
        if (qtdEvaluations > 0) {
            tempMedia /= qtdEvaluations
            this.average = tempMedia
        } else {
            this.average = 0
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

    public int getTotalValidCriterions() {
        int count = 0
        if (this.criteriaAndEvaluations != null) {
            for(int i =0; i<this.criteriaAndEvaluations.size(); i++){
                if(!this.criteriaAndEvaluations[i].getCriterion().getDescription().equals("--")){
                    count++
                }
            }
            return count
        }
    }

    public void addEvaluationsByCriterion(EvaluationsByCriterion evCriterion){
        if(!this.findEvaluationByCriterion(evCriterion.getCriterion().getDescription())){
            this.addToCriteriaAndEvaluations(evCriterion);
        }
    }


}