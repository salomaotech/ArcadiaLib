package br.com.taimber.persistencia.crud;

import br.com.taimber.persistencia.banco.ConexaoSingleTon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Consulta registro na tabela
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ConsultaRegistro {

    /* separa os dados */
    private static List separarDados(ResultSet result) {

        /* retorno */
        List retorno = new ArrayList();

        /* excessão */
        try {

            /* percorre os dados */
            while (result.next()) {

                /* map de dados */
                Map dados = new HashMap();

                /* lista as colunas do resultSet */
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {

                    /* nome da coluna */
                    String nomeColuna = result.getMetaData().getColumnName(i);

                    /* valor da coluna */
                    String valorColuna = result.getString(nomeColuna);

                    /* adiciona os dados no map */
                    dados.put(nomeColuna, valorColuna);

                }

                /* popula o result */
                retorno.add(dados);

            }

        } catch (SQLException | java.lang.NullPointerException ex) {

        }

        /* retorno */
        return retorno;

    }

    /**
     * Consulta registros na tabela
     *
     * @param conexao Conexão com o banco de dados
     * @param instrucaoQuery Instrução query a ser executada
     * @return List com Map de dados
     */
    public static List executar(ConexaoSingleTon conexao, String instrucaoQuery) {

        /* retorno */
        List retorno = new ArrayList();

        /* excessão */
        try {

            /* instrução */
            retorno = separarDados(conexao.getConnection().prepareStatement(instrucaoQuery).executeQuery());

        } catch (SQLException | java.lang.NullPointerException ex) {

        }

        /* retorno */
        return retorno;

    }

    /**
     * Consulta registros na tabela
     *
     * @param conexao Conexão com o banco de dados
     * @param tabela Nome da tabela
     * @param entidades List com campos a serem consultados
     * @param condicaoPesquisa Condição de pesquisa exemplo: where id='1'
     * @return List com Map de dados
     */
    public static List executar(ConexaoSingleTon conexao, String tabela, List entidades, String condicaoPesquisa) {

        /* retorno */
        List retorno = new ArrayList();

        /* excessão */
        try {

            /* colunas */
            String colunas = "";

            /* separador */
            String separador;

            /* contador de linhas */
            int contadorLinha = 0;

            /* pegando os valores do map */
            for (Object chave : entidades) {

                /* valida se ainda vai usar o separador */
                if (contadorLinha == entidades.size() - 1) {

                    separador = "";

                } else {

                    separador = ", ";

                }

                /* atualiza colunas */
                colunas += chave + separador;

                /* atualiza o contador de linha */
                contadorLinha++;

            }

            /* instrução de query */
            String instrucaoQuery = "select " + colunas + " from " + tabela + " " + condicaoPesquisa;

            /* instrução */
            retorno = separarDados(conexao.getConnection().prepareStatement(instrucaoQuery).executeQuery());

        } catch (SQLException | java.lang.NullPointerException ex) {

        }

        /* retorno */
        return retorno;

    }

}
