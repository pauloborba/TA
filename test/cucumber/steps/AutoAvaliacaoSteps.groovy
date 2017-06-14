import pages.AutoAvaliacaoFormPage
import ta.AutoAvaliacaoController
import ta.Estudante
import ta.Meta
import ta.Turma
/**
 * Created by pedrotorchio on 12/06/17.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def metas = []
Turma  turma
String login = ""
String nome  = ""


Given(~/^Existe uma turma "(.*?)" registrada AND Nesta turma estão registradas as metas "(.*?)" AND estudante "(.*?)" esta matriculado com o login "(.*?)" na turma$/) {
        String _turmaCod, String _metas, String alunoNome, String alunoLogin ->

                login = alunoLogin
                nome = alunoNome
                metas = []

                _metas
                    .split(", ")
                    .each{metas.add(Meta.findByDescricao(it))}

                turma = Turma.findByCod(_turmaCod)
                        assert turma
                        assert turma.metas.equals(metas)

                Estudante estudante = Estudante.findByLoginAndTurma(alunoLogin, turma)
                        assert estudante
                        assert estudante.nomeCompleto == alunoNome
}
When(~/^acao AutoAvaliacaoController:concluir recebe notas "(.*?)", referentes as metas da turma AND "(.*?)" copia para aluno$/) {
        String _notas, String copia ->

                def notas = _notas.split(", ")

                        assert notas.size() == metas.size()

                boolean mailme = copia == "com"

                def aval = [:]

                metas.eachWithIndex{it, i ->
                    aval[it.id] = notas[i]
                }

                AutoAvaliacaoController control = new AutoAvaliacaoController()
                control.concluir([
                        turma: turma.cod,
                        login: login,
                        nomeCompleto: nome,
                        copia: mailme
                ] + aval)
}
Then(~/^Servidor de email deve possuir (\d+) emails na fila de envio$/) { //

    int mailCount ->

        def emailService = appCtx.getBean ("emailService")

        assert mailCount == emailService.countEmailQueue()
}




// GUI

Given(~/^Existe uma turma "(.*?)" registrada AND Nesta turma estão registradas as metas "(.*?)" AND Eu, o estudante "(.*?)", estou matriculado com o login "(.*?)" na turma$/) {
        String _turmaCod, String _metas, String alunoNome, String alunoLogin ->

                login = alunoLogin
                nome = alunoNome
                metas = []

                _metas
                        .split(", ")
                        .each{metas.add(Meta.findByDescricao(it))}

                turma = Turma.findByCod(_turmaCod)
                assert turma
                assert turma.metas.equals(metas)

                Estudante estudante = Estudante.findByLoginAndTurma(alunoLogin, turma)
                assert estudante
                assert estudante.nomeCompleto == alunoNome

}
When(~/^Entro na pagina de auto avaliacao$/) { ->
        to AutoAvaliacaoFormPage, turma.cod, login
        at AutoAvaliacaoFormPage
}
Then(~/^Eu vejo um select de nota para cada meta$/) { ->

}
Given(~/^Existe uma turma "(.*?)" registrada AND Nesta turma estão registradas as metas "(.*?)" AND Eu, o estudante "(.*?)", estou matriculado com o login "(.*?)" na turma AND estou na pagina de auto avaliaco$/) { String arg1, String arg2, String arg3, String arg4 ->

}
When(~/^Altero as notas de "(.*?)" para "(.*?)" AND submeto formulario$/) { String arg1, String arg2 ->

}
Then(~/^Vejo pagina de confirmacao$/) { ->

}