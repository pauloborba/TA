package ta

class Class {
    String classID
    String periodo
    static constraints = {
        classID unique: false, blank: false, nullable: false
        periodo unique: false, blank: false, nullable: false
    }
}
