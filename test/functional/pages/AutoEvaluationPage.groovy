package pages

import geb.Page

class AutoEvaluationPage extends Page{

    static url = "/TA/autoEvaluation/index"

    static at = {
        title ==~ /Auto Evaluation/
    }


    def choose (criterion){

    }

    def fillConcept(concept){
        $("form").concept = concept;
    }

    def click (){

    }

    def update (){

    }

    def displayWarning (){

    }





}
