package steps
import cucumber.api.PendingException

/**
 * Created by wfeli on 12/06/2017.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^I have the file "([^"]*)" which contains the students names and user names$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^the file "([^"]*)" has the student "([^"]*)" with cin username "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^the system has the class "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^I import the file "([^"]*)" for the "([^"]*)" class$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^the system adds the student "([^"]*)" with cin username "([^"]*)" to the class "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}