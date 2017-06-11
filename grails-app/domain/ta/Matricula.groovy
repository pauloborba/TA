package ta

class Matricula {
    Aluno aluno
    List avaliacoes

    static belongsTo = [Aluno]
    static hasMany = [avaliacoes: Avaliacao]

    static constraints = {
        aluno unique: true
    }

    public Matricula() {
        this.avaliacoes = []
    }

    String toString() {
        return aluno.toString()
    }
}
