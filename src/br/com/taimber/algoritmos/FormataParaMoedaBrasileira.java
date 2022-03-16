package br.com.taimber.algoritmos;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Cifra para moeda brasileira estilo R$ 299,99
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class FormataParaMoedaBrasileira {

    /**
     * Cifrar
     *
     * @param numero Número a ser cifrado
     * @return Número no formato R$ 299,99
     */
    public static String cifrar(Object numero) {

        /* trata excessão */
        try {

            /* BigDecimal */
            BigDecimal valor = FormataParaBigDecimal.formatar(numero);

            /* formata o numero */
            NumberFormat nf = NumberFormat.getCurrencyInstance();

            /* retorno */
            return nf.format(valor);

        } catch (java.lang.NumberFormatException ex) {

            /* retorno */
            return "";

        }

    }

}
