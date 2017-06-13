package tav2

class Estudante {
    /**
     * Simplifiquei os fields
     */
    String nomeCompleto
    String login
    List classificacoes

    Turma turma
    static hasMany = [classificacoes:Classificacao]
    static constraints = {
        login unique: "turma"
        turma nullable: false
    }

    void addClassificacao(Classificacao classif){
        addToClassificacoes(classif)
    }
    String getEmailAddress(){
        return login + "@domain.com"
    }

}
