/*package steps

import ta.StudentController
import ta.Student

def stLogin
def critName

  @ignore
  Given(~'^that student "([^"]*)" whose login is "([^"]*)" has no grades for criterion "([^"]*)"$') { String name, login, criterion ->
    stLogin = login
    critName = criterion
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criterion)
    assert EvaluateStudentTestDataAndOperations.getConceptsLength(login, criterion) == 0
  @ignore
  And(~'^"([^"]*)" for remaining criteria$') { String concept ->
    A ideia deste passo é iterar pelo HashMap de notas e colocar ao menos um conceito em cada uma, mas
    não soube escrever isto em código
    O nome do critério pego na iteração seria salvo com String criterionName = entry.getKey()
    Em seguida, o conceito seria atualizado com EvaluateStudentTestDataAndOperations.updateConcept(stLogin, critName, concept)
  @ignore
  When(~'^I add "([^"]*)" to criterion "([^"]*)"$') { String concept, criterion ->
    EvaluateStudentTestDataAndOperations.updateConcept(stLogin, criterion, concept)
  @ignore
  Then(~'^the final grade is calculated$') { ->
    A ideia deste passo é confirmar se a nota final, calculada pelo método de Student "calculateCrispGrade" e salva
    no atributo crispGrade, também de Student, é diferente de -1 (flag de erro)

  @ignore
  Given(~'^that student "([^"]*)" whose login is "([^"]*)" has "([^"]*)" for criterion "([^"]*)"$') { String name, login, concept, criterion ->
    stLogin = login
    critName = criterion
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criterion)
    assert EvaluateStudentTestDataAndOperations.updateConcept(stLogin, criterion, concept)
  @ignore
  And(~'^"([^"]*)" for remaining criteria$') { String concept ->
    A ideia deste passo é iterar pelo HashMap de notas e colocar ao menos um conceito em cada uma, mas
    não soube escrever isto em código
    O nome do critério pego na iteração seria salvo com String criterionName = entry.getKey()
    Em seguida, o conceito seria atualizado com EvaluateStudentTestDataAndOperations.updateConcept(stLogin, critName, concept)
  @ignore
  When(~'^I add "([^"]*)" to criterion "([^"]*)"$') { String concept, criterion ->
    EvaluateStudentTestDataAndOperations.updateConcept(stLogin, criterion, concept)
  Then(~the final grade is updated) { ->
    A ideia deste passo é confirmar se a nota final, calculada pelo método de Student "calculateCrispGrade" e salva
    no atributo crispGrade, também de Student, é diferente de -1 (flag de erro)
  
  @ignore
  Given(~'^that student "([^"]*)" whose login is "([^"]*)" does not have a grade for criterion "([^"]*)"$') { String name, login, criterion ->
    stLogin = login
    critName = criterion
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criterion)
    assert EvaluateStudentTestDataAndOperations.getConceptsLength(login, criterion) == 0
  @ignore
  When(~'^I add "([^"]*)" to criterion "([^"]*)"$') { String concept, criterion ->
    assert !criterion.equals(critName)
    EvaluateStudentTestDataAndOperations.updateConcept(stLogin, criterion, concept)
  @ignore
  Then(~'^the system returns an error flag$') { ->
    A ideia deste passo é confirmar se a nota final, calculada pelo método de Student "calculateCrispGrade" e salva
    no atributo crispGrade, também de Student, é igual a -1 (flag de erro)
  
  @ignore
  Given(~'^that student "([^"]*)" whose login is "([^"]*)" has "([^"]*)" for all criteria$') { String name, login, concept ->
    stLogin = login
    critName = criterion
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
    
    Esta parte seguinte consiste em iterar pelo HashMap de critérios colocando um conceito em cada um
  @ignore
  And(~'^the Final Grade has already been calculated$') { ->
    A ideia deste passo é confirmar se a nota final, calculada pelo método de Student "calculateCrispGrade" e salva
    no atributo crispGrade, também de Student, é diferente de -1 (flag de erro)
  @ignore
  When(~'^I add to criterion "([^"]*)" to the list of criterions$') { String criterionName ->
    EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criterionName)
  Then(~'^the system returns an error flag$') { ->
    A ideia deste passo é confirmar se a nota final, calculada pelo método de Student "calculateCrispGrade" e salva
    no atributo crispGrade, também de Student, é igual a -1 (flag de erro)
  */
