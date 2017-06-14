package ta

import ta.Aluno

/**
 * Created by Ricardo on 6/13/2017.

 ESTA GROOVY É DE RESPONSABILIDADE DE OUTRO MEMBRO DO GRUPO

 */
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EnviarEmailController {

    public static List<Aluno> enviarAlunosComProblemas(String turma){
        //Coloquei o retorno desejado, supondo que seriam esses os alunos que receberiam mesmo o email
        List<Aluno> lista = new ArrayList<>()
        lista.add(Aluno.findByNome("Robson"))
        lista.add(Aluno.findByNome("Leonardo"))
        return lista
    }

    public static List<Aluno> enviarAutoavaliacao(String turma){
        //Coloquei o retorno desejado, supondo que seriam esses os alunos que receberiam mesmo o email
        List<Aluno> lista = new ArrayList<>()
        lista.add(Aluno.findByNome("Ricardo"))
        lista.add(Aluno.findByNome("Robson"))
        lista.add(Aluno.findByNome("Isaac"))
        return lista
    }
}
