package ta

/**
 * Created by Isaac Douglas on 07/06/17.
 */
public class PlanilhaFactory {

    /**
     * retorna uma planilha
     * @param url url do arquivo da planilha
     * @param tipoPlanilha string especificando o tipo da planilha
     * @return uma planilha ou null se a planilha nao foi especificada corretamente
     */
    static Planilha getPlanilha(String url, String tipoPlanilha){

        if (tipoPlanilha.equalsIgnoreCase("addaluno")){
            //aqui retorna uma planilha com alunos
        }

        if (tipoPlanilha.equalsIgnoreCase("avaliacao")){
            //aqui retorna uma plalinha com avaliacoes
            return new PlanilhaAvaliacao(url)
        }

        return null
    }
}