package steps

import ta.Criterion
import ta.CriterionController

/**
 * Created by lapp on 07/05/2016.
 */

class CriterionTestDataAndOperations {

    public static void createCriterion(String description, String turma) {
        def controller = new CriterionController()
        controller.params << [description: description, turma:turma]
        controller.createAndSaveCriterion()
        controller.response.reset()
    }

    public static void removeCriterion(Criterion criterionInstance) {
        CriterionController cc = new CriterionController()
        cc.delete(criterionInstance)
        cc.response.reset()
    }

    public static boolean compatibleTo(String desc, Criterion crit) {
        if (desc.equals(crit.description)) return true
        return false
    }

    public static boolean compatibleInCriteria(String desc, String turma) {
        def controller = new CriterionController()
        controller.params << [description: desc, turma:turma]
        return controller.compatibleInCriteria()
    }

    public static Criterion getCriterion(String desc, String turma) {
        def controller = new CriterionController()
        controller.params << [description: desc, turma:turma]
        return controller.retrieveCriterion()
    }

    public static Criterion retrieveCriterion(String description){
        Criterion crit = Criterion.findByDescription(description)
        return crit
    }

    public static void createGroupCriteria(String descriptionGroup, String turma){
        def controller = new CriterionController()
        controller.params << [description: descriptionGroup, turma:turma]
        controller.saveGroup()
        controller.response.reset()
    }

    public static int checkNumbersDescription(String description){
        return Criterion.findAllByDescription(description).size()
    }

    public static int countCriteria(){
        return Criterion.list().size()
    }
}