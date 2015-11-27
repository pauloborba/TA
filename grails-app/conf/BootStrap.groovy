import ta.EvaluationCriterion
import ta.Student

class BootStrap {

    def init = { servletContext ->
//
        Student pp2 = new Student(login:"pp2", name:"Peter Parker").save(failOnError: true)
//        Student psg2 =  new Student(login:"psg2", name:"Pedro Sereno").save(failOnError: true)
//        Student gaabs = new Student(login:"gaabs", name:"Giovanni Barros").save(failOnError: true)
//        Student cjvg = new Student(login:"cjvg", name:"Caio Jose").save(failOnError: true)
//
        EvaluationCriterion criterion = new EvaluationCriterion(name:"Requirements").save(failOnError: true)
        EvaluationCriterion criterion2 = new EvaluationCriterion(name:"Refactor").save(failOnError: true)
        EvaluationCriterion criterion3 = new EvaluationCriterion(name:"Tests").save(failOnError: true)
//
        pp2.addCriterion(criterion)
        pp2.addCriterion(criterion2)
        pp2.addCriterion(criterion3)
//
//        psg2.addCriterion(criterion)
//        psg2.addCriterion(criterion2)
//        psg2.addCriterion(criterion3)
//
//        gaabs.addCriterion(criterion)
//        gaabs.addCriterion(criterion2)
//        gaabs.addCriterion(criterion3)
//
//        cjvg.addCriterion(criterion)
//        cjvg.addCriterion(criterion2)
//        cjvg.addCriterion(criterion3)
        pp2.autoEvaluations.put(criterion.name, "MA")
    }
    def destroy = {
    }
}
