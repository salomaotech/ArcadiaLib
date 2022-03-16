package br.com.taimber.swings;

import br.com.taimber.algoritmos.IsStringNumero;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Valida campos numéricos
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ValidaCamposNumericos {

    /**
     * Valida campos númericos
     *
     * @param campo Campo de entrada
     * @return True os campos passaram no teste
     */
    public static boolean isCamposNumericosValidados(JTextField campo) {

        /* mensagem */
        String mensagem = "Informe um valor monetário corretamente.\nExemplo 1.99 ou 1,99.";

        /* valida se informou o valor */
        if (campo.getText().length() == 0) {

            /* diálogo */
            JOptionPane.showMessageDialog(null, mensagem);

            /* move o foco */
            campo.requestFocus();

            /* retorno */
            return false;

        }

        /* valida se é um número */
        if (!IsStringNumero.executa(campo.getText())) {

            /* diálogo */
            JOptionPane.showMessageDialog(null, mensagem);

            /* move o foco */
            campo.requestFocus();

            /* retorno */
            return false;

        }

        /* valida se há ponto e virgula ao mesmo tempo */
        if (campo.getText().contains(".") && campo.getText().contains(",")) {

            /* diálogo */
            JOptionPane.showMessageDialog(null, mensagem);

            /* move o foco */
            campo.requestFocus();

            /* retorno */
            return false;

        }

        /* retorno */
        return true;

    }

}
