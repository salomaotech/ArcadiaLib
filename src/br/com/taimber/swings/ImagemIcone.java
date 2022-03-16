package br.com.taimber.swings;

import javax.swing.ImageIcon;

/**
 * Retorna um ImageIcon de um pacote
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ImagemIcone {

    /**
     * Retorna um ImageIcon de um pacote
     *
     * @param pathArquivo Endereço PATH do arquivo
     * @return ImageIcon
     */
    public ImageIcon getIcone(String pathArquivo) {

        /* excessão */
        try {

            /* retorno */
            return new ImageIcon(getClass().getResource(pathArquivo));

        } catch (java.lang.NullPointerException ex) {

            /* retorno */
            return null;

        }

    }
}
