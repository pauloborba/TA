package ta

class Matricula {
    Aluno aluno
    Turma turma
    List avaliacoes

    static hasMany = [avaliacoes:Avaliacao]
    static belongsTo = [turma:Turma]

    static constraints = {
        aluno unique: true
    }

    public Matricula(){
        this.avaliacoes = []
    }

    String toString() {
        return aluno.toString()
    }
}
