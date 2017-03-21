package pages.StudentPages

import geb.Page

class ResendPage extends Page {

    static url = "/TA/student/resend"

    static at =  {
        title ==~ /Resend Evaluations/
    }

}

