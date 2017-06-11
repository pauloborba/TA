package ta

class Avaliacao {
    String nome
    List resultados
    Meta meta
    String conceito
    Turma turma

    static hasMany = [resultados: Resultado]
    static belongsTo = [meta: Meta, turma: Turma]

    static constraints = {
        nome unique: true
        nome inList: ["Prova", "Mini-prova", "Formulário", "Final", "Segunda Chamada"], blank: false
        conceito inList :["MA","MPA","MANA","--"], blank :false
    }

    public Avaliacao() {
        this.resultados = []
    }

    String toString() {
        return nome
    }
}