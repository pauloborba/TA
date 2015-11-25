package steps

import ta.EvaluationCriterion
import ta.EvaluationCriterionController
import ta.Student
import ta.StudentController

class EvaluateStudentTestDataAndOperations{

    public static boolean createEvaluationCriterion(String name){
        def cont = new EvaluationCriterionController()
        cont.params << [name: name]
        boolean saved = cont.saveEvaluationCriterion(cont.createEvaluationCriterion())
        cont.response.reset()
        return saved
    }

    public static boolean createStudent(String login, String name){
        def cont = new StudentController()
        cont.params << [login: login] << [name: name] << [evaluations: new HashMap<String, String>()]
        boolean saved = cont.saveStudent(cont.createStudent())
        cont.response.reset()
        return saved
    }

    public static int getConceptsLength(String login, String criterion){
        return Student.findByLogin(login).getEvaluations().get(criterion).length()
    }

    public static String getFinalGrade(String login, String criterion) {
        return Student.findByLogin(login).getFinalGrades().get(criterion)
    }

    public static void updateConcept(String login, String criterion, String concept){
        String studentCriterion = login+" / "+criterion
        new StudentController().updateConcepts(studentCriterion, concept)
    }

    public static boolean checkConceptUpdate(String login, String criterion, String concept, int oldLenght){
        Student student = Student.findByLogin(login)
        String[] concepts = student.getEvaluations().get(criterion).split(" ")
        int size = concepts.length;

        boolean ans = false;
        if ( size > oldLenght && concept.equals(concepts[size-1]) )
            ans = true

        return ans
    }
}
