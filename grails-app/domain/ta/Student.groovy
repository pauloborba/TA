package ta

class Student {
    String login
    String name

    // tentei um enumerador primeiro mas da erro
    static class Concept {
        public static final List<String> CONCEPTS = ["MA", "MPA", "MANA"]
    }


    Map<String, String> evaluations
    Map<String, String> finalGrades

    static constraints = {
        login unique: true
        name blank: false
    }

    public void afterCreateAddCriteria(List<EvaluationCriterion> evaluationCriteria) {
        evaluations = new HashMap<>()
        finalGrades = new HashMap<>()
        for(EvaluationCriterion evaluationCriterion : evaluationCriteria) {
            if(this.evaluations.get(evaluationCriterion.name) == null) {
                this.evaluations.put(evaluationCriterion.name, "")
                this.finalGrades.put(evaluationCriterion.name, "")
            }
        }
    }

    public void addCriterion(EvaluationCriterion evaluationCriterion) {
        if(evaluations == null) {
            evaluations = new HashMap<>()
            finalGrades = new HashMap<>()
        }
        if(this.evaluations.get(evaluationCriterion.name) == null) {
            this.evaluations.put(evaluationCriterion.name, "")
            this.finalGrades.put(evaluationCriterion.name, "")
        }
    }

    public boolean calculateFinalGrade(String criterionName, String concept){
        boolean ans = false;
        String concepts = evaluations.get(criterionName)

        String[] grades = concepts.split(" ")

        int ma = grades.count("MA")
        int mpa = grades.count("MPA")
        int mana = grades.count("MANA")

        if ( concept.equals("MA") ){
            if ( ( mpa + mana ) <= 1 ){
                finalGrades.put(criterionName, "MA")
            } else {
                finalGrades.put(criterionName, "MPA")
            }
        } else if ( concept.equals("MPA") ){
            if ( ma > 0 && mpa == 0 && mana == 0 ){
                finalGrades.put(criterionName, "MA")
            } else if ( mana <= 1 ){
                finalGrades.put(criterionName, "MPA")
            } else {
                finalGrades.put(criterionName, "MANA")
            }
        } else {
            if ( ma > 0 && mpa == 0 && mana == 0 ){
                finalGrades.put(criterionName, "MA")
            } else if ( ma >= 0 && mpa >= 1 && mana == 0 ) {
                finalGrades.put(criterionName, "MPA")
            }  else {
                finalGrades.put(criterionName, "MANA")
            }
        }

        return ans;
    }
}
