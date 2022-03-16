package br.com.taimber.arquivos;

import java.io.File;

/**
 * Reinicializa o sistema
 *
 * @author E-mail(salomao@taimber.com)
 * @version 1.0
 */
public class ReiniciaSistema {

    /**
     * Reinicia o sistema
     */
    public static void reiniciar() {

        /* galhos */
        File[] galhos = new File(Diretorio.getDiretorioAbsolutoAtual()).listFiles();

        /* itera */
        for (File galho : galhos) {

            /* se for .jar para a iteração */
            if (galho.getName().contains(".jar")) {

                /* valida o sistema operacional */
                if (System.getProperty("os.name").equals("Linux")) {

                    /* linux */
                    ExecutaProgramaJarExterno.executar(Diretorio.getDiretorioAbsolutoAtual() + "/" + galho.getName());

                } else {

                    /* windows */
                    ExecutaProgramaJarExterno.executar(Diretorio.getDiretorioAbsolutoAtual() + "\\" + galho.getName());

                }

                /* para looping */
                break;

            }

        }

        /* fecha o sistema */
        System.exit(0);

    }

}
