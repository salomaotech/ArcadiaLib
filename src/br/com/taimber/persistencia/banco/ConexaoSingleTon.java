package br.com.taimber.persistencia.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Objects.isNull;

/**
 * Responsável por gerenciar conexões com o servidor do banco de dados
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class ConexaoSingleTon {

    private static Connection connection;
    private final ArrayList erros = new ArrayList();

    /**
     * Construtor
     *
     * @param servidor Host do servidor
     * @param banco Nome do banco de dados
     * @param login Login
     * @param senha Senha
     * @param porta Porta
     */
    public ConexaoSingleTon(String servidor, String banco, String login, String senha, String porta) {

        /* valida se a conexão já foi instanciada */
        if (ConexaoSingleTon.isFechada()) {

            /* conecta-se ao servidor de banco de dados */
            this.conecta(servidor, banco, login, senha, porta);

        }

    }

    /**
     * Conecta-se ao servidor de banco de dados
     *
     * @param servidor Host do servidor
     * @param banco Nome do banco de dados
     * @param login Login
     * @param senha Senha
     * @param porta Porta
     */
    private void conecta(String servidor, String banco, String login, String senha, String porta) {

        /* excessão */
        try {

            /* valida o banco de dados */
            if (!isNull(banco)) {

                /* conecta-se */
                ConexaoSingleTon.connection = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + porta + "/" + banco, login, senha);

            } else {

                /* conecta-se */
                ConexaoSingleTon.connection = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + porta + "/", login, senha);

            }

        } catch (SQLException ex) {

            /* falha */
            this.erros.add(ex.getMessage());

        }

    }

    /**
     * Fecha uma conexão
     *
     * @return True para fechada
     */
    public boolean fecha() {

        /* excessão */
        try {

            /* fecha a conexão */
            ConexaoSingleTon.connection.close();

            /* retorno */
            return true;

        } catch (SQLException | java.lang.NullPointerException ex) {

            /* falha */
            this.erros.add(ex.getMessage());

        }

        /* retorno */
        return false;

    }

    /**
     * Retorna a conexão
     *
     * @return Connection
     */
    public Connection getConnection() {

        return connection;

    }

    /**
     * Retorna a mensagem da falha
     *
     * @return ex.getMessage()
     */
    public ArrayList getErros() {

        return this.erros;

    }

    /**
     * Retorna se a conexão está fechada
     *
     * @return True está fechada
     */
    public static boolean isFechada() {

        /* excessão */
        try {

            /* retorno */
            return ConexaoSingleTon.connection.isClosed();

        } catch (SQLException | java.lang.NullPointerException ex) {

            /* retorno */
            return true;

        }

    }

}
