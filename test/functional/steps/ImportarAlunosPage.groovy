package steps

import cucumber.api.PendingException

/**
 * Created by wfeli on 12/06/2017.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^I am at the "([^"]*)" page$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^I want to add students from the "([^"]*)" spreadsheet file$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^The file "([^"]*)" has the student "([^"]*)" with user name "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^I add the "([^"]*)" spreadsheet file$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^I can see the list of all students$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^the student "([^"]*)" with user name "([^"]*)" is listed$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}