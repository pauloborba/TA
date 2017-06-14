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

    Aluno(String nome, String loginCin, String loginSlack, String loginGitHub) {
        this.nome = nome
        this.loginCin = loginCin
        this.loginSlack = loginSlack
        this.loginGitHub = loginGitHub
    }

    @Override
    String toString() {
        return nome
    }
}