package tav2

import grails.converters.JSON

class EstudanteController {
    static scaffold = Estudante

    def save() {
        Estudante estudante = newRandomEstudante(params)

        redirect action: "index", estudante: estudante
    }
    def show = {
        def estudante = Estudante.get(params.id)
        [estudante: estudante]
    }

    static Estudante newRandomEstudante(params){
        Estudante estudante = new Estudante(params)
        estudante = randomizeEstudante(estudante)
        estudante.save(flush:true)
        return estudante
    }
    static Estudante randomizeEstudante(Estudante estudante){

        Turma turma = Turma.findByCod(estudante.turma.cod)

        List metas  = turma.metas

        Classificacao classificacao
        metas.each{
            classificacao = new Classificacao(
                    meta: it,
                    nota: Nota.getRandom()
            )
            classificacao.save(flush: true)
            estudante.addClassificacao(
                classificacao
            )
        }

        return estudante
    }
}
