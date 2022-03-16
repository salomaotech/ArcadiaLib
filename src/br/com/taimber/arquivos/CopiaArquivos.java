package br.com.taimber.arquivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import static java.util.Objects.isNull;
import javax.swing.JFileChooser;

/**
 * Copia arquivos de um diretório para outro diretório
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class CopiaArquivos {

    private final JFileChooser selecionaArquivo;

    /**
     * Construtor
     *
     */
    public CopiaArquivos() {

        /* selecionador de arquivos */
        this.selecionaArquivo = new JFileChooser();
        this.selecionaArquivo.setMultiSelectionEnabled(true);

    }

    /**
     * Copia os arquivos mas antes abre o diálogo para selecionar a origem
     *
     * @param pathDestino Pasta de destino
     * @return True para sucesso ao copiar dados
     */
    public boolean copiarComDialogoParaSelecionarOrigem(String pathDestino) {

        /* retorno padrão */
        boolean retorno = false;

        /* cria a pasta se não existir */
        CriaPastaLocal.criar(pathDestino);

        /* valida */
        if (selecionaArquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && !isNull(pathDestino)) {

            /* array de arquivos */
            File[] arquivos = selecionaArquivo.getSelectedFiles();

            /* itera */
            for (File arquivo : arquivos) {

                /* excessão */
                try {

                    /* destino final */
                    String destino = pathDestino + "/" + arquivo.getName();

                    /* copia arquivo */
                    Files.copy(arquivo.toPath(), new File(destino).toPath(), StandardCopyOption.REPLACE_EXISTING);

                    /* seta retorno */
                    retorno = true;

                } catch (IOException ex) {

                    /* seta retorno */
                    retorno = false;

                    /* sai da iteração */
                    break;

                }

            }

        }

        /* retorno */
        return retorno;

    }

    /**
     * Copia os arquivos da origem para o destino
     *
     * @param pathOrigem Origem dos dados
     * @param pathDestino Destino dos dados
     * @return True para sucesso ao copiar dados
     */
    public boolean copiarDeOrigemParaDestino(String pathOrigem, String pathDestino) {

        /* cria a pasta se não existir */
        CriaPastaLocal.criar(pathOrigem);
        CriaPastaLocal.criar(pathDestino);

        /* origem e destino */
        Path origemArquivos = Paths.get(pathOrigem);
        Path destinoArquivos = Paths.get(pathDestino);

        /* excessão */
        try {

            /* lista os arquivos */
            Files.walk(origemArquivos).forEach(origem -> {

                /* excessão */
                try {

                    /* copia da origem para o destino */
                    Path destino = destinoArquivos.resolve(origemArquivos.relativize(origem));
                    Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException ex) {

                }

            });

            /* retorno */
            return true;

        } catch (IOException ex) {

            /* retorno */
            return false;

        }

    }

}
