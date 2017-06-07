package ta

class Avaliacao {
    String nome
    List resultados
    static hasMany = [resultados:Resultado]

    static constraints = {
        nome unique: true , blank : false
    }

    public Avaliacao(){
        this.resultados = []
    }
}