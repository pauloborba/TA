package ta

class Avaliacao {
    String nome
    String tipo
    List resultados

    static hasMany = [resultados:Resultado]

    static constraints = {
        tipo nullable: true, blank : true
        //tipo inList :["Prova","Mini-prova","Questionário","Final","Segunda Chamada"], blank :false
    }

    public Avaliacao(){
        this.resultados=[]
    }
}