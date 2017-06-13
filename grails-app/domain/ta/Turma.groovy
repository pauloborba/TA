package ta

class Turma {
    String nome
    List matriculas
    List metas
    static hasMany = [matriculas:Matricula, metas:Meta]

    static constraints = {
        nome unique : true , blank : false
    }

    public Turma(String nome){
        this.nome = nome
    }
}