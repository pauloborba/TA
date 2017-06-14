
import ta.TurmaController
import ta.Meta
import ta.Turma

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Turma turma = null
def metas = []

Given(~/^Existe uma turma "(.*?)" registrada com as metas "(.*?)"$/) {
    String turmaCod, String _metas ->

        metas = []

        // Lista de metas
        _metas
            .split(", ")
            .each{metas.add(Meta.findByDescricao(it))}

        // Turma
        turma = Turma.findByCod(turmaCod)
            assert turma
            assert turma.metas.equals(metas)

}
When(~/^acao TurmaController:appendMetas recebe metas "(.*?)" para essa turma$/) {
    String _newMetas ->

        def newMetasId = []
        _newMetas
            .split(", ")
            .each{newMetasId.add(Meta.findByDescricao(it).id)}

        TurmaController control = new TurmaController()

        def parameters = [:]
        parameters["turmaCod"] = turma.cod
        parameters["metas[]"]  = newMetasId

        control.appendMetas(parameters)
}
Then(~/^turma deve possuir (\d+) metas$/) {
    int newMetasCount ->

        assert turma.metas.size() == newMetasCount
}

// GUI


