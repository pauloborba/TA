package ta

class Meta {
    String nome

    static constraints = {
        nome unique: true, blank : false
    }
}