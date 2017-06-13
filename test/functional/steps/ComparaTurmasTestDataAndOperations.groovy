package steps

import ta.Turma

/**
 * Created by Guigo on 12/06/2017.
 */

import ta.TurmaController
import ta.AlunoController
import ta.MatriculaController

class ComparaTurmasTestDataAndOperations {

    public void comparaMedia(){
        /*
       Inicio de TurmaT1
        */

        //Criando um alunoT1A e matriculaT1A de teste

        def alunoT1A = new AlunoController()
        alunoT1A.params << [nome: "Jeff Keppler", loginCIn: "jk", loginSlack: "jk" ,loginGitHub: "jk"]
        alunoT1A.create()

        def matriculaT1A = new MatriculaController()
        matriculaT1A.params << [aluno: alunoT1A, media: 6, aprovacao:"A"]
        matriculaT1A.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1B = new AlunoController()
        alunoT1B.params << [nome: "Steve Wonder", loginCIn: "sw", loginSlack: "sw" ,loginGitHub: "sw"]
        alunoT1B.create()

        def matriculaT1B = new MatriculaController()
        matriculaT1B.params << [aluno: alunoT1B, media: 4, aprovacao:"R"]
        alunoT1B.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1C = new AlunoController()
        alunoT1C.params << [nome: "King Bradley", loginCIn: "kb", loginSlack: "kb" ,loginGitHub: "kb"]
        alunoT1C.create()

        def matriculaT1C = new MatriculaController()
        matriculaT1C.params << [aluno: alunoT1C, media: 10, aprovacao:"AM"]
        alunoT1C.create()

        // Crainda turmaT1 de teste

        def turmaT1 = new TurmaController()
        turmaT1.params << [nome: "T1", matriculas:[alunoT1A, alunoT1B, alunoT1C]]
        turmaT1.create()

        /*
        Fim da turmaT1 e

        Inicio da TurmaT2
         */

        //Criando um alunoT2A e matriculaT2A de teste

        def alunoT2A = new AlunoController()
        alunoT2A.params << [nome: "Billy G", loginCIn: "bg", loginSlack: "bg" ,loginGitHub: "bg"]
        alunoT2A.create()

        def matriculaT2A = new MatriculaController()
        matriculaT2A.params << [aluno: alunoT2A, media: 9, aprovacao:"AM"]
        matriculaT2A.create()

        //Criando um alunoT2B e matriculaT2B de teste

        def alunoT2B = new AlunoController()
        alunoT2B.params << [nome: "Diana Prince", loginCIn: "dp", loginSlack: "dp" ,loginGitHub: "dp"]
        alunoT2B.create()

        def matriculaT2B = new MatriculaController()
        matriculaT2B.params << [aluno: alunoT2B, media: 6, aprovacao:"A"]
        alunoT2B.create()

        //Criando um alunoT2C e matriculaT2C de teste

        def alunoT2C = new AlunoController()
        alunoT2C.params << [nome: "King Bradley", loginCIn: "kb", loginSlack: "kb" ,loginGitHub: "kb"]
        alunoT2C.create()

        def matriculaT2C = new MatriculaController()
        matriculaT2C.params << [aluno: alunoT2C, media: 8, aprovacao:"AM"]
        alunoT2C.create()

        // Crainda turmaT2 de teste

        def turmaT2 = new TurmaController()
        turmaT1.params << [nome: "T1", matriculas:[alunoT2A, alunoT2B, alunoT2C]]
        turmaT1.create()

        /*
        Fim da turmaT2 e

        Inicio da TurmaT1
        */


        //Criando um alunoT3A e matriculaT3A de teste

        def alunoT3A = new AlunoController()
        alunoT3A.params << [nome: "Ludwig Mars", loginCIn: "lm", loginSlack: "lm" ,loginGitHub: "lm"]
        alunoT3A.create()


        def matriculaT3A = new MatriculaController()
        matriculaT3A.params << [aluno: alunoT3A, media: 7, aprovacao:"AM"]
        matriculaT3A.create()

        //Criando um alunoT2B e matriculaT2B de teste

        def alunoT3B = new AlunoController()
        alunoT3B.params << [nome: "Diego Prince", loginCIn: "dp", loginSlack: "dp" ,loginGitHub: "dp"]
        alunoT3B.create()


        def matriculaT3B = new MatriculaController()
        matriculaT3B.params << [aluno: alunoT3B, media: 4, aprovacao:"R"]
        alunoT3B.create()

        //Criando um alunoT3C e matriculaT3C de teste

        def alunoT3C = new AlunoController()
        alunoT3C.params << [nome: "King Bradley", loginCIn: "kb", loginSlack: "kb" ,loginGitHub: "kb"]
        alunoT3C.create()


        def matriculaT3C = new MatriculaController()
        matriculaT3C.params << [aluno: alunoT3C, media: 5, aprovacao:"R"]
        alunoT3C.create()

        //Criando um alunoT3D e matriculaT3D de teste

        def alunoT3D = new AlunoController()
        alunoT3D.params << [nome: "King Bradley", loginCIn: "kb", loginSlack: "kb" ,loginGitHub: "kb"]
        alunoT3D.create()


        def matriculaT3D = new MatriculaController()
        matriculaT3D.params << [aluno: alunoT3D, media: 5, aprovacao:"R"]
        alunoT3D.create()

        // Crainda turmaT3 de teste

        def turmaT3 = new TurmaController()
        turmaT3.params << [nome: "T3", matriculas:[alunoT3A, alunoT3C, alunoT3C, alunoT3D]]
        turmaT3.create()

        /*
        Fim da turmaT3
         */
    }



    public static void calcularMedia(){

        /*
        Inicio de TurmaT1
         */

        //Criando um alunoT1A e matriculaT1A de teste

        def alunoT1A = new AlunoController()
        alunoT1A.params << [nome: "Jeff Keppler", loginCIn: "jk", loginSlack: "jk" ,loginGitHub: "jk"]
        alunoT1A.create()

        def matriculaT1A = new MatriculaController()
        matriculaT1A.params << [aluno: alunoT1A, media: 6, aprovacao:"A"]
        matriculaT1A.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1B = new AlunoController()
        alunoT1B.params << [nome: "Steve Wonder", loginCIn: "sw", loginSlack: "sw" ,loginGitHub: "sw"]
        alunoT1B.create()


        def matriculaT1B = new MatriculaController()
        matriculaT1B.params << [aluno: alunoT1B, media: 4, aprovacao:"R"]
        alunoT1B.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1C = new AlunoController()
        alunoT1C.params << [nome: "King Bradley", loginCIn: "kb", loginSlack: "kb" ,loginGitHub: "kb"]
        alunoT1C.create()


        def matriculaT1C = new MatriculaController()
        matriculaT1C.params << [aluno: alunoT1C, media: 10, aprovacao:"AM"]
        alunoT1C.create()

        // Crainda turmaT1 de teste

        def turmaT1 = new TurmaController()
        turmaT1.params << [nome: "T1", matriculas:[alunoT1A, alunoT1B, alunoT1C]]
        turmaT1.create()

        turmaT1.calcularMedia()

    }

    public static void contAM(){

        /*
        Inicio de TurmaT1
         */

        //Criando um alunoT1A e matriculaT1A de teste

        def alunoT1A = new AlunoController()
        alunoT1A.params << [nome: "Jeff Keppler", loginCIn: "jk", loginSlack: "jk" ,loginGitHub: "jk"]
        alunoT1A.create()

        def matriculaT1A = new MatriculaController()
        matriculaT1A.params << [aluno: alunoT1A, media: 6, aprovacao:"A"]
        matriculaT1A.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1B = new AlunoController()
        alunoT1B.params << [nome: "Steve Wonder", loginCIn: "sw", loginSlack: "sw" ,loginGitHub: "sw"]
        alunoT1B.create()


        def matriculaT1B = new MatriculaController()
        matriculaT1B.params << [aluno: alunoT1B, media: 4, aprovacao:"R"]
        alunoT1B.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1C = new AlunoController()
        alunoT1C.params << [nome: "King Bradley", loginCIn: "kb", loginSlack: "kb" ,loginGitHub: "kb"]
        alunoT1C.create()


        def matriculaT1C = new MatriculaController()
        matriculaT1C.params << [aluno: alunoT1C, media: 10, aprovacao:"AM"]
        alunoT1C.create()

        // Crainda turmaT1 de teste

        def turmaT1 = new TurmaController()
        turmaT1.params << [nome: "T1", matriculas:[alunoT1A, alunoT1B, alunoT1C]]
        turmaT1.create()

        turmaT1.contAM()
    }

    public static void contA(){

        /*
        Inicio de TurmaT1
         */

        //Criando um alunoT1A e matriculaT1A de teste

        def alunoT1A = new AlunoController()
        alunoT1A.params << [nome: "Jeff Keppler", loginCIn: "jk", loginSlack: "jk" ,loginGitHub: "jk"]
        alunoT1A.create()

        def matriculaT1A = new MatriculaController()
        matriculaT1A.params << [aluno: alunoT1A, media: 6, aprovacao:"A"]
        matriculaT1A.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1B = new AlunoController()
        alunoT1B.params << [nome: "Steve Wonder", loginCIn: "sw", loginSlack: "sw" ,loginGitHub: "sw"]
        alunoT1B.create()


        def matriculaT1B = new MatriculaController()
        matriculaT1B.params << [aluno: alunoT1B, media: 4, aprovacao:"R"]
        alunoT1B.create()

        //Criando um alunoT1B e matriculaT1B de teste

        def alunoT1C = new AlunoController()
        alunoT1C.params << [nome: "King Bradley", loginCIn: "kb", loginSlack: "kb" ,loginGitHub: "kb"]
        alunoT1C.create()


        def matriculaT1C = new MatriculaController()
        matriculaT1C.params << [aluno: alunoT1C, media: 10, aprovacao:"AM"]
        alunoT1C.create()

        // Crainda turmaT1 de teste

        def turmaT1 = new TurmaController()
        turmaT1.params << [nome: "T1", matriculas:[alunoT1A, alunoT1B, alunoT1C]]
        turmaT1.create()

    }
}
