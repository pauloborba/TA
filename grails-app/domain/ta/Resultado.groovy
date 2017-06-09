package ta

class Resultado {
    Meta meta
    String conceito

    static constraints = {
        conceito unique: true
        conceito inList :["MA","MPA","MANA","--"], blank :false
    }

    String toString() {
        meta.toString()
    }
}