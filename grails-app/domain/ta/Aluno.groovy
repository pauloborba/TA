package ta

class Aluno {
    String nome
    String loginCin
    String loginSlack
    String loginGitHub

    static constraints = {
        nome unique : true, blank : false
        loginCin unique : true , blank : false
        loginSlack unique : true , blank : false
        loginGitHub unique : true , blank : false
    }

    public Aluno(String nome){
        this.nome = nome
    }
}