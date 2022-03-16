package br.com.taimber.persistencia.crud;

import br.com.taimber.persistencia.banco.ConexaoSingleTon;
import java.sql.SQLException;

/**
 * Exclui o banco de dados
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ExcluiBancoDeDados {

    /**
     * Exclui o banco de dados
     *
     * @param conexao Conexão com o banco de dados
     * @param nomeBanco Nome do banco de dados
     * @return True para sucesso
     */
    public static boolean executar(ConexaoSingleTon conexao, String nomeBanco) {

        /* excessão */
        try {

            /* instrução query */
            String instrucaoQuery = "drop database " + nomeBanco;

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
