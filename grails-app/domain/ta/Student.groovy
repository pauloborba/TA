package ta

class Student {
    String login
    String name
    String password

    // tentei um enumerador primeiro mas da erro
    static class Concept {
        public static final List<String> CONCEPTS = ["MA", "MPA", "MANA"]
    }

    Map<String, String> evaluations
    Map<String, String> autoEvaluations
    Map<String, String> finalGrades
    int crispGrade //Esta vai ser a nota de 0 a 10 do aluno

    static constraints = {
        login unique: true
        name blank: false
        password nullable:true, blank:true
    }

    def initialize(){
        if ( evaluations == null ){
            evaluations = new HashMap<>()
            autoEvaluations = new HashMap<>()
            finalGrades = new HashMap<>()
            crispGrade = -1
        }
    }

    public void afterCreateAddCriteria(List<EvaluationCriterion> evaluationCriteria) {
        initialize()
        evaluations = new HashMap<>()
        finalGrades = new HashMap<>()
        crispGrade = -1

        for(EvaluationCriterion evaluationCriterion : evaluationCriteria) {
            addCriterion(evaluationCriterion.name)
        }
    }


    public void addCriterion(String name) {
        initialize()
        if(this.evaluations.get(name) == null) {
            this.autoEvaluations.put(name, "")
            this.evaluations.put(name, "")
            this.finalGrades.put(name, "")
        }

    }
        public void addCriterion(EvaluationCriterion evaluationCriterion) {
            if (evaluations == null) {
                evaluations = new HashMap<>()
                finalGrades = new HashMap<>()
                crispGrade = -1

            }
        }
    def removeCriterion(String criterionName){
        if(this.evaluations.get(criterionName) != null) {
            evaluations.remove(criterionName)
            autoEvaluations.remove(criterionName)
            finalGrades.remove(criterionName)
        }
    }

    /*
    - a “média” é MA se o conceito adicionado é MA e se tiver no máximo um MANA/MPA nos conceitos anteriores
    - a “média” é MPA se o conceito adicionado é MA e se tiver mais de um MANA/MPA nos conceitos anteriores
    - a “média” é MPA se o conceito adicionado é MPA e se tiver no máximo um MANA nos conceitos anteriores
    - a “média” é MANA caso contrário
     */
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
    

    /*Este m�todo calcula a nota final com um valor de 0 a 10, retornando -1
    se não for possível calcular. Tal valor ser� validado posteriormente para
    que se saiba o que ser� impresso na média geral*/

    /*Este método calcula a nota final com um valor de 0 a 10, retornando -1
    se não for possível calcular. Tal valor será validado posteriormente para
    que se saiba o que será impresso na média geral*/

    public void calculateCrispGrade(HashMap fuzzyGrades){
	    if(!fuzzyGrades.containsValue("")){
		    String[] concepts = fuzzyGrades.values().toArray()
		    int ma = 0
		    int mpa = 0
		    int mana = 0

		    for(int i = 0; i < concepts.size(); i++){
    			if(concepts[i] == "MA"){
	    			ma = ma + 1
			    }else if(concepts[i] == "MPA"){
			    	mpa = mpa + 1
			    }else{
				    mana = mana + 1
			    }
		    }

		    float percMA = ((100 * ma)/fuzzyGrades.size())
		    float percMPA = ((100 * mpa)/fuzzyGrades.size())
		    float percMANA = ((100 * mana)/fuzzyGrades.size())

		    if(percMana == 0 && percMa >= 90){
    			crispGrade = 10
		    }else if(percMANA == 0 && percMA >= 70){
		    	crispGrade = 9
		    }else if(percMANA == 0 && percMA >= 50){
			    crispGrade = 8
		    }else if(percMANA == 0){
			    crispGrade = 7
		    }else if(percMANA <= 10){
			    crispGrade = 6
		    }else if(percMANA <= 30){
			    crispGrade = 5
		    }else if(percMANA <= 50){
			    crispGrade = 4
		    }else if(percMANA <= 70){
			    crispGrade = 3
		    }else if(percMANA <= 80){
			    crispGrade = 2
		    }else if(percMANA <= 90){
			    crispGrade = 1
		    }else{
			    crispGrade = 0
		    }
        }else{
            crispGrade = -1
        }
    }
}
