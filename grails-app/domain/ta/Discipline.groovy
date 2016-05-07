package ta

class Discipline {

    String name;
    String teacher;
    String concepts;

    static constraints = {
        name unique: true
    }
}