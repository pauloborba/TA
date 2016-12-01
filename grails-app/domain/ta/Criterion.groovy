package ta

class Criterion {
    String description

    Turma turma
    static constraints = {
        description unique: 'turma', blank: false, nullable: false

    }

    public Criterion(String description, String turma){
        this.description = description
        this.turma = Turma.findById(Long.parseLong(turma))
    }

    public Criterion(String description, String classID, String periodo){
        this.description = description
        this.turma = Turma.findByClassIDAndPeriodo(classID, periodo)
        assert turma != null
    }
}
