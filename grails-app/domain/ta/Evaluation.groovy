package ta

/**
 * Created by Deyvson on 18/04/2015.
 */
class Evaluation {
    String title
    List<String> questions
    List<String> answers

    static constraints = {
        title blank: false

    }

    boolean addQuestion(String question, String answer){
        if(verifyQuestions(question, answer)){
            questions.add(question)
            answers.add(answer)
            return true
        }

        return false
    }

    boolean verifyQuestions(String question, String answer){
        if(question.equals("") || answer.equals("")) return false
        return true
    }

}
