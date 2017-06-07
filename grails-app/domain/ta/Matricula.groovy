package ta

class Matricula {
    Aluno aluno
    List avaliacoes
    static hasMany = [avaliacoes:Avaliacao]

    static constraints = {
        aluno unique: true
    }

    public Matricula(){
        this.avaliacoes = []
    }
}