package br.com.taimber.persistencia.sql;

import br.com.taimber.algoritmos.RemoveCaracteresEspeciaisString;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Objects.isNull;

/**
 * Trata entidades antes de gravar no banco de dados
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class SqlTrataEntidades {

    /* trata dados antes de gravar */
    public static LinkedHashMap tratar(Map entidades) {

        /* map de retorno */
        LinkedHashMap retorno = new LinkedHashMap();

        /* listando entidades */
        for (Object chave : entidades.keySet()) {

            /* valor da chave */
            Object valor = entidades.get(chave);

            /* valida o valor */
            if (isNull(valor)) {

                /* valor padrão */
                valor = "";

            }

            /* atualiza o retorno */
            retorno.put(chave, RemoveCaracteresEspeciaisString.executa(valor));

        }

        /* retorno */
        return retorno;

    }

}
