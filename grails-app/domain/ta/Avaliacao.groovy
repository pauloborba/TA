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
//        nome unique: true
        nome inList: ["Prova", "Mini-prova", "Formulário", "Final", "Segunda Chamada"], blank: false
        conceito inList :["MA","MPA","MANA","--"], blank :false
    }

    public Avaliacao(String nome, String meta, String conceito, String idTurma) {
        this.nome = nome
        this.meta = Meta.findByNome(meta)
        this.conceito = conceito
        this.turma = Turma.findById(Long.parseLong(idTurma))
        this.resultados = []
    }

    public Avaliacao(){
        this.resultados = []
    }

    String toString() {
        return nome
    }
}