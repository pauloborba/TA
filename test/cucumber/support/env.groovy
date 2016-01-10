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
    def students = Student.findAll();
    for( Student i : students ){
        i.delete(flush: true)
    }
    def criteria = EvaluationCriterion.findAll();
    for( EvaluationCriterion i : criteria ){
        i.delete(flush: true)
    }
//    Student.deleteAll(Student.findAll())
//    EvaluationCriterion.deleteAll(EvaluationCriterion.findAll())
}

After () {
    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}