package ta

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
    static Classificacao getRandomWithMeta(Meta it){
        Classificacao rand = new Classificacao(
                meta: it,
                nota: Nota.getRandom()
        )
        rand.save(flush: true)

        return rand
    }

}
