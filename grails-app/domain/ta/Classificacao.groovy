package tav2

class Classificacao {
    Meta meta
    Nota nota

    static embedded = ["nota"]
    static constraints = {
        meta nullable: false
        nota nullable: false
    }

    String getDescricao(){
        return meta.descricao
    }
    String getValor(){
        return nota.toString()
    }

}
