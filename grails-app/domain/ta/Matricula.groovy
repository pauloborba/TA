package ta

class Matricula {
    String id
    Aluno aluno
    List avaliacoes
    Double media
    String aprovacao

    static hasMany = [avaliacoes:Avaliacao]
    static belongsTo = [turma:Turma]

    static constraints = {
        aluno unique: true
        media unique:true, nullable: true
        aprovacao inList :["AM","A","R","--"], blank :false, nullable: true
    }

    public Matricula(String id){
        this.id = id
        this.aprovacao = "--"
    }
}