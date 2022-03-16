package br.com.taimber.persistencia.crud;

import br.com.taimber.persistencia.banco.ConexaoSingleTon;
import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 * Atualiza registro da tabela
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class AtualizaRegistro {

    /**
     * Atualiza registro da tabela
     *
     * @param conexao Conexão com o banco de dados
     * @param tabela Nome da tabela
     * @param entidades LinkedHashMap com dados a serem inseridos
     * @param condicoes LinkedHashMap com condições a serem avaliadas
     * @return True para sucesso
     */
    public static boolean executar(ConexaoSingleTon conexao, String tabela, LinkedHashMap entidades, LinkedHashMap condicoes) {

        /* excessão */
        try {

            /* não permite operar no banco de dados sem uma condição */
            if (condicoes.isEmpty()) {

                /* retorno */
                return false;

            }

            /* valores */
            String valores = "";

            /* condição */
            String condicao = "";

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

                /* atualiza valores */
                valores += chave + "='" + entidades.get(chave) + "'" + separador;

                /* atualiza o contador de linha */
                contadorLinha++;

            }

            /* contador de linhas */
            contadorLinha = 0;

            /* pegando os valores do map */
            for (Object chave : condicoes.keySet()) {

                /* valida se ainda vai usar o separador */
                if (contadorLinha == condicoes.size() - 1) {

                    separador = "";

                } else {

                    separador = " and ";

                }

                /* atualiza valores */
                condicao += chave + "='" + condicoes.get(chave) + "'" + separador;

                /* atualiza o contador de linha */
                contadorLinha++;

            }

            /* verifica condição */
            if (condicao.length() > 0) {

                /* complementa */
                condicao = " where " + condicao;

            }

            /* instrução de query */
            String instrucaoQuery = "update " + tabela + " set " + valores + condicao;

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
