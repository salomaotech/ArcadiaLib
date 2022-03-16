package br.com.taimber.arquivos;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lista os arquivos locais
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ListaArquivos {

    /**
     * Retorna uma lista com arquivos locais
     *
     * @param pastaDestino Pasta de destino
     * @return ArrayList com endereços de arquivos
     */
    public static ArrayList listar(String pastaDestino) {

        /* pastas */
        ArrayList pastas = new ArrayList();

        /* excessão */
        try {

            /* galhos */
            File[] galhos = new File(pastaDestino).listFiles();

            /* ordena */
            Arrays.sort(galhos);

            /* atualiza */
            pastas.addAll(Arrays.asList(galhos));

            /* retorno */
            return pastas;

        } catch (java.lang.NullPointerException ex) {

            /* retorno */
            return pastas;

        }

    }

}
