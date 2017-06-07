package support

import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor


import static cucumber.api.groovy.Hooks.*

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()
}

After () {
    cleanEnvironment()
    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}

def void cleanEnvironment() {
    /*
    cleanList(Report.list())

    CriterionController criterionController = new CriterionController()
    Criterion.list().each { crit ->
        criterionController.delete(crit)
    }
    cleanList(EvaluationsByCriterion.list())
    cleanList(Aluno.list())
    */
}

def cleanList(List l) {
    l.each { e ->
        e.delete(flush: true)
    }
}