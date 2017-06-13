package tav2

import grails.converters.JSON

class TurmaController {
    static scaffold = Turma

    def show() {
        Turma turma = Turma.findById(params.id)
        def turmas = Turma.findAll() - [turma]

        render(view: "/turma/show.gsp", model: [turma: turma, turmas: turmas])
    }
    def edit() {
        Turma turma = Turma.findById(params.id)
        def turmas = Turma.findAll() - [turma]

        render(view: "/turma/edit.gsp", model: [turma: turma, turmas: turmas])
    }

    def appendMetasRequest(){
        if(!appendMetas(params))
            render "NOT!"
        else
            render "OK!"
    }
    /**
     *
     *
     * (params), onde
     * String params.turma, codigo da turma
     * String params.metas[], lista de ids de metas
     *
     * @return void
     */
    boolean appendMetas(_params) {

        if (!_params["metas[]"])
            return false

        Turma turma = Turma.findByCod(_params.turma)
        def metas = _params["metas[]"]
        metas.each {
            Meta incoming = Meta.findById(it)
            addMetaIfNotExists(incoming, turma)
        }
        turma.save(flush: true)

        return true
    }

    boolean addMetaIfNotExists(Meta incoming, Turma turma) {
        Meta existing = turma.metas.find {
            ((Meta)it).descricao == incoming.descricao
        }
        if (!existing)
            turma.addMeta(incoming)

        else return false

        return true
    }

}
