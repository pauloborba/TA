package steps

import pages.EvaluationComparisonPage
import pages.ShowComparisonPage
import pages.StudentPages.StudentPage
import ta.Student
import ta.StudentController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


/*
Given the student "X" appear in the list of student that sent their auto-Evaluation
When I select the compare grades option
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen.
*/

Given (~'^The student with the login "([^"]*)" appear in the list of student that sent their auto-Evaluation$'){
    String login ->
        student = new StudentController()
        assert student.sentAuto(login)

}

When (~'^choose to compare student "([^"]*)" grades$') {
    String text->
        at StudentPage
        page.choose()
}

Then (~'^I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen$'){->
    at ShowComparisonPage
}

/*
Given the student "X" don't appear in the list of student that sent their auto-Evaluation
When I select the compare grades option
And choose to compare student "X" grades
Then I can see a error message with a go-back button to go to the main page.
*/

Given (~'^The student "([^"]*)" don`t appear in the list of student that sent their auto-Evaluation$'){
    String login ->
        student = new StudentController()
        assert !student.sentAuto(login)

}


Then (~'^I should stay in Evaluation Comparision page$'){->
    at EvaluationComparisonPage
}

/*
Given Student "X"�s Auto-Evaluation is on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns a detailed table with both student and the professor grades.
*/

Given (~'^The student "([^"]*)"`s Auto-Evaluation is on the database$'){
    String text ->
        assert Student.findByName(text).AutoEvaluations!=null

}

When (~'^the system requires the  Evaluation -> Auto-evaluation comparison$') {
    ->
        studentX = new StudentController()
        //studentX send his auto Evaluation and his Evaluation info to the show comparision page
}

Then (~'^the system returns a detailed table with both student and the professor grades$'){->
    //check steps
}


/*
Given Student "X"�s Auto-Evaluation isn�t on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns an exception.
*/

Given (~'^The student "([^"]*)"`s Auto-Evaluation isn`t on the database$'){
    String text ->
        assert Student.findByName(text).AutoEvaluations==null

}

Then (~'^the system returns an exception$'){->
    //check steps

}
