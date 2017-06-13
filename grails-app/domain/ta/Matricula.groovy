package ta

class Matricula {
    Aluno aluno
    List avaliacoes
    Double media
    String aprovacao

    static hasMany = [avaliacoes:Avaliacao]
    static belongsTo = [turma:Turma]

    static constraints = {
        aluno unique: true
        media unique:true
        aprovacao inList :["AM","A","R","--"], blank :false
    }

    public Matricula(Aluno aluno1){
        this.aluno = aluno
    }
}