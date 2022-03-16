package br.com.taimber.arquivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 * Executa um programa java externo no formato .jar
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ExecutaProgramaJarExterno {

    /**
     * Executa um programa externo
     *
     * @param enderecoDoPrograma Endereço do programa
     */
    public static void executar(String enderecoDoPrograma) {

        /* excessão */
        try {

            /* pasta do programa */
            Path pastaDoPrograma = Paths.get(enderecoDoPrograma);

            /* arquivo */
            File arquivo = new File(pastaDoPrograma.getParent().toString());

            /* comando */
            String comandoExecutar = "java -jar " + pastaDoPrograma.getFileName();

            /* roda o processo */
            Runtime.getRuntime().exec(comandoExecutar, null, arquivo);

        } catch (IOException ex) {

            /* dialogo */
            JOptionPane.showMessageDialog(null, "Falha ao abrir " + enderecoDoPrograma + "\n" + ex.getMessage());

        }

    }

    /**
     * Executa um programa externo
     *
     * @param enderecoDoPrograma Endereço do programa
     * @param parametro Parâmetros
     */
    public static void executar(String enderecoDoPrograma, Object parametro) {

        /* excessão */
        try {

            /* pasta do programa */
            Path pastaDoPrograma = Paths.get(enderecoDoPrograma);

            /* arquivo */
            File arquivo = new File(pastaDoPrograma.getParent().toString());

            /* comando */
            String comandoExecutar = "java -jar " + pastaDoPrograma.getFileName() + " " + parametro;

            /* roda o processo */
            Runtime.getRuntime().exec(comandoExecutar, null, arquivo);

        } catch (IOException ex) {

            /* dialogo */
            JOptionPane.showMessageDialog(null, "Falha ao abrir " + enderecoDoPrograma + "\n" + ex.getMessage());

        }

    }

}
