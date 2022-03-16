package br.com.taimber.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Baixa ArrayList de dados do servidor
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class BaixaStringDeDadosDoServidor {

    /**
     * Baixa os dados
     *
     * @param url URL a ser aberta na conexão
     * @return Dados
     */
    public static ArrayList baixar(String url) {

        /* retorno */
        ArrayList retorno = new ArrayList();

        /* excessão */
        try {

            InputStreamReader entrada = new InputStreamReader(new URL(url).openStream());
            BufferedReader br = new BufferedReader(entrada);
            String linha = br.readLine();

            /* valida a linha */
            while (linha != null) {

                /* atualiza o retorno */
                retorno.add(linha);

                /* atualiza a linha */
                linha = br.readLine();

            }

            /* fecha o que estiver aberto */
            br.close();

        } catch (IOException ex) {

        }

        /* retorno */
        return retorno;

    }

}
