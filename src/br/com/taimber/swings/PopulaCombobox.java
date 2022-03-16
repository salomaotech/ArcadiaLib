package br.com.taimber.swings;

import br.com.taimber.persistencia.banco.BancoDados;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;

/**
 * Popula dados em uma combobox
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class PopulaCombobox {

    private static final ArrayList objetos = new ArrayList();

    /**
     * Carrega os dados numa jComboBox
     *
     * @param banco Banco de dados
     * @param jc Objeto jComboBox
     * @param tabela Nome da tabela do banco de dados
     * @param coluna Coluna que será recuperada
     */
    public static void executa(BancoDados banco, JComboBox jc, String tabela, String coluna) {

        /* limpa dados antigos */
        jc.removeAllItems();

        /* entidades */
        List entidades = new ArrayList();
        entidades.add(coluna);

        /* condição de pesquisa */
        String condicaoPesquisa = "group by " + coluna + " order by " + coluna;

        /* list com dados da consulta */
        List dados = banco.consultarRegistro(tabela, entidades, condicaoPesquisa);

        /* adiciona primeiro ítem vazio */
        jc.addItem("");

        /* listando os dados */
        dados.forEach((linha) -> {

            /* excessão */
            try {

                /* map de dados */
                Map dadosMap = (Map) linha;

                /* valor */
                String valor = (String) dadosMap.get(coluna);

                /* valida valor */
                if (valor.length() > 0) {

                    /* adicona o item */
                    jc.addItem((String) dadosMap.get(coluna));

                }

            } catch (java.lang.NullPointerException ex) {

            }

        });

        /* valida se já adicionou evento ao objeto */
        if (!objetos.contains(jc)) {

            /* valida se é editável */
            if (jc.isEditable()) {

                /* add eventos */
                addEventosJComboBoxEditavel(banco, jc, tabela, coluna);

            } else {

                /* add eventos */
                addEventosJComboBox(banco, jc, tabela, coluna);

            }

            /* adiciona objeto */
            objetos.add(jc);

        }

    }

    /**
     * Adiciona a parte de eventos
     *
     * @param banco Banco de dados
     * @param jc Objeto jComboBox
     * @param tabela Nome da tabela do banco de dados
     * @param coluna Coluna que será recuperada
     */
    private static void addEventosJComboBox(BancoDados banco, JComboBox jc, String tabela, String coluna) {

        /* evento de foco */
        jc.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

                /* conteúdo atual */
                String conteudo = (String) jc.getEditor().getItem();

                /* carrega os novos dados */
                PopulaCombobox.executa(banco, jc, tabela, coluna);

                /* seta o conteúdo atual */
                jc.setSelectedItem(conteudo);

            }

            @Override
            public void focusLost(FocusEvent e) {

            }

        });

    }

    /**
     * Adiciona a parte de eventos
     *
     * @param banco Banco de dados
     * @param jc Objeto jComboBox
     * @param tabela Nome da tabela do banco de dados
     * @param coluna Coluna que será recuperada
     */
    private static void addEventosJComboBoxEditavel(BancoDados banco, JComboBox jc, String tabela, String coluna) {

        /* evento de foco */
        jc.getEditor().getEditorComponent().addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

                /* conteúdo atual */
                String conteudo = (String) jc.getEditor().getItem();

                /* carrega os novos dados */
                PopulaCombobox.executa(banco, jc, tabela, coluna);

                /* seta o conteúdo atual */
                jc.setSelectedItem(conteudo);

            }

            @Override
            public void focusLost(FocusEvent e) {

            }

        });

    }

}
