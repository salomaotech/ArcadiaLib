package br.com.taimber.persistencia.sql;

import br.com.taimber.configuracoes.PropriedadesLib;
import java.util.Map;
import static java.util.Objects.isNull;

/**
 * Completa a pesquisa de uma query
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class SqlCompletaQuery {

    private final Map entidades;
    private final int pagina;
    private final String tabela;
    private final boolean isLike;

    /**
     * Construtor
     *
     * @param entidades Map com entidades
     * @param paginaPaginador Página do paginador
     * @param tabela Nome da tabela
     * @param isLike True usa o modo like para pesquisa, False usa = para
     * pesquisa
     */
    public SqlCompletaQuery(Map entidades, Object paginaPaginador, String tabela, boolean isLike) {

        /* propriedades */
        this.entidades = entidades;
        this.tabela = tabela;
        this.isLike = isLike;

        /* valida página */
        if (!isNull(paginaPaginador)) {

            this.pagina = (int) paginaPaginador;

        } else {

            this.pagina = 0;

        }

    }

    /* retorna a quantidade de itens válidos a serem pesquisados */
    private int quantidadeItensValidosApesquisar() {

        /* retorno */
        int retorno = 0;

        /* listando entidades */
        for (Object chave : entidades.keySet()) {

            /* valida se ha valor na chave! */
            if (!this.entidades.get(chave).equals("")) {

                /* atualiza o retorno */
                retorno++;

            }

        }

        /* retorno */
        return retorno;

    }

    /**
     * Completa query
     *
     * @param usarLimite True usa o limitador por exemplo limit 1,100
     * @param condicaoAnterior Condições anteriores
     * @param ordenadorOrderBy Tipo de ordenação
     * @return Completa query String formatada para pesquisar no banco de dados
     */
    public String completar(boolean usarLimite, String condicaoAnterior, String ordenadorOrderBy) {

        /* string de retorno */
        String completaQuery;

        /* campos de pesquisa */
        String camposPesquisa = "";

        /* contador de linhas */
        int contadorLinha = 0;

        /* número de itens */
        int numeroItens = this.quantidadeItensValidosApesquisar();

        /* listando entidades */
        for (Object chave : entidades.keySet()) {

            /* valida se ha valor na chave! */
            if (!this.entidades.get(chave).equals("")) {

                /* operador */
                String operador;

                /* valida o tamanho do contador */
                if (contadorLinha == (numeroItens - 1)) {

                    operador = "";

                } else {

                    operador = "and ";

                }

                /* valida se irá usar like para pesquisa ou = */
                if (this.isLike) {

                    /* campos de pesquisa */
                    camposPesquisa += this.tabela + "." + chave + " like '%" + this.entidades.get(chave) + "%' " + operador;

                } else {

                    /* campos de pesquisa */
                    camposPesquisa += this.tabela + "." + chave + "='" + this.entidades.get(chave) + "' " + operador;

                }

                /* atualiza o contador */
                contadorLinha++;

            }

        }

        /* valida condição anterior */
        if (isNull(condicaoAnterior)) {

            condicaoAnterior = "";

        }

        /* valida ordenador */
        if (isNull(ordenadorOrderBy)) {

            ordenadorOrderBy = "";

        }

        /* se houver campos de pesquisa, e condição anterior então adicione aos campos de pesquisa a condição anterior */
        if (!camposPesquisa.equals("") & !condicaoAnterior.equals("")) {

            camposPesquisa += " and " + condicaoAnterior;

        }

        /* se não houver campos de pesquisa, mas houver condição anterior então os campos de pesquisa serão a condição anterior*/
        if (camposPesquisa.equals("") & !condicaoAnterior.equals("")) {

            camposPesquisa = condicaoAnterior;

        }

        /* se houver campos de pesquisa, então adicione o where e o ordenador, caso contrário só adicione o ordenador */
        if (!camposPesquisa.equals("")) {

            completaQuery = "where " + camposPesquisa + " " + ordenadorOrderBy;

        } else {

            completaQuery = ordenadorOrderBy;

        }

        /* valida usar limite */
        if (usarLimite) {

            /* completa query com limit */
            completaQuery += " limit " + (this.pagina * PropriedadesLib.SQL_NUMERO_RESULTADOS_APRESENTAR_POR_PESQUISA) + ", " + PropriedadesLib.SQL_NUMERO_RESULTADOS_APRESENTAR_POR_PESQUISA;

        }

        /* retorno */
        return completaQuery;

    }

}
