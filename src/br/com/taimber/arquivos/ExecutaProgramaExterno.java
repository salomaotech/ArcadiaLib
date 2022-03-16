package br.com.taimber.arquivos;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Executa um programa java externo
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ExecutaProgramaExterno {

    /**
     * Executa um programa externo no modo desktop
     *
     * @param enderecoDoPrograma Endereço do programa
     * @return True conseguiu executar
     */
    public static boolean executarModoDesktop(String enderecoDoPrograma) {

        /* excessão */
        try {

            /* desktop */
            Desktop desktop = Desktop.getDesktop();
            File meuArquivo = new File(enderecoDoPrograma);
            desktop.open(meuArquivo);

            /* retorno */
            return true;

        } catch (IOException ex) {

            /* retorno */
            return false;

        }

    }

    /**
     * Executa um programa externo no modo runtime usando array de instruções
     *
     * @param arrayDeInstrucoes Endereço do programa
     * @return True conseguiu executar
     */
    public static boolean executarModoRuntimeArrayComandos(String[] arrayDeInstrucoes) {

        /* excessão */
        try {

            /* processo */
            Process p = Runtime.getRuntime().exec(arrayDeInstrucoes);
            p.waitFor();

            /* retorno */
            return true;

        } catch (IOException | InterruptedException ex) {

            /* retorno */
            return false;

        }

    }

    /**
     * Executa um programa externo no modo runtime usando linha de comando
     *
     * @param linhaDeComando Linha de comando
     * @return True conseguiu executar
     */
    public static boolean executarModoRuntimeLinhaDeComando(String linhaDeComando) {

        /* excessão */
        try {

            /* processo */
            Process p = Runtime.getRuntime().exec(linhaDeComando);
            p.waitFor();

            /* retorno */
            return true;

        } catch (IOException | InterruptedException ex) {

            /* retorno */
            return false;

        }

    }

}
