package ta

class Meta {
    String nome

    static constraints = {
        nome unique: true, blank : false
    }

    Meta(String nome){
        this.nome = nome
    }

    String toString() {
        return nome
    }
}