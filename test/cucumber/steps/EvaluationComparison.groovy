package steps

import pages.EvaluationComparisonPage
import ta.Evaluation
import ta.EvaluationController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)



/*
Given the student "X" appear in the list of student that sent their auto-Evaluation
When I select the compare grades option
And choose to compare student "X" grades
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen.
*/

Given (~'^Given the student "([^"]*)" appear in the list of student that sent their auto-Evaluation$'){
    String text ->



}

When (~'^I select the compare grades option$') { ->

        at EvaluationComparisonPage
        page.click()
}

And (~'^choose to compare student "([^"]*)" grades$'){
    String text->


}

/*
Given the student "X" don't appear in the list of student that sent their auto-Evaluation
When I select the compare grades option
And choose to compare student "X" grades
Then I can see a error message with a go-back button to go to the main page.
*/

/*
Given Student "X"’s Auto-Evaluation is on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns a detailed table with both student and the professor grades.
*/

/*
Given Student "X"’s Auto-Evaluation isn’t on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns an exception.
*/