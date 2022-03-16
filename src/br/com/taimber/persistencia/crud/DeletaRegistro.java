package br.com.taimber.persistencia.crud;

import br.com.taimber.persistencia.banco.ConexaoSingleTon;
import java.sql.SQLException;

/**
 * Deleta registro da tabela
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class DeletaRegistro {

    /**
     * Deleta registro da tabela
     *
     * @param conexao Conexão com o banco de dados
     * @param tabela Nome da tabela
     * @param chave ID de chave primária
     * @return True para sucesso
     */
    public static boolean executar(ConexaoSingleTon conexao, String tabela, String chave) {

        /* excessão */
        try {

            /* instrução query */
            String instrucaoQuery = "delete from " + tabela + " where id='" + chave + "'";

            /* instrução */
            conexao.getConnection().prepareStatement(instrucaoQuery).execute();

            /* retorno */
            return true;

        } catch (SQLException | java.lang.NullPointerException ex) {

            /* retorno */
            return false;

        }

    }

}
