package br.com.taimber.swings;

import br.com.taimber.configuracoes.PropriedadesLib;
import br.com.taimber.persistencia.banco.BancoDados;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 * Retorna o paginador
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class Paginador {

    private final JComboBox jc;
    private final String tabela;
    private final String condicaoPesquisa;

    /**
     * Construtor
     *
     * @param jc ComboBox do paginador
     *
     * @param tabela Nome da tabela
     * @param condicaoPesquisa Condição de pesquisa
     */
    public Paginador(JComboBox jc, Object tabela, String condicaoPesquisa) {

        /* combobox */
        this.jc = jc;

        /* nome da tabela */
        this.tabela = (String) tabela;

        /* condição de pesquisa */
        this.condicaoPesquisa = condicaoPesquisa;

    }

    /**
     * Popula o paginador
     *
     * @param banco Banco de dados
     */
    public void popular(BancoDados banco) {

        /* item atual */
        Object itemAtual = jc.getSelectedItem();

        /* remove todos os itens */
        jc.removeAllItems();

        /* entidades */
        List entidades = new ArrayList();
        entidades.add("id");

        /* lista os dados */
        List dados = banco.consultarRegistro(this.tabela, entidades, this.condicaoPesquisa);

        /* número de páginas */
        int paginas = (dados.size() / PropriedadesLib.SQL_NUMERO_RESULTADOS_APRESENTAR_POR_PESQUISA);

        /* itera */
        for (int i = 0; i <= paginas; i++) {

            /* adicona o item */
            this.jc.addItem(i);

        }

        /* seleciona o item atual */
        this.jc.setSelectedItem(itemAtual);

    }

}
