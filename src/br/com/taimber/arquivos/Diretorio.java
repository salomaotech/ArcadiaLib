package br.com.taimber.arquivos;

import java.io.File;

/**
 * Trabalha com diretórios, pastas
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class Diretorio {

    /**
     * Retorna o diretório absoluto atual
     *
     * @return Diretório atual absoluto
     */
    public static String getDiretorioAbsolutoAtual() {

        return new File("").getAbsolutePath();

    }

}
