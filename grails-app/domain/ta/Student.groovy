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

    public boolean calculateFinalGrade(String criterionName){
        boolean ans = false;
        String concepts = evaluations.get(criterionName)

        System.out.println(concepts)

        String[] grades = concepts.split(" ")

        int lenght = grades.length
        System.out.println(lenght)
        for( int i = 0; i < lenght; i++ ){
            System.out.println(grades[i])
        }

        return ans;
    }
}
