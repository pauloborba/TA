package ta

class Class {
    String classID
    String periodo
    List students
    static hasMany = [students: Student]

    static constraints = {
        classID unique: 'periodo', blank: false, nullable: false
        periodo unique: false, blank: false, nullable: false
    }

    public Class(String id, String periodo){
        this.classId = id
        this.periodo = periodo
        this.students = []
    }
}
