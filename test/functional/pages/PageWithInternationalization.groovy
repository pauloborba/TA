package pages

import geb.Page
import steps.InternationalizationHelper

class PageWithInternationalization extends Page{
    InternationalizationHelper internationalizationHelper = InternationalizationHelper.instance
}
