package ta

class Resultado {
    Meta meta
    String conceito
    Avaliacao avaliacao

    static belongsTo = [avaliacao:Avaliacao]

    static constraints = {
        conceito inList :["MA","MPA","MANA","--"], blank :false
    }
}