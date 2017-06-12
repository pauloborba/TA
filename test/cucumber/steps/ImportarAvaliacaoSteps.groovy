package steps

import cucumber.api.PendingException
import ta.Aluno
import ta.AlunoController
import ta.MetaController
import ta.PlanilhaAvaliacao
import ta.PlanilhaFactory

import java.text.SimpleDateFormat

/**
 * Created by Isaac Douglas on 28/05/17.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


String path = null
String origemAvaliacao = null
String metaGlobal = null

Given(~/^existe uma planilha "([^"]*)" com os conceitos da meta "([^"]*)" de um "([^"]*)"$/) { String pathPlanilha, String meta, String origem ->

    //existe uma planilha
    File file =  new File(pathPlanilha)
    assert file.exists() // se nao existir o arquivo sai do teste
    path = pathPlanilha
    origemAvaliacao = origem

    //cria uma meta no sistema com o nome da meta
    MetaController controladorMeta = new MetaController()
    controladorMeta.salvar(meta)

    //verifica se a meta foi criada
    assert controladorMeta.metaExiste(meta) // se a meta nao existe no sistema sai do teste

    //verifica se na planilha existe os conceitos da meta
    PlanilhaAvaliacao avaliacoes = PlanilhaFactory.getPlanilha(path, "avaliacao")
    assert avaliacoes.metaExiste(meta) // se nao exister o conceito na planilha sai do teste

    //Criando estudantes no sistema com os logins da planilha
    def logins = avaliacoes.logins
    AlunoController alunoController = new AlunoController()
    for(int i=0; i< logins.size(); i++) {
        alunoController.params << [nome: logins.get(i), loginCin: logins.get(i), loginSlack: logins.get(i), loginGitHub: logins.get(i)]
        alunoController.save flush: true
        assert alunoController.alunoExiste(logins.get(i)) //sai do teste se nao conseguir criar o estudante
    }

    def bla = Aluno.list()

    for (int i=0; i<bla.size(); i++ ){
        println(bla.get(i).nome+" "+bla.get(i).loginCin)
    }

}
And(~/^o aluno "([^"]*)" tem o conceito "([^"]*)"$/) { String aluno, String conceito ->

    //verificando se o aluno tem mesmo aquele conceito na planilha
    PlanilhaAvaliacao avaliacoes = PlanilhaFactory.getPlanilha(path, "avaliacao")

    def indexMeta = 0
    def titulos = avaliacoes.getTitulosPlanilha()

    for(int i=0; i<titulos.size(); i++){
        if(titulos.get(i).equalsIgnoreCase(metaGlobal)){
            indexMeta = i
        }
    }

    assert indexMeta != 0 // para o teste se nao existir a meta na planilha

    def existeAlunoConceito = false
    for(int i=1; i<avaliacoes.sizeLinha; i++){

        String login = avaliacoes.getLinha(i).get(0)
        String conceitoLogin = avaliacoes.getLinha(i).get(indexMeta)

        if(login.equalsIgnoreCase(aluno) && conceito.equalsIgnoreCase(conceitoLogin)){
            existeAlunoConceito = true
        }
    }
    assert existeAlunoConceito

}
When(~/^eu tento salvar as avaliações com os conceitos da meta "([^"]*)" do "([^"]*)"$/) { String meta, String origem ->


    //verifica se na planilha existe os conceitos da meta
    PlanilhaAvaliacao avaliacoes = PlanilhaFactory.getPlanilha(path, "avaliacao")


}
Then(~/^o aluno "([^"]*)" fica com o conceito "([^"]*)" na meta "([^"]*)"$/) { String login, String conceito, String meta ->



}


Given(~/^eu estou na pagina "([^"]*)"$/) { String arg1 ->


}
When(~/^eu salvo as avaliações da planilha "([^"]*)"$/) { String arg1 ->


}
Then(~/^eu consigo ver as avaliações salvas na pagina "([^"]*)"$/) { String arg1 ->


}



