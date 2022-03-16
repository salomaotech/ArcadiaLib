package br.com.taimber.arquivos;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 * Abre uma URL
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class AbrirUrl {

    /**
     * Abre uma url de um site
     *
     * @param url Endereço
     */
    public static void Abrir(String url) {

        /* excessão */
        try {

            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(url);
            desktop.browse(oURL);

        } catch (IOException | URISyntaxException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
