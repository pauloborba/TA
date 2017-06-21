package ta

class Resultado {
    Meta meta
    String conceito

    static constraints = {
        conceito inList :["MA","MPA","MANA","--"], blank :false
    }
}