package br.com.taimber.persistencia.crud;

import br.com.taimber.persistencia.banco.ConexaoSingleTon;
import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 * Insere registro na tabela
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class InsereRegistro {

    /**
     * Insere registro na tabela
     *
     * @param conexao Conexão com o banco de dados
     * @param tabela Nome da tabela
     * @param entidades LinkedHashMap com dados a serem inseridos
     * @return True para sucesso
     */
    public static boolean executar(ConexaoSingleTon conexao, String tabela, LinkedHashMap entidades) {

        /* excessão */
        try {

            /* colunas */
            String colunas = "";

            /* valores */
            String valores = "";

            /* separador */
            String separador;

            /* contador de linhas */
            int contadorLinha = 0;

            /* pegando os valores do map */
            for (Object chave : entidades.keySet()) {

                /* valida se ainda vai usar o separador */
                if (contadorLinha == entidades.size() - 1) {

                    separador = "";

                } else {

                    separador = ", ";

                }

                /* atualiza colunas */
                colunas += chave + separador;

                /* atualiza valores */
                valores += "'" + entidades.get(chave) + "'" + separador;

                /* atualiza o contador de linha */
                contadorLinha++;

            }

            /* instrução de query */
            String instrucaoQuery = "insert into " + tabela + "(" + colunas + ") values (" + valores + ")";

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
