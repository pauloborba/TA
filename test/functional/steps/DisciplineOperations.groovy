
package steps

import ta.Discipline
import ta.DisciplineController

class DisciplineOperations {

    public static boolean createDiscipline(String name, String teacher, String[] concepts){
        def cont = new DisciplineController()
        cont.params << [name: name] << [teacher: teacher] << [concepts: concepts]
        boolean saved = cont.saveDiscipline(cont.createDiscipline())
        cont.response.reset()
        return saved
    }
}