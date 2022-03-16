package br.com.taimber.swings;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Altera a cor das linhas de uma JTable
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class MudaCorLinhaJtable {

    /**
     * Muda a cor de uma linha de uma JTable
     *
     * @param jtTabela Tabela
     * @param cores Cores
     */
    public static void mudar(JTable jtTabela, List<Color> cores) {

        /* altera o método */
        jtTabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable tabelaView, Object valor, boolean isSelecionado, boolean temFoco, int linha, int coluna) {

                /* super */
                super.getTableCellRendererComponent(tabelaView, valor, isSelecionado, temFoco, linha, coluna);

                /* posição */
                int posicao = 0;

                /* itera a lista de cores */
                for (Color cor : cores) {

                    /* valida a posição da linha */
                    if (linha == posicao) {

                        /* seta a cor */
                        setBackground(cor);

                    }

                    /* atualiza a posição */
                    posicao++;

                }

                /* retorno */
                return this;

            }

        });

    }

}
