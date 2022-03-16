package br.com.taimber.persistencia.sql;

import static java.util.Objects.isNull;

/**
 * Monta uma String para pesquisar entre datas no sql
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class SqlEntreDatas {

    /**
     * Monta
     *
     * @param dataInicial Data inicial
     * @param dataFinal Data final
     * @param nomeColunaData Nome da coluna que contém a data da pesquisa
     * @return
     */
    public static String montar(String dataInicial, String dataFinal, String nomeColunaData) {

        /* retorno */
        String retorno = "";

        /* excessão */
        try {

            /* somente data inicial informada */
            if (!isNull(dataInicial) && isNull(dataFinal)) {

                retorno = "str_to_date(" + nomeColunaData + ", '%d/%m/%Y') = str_to_date('" + dataInicial + "', '%d/%m/%Y')";

            }

            /* data inicial e final formada */
            if (!isNull(dataInicial) && !isNull(dataFinal)) {

                retorno += "str_to_date(" + nomeColunaData + ", '%d/%m/%Y') >= str_to_date('" + dataInicial + "', '%d/%m/%Y')";
                retorno += " and ";
                retorno += "str_to_date(" + nomeColunaData + ", '%d/%m/%Y') <= str_to_date('" + dataFinal + "', '%d/%m/%Y')";

            }

        } catch (java.lang.NullPointerException ex) {

        }

        /* retorno */
        return retorno;

    }

}
