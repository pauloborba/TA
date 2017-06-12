package ta

/**
 * Created by Isaac Douglas on 08/06/17.
 */
class PlanilhaAvaliacao extends Planilha{

    def url

    ArrayList<String> logins
    ArrayList<String> metas

    /**
     *
     * @param url endereco do arquivo de entrada
     */
    PlanilhaAvaliacao(String url) {
        super(url)
        this.url = url

        logins = new ArrayList<String>()
        metas = new ArrayList<String>()

        for(int i=1; i<sizeColuna; i++){
            metas.add(getColuna(i).get(0))
        }

        for(int i=1; i<sizeLinha; i++){
            logins.add(getLinha(i).get(0))
        }
    }

    ArrayList<String> colunaByMeta(String meta){
        ArrayList<String> titulos = getTitulosPlanilha()
        ArrayList<String> coluna = null
        for(int i=0; i<titulos.size(); i++){
            if(meta.equalsIgnoreCase(titulos.get(i))){
                coluna = getColuna(i)
                return coluna
            }
        }
        return  coluna
    }

    ArrayList<String> linhaByLogin(String login){
        ArrayList<String> logins = getColuna(0)
        ArrayList<String> linha = null
        for(int i=0; i<logins.size(); i++){
            if(login.equalsIgnoreCase(logins.get(i))){
                linha = getLinha(i)
                return linha
            }
        }
        return linha
    }

    boolean metaExiste(String nome){
        for (int i=0; i<metas.size(); i++){
            String metaAtual = metas.get(i)
            if (metaAtual.equalsIgnoreCase(nome)){
                return true
            }
        }
        return false
    }

    boolean alunoExiste(String loginCin){
        for (int i=0; i<logins.size(); i++){
            String alunoAtual = logins.get(i)
            if (alunoAtual.equalsIgnoreCase(loginCin)){
                return true
            }
        }
        return false
    }

}
