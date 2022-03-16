package br.com.taimber.algoritmos;

import java.math.BigDecimal;

/**
 * Avalia se um número é inteiro
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class IsNumeroInteiro {

    /**
     * Retorna se um número é inteiro
     *
     * @param numeroString Número
     * @return True é um numero inteiro, ou seja, sem resto
     */
    public static boolean is(Object numeroString) {

        /* excessão */
        try {

            /* número BigDecimal */
            BigDecimal numeroBigDecimal = FormataParaBigDecimal.formatar(numeroString);

            /* resto depois do ponto */
            BigDecimal resto = FormataParaBigDecimal.formatar(numeroBigDecimal.toBigInteger()).remainder(numeroBigDecimal);
            resto = numeroBigDecimal.remainder(resto);

            /* retorno */
            return resto.compareTo(new BigDecimal("0")) <= 0;

        } catch (java.lang.ArithmeticException ex) {

            /* retorno */
            return true;

        }

    }

}
