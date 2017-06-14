package pages

import geb.Page


class AutoAvaliacaoFormPage extends Page {
    static url = "autoaval"

    static at = {
        $("meta[name='whois']").attr("content") == "autoaval-form"
    }

    static content = {
    }
}