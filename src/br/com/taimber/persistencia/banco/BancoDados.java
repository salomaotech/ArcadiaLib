package br.com.taimber.persistencia.banco;

import br.com.taimber.persistencia.crud.CriaBancoDeDados;
import br.com.taimber.persistencia.crud.CriaTabela;
import br.com.taimber.persistencia.crud.AtualizaRegistro;
import br.com.taimber.persistencia.crud.DeletaRegistro;
import br.com.taimber.persistencia.crud.ExcluiBancoDeDados;
import br.com.taimber.persistencia.crud.InsereRegistro;
import br.com.taimber.persistencia.crud.ConsultaRegistro;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Gerencia o banco de dados
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class BancoDados {

    private final ConexaoSingleTon conexao;

    /**
     * Construtor
     *
     * @param conexao Conexão com o servidor
     */
    public BancoDados(ConexaoSingleTon conexao) {

        this.conexao = conexao;

    }

    /**
     * Criar banco de dados
     *
     * @param nomeBanco Nome do banco de dados
     * @return Retorna true para sucesso
     */
    public boolean criarBancoDeDados(String nomeBanco) {

        /* retorno */
        boolean retorno = CriaBancoDeDados.executar(this.conexao, nomeBanco);

        /* fecha a conexão */
        this.conexao.fecha();

        /* retorno */
        return retorno;

    }

    /**
     * Criar tabela
     *
     * @param tabela Nome da tabela
     * @param entidades Entidades a serem criadas
     * @return Retorna true para sucesso
     */
    public boolean criarTabela(String tabela, LinkedHashMap entidades) {

        /* retorno */
        return CriaTabela.executar(this.conexao, tabela, entidades);

    }

    /**
     * Consultar registro por uma instrução query direta
     *
     * @param instrucaoQuery Instrução query
     * @return List com Map de dados
     */
    public List consultarRegistro(String instrucaoQuery) {

        /* retorno */
        return ConsultaRegistro.executar(this.conexao, instrucaoQuery);

    }

    /**
     * Consultar registro
     *
     * @param tabela Nome da tabela
     * @param entidades List com campos a serem consultados
     * @param condicaoPesquisa Condição de pesquisa exemplo: where id='1'
     * @return List com Map de dados
     */
    public List consultarRegistro(String tabela, List entidades, String condicaoPesquisa) {

        /* retorno */
        return ConsultaRegistro.executar(this.conexao, tabela, entidades, condicaoPesquisa);

    }

    /**
     * Inserir registro
     *
     * @param tabela Nome da tabela
     * @param entidades LinkedHashMap com dados a serem inseridos
     * @return True para sucesso
     */
    public boolean inserirRegistro(String tabela, LinkedHashMap entidades) {

        /* retorno */
        return InsereRegistro.executar(this.conexao, tabela, entidades);

    }

    /**
     * Atualizar registro
     *
     * @param tabela Nome da tabela
     * @param entidades LinkedHashMap com dados a serem inseridos
     * @param condicoes LinkedHashMap com condições a serem avaliadas
     * @return True para sucesso
     */
    public boolean atualizarRegistro(String tabela, LinkedHashMap entidades, LinkedHashMap condicoes) {

        /* retorno */
        return AtualizaRegistro.executar(this.conexao, tabela, entidades, condicoes);

    }

    /**
     * Deletar registro
     *
     * @param tabela Nome da tabela
     * @param chave ID de chave primária
     * @return True para sucesso
     */
    public boolean deletarRegistro(String tabela, String chave) {

        /* retorno */
        return DeletaRegistro.executar(this.conexao, tabela, chave);

    }

    /**
     * Excluir banco de dados
     *
     * @param nomeBanco Nome do banco de dados
     * @return Retorna true para sucesso
     */
    public boolean excluirBancoDeDados(String nomeBanco) {

        /* retorno */
        boolean retorno = ExcluiBancoDeDados.executar(this.conexao, nomeBanco);

        /* fecha a conexão */
        this.conexao.fecha();

        /* retorno */
        return retorno;

    }

}
