package support

import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor
import ta.EvaluationCriterion
import ta.Student

import static cucumber.api.groovy.Hooks.*

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()

    Student.list().each {
        it.delete(flush:true)
    }

    EvaluationCriterion.list().each {
        it.delete(flush:true)
    }

}

After () {
    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}