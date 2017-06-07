package ta

class Matricula {
    Aluno aluno
    List avaliacoes
    Turma turma
    static hasMany = [avaliacoes:Avaliacao]
    static belongsTo = [turma:Turma]

    static constraints = {
        aluno unique: true
    }

    public Matricula(){
        this.avaliacoes = []
    }

    String toString() {
        return this.aluno.toString()
    }
}