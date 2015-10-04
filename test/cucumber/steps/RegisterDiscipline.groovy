package steps

import ta.Discipline
import pages.DisciplinePages.RegisterNewDisciplinePage
import pages.DisciplinePages.DisciplinePage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


/////////////////////////controller tests////////////////////////////////////////
Given(~'The system has no discipline named "([^"]*)"$') { String discipline ->
    assert Discipline.findByName(discipline) == null
}

When(~'I create the discipline "([^"]*)" with teacher "([^"]*)" and concepts "([^"]*)"$') { String discipline, teacher,
                                                                                            String[] concepts ->
    RegisterNewDiscipline.createDiscipline(discipline, teacher, concepts)
}

Then(~'The discipline "([^"]*)" is properly stored in the system$') { String discipline ->
    assert Discipline.findByName(discipline) != null
}

///////////////////////////////////

Given(~'The system already has a discipline named "([^"]*)"$') { String discipline ->
    RegisterNewDiscipline.createDiscipline(discipline, teacher, concepts)
    assert Discipline.findByName(discipline) != null
}

When(~'I create the discipline "([^"]*)" with teacher "([^"]*)" and concepts "([^"]*)"$') { String discipline, teacher,
                                                                                            String[] concepts ->
    saved = RegisterNewDiscipline.createDiscipline(discipline, teacher, concepts)
}

Then(~'The discipline "([^"]*)" is not stored more than one time in the system$') { String discipline ->
    assert Discipline.findByName(discipline) != null && !saved
}

////////////////////////GUI tests////////////////////////////////////////////////////

Given(~'I am at the homepage$') { ->
    to homePage // checar se essa
    at homePage // página existe mesmo
}

When(~'I select create new discipline$') { ->
    to RegisterNewDisciplinePage
    at RegisterNewDisciplinePage
}

And(~'fill the form with name "([^"]*)" with teacher "([^"]*)" and concepts "([^"]*)"$') { String discipline, teacher,
    String[] concepts ->
    page.fillDisciplineForm(discipline, teacher, concepts)
    disciplineSaved = discipline
}

Then(~'A success message is displayed$') {
    // ver como fazer isso
}

And(~'I am taken to the list of disciplines page where "([^"]*)" is listed as a discipline$') { String discipline ->
    to DisciplinePage
    at DisciplinePage
    assert discipline == disciplineSaved
}

////////////////////////////////

Given(~'I am at the homepage$') { ->
    to homePage // checar se essa
    at homePage // página existe mesmo
}

When(~'I select create new discipline$') { ->
    to RegisterNewDisciplinePage
    at RegisterNewDisciplinePage
}

And(~'fill the form with name "([^"]*)" with teacher "([^"]*)" and concepts "([^"]*)"$') { String discipline, teacher,
                                                                                           String[] concepts ->
    page.fillDisciplineForm(discipline, teacher, concepts)
    disciplineSaved = discipline
}

And(~'the system already has a discipline named "([^"]*)"$') { ->
    //
}

Then(~'An error message is displayed$') { ->
    // ver como fazer isso
}

And(~'I am taken to the list of disciplines page where "([^"]*)" is already listed as a discipline$') { String discipline ->
    to DisciplinePage
    at DisciplinePage
    assert discipline == disciplineSaved

}