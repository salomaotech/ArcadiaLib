package br.com.taimber.swings;

import java.io.File;
import java.util.Arrays;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Exibe pastas do disco local a partir de um endereço
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class GridPastas {

    /**
     * Exibe as pastas
     *
     * @param pastaDestino Pasta de destino
     * @param jTree JTree de destino
     */
    public void exibir(String pastaDestino, JTree jTree) {

        /* configuracoes iniciais */
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        /* remove antigos */
        root.removeAllChildren();
        model.reload();

        /* excessão */
        try {

            /* galhos */
            File[] galhos = new File(pastaDestino).listFiles();

            /* ordena */
            Arrays.sort(galhos);

            /* itera */
            for (File galho : galhos) {

                /* novo galho */
                DefaultMutableTreeNode tree = new DefaultMutableTreeNode(galho.getName());

                /* folhas */
                File[] folhas = new File(galho.getAbsolutePath()).listFiles();

                /* ordena */
                Arrays.sort(folhas);

                /* itera */
                for (File folha : folhas) {

                    /* add folha */
                    tree.add(new DefaultMutableTreeNode(folha.getName()));

                }

                /* add galho */
                root.add(tree);

            }

        } catch (java.lang.NullPointerException | ArrayIndexOutOfBoundsException ex) {

        }

        /* expande todos os nodes */
        expandirNodes(jTree, 0, jTree.getRowCount());

    }

    /**
     * Expande todos os nodes
     *
     * @param jTree JTree de destino
     * @param inicioContagem Início da contagem
     * @param totalColunas Total de colunas
     */
    private void expandirNodes(JTree jTree, int inicioContagem, int totalColunas) {

        /* inicia a contagem e expande */
        for (int i = inicioContagem; i < totalColunas; ++i) {

            /* expande */
            jTree.expandRow(i);

        }

        /* valida o total da contagem */
        if (jTree.getRowCount() != totalColunas) {

            /* expande todos os nodes */
            expandirNodes(jTree, totalColunas, jTree.getRowCount());

        }

    }

}
