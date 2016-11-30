package pages

import geb.Page
import grails.plugin.remotecontrol.RemoteControl

/**
 * Created by lapp on 31/05/2016.
 */
class ShowCriterionPage extends Page {
    static url = "criterion/show"

    static at = {
        RemoteControl remoteControl = new RemoteControl()
        def titleLabel = remoteControl.exec {
            ctx.messageSource.getMessage('default.show.label', null, Locale.getDefault())
        }
        title ==~ /Show Criterion/
    }

    def boolean selectDeleteCriterion() {
        boolean b = false
        if ($("input", class: "delete").isDisplayed()) b = true
        if(b) {
            withConfirm {$("input", class: "delete").click()}
        }
    }
}