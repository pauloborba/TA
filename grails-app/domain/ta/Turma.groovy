package ta

class Turma {
    String nome
    List matriculas
    List metas
    static hasMany = [matriculas:Matricula, metas:Meta]

    static constraints = {
        nome unique : true , blank : false
    }

    public Turma(){
        this.matriculas = []
        this.metas = []
    }

    Turma(String nome) {
        this.nome = nome
        this.matriculas = []
        this.metas = []
    }

    String toString() {
        return nome
    }
}