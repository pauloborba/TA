import javafx.beans.binding.When
import org.spockframework.compiler.model.ThenBlock
import pages.ClassPages.CreateClassPage
import pages.ClassPages.TurmasPage
import steps.ClassTestDataAndOperations

/**
 * Created by dquei on 9/28/2016.
 */


/*
#Controller scenario
Scenario: new class
Given the system has no class named "ESS" and periodo "2016.2"
When I add a class with ID "ESS" and periodo "2016.2"
Then the class "ESS" with periodo "2016.2" is properly stored in the system
*/

Given(~'^the system has no class named "[(^")*]" and periodo "[(^")*]"$'){
    String id, String periodo ->
        assert ClassTestDataAndOperations.get_Class(id, periodo) == null

}
When(~'^I add a class with ID "[(^")*]" and periodo "[(^")*]"$'){
    String id, String periodo ->
        ClassTestDataAndOperations.createClass(id, periodo)
        cl = ClassTestDataAndOperations.get_Class(id, periodo)
}
Then(~'^the class "[(^")*]" with periodo "[(^")*]" is properly stored in the system$'){
    String id, periodo ->
        assert ClassTestDataAndOperations.compatibleTo(id, periodo, cl)
}

/*
#Controller scenario
Scenario: new class with duplicate ID and periodo
Given the system already has a class with ID "GDI" and periodo "2016.1"
When I add a class with ID "GDI" and periodo "2016.1"
Then the class "GDI" with periodo "2016.1" is not stored twice in the system
*/

Given(~'^the system already has a class with ID "[(^")*]" and periodo "[(^")*]"$'){
    String id, String periodo ->
        assert ClassTestDataAndOperations.get_Class(id, periodo) != null
}
When(~'^$I add a class with ID "[(^")*]" and periodo "[(^")*]"'){
    String id, String periodo ->
        ClassTestDataAndOperations.createClass(id, periodo)
        cl = ClassTestDataAndOperations.get_Class(id, periodo)
}
Then(~'^$the class "[(^")*]" with periodo "[(^")*]" is not stored twice in the system'){
    String id, periodo ->
        assert !ClassTestDataAndOperations.compatibleTo(id, periodo, cl)
}

/*
#GUI scenario
Scenario: new class
Given I am at the Create Class page
When I fill the class details with name "ESS", periodo "2016.2"
And I save the class
Then I can see a confirmation message
And I can see the information for class "ESS", periodo "2016.2" at the Turmas page

*/

Given(~'^I am at the Create Class page$'){
    String page ->
        to TurmasPage
        at TurmasPage

}
When(~'I fill the class details with name "[(^")*]", periodo "[(^")*]" ') {
    String id, String periodo ->
        at TurmasPage
        page.fillClassDetails(id, periodo)

}
And(~'^I save the class$'){
    ->
    at CreateClassPage
    page.selectCreateClass()
}
Then(~'^I can see a confirmation message$'){
    ->
    at CreateClassPage
}
And(~'^I can see the information for class "[(^")*]", periodo "[(^")*]" at the Turmas page$'){
    String id, String periodo ->
        to TurmasPage
        at TurmasPage
        page.assertClass(id, periodo)
}

/*
#GUI scenario
 Given the system already has a class with name "GDI" and periodo "2016.1"
 And I am at the Create Class page
 When I fill the class details with name "GDI" and periodo "2016.1"
 And I save the class
 Then I see an error message
  And I am taken to the Turmas page where class "GDI", periodo "2016.1" is not listed twice

*/

Given(~'^the system already has a class with name "[(^")*]" and periodo "[(^")*]"$'){
    String id, String periodo ->
        to CreateClassPage
        at CreateClassPage
        page.fillClassDetails(id, periodo)
}
And(~'^I am at the Create Class page$'){
    String page ->
        to CreateClassPage
        at CreateClassPage
}
When(~'^I fill the class details with name "[(^")*]" and periodo "[(^")*]"'){
    String id, String periodo ->
        at CreateClassPage
        page.fillClassDetails(id, periodo)
}
And(~'^I save the class$'){
    ->
    at CreateClassPage
    page.selectCreateClass()
}
Then(~'^I see an error message$'){
    ->
    at CreateClassPage
    page.checkErrors()
}
And(~'^I am taken to the Turmas page where class "[(^")*]", periodo "[(^")*]" is not listed twice$'){
    String id, String periodo ->
        to TurmasPage
        at TurmasPage
        page.assertNotDuplicateClass(id, periodo)
}