package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.ContaCorrente;
import br.gov.cultura.sistema.model.corporativo.Email;
import br.gov.cultura.sistema.model.corporativo.Endereco;
import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.corporativo.PessoaEstrangeira;
import br.gov.cultura.sistema.model.corporativo.PessoaFisica;
import br.gov.cultura.sistema.model.corporativo.PessoaJuridica;
import br.gov.cultura.sistema.model.corporativo.PessoaVinculada;
import br.gov.cultura.sistema.model.corporativo.SituacaoCadastralPJ;
import br.gov.cultura.sistema.model.corporativo.Telefone;
import br.gov.cultura.sistema.model.corporativo.TipoLucro;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.PessoaEstrangeiraService;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.pessoa.service.PessoaJuridicaService;
import br.gov.cultura.sistema.service.SegurancaService;
import br.gov.cultura.sistema.util.DateUtils;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pessoa_juridica")
@Auditar
public class PessoaJuridicaRESTService {
    @Inject
    private PessoaJuridicaService service;
    @Inject
    private PessoaFisicaService pfService;
    @Inject
    private PessoaEstrangeiraService peService;
    @Inject
    private SegurancaService segurancaService;

    public PessoaJuridicaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/verificar_situacao_cadastral/{cnpj}/{hash}")
    public Response verificarSituacaoCadastralPessoaJuridica(@PathParam("cnpj") String cnpj, @PathParam("hash") String hash, @Context HttpServletRequest request) {
        try {
            if (ValidacaoUtils.isCNPJ(cnpj)) {
                SituacaoCadastralPJ situacao = this.service.getSituacaoCadastral(cnpj, hash);
                if (situacao == null) {
                    throw new NegocioException("Hash não válido para essa empresa");
                } else {
                    String hashGerado = PessoaUtils.gerarHashSituacaoCadastral(situacao.getIdPessoaJuridica(), situacao.getDtSituacaoCadastral(), situacao.getTipoSituacaoCadastral().getCdSituacaoCadastral());
                    if (!hash.equals(hashGerado)) {
                        throw new NegocioException("Erro de integridade, o hash foi alterado");
                    } else {
                        SituacaoCadastralPJ situacaoAtual = this.service.getSituacaoCadastralAtual(cnpj);
                        return Response.ok(this.getReturnFields(situacaoAtual, cnpj)).build();
                    }
                }
            } else {
                throw new NegocioException("CPF Inválido");
            }
        } catch (NegocioException var7) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var7.getErroMap()).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cnpj}")
    public Response retornarPessoaJuridicaTudo(@PathParam("cnpj") String cnpj, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        try {
            if (ValidacaoUtils.isCNPJ(cnpj)) {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaJuridica pj = this.service.getPessoaJuridicaPorCNPJ(cnpj, servico, forcarBuscaNaReceita);
                return pj == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsTudo(pj)).build();
            } else {
                Map<String, String> map = new HashMap(1);
                map.put("erro", "CNPJ Inválido");
                return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
            }
        } catch (NegocioException var6) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cnpj}/basico")
    public Response retornarPessoaJuridicaBasico(@PathParam("cnpj") String cnpj, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        try {
            if (ValidacaoUtils.isCNPJ(cnpj)) {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaJuridica pj = this.service.getPessoaJuridicaPorCNPJ(cnpj, servico, forcarBuscaNaReceita);
                return pj == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsBasicas(pj)).build();
            } else {
                Map<String, String> map = new HashMap(1);
                map.put("erro", "CNPJ Inválido");
                return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
            }
        } catch (NegocioException var6) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cnpj}/endereco")
    public Response retornarPessoaJuridicaEndereco(@PathParam("cnpj") String cnpj, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        try {
            if (ValidacaoUtils.isCNPJ(cnpj)) {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaJuridica pj = this.service.getPessoaJuridicaPorCNPJ(cnpj, servico, forcarBuscaNaReceita);
                return pj == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsEndereco(pj)).build();
            } else {
                Map<String, String> map = new HashMap(1);
                map.put("erro", "CNPJ Inválido");
                return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
            }
        } catch (NegocioException var6) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cnpj}/vinculo_pessoa")
    public Response retornarPessoaJuridicaVinculoPessoa(@PathParam("cnpj") String cnpj, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        try {
            if (ValidacaoUtils.isCNPJ(cnpj)) {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaJuridica pj = this.service.getPessoaJuridicaPorCNPJ(cnpj, servico, forcarBuscaNaReceita);
                return pj == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsVinculoPessoa(pj)).build();
            } else {
                Map<String, String> map = new HashMap(1);
                map.put("erro", "CNPJ Inválido");
                return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
            }
        } catch (NegocioException var6) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cnpj}/informacao_bancaria")
    public Response retornarPessoaJuridicaInformacaoBancaria(@PathParam("cnpj") String cnpj, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        try {
            if (ValidacaoUtils.isCNPJ(cnpj)) {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaJuridica pj = this.service.getPessoaJuridicaPorCNPJ(cnpj, servico, forcarBuscaNaReceita);
                return pj == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsInformacoesBancarias(pj)).build();
            } else {
                Map<String, String> map = new HashMap(1);
                map.put("erro", "CNPJ Inválido");
                return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
            }
        } catch (NegocioException var6) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
        }
    }

    private Map<String, Object> getReturnFieldsBasicas(PessoaJuridica pj) {
        Map<String, Object> toReturn = new LinkedHashMap();
        toReturn.put("idPessoaJuridica", pj.getIdPessoaJuridica());
        SituacaoCadastralPJ situacao = pj.getSituacaoCadastralAtual();
        LinkedHashMap naturezaJuridica;
        if (situacao != null) {
            naturezaJuridica = new LinkedHashMap(3);
            naturezaJuridica.put("dsHash", situacao.getDsHash());
            naturezaJuridica.put("dtSituacaoCadastral", DateUtils.getDataHoraFormatada(situacao.getDtSituacaoCadastral()));
            Map<String, Object> tipoSituacaoCadastral = new LinkedHashMap(2);
            if (situacao.getTipoSituacaoCadastral() != null) {
                tipoSituacaoCadastral.put("cdSituacaoCadastral", situacao.getTipoSituacaoCadastral().getCdSituacaoCadastral());
                tipoSituacaoCadastral.put("dsSituacaoCadastral", situacao.getTipoSituacaoCadastral().getDsSituacaoCadastral());
            }

            naturezaJuridica.put("tipoSituacaoCadastral", tipoSituacaoCadastral);
            toReturn.put("situacaoCadastral", naturezaJuridica);
        }

        naturezaJuridica = new LinkedHashMap(1);
        if (pj.getNaturezaJuridica() != null) {
            naturezaJuridica.put("cdNaturezaJuridica", pj.getNaturezaJuridica().getCdNaturezaJuridica());
            naturezaJuridica.put("dsNaturezaJuridica", pj.getNaturezaJuridica().getDsNaturezaJuridica());
        }

        toReturn.put("naturezaJuridica", naturezaJuridica);
        List<Map<String, Object>> tiposLucro = new ArrayList();
        if (pj.getTiposLucro() != null) {
            Iterator var7 = pj.getTiposLucro().iterator();

            while(var7.hasNext()) {
                TipoLucro tp = (TipoLucro)var7.next();
                Map<String, Object> tipoLucro = new LinkedHashMap(2);
                tipoLucro.put("idTipoLucro", tp.getIdTipoLucro());
                tipoLucro.put("dsTipoLucro", tp.getDsTipoLucro());
                tiposLucro.add(tipoLucro);
            }
        }

        toReturn.put("tiposLucro", tiposLucro);
        toReturn.put("nrCnpj", pj.getNrCnpj());
        toReturn.put("nrInscricaoEstadual", pj.getNrInscricaoEstadual());
        toReturn.put("nmRazaoSocial", pj.getNmRazaoSocial());
        toReturn.put("nmFantasia", pj.getNmFantasia());
        toReturn.put("nrCei", pj.getNrCei());
        return toReturn;
    }

    private Map<String, Object> getReturnFieldsEndereco(PessoaJuridica pj) {
        return this.getReturnFieldsEndereco(pj, this.getReturnFieldsBasicas(pj));
    }

    private Map<String, Object> getReturnFieldsEndereco(PessoaJuridica pj, Map<String, Object> data) {
        Map<String, Object> pessoa = (Map)data.get("pessoa");
        if (pessoa == null) {
            pessoa = new LinkedHashMap();
            data.put("pessoa", pessoa);
        }

        List<Map<String, Object>> enderecos = new ArrayList();
        LinkedHashMap telefone;
        LinkedHashMap logradouro;
        LinkedHashMap uf;
        if (pj.getPessoa().getEnderecos() != null) {
            Iterator var7 = pj.getPessoa().getEnderecos().iterator();

            while(var7.hasNext()) {
                Endereco end = (Endereco)var7.next();
                Map<String, Object> endereco = new LinkedHashMap(8);
                endereco.put("idEndereco", end.getIdEndereco());
                telefone = new LinkedHashMap(3);
                if (end.getTipoEndereco() != null) {
                    telefone.put("cdTipoEndereco", end.getTipoEndereco().getCdTipoEndereco());
                    telefone.put("dsTipoEndereco", end.getTipoEndereco().getDsTipoEndereco());
                    logradouro = new LinkedHashMap(2);
                    if (end.getTipoEndereco().getTipoPessoa() != null) {
                        logradouro.put("cdTipoPessoa", end.getTipoEndereco().getTipoPessoa().getCdTipoPessoa());
                        logradouro.put("dsTipoPessoa", end.getTipoEndereco().getTipoPessoa().getDsTipoPessoa());
                    }

                    telefone.put("tipoPessoa", logradouro);
                }

                endereco.put("tipoEndereco", telefone);
                logradouro = new LinkedHashMap(8);
                LinkedHashMap servico;
                if (end.getLogradouro() != null) {
                    logradouro.put("idLogradouro", end.getLogradouro().getIdLogradouro());
                    uf = new LinkedHashMap(3);
                    if (end.getLogradouro().getUf() != null) {
                        uf.put("sgUf", end.getLogradouro().getUf().getSgUf());
                        uf.put("nmUf", end.getLogradouro().getUf().getNmUf());
                        servico = new LinkedHashMap(1);
                        if (end.getLogradouro().getUf().getRegiao() != null) {
                            servico.put("sgRegiao", end.getLogradouro().getUf().getRegiao().getSgRegiao());
                        }

                        uf.put("regiao", servico);
                    }

                    logradouro.put("uf", uf);
                    servico = new LinkedHashMap(5);
                    if (end.getLogradouro().getMunicipio() != null) {
                        servico.put("idMunicipio", end.getLogradouro().getMunicipio().getIdMunicipio());
                        servico.put("cdDdd", end.getLogradouro().getMunicipio().getCdDdd());
                        servico.put("nmMunicipio", end.getLogradouro().getMunicipio().getNmMunicipio());
                        servico.put("stCapital", end.getLogradouro().getMunicipio().getStCapital());
                        servico.put("tpLocalidade", end.getLogradouro().getMunicipio().getTpLocalidade());
                    }

                    logradouro.put("municipio", servico);
                    logradouro.put("nmLogradouro", end.getLogradouro().getNmLogradouro());
                    logradouro.put("dsTipoLogradouro", end.getLogradouro().getDsTipoLogradouro());
                    logradouro.put("dsComplemento", end.getLogradouro().getDsComplemento());
                    logradouro.put("nrCep", end.getLogradouro().getNrCep());
                    logradouro.put("nrCpc", end.getLogradouro().getNrCpc());
                }

                endereco.put("logradouro", logradouro);
                uf = new LinkedHashMap(2);
                if (end.getBairro() != null) {
                    uf.put("idBairro", end.getBairro().getIdBairro());
                    uf.put("nmBairro", end.getBairro().getNmBairro());
                }

                endereco.put("bairro", uf);
                endereco.put("dsComplementoEndereco", end.getDsComplementoEndereco());
                endereco.put("nrComplemento", end.getNrComplemento());
                endereco.put("dsLograEndereco", end.getDsLograEndereco());
                endereco.put("dsBairroEndereco", end.getDsBairroEndereco());
                servico = new LinkedHashMap(1);
                if (end.getServico() != null) {
                    servico.put("idServico", end.getServico().getIdServico());
                }

                endereco.put("servico", servico);
                enderecos.add(endereco);
            }
        }

        ((Map)pessoa).put("enderecos", enderecos);
        List<Map<String, Object>> telefones = new ArrayList();
        if (pj.getPessoa().getTelefones() != null) {
            Iterator var16 = pj.getPessoa().getTelefones().iterator();

            while(var16.hasNext()) {
                Telefone tel = (Telefone)var16.next();
                telefone = new LinkedHashMap(5);
                telefone.put("idTelefone", tel.getIdTelefone());
                logradouro = new LinkedHashMap(1);
                if (tel.getDdd() != null) {
                    logradouro.put("cdDdd", tel.getDdd().getCdDdd());
                }

                telefone.put("ddd", logradouro);
                telefone.put("nrTelefone", tel.getNrTelefone());
                telefone.put("nrRamal", tel.getNrRamal());
                uf = new LinkedHashMap(2);
                if (tel.getTipoTelefone() != null) {
                    uf.put("idTipoTelefone", tel.getTipoTelefone().getIdTipoTelefone());
                    uf.put("dsTipoTelefone", tel.getTipoTelefone().getDsTipoTelefone());
                }

                telefone.put("tipoTelefone", uf);
                telefones.add(telefone);
            }
        }

        ((Map)pessoa).put("telefones", telefones);
        List<Map<String, Object>> emails = new ArrayList();
        if (pj.getPessoa().getEmails() != null) {
            Iterator var18 = pj.getPessoa().getEmails().iterator();

            while(var18.hasNext()) {
                Email email = (Email)var18.next();
                logradouro = new LinkedHashMap(4);
                logradouro.put("idEmail", email.getIdEmail());
                logradouro.put("dsEmail", email.getDsEmail());
                uf = new LinkedHashMap(2);
                if (email.getTipoEmail() != null) {
                    uf.put("idTipoEmail", email.getTipoEmail().getIdTipoEmail());
                    uf.put("dsTipoEmail", email.getTipoEmail().getDsTipoEmail());
                }

                logradouro.put("tipoEmail", uf);
                logradouro.put("stEmailPrincipal", email.getStEmailPrincipal());
                emails.add(logradouro);
            }
        }

        ((Map)pessoa).put("emails", emails);
        return data;
    }

    private Map<String, Object> getReturnFieldsVinculoPessoa(PessoaJuridica pj) {
        return this.getReturnFieldsVinculoPessoa(pj, this.getReturnFieldsBasicas(pj));
    }

    private Map<String, Object> getReturnFieldsVinculoPessoa(PessoaJuridica pj, Map<String, Object> data) {
        Map<String, Object> pessoa = (Map)data.get("pessoa");
        if (pessoa == null) {
            pessoa = new LinkedHashMap();
            data.put("pessoa", pessoa);
        }

        List<Map<String, Object>> pessoasVinculadas = new ArrayList();
        if (pj.getPessoa().getPessoasVinculadas() != null) {
            Iterator var7 = pj.getPessoa().getPessoasVinculadas().iterator();

            while(var7.hasNext()) {
                PessoaVinculada pessoaVinculada = (PessoaVinculada)var7.next();
                Map<String, Object> vinculo = new LinkedHashMap(4);
                String key = this.getKeyPessoaVinculada(pessoaVinculada.getPessoaVinculada());
                Map<String, Object> value = this.createPessoaVinculadaReturnFields(pessoaVinculada.getPessoaVinculada());
                vinculo.put(key, value);
                Map<String, Object> tipoVinculo = new LinkedHashMap(2);
                tipoVinculo.put("idTipoVinculoPessoa", pessoaVinculada.getTipoVinculoPessoa().getIdTipoVinculoPessoa());
                tipoVinculo.put("dsTipoVinculoPessoa", pessoaVinculada.getTipoVinculoPessoa().getDsTipoVinculoPessoa());
                vinculo.put("tipoVinculoPessoa", tipoVinculo);
                vinculo.put("dtInicio", DateUtils.getDataFormatada(pessoaVinculada.getDtInicio()));
                vinculo.put("dtFim", DateUtils.getDataFormatada(pessoaVinculada.getDtFim()));
                pessoasVinculadas.add(vinculo);
            }
        }

        ((Map)pessoa).put("pessoasVinculadas", pessoasVinculadas);
        List<Map<String, Object>> pessoasMeVincularam = new ArrayList();
        if (pj.getPessoa().getPessoasMeVincularam() != null) {
            Iterator var17 = pj.getPessoa().getPessoasMeVincularam().iterator();

            while(var17.hasNext()) {
                PessoaVinculada pessoaVinculada = (PessoaVinculada)var17.next();
                Map<String, Object> vinculo = new LinkedHashMap(4);
                String key = this.getKeyPessoaVinculada(pessoaVinculada.getPessoa());
                Map<String, Object> value = this.createPessoaVinculadaReturnFields(pessoaVinculada.getPessoa());
                vinculo.put(key, value);
                Map<String, Object> tipoVinculo = new LinkedHashMap(2);
                tipoVinculo.put("idTipoVinculoPessoa", pessoaVinculada.getTipoVinculoPessoa().getIdTipoVinculoPessoa());
                tipoVinculo.put("dsTipoVinculoPessoa", pessoaVinculada.getTipoVinculoPessoa().getDsTipoVinculoPessoa());
                vinculo.put("tipoVinculoPessoa", tipoVinculo);
                vinculo.put("dtInicio", DateUtils.getDataFormatada(pessoaVinculada.getDtInicio()));
                vinculo.put("dtFim", DateUtils.getDataFormatada(pessoaVinculada.getDtFim()));
                pessoasMeVincularam.add(vinculo);
            }
        }

        ((Map)pessoa).put("pessoasMeVincularam", pessoasMeVincularam);
        return data;
    }

    private Map<String, Object> getReturnFieldsInformacoesBancarias(PessoaJuridica pj) {
        return this.getReturnFieldsInformacoesBancarias(pj, this.getReturnFieldsBasicas(pj));
    }

    private Map<String, Object> getReturnFieldsInformacoesBancarias(PessoaJuridica pj, Map<String, Object> data) {
        Map<String, Object> pessoa = (Map)data.get("pessoa");
        if (pessoa == null) {
            pessoa = new LinkedHashMap();
            data.put("pessoa", pessoa);
        }

        List<Map<String, Object>> contas = new ArrayList();
        if (pj.getPessoa().getContas() != null) {
            Iterator var7 = pj.getPessoa().getContas().iterator();

            while(var7.hasNext()) {
                ContaCorrente contaCorrente = (ContaCorrente)var7.next();
                Map<String, Object> conta = new LinkedHashMap(9);
                conta.put("idContaCorrente", contaCorrente.getIdContaCorrente());
                Map<String, Object> banco = new LinkedHashMap(2);
                banco.put("nrBanco", contaCorrente.getBanco().getNrBanco());
                banco.put("nmBanco", contaCorrente.getBanco().getNmBanco());
                conta.put("banco", banco);
                Map<String, Object> agencia = new LinkedHashMap(3);
                agencia.put("idAgencia", contaCorrente.getAgencia().getIdAgencia());
                agencia.put("nrAgencia", contaCorrente.getAgencia().getNrAgencia());
                agencia.put("nmAgencia", contaCorrente.getAgencia().getNmAgencia());
                conta.put("agencia", agencia);
                conta.put("nrContaCorrente", contaCorrente.getNrContaCorrente());
                conta.put("stContaCorrentePrincipal", contaCorrente.getStContaCorrentePrincipal());
                contas.add(conta);
            }
        }

        ((Map)pessoa).put("contas", contas);
        return data;
    }

    private Map<String, Object> getReturnFieldsTudo(PessoaJuridica pj) {
        Map<String, Object> toReturn = this.getReturnFieldsBasicas(pj);
        this.getReturnFieldsEndereco(pj, toReturn);
        this.getReturnFieldsVinculoPessoa(pj, toReturn);
        this.getReturnFieldsInformacoesBancarias(pj, toReturn);
        return toReturn;
    }

    private Map<String, Object> getReturnFields(SituacaoCadastralPJ situacao, String cnpj) {
        Map<String, Object> situacaoCadastral = new LinkedHashMap(3);
        situacaoCadastral.put("nrCnpj", cnpj);
        situacaoCadastral.put("dsHash", situacao.getDsHash());
        situacaoCadastral.put("dtSituacaoCadastral", DateUtils.getDataHoraFormatada(situacao.getDtSituacaoCadastral()));
        Map<String, Object> tipoSituacaoCadastral = new LinkedHashMap(2);
        if (situacao.getTipoSituacaoCadastral() != null) {
            tipoSituacaoCadastral.put("cdSituacaoCadastral", situacao.getTipoSituacaoCadastral().getCdSituacaoCadastral());
            tipoSituacaoCadastral.put("dsSituacaoCadastral", situacao.getTipoSituacaoCadastral().getDsSituacaoCadastral());
        }

        situacaoCadastral.put("tipoSituacaoCadastral", tipoSituacaoCadastral);
        return situacaoCadastral;
    }

    private Map<String, Object> createPessoaVinculadaReturnFields(Pessoa pessoa) {
        Map<String, Object> toReturn = new LinkedHashMap();
        char cdTipoPessoa = pessoa.getTipoPessoa().getCdTipoPessoa().charAt(0);
        switch(cdTipoPessoa) {
            case 'E':
                PessoaEstrangeira pe = this.peService.find(pessoa.getIdPessoa());
                toReturn.put("idPessoaEstrangeira", pe.getIdPessoaEstrangeira());
                toReturn.put("nmPessoaEstrangeira", pe.getNmPessoaEstrangeira());
                toReturn.put("nrIdentificacao", pe.getNrIdentificacao());
                break;
            case 'F':
                PessoaFisica pf = this.pfService.find(pessoa.getIdPessoa());
                toReturn.put("idPessoaFisica", pf.getIdPessoaFisica());
                toReturn.put("nmPessoaFisica", pf.getNmPessoaFisica());
                toReturn.put("nrCpf", pf.getNrCpf());
            case 'G':
            case 'H':
            case 'I':
            default:
                break;
            case 'J':
                PessoaJuridica pj = this.service.find(pessoa.getIdPessoa());
                toReturn.put("idPessoaJuridica", pj.getIdPessoaJuridica());
                toReturn.put("nmRazaoSocial", pj.getNmRazaoSocial());
                toReturn.put("nrCnpj", pj.getNrCnpj());
        }

        return toReturn;
    }

    private String getKeyPessoaVinculada(Pessoa pessoa) {
        String key = null;
        char cdTipoPessoa = pessoa.getTipoPessoa().getCdTipoPessoa().charAt(0);
        switch(cdTipoPessoa) {
            case 'E':
                key = "pessoaEstrangeira";
                break;
            case 'F':
                key = "pessoaFisica";
            case 'G':
            case 'H':
            case 'I':
            default:
                break;
            case 'J':
                key = "pessoaJuridica";
        }

        return key;
    }
}
