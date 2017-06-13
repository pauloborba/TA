package ta

class Aluno {
    String nome
    String loginCin
    String loginSlack
    String loginGitHub
    double media

    static constraints = {
        nome unique : true, blank : false
        loginCin unique : true , blank : false, nullable: true
        loginSlack unique : true , blank : false, nullable: true
        loginGitHub unique : true , blank : false, nullable: true
    }

    public Aluno(String nome){
        this.nome = nome
    }
}