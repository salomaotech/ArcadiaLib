package br.com.taimber.algoritmos;

import java.text.Normalizer;

/**
 * Trata Strings removendo caracteres especiais
 *
 * @author E-mail(salomao@taimber.com)
 * @version 1.0
 */
public class RemoveCaracteresEspeciaisString {

    /**
     * Remove espaços em branco no fim e no inicio
     *
     * @param conteudo
     * @return String
     */
    private static String removeEspacoBrancoInicioFinal(Object conteudo) {

        /* string de retorno */
        String retorno = String.valueOf(conteudo);

        /* remove espaços em banco */
        retorno = retorno.trim();

        /* retorno */
        return retorno;

    }

    /**
     * Escapa dados
     *
     * @param conteudo
     * @return String
     */
    private static String escapaDados(Object conteudo) {

        /* string de retorno */
        String retorno = (String) conteudo;

        /* remove aspas */
        retorno = retorno.replaceAll("^\"+|\"+$", "");
        retorno = retorno.replaceAll("^[\"']+|[\"']+$", "");
        retorno = retorno.replace("'", "");
        retorno = retorno.replace("\\", "");

        /* retorno */
        return retorno;

    }

    /**
     * Converte uma para minúsculo
     *
     * @param conteudo
     * @return String
     */
    private static String converteMinusculo(Object conteudo) {

        /* string de retorno */
        String retorno = (String) conteudo;

        /* converte a primeira letra para maisculo e o restante para minusculo */
        retorno = retorno.substring(0, 1).toUpperCase().concat(retorno.substring(1).toLowerCase());

        /* retorno */
        return retorno;

    }

    /**
     * Remove acentos de uma string
     *
     * @param conteudo
     * @return String
     */
    private static String removeAcentos(Object conteudo) {

        /* string de retorno */
        String retorno = String.valueOf(conteudo);

        /* retorno */
        return Normalizer.normalize(retorno, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

    }

    /**
     * @param conteudo
     * @return String
     */
    public static String executa(Object conteudo) {

        /* trata excessão */
        try {

            /* remove espaços em branco no fim e no inicio */
            conteudo = removeEspacoBrancoInicioFinal(conteudo);

            /* remove acentos */
            conteudo = removeAcentos(conteudo);
            conteudo = converteMinusculo(conteudo);
            conteudo = escapaDados(conteudo);

            /* converte em string e retorna */
            return (String) conteudo;

        } catch (java.lang.StringIndexOutOfBoundsException ex) {

            /* retorno */
            return "";

        }

    }

}
