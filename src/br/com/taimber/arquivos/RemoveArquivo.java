package br.com.taimber.arquivos;

import java.io.File;
import static java.util.Objects.isNull;

/**
 * Remove um arquivo
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class RemoveArquivo {

    /**
     * Remove um arquivo
     *
     * @param pathArquivo Caminho do arquivo
     * @return True se conseguiu remover arquivo
     */
    public static boolean remover(String pathArquivo) {

        /* valida endereço de arquivo */
        if (!isNull(pathArquivo)) {

            /* arquivo */
            File arquivo = new File(pathArquivo);

            /* retorno */
            return arquivo.delete();

        } else {

            /* retorno */
            return false;

        }

    }

}
