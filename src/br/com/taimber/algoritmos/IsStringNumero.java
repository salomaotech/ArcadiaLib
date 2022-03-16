package br.com.taimber.algoritmos;

/**
 * Retorna se uma string é um número
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class IsStringNumero {

    /**
     *
     * @param conteudo String a ser analisada
     * @return retorna se é um número por exemplo: 1500, ou 1500,36, ou ainda
     * 1500.36. Ou seja não serão ignorados ponto e virgula, somente letras e
     * espaços
     */
    public static boolean executa(String conteudo) {

        /* percorre por cada item da string */
        for (int i = 0; i < conteudo.length(); i++) {

            /* ignora o ponto e verifica se cada caractere é um número */
            if (conteudo.charAt(i) != '.' && conteudo.charAt(i) != ',' && Character.isDigit(conteudo.charAt(i)) == false) {

                /* retorno */
                return false;

            }

        }

        /* retorno */
        return true;

    }

}
