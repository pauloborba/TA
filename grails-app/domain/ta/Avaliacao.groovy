package ta

class Avaliacao {
    String nome
    List resultados
    static hasMany = [resultados:Resultado]

    static constraints = {
        nome unique: true
        nome inList :["Prova","Mini-prova","Formulário","Final","Segunda Chamada"], blank :false
    }

    public Avaliacao(){
        this.resultados = []
    }

    String toString() {
        return nome
    }
}