package ta

class Score {
    String value
    Student student
    Evaluation evaluation

    static belongsTo = [evaluation: Evaluation]

    static constraints = {
        value blank : false, unique: false
        student unique : 'evaluation', blank:false
    }

    public Score(String value, String studentId, String evaluationId){
        this.value = value
        this.student = Student.findById(studentId)
        this.evaluation = Evaluation.findById(evaluationId)
    }
}
