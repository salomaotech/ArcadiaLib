package br.com.taimber.algoritmos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Retorna data atual
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class Datas {

    /**
     * Data no formato dd/MM/yyyy
     *
     * @return Exemplo 15/09/1989
     */
    public static String getDataAtualDiaMesAno() {

        /* instancia da data atual */
        Date date = Calendar.getInstance().getTime();

        /* formatador de datas */
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        /* retorno */
        return dateFormat.format(date);

    }

    /**
     * Data no formato dd/MM/yyyy HH:mm
     *
     * @return Exemplo 15/09/1989 23:30
     */
    public static String getDataAtualDiaMesAnoComHoraMinuto() {

        /* instancia da data atual */
        Date date = Calendar.getInstance().getTime();

        /* formatador de datas */
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        /* retorno */
        return dateFormat.format(date);

    }

    /**
     * Data no formato dd/MM/yyyy HH:mm:ss
     *
     * @return Exemplo 15/09/1989 23:30
     */
    public static String getDataAtualDiaMesAnoComHoraMinutoSegundo() {

        /* instancia da data atual */
        Date date = Calendar.getInstance().getTime();

        /* formatador de datas */
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        /* retorno */
        return dateFormat.format(date);

    }

    /**
     * Retorna se a data inicial é menor do que a data final
     *
     * @param dataInicial Data inicial no formato dd/MM/yyyy
     * @param dataFinal Data final no formato dd/MM/yyyy
     * @return Se retornar true a data inicial é menor do que a data final
     */
    public static boolean isDataInicialMenorDataFinal(Object dataInicial, Object dataFinal) {

        /* excessão */
        try {

            /* formatador de datas */
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            /* data inicial e final */
            Date d1 = dateFormat.parse((String) dataInicial);
            Date d2 = dateFormat.parse((String) dataFinal);

            /* retorno */
            return d1.before(d2);

            /* retorno */
        } catch (ParseException ex) {

        }

        /* retorno */
        return false;

    }

    /**
     * Retorna se a data inicial é igual a data final
     *
     * @param dataInicial Data inicial no formato dd/MM/yyyy
     * @param dataFinal Data final no formato dd/MM/yyyy
     * @return Se retornar true a data inicial é igual a data final
     */
    public static boolean isDataInicialIgualDataFinal(Object dataInicial, Object dataFinal) {

        /* excessão */
        try {

            /* formatador de datas */
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            /* data inicial e final */
            Date d1 = dateFormat.parse((String) dataInicial);
            Date d2 = dateFormat.parse((String) dataFinal);

            /* retorno */
            return d1.equals(d2);

            /* retorno */
        } catch (ParseException ex) {

        }

        /* retorno */
        return false;

    }

    /**
     * Retorna se a data inicial é menor do que a data final
     *
     * @param dataInicial Data inicial no formato dd/MM/yyyy HH:mm
     * @param dataFinal Data final no formato dd/MM/yyyy HH:mm
     * @return Se retornar true a data inicial é igual a data final com hora e
     * minuto exemplo 15/09/1989 22:30
     */
    public static boolean isDataInicialMenorDataFinalComHoraMinuto(Object dataInicial, Object dataFinal) {

        /* excessão */
        try {

            /* formatador de datas */
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            /* data inicial e final */
            Date d1 = dateFormat.parse((String) dataInicial);
            Date d2 = dateFormat.parse((String) dataFinal);

            /* retorno */
            return d1.before(d2);

            /* retorno */
        } catch (ParseException ex) {

        }

        /* retorno */
        return false;

    }

    /**
     * Adiciona meses a uma data
     *
     * @param dataParametro Data no formato dia/mes/ano
     * @param quantidadeMeses Quantidade de meses a serem adicionados
     * @return Exemplo 01/01/2021 adicionar 01 mes fica 01/02/2021
     */
    public static String adicionaMesData(String dataParametro, int quantidadeMeses) {

        /* excessão */
        try {

            /* desmembra a data */
            String[] dataDesmenbrada = dataParametro.split("/");

            /* data */
            LocalDate data = LocalDate.of(Integer.valueOf(dataDesmenbrada[2]), Integer.valueOf(dataDesmenbrada[1]), Integer.valueOf(dataDesmenbrada[0]));

            /* adiciona mes */
            data = data.plusMonths(quantidadeMeses);

            /* data no formato array */
            String[] dataArray = data.toString().split("-");

            /* retorno */
            return dataArray[2] + "/" + dataArray[1] + "/" + dataArray[0];

        } catch (java.lang.NumberFormatException ex) {

            /* retorno */
            return null;

        }

    }

    /**
     * Retorna uma data amigável no estilo Sabado 23 de outubro de 2021
     *
     * @param data Data no formato 23/10/2021
     * @return Data amigável no estilo Sabado 23 de outubro de 2021
     */
    public static String dataAmigavel(String data) {

        /* valida se é hoje */
        if (data.equals(getDataAtualDiaMesAno())) {

            /* retorno */
            return "Hoje";

        }

        /* dia da semana */
        String diaSemana = null;

        /* mes mes do ano */
        String mesAno = null;

        /* mes */
        String[] arrayData = data.split("/");

        /* excessão */
        try {

            /* formata data */
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            /* nova data */
            Date novaData = sdf.parse(data);

            /* novo calendario */
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(novaData);

            /* dia da semana */
            switch (gc.get(GregorianCalendar.DAY_OF_WEEK)) {

                case 1:
                    diaSemana = "Domingo";
                    break;

                case 2:
                    diaSemana = "Segunda-feira";
                    break;

                case 3:
                    diaSemana = "Terça-feira";
                    break;

                case 4:
                    diaSemana = "Quarta-feira";
                    break;

                case 5:
                    diaSemana = "Quinta-feira";
                    break;

                case 6:
                    diaSemana = "Sexta-feira";
                    break;

                case 7:
                    diaSemana = "Sabado";
                    break;

            }

            /* mes atual */
            switch (Integer.parseInt(arrayData[1])) {

                case 1:
                    mesAno = "Janeiro";
                    break;

                case 2:
                    mesAno = "Fevereiro";
                    break;

                case 3:
                    mesAno = "Marco";
                    break;

                case 4:
                    mesAno = "Abril";
                    break;

                case 5:
                    mesAno = "Maio";
                    break;

                case 6:
                    mesAno = "Junho";
                    break;

                case 7:
                    mesAno = "Julho";
                    break;

                case 8:
                    mesAno = "Agosto";
                    break;

                case 9:
                    mesAno = "Setembro";
                    break;

                case 10:
                    mesAno = "Outubro";
                    break;

                case 11:
                    mesAno = "Novembro";
                    break;

                case 12:
                    mesAno = "Dezembro";
                    break;

            }

        } catch (ParseException ex) {

        }

        /* retorno */
        return diaSemana + " " + arrayData[0] + " de " + mesAno + " de " + arrayData[2];

    }

    /**
     * Converte um Date para String
     *
     * @param data Date no formato dd/MM/yyyy
     * @return Saída Date no formato dd/MM/yyyy
     */
    public static String converterDateParaString(Date data) {

        /* excessão */
        try {

            /* retorno */
            return new SimpleDateFormat("dd/MM/yyyy").format(data);

        } catch (java.lang.NullPointerException ex) {

            /* retorno */
            return null;

        }

    }

    /**
     * Converte uma String para um Date
     *
     * @param data String no formato dd/MM/yyyy
     * @return Saída String no formato dd/MM/yyyy
     */
    public static Date converterStringParaDate(String data) {

        /* excessão */
        try {

            /* retorno */
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);

        } catch (ParseException ex) {

            /* retorno */
            return null;

        }

    }

}
