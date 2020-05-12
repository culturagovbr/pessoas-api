package br.gov.cultura.sistema.pessoa;

import java.util.Calendar;

import br.gov.cultura.sistema.util.HashUtils;
import br.gov.cultura.sistema.util.PropertyFileUtils;

public class PessoaUtils {
    private static final String SENHA_GERACAO_HASH_SITUACAO_CADASTRAL = "SENHA";
    private static String configFileName = "config.properties";
    private static String messageFileName = "messages.properties";
    private static String nomeServicoRH = null;
    private static String estagioProjeto = null;
    private static String msgRegistroDuplicado = null;
    private static String msgEmailPrincipal = null;
    private static String msgContaCorrentePrincpal = null;
    private static String msgEnderecoOutroServico = null;
    private static String msgRhPermissaoAlterar = null;
    private static String msgAgenciaOutroBanco = null;
    private static String msgRegistrosDependentes = null;
    private static String msgAtualizarPessoaFisicaErro = null;
    private static String msgAtualizarPessoaFisicaAtributoErro = null;
    private static String msgPessoaFisicaNaoEncontrada = null;
    private static String msgPessoaJuridicaNaoEncontrada = null;
    private static String msgTelefoneReceitaFederal = null;
    private static int idServicoReceita = 0;

    public PessoaUtils() {
    }

    public static String gerarHashSituacaoCadastral(int idPessoa, Calendar data, int situacaoCadastral) {
        return HashUtils.getMD5("" + idPessoa + data.getTimeInMillis() + situacaoCadastral + SENHA_GERACAO_HASH_SITUACAO_CADASTRAL);
    }

    public static String getMsgRegistroDuplicado() {
        if (msgRegistroDuplicado == null) {
            msgRegistroDuplicado = PropertyFileUtils.readProperty(messageFileName, "msg.registro.duplicado");
        }

        return msgRegistroDuplicado;
    }

    public static String getMsgEmailPrincipal() {
        if (msgEmailPrincipal == null) {
            msgEmailPrincipal = PropertyFileUtils.readProperty(messageFileName, "msg.email.principal");
        }

        return msgEmailPrincipal;
    }

    public static String getMsgContaCorrentePrincipal() {
        if (msgContaCorrentePrincpal == null) {
            msgContaCorrentePrincpal = PropertyFileUtils.readProperty(messageFileName, "msg.conta.corrente.principal");
        }

        return msgContaCorrentePrincpal;
    }

    public static String getMsgEnderecoOutroServico() {
        if (msgEnderecoOutroServico == null) {
            msgEnderecoOutroServico = PropertyFileUtils.readProperty(messageFileName, "msg.endereco.outro.servico");
        }

        return msgEnderecoOutroServico;
    }

    public static String getMsgRhPermissaoAlterar() {
        if (msgRhPermissaoAlterar == null) {
            msgRhPermissaoAlterar = PropertyFileUtils.readProperty(messageFileName, "msg.rh.permissao.alterar");
        }

        return msgRhPermissaoAlterar;
    }

    public static String getMsgAgenciaOutroBanco() {
        if (msgAgenciaOutroBanco == null) {
            msgAgenciaOutroBanco = PropertyFileUtils.readProperty(messageFileName, "msg.agencia.outro.banco");
        }

        return msgAgenciaOutroBanco;
    }

    public static String getMsgRegistroDependentes() {
        if (msgRegistrosDependentes == null) {
            msgRegistrosDependentes = PropertyFileUtils.readProperty(messageFileName, "msg.registros.dependentes");
        }

        return msgRegistrosDependentes;
    }

    public static String getMsgAtualizarPessoaFisicaErro() {
        if (msgAtualizarPessoaFisicaErro == null) {
            msgAtualizarPessoaFisicaErro = PropertyFileUtils.readProperty(messageFileName, "msg.atualizar.pessoa.fisica.erro");
        }

        return msgAtualizarPessoaFisicaErro;
    }

    public static String getMsgAtualizarPessoaFisicaAtributoErro(String atributo) {
        if (msgAtualizarPessoaFisicaAtributoErro == null) {
            msgAtualizarPessoaFisicaAtributoErro = PropertyFileUtils.readProperty(messageFileName, "msg.atualizar.pessoa.fisica.atributo.erro");
        }

        return String.format(msgAtualizarPessoaFisicaAtributoErro, atributo);
    }

    public static String getMsgPessoaFisicaNaoEncontradada() {
        if (msgPessoaFisicaNaoEncontrada == null) {
        	msgPessoaFisicaNaoEncontrada = PropertyFileUtils.readProperty(messageFileName, "msg.pessoa.fisica.nao.encontrada");
        }

        return msgPessoaFisicaNaoEncontrada;
    }

    public static String getMsgPessoaJuridicaNaoEncontradada() {
        if (msgPessoaJuridicaNaoEncontrada == null) {
        	msgPessoaJuridicaNaoEncontrada = PropertyFileUtils.readProperty(messageFileName, "msg.pessoa.juridica.nao.encontrada");
        }

        return msgPessoaJuridicaNaoEncontrada;
    }
    
    public static String getMsgTelefoneReceitaFederal() {
        if (msgTelefoneReceitaFederal == null) {
            msgTelefoneReceitaFederal = PropertyFileUtils.readProperty(messageFileName, "msg.telefone.receita.federal");
        }

        return msgTelefoneReceitaFederal;
    }

    public static int getIdServicoReceita() {
        if (idServicoReceita == 0) {
            idServicoReceita = Integer.parseInt(PropertyFileUtils.readProperty(configFileName, "servico.receita.id", "0"));
        }

        return idServicoReceita;
    }

    public static String getNomeServicoRH() {
        if (nomeServicoRH == null) {
            nomeServicoRH = PropertyFileUtils.readProperty(configFileName, "servico.rh.nome", "RH");
        }

        return nomeServicoRH;
    }

    public static String getEstagioProjeto() {
        if (estagioProjeto == null) {
            estagioProjeto = PropertyFileUtils.readProperty(configFileName, "estagio.projeto", "desenvolvimento");
        }

        return estagioProjeto;
    }
    
}
