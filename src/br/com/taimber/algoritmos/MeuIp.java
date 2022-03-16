package br.com.taimber.algoritmos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Retorna o IP o endereço de IP onde a classe está rodando
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class MeuIp {

    /**
     * Retorna os dados de uma url
     *
     * @param url Url
     * @return String contendo os dados
     */
    private static String getDadosUrl(String url) {

        /* excessão */
        try {

            /* url do serviço de IP */
            URL urlServicoIp = new URL(url);

            /* lê os dados do serviço de IP */
            BufferedReader in = new BufferedReader(new InputStreamReader(urlServicoIp.openStream()));

            /* retorno */
            return in.readLine();

        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        }

        /* retorno */
        return null;

    }

    /**
     * Retorna o endereço IP
     *
     * @return
     */
    public static String retornar() {

        /* serviço de consulta de ip */
        String servicoDeConsultaDeIp = getDadosUrl("https://taimber.com/network/ip/");

        /* retorno */
        return getDadosUrl(servicoDeConsultaDeIp);

    }

}
