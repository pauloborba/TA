package ta

class Meta {
    String descricao

    static constraints = {
        descricao unique: true, blank: false
    }
    static belongsTo = Turma
    String toString(){
        return descricao
    }
}
