package ta

class Turma {

    String classID
    String periodo
    List students
    static hasMany = [students: Student]

    static constraints = {
        classID unique: 'periodo', blank: false, nullable: false
        periodo unique: false, blank: false, nullable: false
    }

    public Turma(String id, String periodo) {

        this.classID = id
        this.periodo = periodo
        this.students = []

    }
}

