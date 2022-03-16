package br.com.taimber.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Envia uma String de dados para o servidor
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class EnviaStringDeDadosParaServidor {

    /**
     * Envia os dados para a url informada
     *
     * @param url Url para onde os dados serão enviados
     * @return True conseguiu enviar os dados
     */
    public static boolean enviar(String url) {

        /* excessão */
        try {

            /* formata a String */
            url = url.replace(" ", "%20");

            /* abre a conexão e envia os dados */
            InputStream is = new URL(url).openStream();

            /* fecha a conexão */
            is.close();

            /* retorno */
            return true;

        } catch (MalformedURLException ex) {

            /* retorno */
            return false;

        } catch (IOException ex) {

            /* retorno */
            return false;

        }

    }

}
