package ta

class Class {

    String classID, periodo

    static constraints = {
        classID unique: false, blank: false, nullable: false
        periodo unique: false, blank: false, nullable: false
    }
}
