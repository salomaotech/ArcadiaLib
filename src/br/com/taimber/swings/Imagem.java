package br.com.taimber.swings;

import br.com.taimber.arquivos.ExecutaProgramaExterno;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Exibe imagem a pertir de um endereço do disco
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class Imagem {

    /**
     *
     * @param enderecoImagem Endereço da imagem
     * @param jPrincipal Painel de destino
     * @param largura Largura
     * @param altura Altura
     */
    public void exibir(String enderecoImagem, JPanel jPrincipal, int largura, int altura) {

        /* remove elementos antigos do painel */
        jPrincipal.removeAll();

        /* pega o arquivo pelo index */
        File arquivo = new File(enderecoImagem);

        /* elemento */
        JLabel elemento = new JLabel();
        elemento.setIcon(new ImageIcon(new ImageIcon(arquivo.getAbsolutePath()).getImage().getScaledInstance(largura, altura, Image.SCALE_DEFAULT)));
        elemento.setLocation(5, 5);
        elemento.setSize(largura, altura);

        /* adiciona elemento */
        jPrincipal.add(elemento);

        /* evento do mouse */
        elemento.addMouseListener(new MouseAdapter() {

            /* add evento do mouse */
            @Override
            public void mouseClicked(MouseEvent e) {

                /* clique */
                if (e.getClickCount() == 2 && !e.isConsumed()) {

                    /* executa o programa */
                    ExecutaProgramaExterno.executarModoDesktop(arquivo.getAbsolutePath());

                }

            }

        });

    }

}
