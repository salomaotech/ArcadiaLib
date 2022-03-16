package br.com.taimber.arquivos;

import javax.swing.JFileChooser;

/**
 * Abre o diálogo para salvar um arquivo
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class DialogoSalvarArquivo {

    /**
     * Retorna o diretório selecionado
     *
     * @return Endereço da pasta onde será salvo o arquivo
     */
    public static String executar() {

        /* selecionador de arquivo */
        JFileChooser selecionaArquivo = new JFileChooser();

        /* valida se aprovou a seleção do arquivo */
        if (selecionaArquivo.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            /* retorna o diretório do arquivo */
            return selecionaArquivo.getSelectedFile().getAbsolutePath();

        } else {

            /* retorno */
            return null;

        }

    }

}
