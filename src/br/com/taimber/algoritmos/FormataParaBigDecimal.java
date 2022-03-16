package br.com.taimber.algoritmos;

import java.math.BigDecimal;

/**
 * Formata um número para BigDecimal
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class FormataParaBigDecimal {

    /**
     * Formata
     *
     * @param numero Número a ser formatado
     * @return Retorna o valor no formato BigDecimal
     */
    public static BigDecimal formatar(Object numero) {

        /* excessão */
        try {

            /* converte a virgula em ponto */
            numero = numero.toString().replace(",", ".");

            /* retorno */
            return new BigDecimal(String.valueOf(numero));

        } catch (java.lang.NumberFormatException | java.lang.NullPointerException | java.lang.ClassCastException ex) {

            /* retorno */
            return new BigDecimal(0);

        }

    }

}
