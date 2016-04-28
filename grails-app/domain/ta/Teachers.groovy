package ta

class Teachers {

    String name
    String cpf

    static constraints = {
        name blank: false
        cpf black: false, unique: true
    }

}