import javafx.beans.binding.When
import org.spockframework.compiler.model.ThenBlock

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
    String id, periodo ->
}
When(~'^I add a class with ID "[(^")*]" and periodo "[(^")*]"$'){
    Strring id, periodo ->
}
Then(~'^the class "[(^")*]" with periodo "[(^")*]" is properly stored in the system$'){
    String id, periodo ->
}

/*
#Controller scenario
Scenario: new class with duplicate ID and periodo
Given the system already has a class with ID "GDI" and periodo "2016.1"
When I add a class with ID "GDI" and periodo "2016.1"
Then the class "GDI" with periodo "2016.1" is not stored twice in the system
*/

Given(~'^the system already has a class with ID "[(^")*]" and periodo "[(^")*]"$'){
    String id, periodo ->
}
When(~'^$I add a class with ID "[(^")*]" and periodo "[(^")*]"'){
    String id, periodo ->
}
Then(~'^$the class "[(^")*]" with periodo "[(^")*]" is not stored twice in the system'){
    String id, periodo ->
}

/*
#GUI scenario
Scenario: new class
Given I am at the "Turmas" page
When I select the "Adicionar" option
And fill the class details with name "ESS", periodo "2016.2"
And I save the class
Then I can see a confirmation message
And I can see the information for class "ESS" at the "Turmas" page
*/

Given(~'^I am at the "[(^")*]" page$'){
    String page ->
}
When(~'^I select the "[(^")*]" option$'){
    String option ->
}
And(~'^fill the class details with name "[(^")*]", periodo "[(^")*]"$'){
    String id, periodo ->
}
And(~'^I save the class$'){
    ->
}
Then(~'^I can see a confirmation message$'){
    ->
}
And(~'^I can see the information for class "[(^")*]" at the "[(^")*]" page$'){
    String id, page ->
}

/*
#GUI scenario
Scenario: new class with duplicate ID and periodo
Given the system already has a class with name "GDI" and periodo "2016.1"
And I am at the "Turmas" page
When I select the "Adicionar" option
And fill the class details with name "GDI" and periodo "2016.1"
And I save the class
Then I see an error message
And I am taken to the "Turmas" page where class "GDI" is not listed twice
*/

Given(~'^the system already has a class with name "[(^")*]" and periodo "[(^")*]"$'){
    String id, periodo ->
}
And(~'^I am at the "[(^")*]" page$'){
    String page ->
}
When(~'^I select the "[(^")*]" option$'){
    String option ->
}
And(~'^fill the class details with name "[(^")*]" and periodo "[(^")*]"'){
    String id, periodo ->
}
And(~'^I save the class$'){
    ->
}
Then(~'^I see an error message$'){
    ->
}
And(~'^I am taken to the "[(^")*]" page where class "[(^")*]" is not listed twice$'){
    String page, id ->
}