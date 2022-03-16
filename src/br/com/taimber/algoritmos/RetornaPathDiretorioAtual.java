package br.com.taimber.algoritmos;

import java.nio.file.Paths;

/**
 * Retorna o diretorio atual
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class RetornaPathDiretorioAtual {

    /**
     * Retorna o diretorio atual
     *
     * @return Diretório atual
     */
    public static String retornar() {

        /* retorno */
        return Paths.get(".").toAbsolutePath().normalize().toString();

    }

}
