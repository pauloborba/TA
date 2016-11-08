package support

import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor
import ta.Concept
import ta.ConceptController
import ta.Criterion
import ta.CriterionController
import ta.Evaluation
import ta.EvaluationConceptController
import ta.EvaluationsByCriterion
import ta.Student
import ta.EvaluationConcept

import static cucumber.api.groovy.Hooks.*
import ta.Report

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()


}

After () {
    cleanEnvironment()
    def eConcepts = EvaluationConcept.all
    for (c in eConcepts){
        def e = c.delete(flush: true)
        e
    }
    def concepts = Concept.all
    for(c in concepts){
        def e = c.delete(flush: true)
        e
    }
    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}

def void cleanEnvironment() {
    cleanList(Report.list())
    CriterionController criterionController = new CriterionController()
    Criterion.list().each { crit ->
        criterionController.delete(crit)
    }
    cleanList(EvaluationsByCriterion.list())
    cleanList(Student.list())

}

def cleanList(List l) {
    l.each { e ->
        e.delete(flush: true)
    }
}