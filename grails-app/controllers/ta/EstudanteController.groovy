package ta

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

        Turma turma = estudante.turma

        List metas  = turma.metas

        Classificacao classificacao
        metas.each{
            classificacao = Classificacao.getRandomWithMeta(it)
            estudante.addClassificacao(
                classificacao
            )
        }

        return estudante
    }
}
