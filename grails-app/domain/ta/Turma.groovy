package ta

class Turma {
    String nome
    List matriculas
    List alunos
    List metas
    static hasMany = [alunos:Aluno, metas:Meta]
    int totalTurma = 0
    double mediaGeral = 0
    int numAM = 0
    int numA = 0

    static constraints = {
        nome unique : true , blank : false
    }

    public Turma(String nome){
        this.nome = nome

        Aluno begin = new AlunoController(nome: "Alto", media: 10)
        Aluno end = new AlunoController(nome: "Baixo", media: 0)
        this.alunos = [begin, end]
    }



    void inserir(Aluno a){
        int i = 0
        while (i < this.alunos.size()){
        i++
        }
        this.alunos[i] = a
    }




    double calcularMedia(){
        for(int i=0; i < alunos.size(); i++){
            mediaGeral = mediaGeral + alunos[i].media
        }
        totalTurma = matriculas.size()
        mediaGeral = mediaGeral /totalTurma
    }
}