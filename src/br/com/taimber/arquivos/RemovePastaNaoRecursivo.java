package br.com.taimber.arquivos;

import java.io.File;
import static java.util.Objects.isNull;

/**
 * Remove uma pasta e seus arquivos não recursivo
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class RemovePastaNaoRecursivo {

    /**
     * Remove uma pasta com seus arquivos
     *
     * @param pathDestino Pasta de destino
     * @return True se conseguiu remover a pasta
     */
    public static boolean remover(String pathDestino) {

        /* valida */
        if (!isNull(pathDestino)) {

            /* excessão */
            try {

                /* arquivos */
                File arquivos = new File(pathDestino);

                /* lista de arquivos */
                File[] listaDeArquivos = arquivos.listFiles();

                /* itera */
                for (File arquivo : listaDeArquivos) {

                    /* remove o arquivo */
                    arquivo.delete();

                }

                /* agora remove a pasta */
                File arquivo = new File(pathDestino);

                /* retorno */
                return arquivo.delete();

            } catch (java.lang.NullPointerException ex) {

                /* retorno */
                return false;

            }

        } else {

            /* retorno */
            return false;

        }

    }

}
