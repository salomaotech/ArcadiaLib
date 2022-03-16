package br.com.taimber.arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Leitor do arquivo de propriedades
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class LeitorDePropriedades {

    private Properties propriedades;

    /**
     * Construtor
     *
     * @param enderecoArquivo Endereço do arquivo a ser lido
     */
    public LeitorDePropriedades(String enderecoArquivo) {

        /* cria o arquivo de propriedades se ele não existir */
        criarArquivoSeNaoExistir(enderecoArquivo);

        /* excessão */
        try {

            /* propriedades */
            this.propriedades = new Properties();

            /* abre o arquivo */
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(enderecoArquivo), "UTF-8"));

            /* carrega o arquivo */
            this.propriedades.load(buffer);

            /* fecha o buffer de arquivo */
            buffer.close();

        } catch (IOException ex) {

        }

    }

    /* cria o arquivo de propriedades se ele não existir */
    private void criarArquivoSeNaoExistir(String enderecoArquivo) {

        /* arquivo */
        File arquivo = new File(enderecoArquivo);

        /* valida se pasta de propriedades existe */
        if (!new File(arquivo.getPath()).exists()) {

            /* excessão */
            try {

                /* cria pasta local */
                CriaPastaLocal.criar(arquivo.getPath().replace(arquivo.getName(), ""));

                /* cria o arquivo */
                arquivo.createNewFile();

            } catch (IOException ex) {

            }

        }

    }

    /**
     * Retorna as propriedades
     *
     * @return Retorna os dados das propriedades lido
     */
    public Properties getPropriedades() {

        return propriedades;

    }

}
