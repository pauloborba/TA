
import ta.*

/**
 * Created by pedrotorchio on 12/06/17.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)



Given(~/^gerar bd via bootstrapper$/) { ->

}
When(~/^executo$/) { ->
    BootStrapper.boot()
}
Then(~/^Deve-se encontrar (\d+) metas, (\d+) turmas e (\d+) estudantes/) { int arg1, int arg2, int arg3 ->
    assert Meta.findAll().size() == arg1
    assert Turma.findAll().size() == arg2
    assert Estudante.findAll().size() == arg3
}