package br.com.taimber.arquivos;

import java.io.File;

/**
 * Cria uma pasta no disco local
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class CriaPastaLocal {

    /**
     * Cria uma pasta
     *
     * @param destinoPath Endereço da pasta a ser criada
     * @return True conseguiu criar a pasta
     */
    public static boolean criar(String destinoPath) {

        /* arquivo */
        File novaPath = new File(destinoPath);

        /* valida se existe */
        if (!novaPath.exists()) {

            /* tenta criar e retorna */
            return novaPath.mkdirs();

        } else {

            /* retonrno */
            return false;

        }

    }

}
