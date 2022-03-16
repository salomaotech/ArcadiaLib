package br.com.taimber.algoritmos;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 * Maskara de dados
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class MaskaraDeDados {

    /**
     * Maskara para CNPJ
     *
     * @param valor Valor
     * @return Exemplo 00.000.000/0000-00
     */
    public static String cnpj(String valor) {

        /* excessão */
        try {

            /* mascara */
            MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);

            /* retorno */
            return mask.valueToString(valor);

        } catch (ParseException ex) {

        }

        /* retorno */
        return valor;

    }

    /**
     * Maskara para CPF
     *
     * @param valor Valor
     * @return Exemplo 000.000.000-00
     */
    public static String cpf(String valor) {

        /* excessão */
        try {

            /* mascara */
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);

            /* retorno */
            return mask.valueToString(valor);

        } catch (ParseException ex) {

        }

        /* retorno */
        return valor;

    }

    /**
     * Remove maskara de valor
     *
     * @param valor Valor
     * @return Se entrar 000.000.000-00 sai 00000000000
     */
    public static String removeMaskara(String valor) {

        /* remove formatação */
        valor = valor.replace(".", "");
        valor = valor.replace("-", "");
        valor = valor.replace("/", "");
        valor = valor.trim();

        /* retorno */
        return valor;

    }

}
