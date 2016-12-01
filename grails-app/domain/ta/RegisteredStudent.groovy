package ta

class RegisteredStudent {

    Student student
    static hasMany = [criteriaAndEvaluations:EvaluationsByCriterion]
    static belongsTo = [turma: Turma]

    static constraints = {
    }

    public RegisterdStudent(Student std){
        student.name = std.name;
        student.login = std.login;
        this.criteriaAndEvaluations = [];
        this.turma = [];
    }
}
