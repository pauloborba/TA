package steps

import pages.EvaluationComparisonPage
import pages.ShowComparisonPage
import ta.Student
import ta.StudentController




/*
Given the student "X" appear in the list of student that sent their auto-Evaluation
When I select the compare grades option
And choose to compare student "X" grades
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen.
*/

Given (~'^Given the student "([^"]*)" appear in the list of student that sent their auto-Evaluation$'){
    String text ->
        assert Student.findByName(text).AutoEvaluations==null:"test failed"

}

When (~'^choose to compare student "([^"]*)" grades$') {
    String text->
        at EvaluationComparisonPage
        page.select(text)

}

And (~'^I select the compare grades option$'){ ->
    at EvaluationComparisonPage
    page.click()

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

Given (~'^Given the student "([^"]*)" don`t appear in the list of student that sent their auto-Evaluation$'){
    String text ->
        assert Student.findByName(text).AutoEvaluations!=null:"test failed"

}

When (~'^choose to compare student "([^"]*)" grades$') {
    String text->
        at EvaluationComparisonPage
        page.select(text)

}

And (~'^I select the compare grades option$'){ ->
    at EvaluationComparisonPage
    page.click()

}

Then (~'^I should stay in Evaluation Comparision page$'){->
    at EvaluationComparisonPage
}

/*
Given Student "X"�s Auto-Evaluation is on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns a detailed table with both student and the professor grades.
*/

Given (~'^Given the student "([^"]*)"`s Auto-Evaluation is on the database$'){
    String text ->
        assert Student.findByName(text).AutoEvaluations==null:"test failed"

}

When (~'^the system requires the  Evaluation -> Auto-evaluation comparison$') {
    ->
        studentX = new StudentController()
        //studentX send his auto Evaluation and his Evaluation info to the show comparision page
}

Then (~'^the system returns a detailed table with both student and the professor grades$'){->
    at ShowComparisonPage
}


/*
Given Student "X"�s Auto-Evaluation isn�t on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns an exception.
*/

Given (~'^Given the student "([^"]*)"`s Auto-Evaluation isn`t on the database$'){
    String text ->
        assert Student.findByName(text).AutoEvaluations!=null:"test failed"

}

When (~'^the system requires the  Evaluation -> Auto-evaluation comparison$') {
    ->
    studentX = new StudentController()
    //studentX send null and his Evaluation info to the show comparision page
}

Then (~'^the system returns an exception$'){->
    at ShowComparisionPage
    assert page.AutoEvaContent==null:"Auto Evaluation null"
}