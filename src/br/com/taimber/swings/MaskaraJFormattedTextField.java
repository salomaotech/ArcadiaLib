package br.com.taimber.swings;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * Maskara de dados
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class MaskaraJFormattedTextField {

    /**
     * Seta a mascara em um JFormattedTextField
     *
     * @param campo Campo JFormattedTextField
     * @param mascara Mascara
     */
    public static void setMascara(JFormattedTextField campo, String mascara) {

        try {

            campo.setFormatterFactory(null);
            MaskFormatter format = new MaskFormatter(mascara);
            campo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
            campo.setValue(null);

        } catch (ParseException ex) {

        }

    }

}
