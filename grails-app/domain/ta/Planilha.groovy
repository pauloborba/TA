package ta

/**
 * Created by Isaac Douglas on 07/06/17.
 */

import jxl.Cell
import jxl.Sheet
import jxl.Workbook


class Planilha {

    private Workbook planilha // objeto que recebera um instancia da planilha estudada
    private Sheet aba // objeto que sera a aba
    private File arquivo // arquivo .xls que sera lido
    private String url // endereco do arquivo .xls
    private String[][] matriz //matriz que vai ser povoada pelo arquivo
    public int sizeLinha
    public int sizeColuna

    Planilha(String url) {
        this.url = url

        try {

            arquivo = new File(this.url)

            // instancia a planilha
            planilha = Workbook.getWorkbook(arquivo)

            aba = planilha.getSheet(0) // pega a primeira aba, ou seja, aba de indice 0.

            matriz = new String[aba.getRows()][aba.getColumns()]

            sizeLinha = matriz.length
            sizeColuna = matriz[0].length

            Cell[] cel // instancia um array de células que ira auxiliar no povoamento da matriz

            for (int i = 0; i < matriz.length; i++) {

                cel = aba.getRow(i)

                for (int j = 0; j < matriz[0].length; j++) {
                    // pega os dados da celula cel[j] e adiciona na matriz
                    matriz[i][j] = cel[j].getContents()
                }
            }

        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    /**
     Retorna os titulos das colunas
     */
    ArrayList<String> getTitulosPlanilha() {

        ArrayList<String> titulos = new ArrayList<String>()

        for (int j = 0; j < matriz[0].length; j++) {
            titulos.add(matriz[0][j])
        }

        return titulos
    }

    /**
     Retorna a linha especificada ou null se nao existir
     * @param index index da linha de retorno
     * @return a linha especifica ou null
     */
    ArrayList<String> getLinha(int index) {

        if (index >= sizeLinha){
            return null
        }

        ArrayList<String> row = new ArrayList<String>()

        for (int j = 0; j < matriz[index].length; j++) {
            row.add(matriz[index][j])
        }

        return row
    }

    ArrayList<String> getColuna(int index){

        if (index >= sizeColuna){
            return null
        }

        ArrayList<String> coluna = new ArrayList<String>()

        for (int j = 0; j < matriz.length; j++) {
            coluna.add(matriz[j][index])
        }

        return coluna
    }
}