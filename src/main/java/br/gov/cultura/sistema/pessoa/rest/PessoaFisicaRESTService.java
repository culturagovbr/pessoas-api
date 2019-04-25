package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.CaracteristicaFisica;
import br.gov.cultura.sistema.model.corporativo.ContaCorrente;
import br.gov.cultura.sistema.model.corporativo.DocumentacaoPessoa;
import br.gov.cultura.sistema.model.corporativo.Email;
import br.gov.cultura.sistema.model.corporativo.Endereco;
import br.gov.cultura.sistema.model.corporativo.Escolaridade;
import br.gov.cultura.sistema.model.corporativo.EstadoCivil;
import br.gov.cultura.sistema.model.corporativo.IdiomaPessoa;
import br.gov.cultura.sistema.model.corporativo.Municipio;
import br.gov.cultura.sistema.model.corporativo.NivelEscolaridade;
import br.gov.cultura.sistema.model.corporativo.Pais;
import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.corporativo.PessoaCursoFormacao;
import br.gov.cultura.sistema.model.corporativo.PessoaEstrangeira;
import br.gov.cultura.sistema.model.corporativo.PessoaFisica;
import br.gov.cultura.sistema.model.corporativo.PessoaFisicaJuridicaCbo;
import br.gov.cultura.sistema.model.corporativo.PessoaJuridica;
import br.gov.cultura.sistema.model.corporativo.PessoaVinculada;
import br.gov.cultura.sistema.model.corporativo.SituacaoCadastralPF;
import br.gov.cultura.sistema.model.corporativo.Telefone;
import br.gov.cultura.sistema.model.enums.BooleanEnum;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.PessoaEstrangeiraService;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.pessoa.service.PessoaJuridicaService;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.service.SegurancaService;
import br.gov.cultura.sistema.util.DateUtils;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pessoa_fisica")
@Auditar
public class PessoaFisicaRESTService {
    @Inject
    private PessoaFisicaService service;
    @Inject
    private PessoaJuridicaService pjService;
    @Inject
    private PessoaEstrangeiraService peService;
    @Inject
    private SegurancaService segurancaService;
    @Inject
    private GenericCrudService genericCrudService;

    public PessoaFisicaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/verificar_situacao_cadastral/{cpf}/{hash}")
    public Response verificarSituacaoCadastralPessoaFisica(@PathParam("cpf") String cpf, @PathParam("hash") String hash, @Context HttpServletRequest request) {
        try {
            if (ValidacaoUtils.isCPF(cpf)) {
                SituacaoCadastralPF situacao = this.service.getSituacaoCadastral(cpf, hash);
                if (situacao == null) {
                    throw new NegocioException("Hash não válido para essa pessoa");
                } else {
                    String hashGerado = PessoaUtils.gerarHashSituacaoCadastral(situacao.getIdPessoaFisica(), situacao.getDtSituacaoCadastral(), situacao.getTipoSituacaoCadastral().getCdSituacaoCadastral());
                    if (!hash.equals(hashGerado)) {
                        throw new NegocioException("Erro de integridade, o hash foi alterado");
                    } else {
                        SituacaoCadastralPF situacaoAtual = this.service.getSituacaoCadastralAtual(cpf);
                        return Response.ok(this.getReturnFields(situacaoAtual, cpf)).build();
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
    @Path("/consultar/{cpf}")
    public Response retornarPessoaFisicaTudo(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsTudo(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}/basico")
    public Response retornarPessoaFisicaBasico(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsBasicas(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}/endereco")
    public Response retornarPessoaFisicaEndereco(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsEndereco(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}/documentacao")
    public Response retornarPessoaFisicaDocumentacao(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsDocumentacao(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}/formacao")
    public Response retornarPessoaFisicaFormacao(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsFormacao(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}/caracteristica_fisica")
    public Response retornarPessoaFisicaCaracteristicaFisica(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsCaracteristicasFisicas(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}/informacao_bancaria")
    public Response retornarPessoaFisicaInformacaoBancaria(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsInformacoesBancarias(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}/vinculo_pessoa")
    public Response retornarPessoaFisicaVinculoPessoa(@PathParam("cpf") String cpf, @QueryParam("forcarBuscaNaReceita") boolean forcarBuscaNaReceita, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                PessoaFisica pf = this.service.getPessoaFisicaPorCPF(cpf, servico, forcarBuscaNaReceita);
                return pf == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFieldsVinculoPessoa(pf)).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    @PUT
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("/atualizar/{cpf}")
    public Response atualizarPessoaFisica(Map<String, Object> dadosParaAtualizar, @PathParam("cpf") String cpf, @Context HttpServletRequest request) {
        if (ValidacaoUtils.isCPF(cpf)) {
            try {
                PessoaFisica pessoaFisica = this.service.getPessoaFisicaPorCPF(cpf, (Servico)null, false);
                if (pessoaFisica == null) {
                    return Response.status(Status.NO_CONTENT).build();
                } else {
                    this.validarAlteracoes(pessoaFisica, dadosParaAtualizar);
                    int idPessoaFisica = pessoaFisica.getIdPessoaFisica();
                    Servico servico = this.segurancaService.getServicoByRequest(request);
                    this.service.isPermitidoAlterar(idPessoaFisica, servico);
                    this.service.update(pessoaFisica);
                    return Response.ok().build();
                }
            } catch (NegocioException var7) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var7.getErroMap()).build();
            } catch (Exception var8) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            Map<String, String> map = new HashMap(1);
            map.put("erro", "CPF Inválido");
            return Response.status(Status.PRECONDITION_FAILED).entity(map).build();
        }
    }

    private void validarAlteracoes(PessoaFisica pf, Map<String, Object> dadosParaAtualizar) throws NegocioException {
        Iterator var4 = dadosParaAtualizar.entrySet().iterator();

        while(var4.hasNext()) {
            Entry<String, Object> entry = (Entry)var4.next();
            String key = (String)entry.getKey();
            switch(key.hashCode()) {
                case -497111867:
                    if (!key.equals("cdEscolaridade")) {
                        throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaErro());
                    }
                    break;
                case -353564358:
                    if (!key.equals("dsTipoSanguineo")) {
                        throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaErro());
                    }
                    break;
                case 104914521:
                    if (!key.equals("nmPai")) {
                        throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaErro());
                    }
                    break;
                case 323036428:
                    if (!key.equals("cdEstadoCivil")) {
                        throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaErro());
                    }
                    break;
                case 483219986:
                    if (!key.equals("stDoador")) {
                        throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaErro());
                    }
                    break;
                case 2113765047:
                    if (!key.equals("idMunicipioNatural")) {
                        throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaErro());
                    }
                    break;
                default:
                    throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaErro());
            }
        }

        try {
            Object stDoadorObj;
            Integer idMunicipioNatural;
            try {
                if (dadosParaAtualizar.containsKey("cdEscolaridade")) {
                    stDoadorObj = dadosParaAtualizar.get("cdEscolaridade");
                    if (stDoadorObj != null) {
                        idMunicipioNatural = Integer.parseInt(stDoadorObj.toString());
                        Escolaridade escolaridade = (Escolaridade)this.genericCrudService.find(Escolaridade.class, idMunicipioNatural);
                        if (escolaridade == null) {
                            throw new Exception();
                        }

                        pf.setEscolaridade(escolaridade);
                    } else {
                        pf.setEscolaridade((Escolaridade)null);
                    }
                }
            } catch (Exception var10) {
                throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaAtributoErro("escolaridade"));
            }

            try {
                if (dadosParaAtualizar.containsKey("cdEstadoCivil")) {
                    stDoadorObj = dadosParaAtualizar.get("cdEscolaridade");
                    if (stDoadorObj != null) {
                        EstadoCivil estadoCivil = (EstadoCivil)this.genericCrudService.find(EstadoCivil.class, stDoadorObj);
                        if (estadoCivil == null) {
                            throw new Exception();
                        }

                        pf.setEstadoCivil(estadoCivil);
                    } else {
                        pf.setEstadoCivil((EstadoCivil)null);
                    }
                }
            } catch (Exception var8) {
                throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaAtributoErro("estado civil"));
            }

            try {
                if (dadosParaAtualizar.containsKey("idMunicipioNatural")) {
                    stDoadorObj = dadosParaAtualizar.get("idMunicipioNatural");
                    if (stDoadorObj != null) {
                        idMunicipioNatural = Integer.parseInt(stDoadorObj.toString());
                        Municipio municipio = (Municipio)this.genericCrudService.find(Municipio.class, idMunicipioNatural);
                        if (municipio == null) {
                            throw new Exception();
                        }

                        pf.setMunicipio(municipio);
                    } else {
                        pf.setMunicipio((Municipio)null);
                    }
                }
            } catch (Exception var9) {
                throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaAtributoErro("municipio"));
            }

            if (dadosParaAtualizar.containsKey("nmPai")) {
                stDoadorObj = dadosParaAtualizar.get("nmPai");
                pf.setNmPai(stDoadorObj == null ? null : stDoadorObj.toString());
            }

            if (dadosParaAtualizar.containsKey("dsTipoSanguineo")) {
                stDoadorObj = dadosParaAtualizar.get("dsTipoSanguineo");
                pf.setDsTipoSanguineo(stDoadorObj == null ? null : stDoadorObj.toString());
            }

            try {
                if (dadosParaAtualizar.containsKey("stDoador")) {
                    stDoadorObj = dadosParaAtualizar.get("stDoador");
                    if (stDoadorObj != null) {
                        String stDoador = stDoadorObj.toString().toUpperCase();
                        if (!BooleanEnum.NAO.getSigla().equals(stDoadorObj) && !BooleanEnum.SIM.getSigla().equals(stDoadorObj)) {
                            throw new Exception();
                        }

                        pf.setStDoador(stDoador);
                    } else {
                        pf.setStDoador((String)null);
                    }
                }

            } catch (Exception var7) {
                throw new NegocioException(PessoaUtils.getMsgAtualizarPessoaFisicaAtributoErro("doador"));
            }
        } catch (Exception var11) {
            throw new NegocioException("Ocorreu um erro inesperado: " + var11.getMessage());
        }
    }

    private Map<String, Object> getReturnFieldsBasicas(PessoaFisica pf) {
        Map<String, Object> toReturn = new LinkedHashMap();
        toReturn.put("idPessoaFisica", pf.getIdPessoaFisica());
        toReturn.put("nmPessoaFisica", pf.getNmPessoaFisica());
        toReturn.put("nrCpf", pf.getNrCpf());
        toReturn.put("nmMae", pf.getNmMae());
        toReturn.put("nmPai", pf.getNmPai());
        toReturn.put("dtNascimento", DateUtils.getDataFormatada(pf.getDtNascimento()));
        toReturn.put("sgSexo", pf.getSgSexo());
        toReturn.put("dsTipoSanguineo", pf.getDsTipoSanguineo());
        toReturn.put("stDoador", pf.getStDoador());
        SituacaoCadastralPF situacao = pf.getSituacaoCadastralAtual();
        LinkedHashMap pessoa;
        LinkedHashMap tipoAbrangencia;
        if (situacao != null) {
            pessoa = new LinkedHashMap(3);
            pessoa.put("dsHash", situacao.getDsHash());
            pessoa.put("dtSituacaoCadastral", DateUtils.getDataHoraFormatada(situacao.getDtSituacaoCadastral()));
            tipoAbrangencia = new LinkedHashMap(2);
            if (situacao.getTipoSituacaoCadastral() != null) {
                tipoAbrangencia.put("cdSituacaoCadastral", situacao.getTipoSituacaoCadastral().getCdSituacaoCadastral());
                tipoAbrangencia.put("dsSituacaoCadastral", situacao.getTipoSituacaoCadastral().getDsSituacaoCadastral());
            }

            pessoa.put("tipoSituacaoCadastral", tipoAbrangencia);
            toReturn.put("situacaoCadastral", pessoa);
        }

        pessoa = new LinkedHashMap(2);
        toReturn.put("pessoa", pessoa);
        tipoAbrangencia = new LinkedHashMap(2);
        if (pf.getPessoa().getTipoAbrangencia() != null) {
            tipoAbrangencia.put("cdTipoAbrangencia", pf.getPessoa().getTipoAbrangencia().getCdTipoAbrangencia());
            tipoAbrangencia.put("dsTipoAbrangencia", pf.getPessoa().getTipoAbrangencia().getDsTipoAbrangencia());
        }

        pessoa.put("tipoAbrangencia", tipoAbrangencia);
        Map<String, Object> pais = new LinkedHashMap(4);
        if (pf.getPessoa().getPais() != null) {
            pais.put("sgPais", pf.getPessoa().getPais().getSgPais());
            pais.put("nmPais", pf.getPessoa().getPais().getNmPais());
            pais.put("sgPaisIso", pf.getPessoa().getPais().getSgPaisIso());
            pais.put("cdDdi", pf.getPessoa().getPais().getCdDdi());
        }

        pessoa.put("pais", pais);
        Map<String, Object> municipio = new LinkedHashMap(2);
        if (pf.getMunicipio() != null) {
            municipio.put("idMunicipio", pf.getMunicipio().getIdMunicipio());
            municipio.put("nmMunicipio", pf.getMunicipio().getNmMunicipio());
        }

        toReturn.put("municipio", municipio);
        Map<String, Object> estadoCivil = new LinkedHashMap(2);
        if (pf.getEstadoCivil() != null) {
            estadoCivil.put("cdEstadoCivil", pf.getEstadoCivil().getCdEstadoCivil());
            estadoCivil.put("dsEstadoCivil", pf.getEstadoCivil().getDsEstadoCivil());
        }

        toReturn.put("estadoCivil", estadoCivil);
        return toReturn;
    }

    private Map<String, Object> getReturnFieldsEndereco(PessoaFisica pf) {
        return this.getReturnFieldsEndereco(pf, this.getReturnFieldsBasicas(pf));
    }

    private Map<String, Object> getReturnFieldsEndereco(PessoaFisica pf, Map<String, Object> data) {
        Map<String, Object> pessoa = (Map)data.get("pessoa");
        List<Map<String, Object>> enderecos = new ArrayList();
        Iterator var7 = pf.getPessoa().getEnderecos().iterator();

        LinkedHashMap telefone;
        LinkedHashMap emailMap;
        LinkedHashMap tipoEmail;
        while(var7.hasNext()) {
            Endereco end = (Endereco)var7.next();
            Map<String, Object> endereco = new LinkedHashMap(8);
            endereco.put("idEndereco", end.getIdEndereco());
            telefone = new LinkedHashMap(3);
            if (end.getTipoEndereco() != null) {
                telefone.put("cdTipoEndereco", end.getTipoEndereco().getCdTipoEndereco());
                telefone.put("dsTipoEndereco", end.getTipoEndereco().getDsTipoEndereco());
                emailMap = new LinkedHashMap(2);
                if (end.getTipoEndereco().getTipoPessoa() != null) {
                    emailMap.put("cdTipoPessoa", end.getTipoEndereco().getTipoPessoa().getCdTipoPessoa());
                    emailMap.put("dsTipoPessoa", end.getTipoEndereco().getTipoPessoa().getDsTipoPessoa());
                }

                telefone.put("tipoPessoa", emailMap);
            }

            endereco.put("tipoEndereco", telefone);
            emailMap = new LinkedHashMap(8);
            LinkedHashMap servico;
            if (end.getLogradouro() != null) {
                emailMap.put("idLogradouro", end.getLogradouro().getIdLogradouro());
                tipoEmail = new LinkedHashMap(3);
                if (end.getLogradouro().getUf() != null) {
                    tipoEmail.put("sgUf", end.getLogradouro().getUf().getSgUf());
                    tipoEmail.put("nmUf", end.getLogradouro().getUf().getNmUf());
                    servico = new LinkedHashMap(1);
                    if (end.getLogradouro().getUf().getRegiao() != null) {
                        servico.put("sgRegiao", end.getLogradouro().getUf().getRegiao().getSgRegiao());
                    }

                    tipoEmail.put("regiao", servico);
                }

                emailMap.put("uf", tipoEmail);
                servico = new LinkedHashMap(5);
                if (end.getLogradouro().getMunicipio() != null) {
                    servico.put("idMunicipio", end.getLogradouro().getMunicipio().getIdMunicipio());
                    servico.put("cdDdd", end.getLogradouro().getMunicipio().getCdDdd());
                    servico.put("nmMunicipio", end.getLogradouro().getMunicipio().getNmMunicipio());
                    servico.put("stCapital", end.getLogradouro().getMunicipio().getStCapital());
                    servico.put("tpLocalidade", end.getLogradouro().getMunicipio().getTpLocalidade());
                }

                emailMap.put("municipio", servico);
                emailMap.put("nmLogradouro", end.getLogradouro().getNmLogradouro());
                emailMap.put("dsTipoLogradouro", end.getLogradouro().getDsTipoLogradouro());
                emailMap.put("dsComplemento", end.getLogradouro().getDsComplemento());
                emailMap.put("nrCep", end.getLogradouro().getNrCep());
                emailMap.put("nrCpc", end.getLogradouro().getNrCpc());
            }

            endereco.put("logradouro", emailMap);
            tipoEmail = new LinkedHashMap(2);
            if (end.getBairro() != null) {
                tipoEmail.put("idBairro", end.getBairro().getIdBairro());
                tipoEmail.put("nmBairro", end.getBairro().getNmBairro());
            }

            endereco.put("bairro", tipoEmail);
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

        pessoa.put("enderecos", enderecos);
        List<Map<String, Object>> telefones = new ArrayList();
        if (pf.getPessoa().getTelefones() != null) {
            Iterator var16 = pf.getPessoa().getTelefones().iterator();

            while(var16.hasNext()) {
                Telefone tel = (Telefone)var16.next();
                telefone = new LinkedHashMap(5);
                telefone.put("idTelefone", tel.getIdTelefone());
                emailMap = new LinkedHashMap(1);
                if (tel.getDdd() != null) {
                    emailMap.put("cdDdd", tel.getDdd().getCdDdd());
                }

                telefone.put("ddd", emailMap);
                telefone.put("nrTelefone", tel.getNrTelefone());
                telefone.put("nrRamal", tel.getNrRamal());
                tipoEmail = new LinkedHashMap(2);
                if (tel.getTipoTelefone() != null) {
                    tipoEmail.put("idTipoTelefone", tel.getTipoTelefone().getIdTipoTelefone());
                    tipoEmail.put("dsTipoTelefone", tel.getTipoTelefone().getDsTipoTelefone());
                }

                telefone.put("tipoTelefone", tipoEmail);
                telefones.add(telefone);
            }
        }

        pessoa.put("telefones", telefones);
        List<Map<String, Object>> emails = new ArrayList();
        if (pf.getPessoa().getEmails() != null) {
            Iterator var18 = pf.getPessoa().getEmails().iterator();

            while(var18.hasNext()) {
                Email email = (Email)var18.next();
                emailMap = new LinkedHashMap(4);
                emailMap.put("idEmail", email.getIdEmail());
                emailMap.put("dsEmail", email.getDsEmail());
                tipoEmail = new LinkedHashMap(2);
                if (email.getTipoEmail() != null) {
                    tipoEmail.put("idTipoEmail", email.getTipoEmail().getIdTipoEmail());
                    tipoEmail.put("dsTipoEmail", email.getTipoEmail().getDsTipoEmail());
                }

                emailMap.put("tipoEmail", tipoEmail);
                emailMap.put("stEmailPrincipal", email.getStEmailPrincipal());
                emails.add(emailMap);
            }
        }

        pessoa.put("emails", emails);
        return data;
    }

    private Map<String, Object> getReturnFieldsDocumentacao(PessoaFisica pf) {
        return this.getReturnFieldsDocumentacao(pf, this.getReturnFieldsBasicas(pf));
    }

    private Map<String, Object> getReturnFieldsDocumentacao(PessoaFisica pf, Map<String, Object> data) {
        Map<String, Object> documentacao = new LinkedHashMap(24);
        DocumentacaoPessoa dp = pf.getDocumentacao();
        if (dp != null) {
            Map<String, Object> ufTituloEleitoral = new HashMap(2);
            documentacao.put("ufTituloEleitoral", ufTituloEleitoral);
            if (dp.getUfTituloEleitoral() != null) {
                ufTituloEleitoral.put("sgUf", dp.getUfTituloEleitoral().getSgUf());
                ufTituloEleitoral.put("nmUf", dp.getUfTituloEleitoral().getNmUf());
            }

            Map<String, Object> ufConselhoClasse = new HashMap(2);
            documentacao.put("ufConselhoClasse", ufConselhoClasse);
            if (dp.getUfConselhoClasse() != null) {
                ufConselhoClasse.put("sgUf", dp.getUfConselhoClasse().getSgUf());
                ufConselhoClasse.put("nmUf", dp.getUfConselhoClasse().getNmUf());
            }

            Map<String, Object> ufCarteiraTrabalho = new HashMap(2);
            documentacao.put("ufCarteiraTrabalho", ufCarteiraTrabalho);
            if (dp.getUfCarteiraTrabalho() != null) {
                ufCarteiraTrabalho.put("sgUf", dp.getUfCarteiraTrabalho().getSgUf());
                ufCarteiraTrabalho.put("nmUf", dp.getUfCarteiraTrabalho().getNmUf());
            }

            Map<String, Object> ufIdentidade = new HashMap(2);
            documentacao.put("ufIdentidade", ufIdentidade);
            if (dp.getUfIdentidade() != null) {
                ufIdentidade.put("sgUf", dp.getUfIdentidade().getSgUf());
                ufIdentidade.put("nmUf", dp.getUfIdentidade().getNmUf());
            }

            documentacao.put("nrTituloEleitor", dp.getNrTituloEleitor());
            documentacao.put("nrZonaTituloEleitor", dp.getNrZonaTituloEleitor());
            documentacao.put("nrSecaoTituloEleitor", dp.getNrSecaoTituloEleitor());
            documentacao.put("dtExpTituloEleitor", DateUtils.getDataFormatada(dp.getDtExpTituloEleitor()));
            documentacao.put("nrCertificadoReservista", dp.getNrCertificadoReservista());
            documentacao.put("nmExpCertificadoReservista", dp.getNmExpCertificadoReservista());
            documentacao.put("dtExpCertificadoReservista", DateUtils.getDataFormatada(dp.getDtExpCertificadoReservista()));
            documentacao.put("nrHabilitacao", dp.getNrHabilitacao());
            documentacao.put("dsCategoriaHabilitacao", dp.getDsCategoriaHabilitacao());
            documentacao.put("nrCarteiraConselhoClasse", dp.getNrCarteiraConselhoClasse());
            documentacao.put("nmExpConselhoClasse", dp.getNmExpConselhoClasse());
            documentacao.put("dsRegiaoReservista", dp.getDsRegiaoReservista());
            documentacao.put("cdCategoriaReservista", dp.getCdCategoriaReservista());
            documentacao.put("nrCarteiraTrabalho", dp.getNrCarteiraTrabalho());
            documentacao.put("nrSerieCarteiraTrabalho", dp.getNrSerieCarteiraTrabalho());
            documentacao.put("nrRg", dp.getNrRg());
            documentacao.put("nmOrgaoExpRg", dp.getNmOrgaoExpRg());
            documentacao.put("dtExpedicaoRg", DateUtils.getDataFormatada(dp.getDtExpedicaoRg()));
            documentacao.put("nrPisPasep", dp.getNrPisPasep());
        }

        List<Map<String, Object>> cbos = new ArrayList();
        if (pf.getCbos() != null) {
            Iterator var13 = pf.getCbos().iterator();

            while(var13.hasNext()) {
                PessoaFisicaJuridicaCbo cbo = (PessoaFisicaJuridicaCbo)var13.next();
                Map<String, Object> cboPessoaMap = new LinkedHashMap(1);
                Map<String, Object> cboMap = new LinkedHashMap(1);
                cboMap.put("cdCbo", cbo.getCbo().getCdCbo());
                cboMap.put("nmCbo", cbo.getCbo().getNmCbo());
                cboPessoaMap.put("cbo", cboMap);
                cbos.add(cboPessoaMap);
            }
        }

        documentacao.put("cbos", cbos);
        data.put("documentacao", documentacao);
        return data;
    }

    private Map<String, Object> getReturnFieldsFormacao(PessoaFisica pf) {
        return this.getReturnFieldsFormacao(pf, this.getReturnFieldsBasicas(pf));
    }

    private Map<String, Object> getReturnFieldsFormacao(PessoaFisica pf, Map<String, Object> data) {
        Escolaridade e = pf.getEscolaridade();
        Map<String, Object> escolaridade = new LinkedHashMap(3);
        if (e != null) {
            escolaridade.put("cdEscolaridade", e.getCdEscolaridade());
            escolaridade.put("dsEscolaridade", e.getDsEscolaridade());
            NivelEscolaridade ne = e.getNivelEscolaridade();
            Map<String, Object> nivelEscolaridade = new LinkedHashMap(3);
            if (ne != null) {
                nivelEscolaridade.put("idNivelEscolaridade", ne.getIdNivelEscolaridade());
                nivelEscolaridade.put("dsNivelEscolaridade", ne.getDsNivelEscolaridade());
                nivelEscolaridade.put("sgEscolaridadeSiape", ne.getSgEscolaridadeSiape());
            }

            escolaridade.put("nivelEscolaridade", nivelEscolaridade);
        }

        data.put("escolaridade", escolaridade);
        List<Map<String, Object>> idiomas = new ArrayList();
        if (pf.getIdiomas() != null) {
            Iterator var8 = pf.getIdiomas().iterator();

            while(var8.hasNext()) {
                IdiomaPessoa idiomaPessoa = (IdiomaPessoa)var8.next();
                Map<String, Object> idioma = new LinkedHashMap(8);
                idioma.put("idIdioma", idiomaPessoa.getIdioma().getIdIdioma());
                idioma.put("dsIdioma", idiomaPessoa.getIdioma().getDsIdioma());
                idioma.put("nmEstabelecimentoEnsino", idiomaPessoa.getNmEstabelecimentoEnsino());
                idioma.put("stEntende", idiomaPessoa.getStEntende());
                idioma.put("stFala", idiomaPessoa.getStFala());
                idioma.put("stEscreve", idiomaPessoa.getStEscreve());
                idioma.put("stLe", idiomaPessoa.getStLe());
                idioma.put("stDominioPortugues", idiomaPessoa.getStDominioPortugues());
                idiomas.add(idioma);
            }
        }

        data.put("idiomas", idiomas);
        List<Map<String, Object>> formacoes = new ArrayList();
        if (pf.getFormacoes() != null) {
            Iterator var23 = pf.getFormacoes().iterator();

            while(var23.hasNext()) {
                PessoaCursoFormacao pessoaCursoFormacao = (PessoaCursoFormacao)var23.next();
                Map<String, Object> formacao = new LinkedHashMap(9);
                formacao.put("idPessoaCursoFormacao", pessoaCursoFormacao.getIdPessoaCursoFormacao());
                Map<String, Object> cursoFormacao = new LinkedHashMap(4);
                cursoFormacao.put("idCursoFormacao", pessoaCursoFormacao.getCursoFormacao().getIdCursoFormacao());
                Map<String, Object> curso = new LinkedHashMap(2);
                curso.put("idCurso", pessoaCursoFormacao.getCursoFormacao().getCurso().getIdCurso());
                curso.put("nmCurso", pessoaCursoFormacao.getCursoFormacao().getCurso().getNmCurso());
                cursoFormacao.put("curso", curso);
                Map<String, Object> cursoArea = new LinkedHashMap(2);
                cursoArea.put("idCursoArea", pessoaCursoFormacao.getCursoFormacao().getCursoArea().getIdCursoArea());
                cursoArea.put("dsCursoArea", pessoaCursoFormacao.getCursoFormacao().getCursoArea().getDsCursoArea());
                cursoFormacao.put("cursoArea", cursoArea);
                Map<String, Object> cursoNivelFormacao = new LinkedHashMap(2);
                cursoNivelFormacao.put("idCursoNivelFormacao", pessoaCursoFormacao.getCursoFormacao().getCursoNivelFormacao().getIdCursoNivelFormacao());
                cursoNivelFormacao.put("dsCursoNivelFormacao", pessoaCursoFormacao.getCursoFormacao().getCursoNivelFormacao().getDsCursoNivelFormacao());
                cursoFormacao.put("cursoNivelFormacao", cursoNivelFormacao);
                formacao.put("cursoFormacao", cursoFormacao);
                Map<String, Object> pais = new LinkedHashMap(2);
                Pais p = pessoaCursoFormacao.getPais();
                if (p != null) {
                    pais.put("sgPais", p.getSgPais());
                    pais.put("nmPais", p.getNmPais());
                }

                formacao.put("pais", pais);
                Map<String, Object> municipio = new LinkedHashMap(2);
                Municipio muni = pessoaCursoFormacao.getMunicipio();
                if (muni != null) {
                    municipio.put("idMunicipio", muni.getIdMunicipio());
                    municipio.put("nmMunicipio", muni.getNmMunicipio());
                }

                formacao.put("municipio", municipio);
                formacao.put("nmInstituicaoEnsino", pessoaCursoFormacao.getNmInstituicaoEnsino());
                formacao.put("dsTituloAcademico", pessoaCursoFormacao.getDsTituloAcademico());
                formacao.put("nrCargaHoraria", pessoaCursoFormacao.getNrCargaHoraria());
                formacao.put("aaInicioCurso", pessoaCursoFormacao.getAaInicioCurso());
                formacao.put("aaFimCurso", pessoaCursoFormacao.getAaFimCurso());
                formacoes.add(formacao);
            }
        }

        data.put("formacoes", formacoes);
        return data;
    }

    private Map<String, Object> getReturnFieldsCaracteristicasFisicas(PessoaFisica pf) {
        return this.getReturnFieldsCaracteristicasFisicas(pf, this.getReturnFieldsBasicas(pf));
    }

    private Map<String, Object> getReturnFieldsCaracteristicasFisicas(PessoaFisica pf, Map<String, Object> data) {
        Map<String, Object> caracteristicaFisica = new LinkedHashMap(2);
        CaracteristicaFisica cf = pf.getCaracteristicaFisica();
        if (cf != null) {
            Map<String, Object> cor = new LinkedHashMap(2);
            if (cf.getCor() != null) {
                cor.put("idCor", cf.getCor().getIdCor());
                cor.put("dsCor", cf.getCor().getDsCor());
            }

            caracteristicaFisica.put("cor", cor);
            Map<String, Object> pais = new LinkedHashMap(2);
            if (cf.getPais() != null) {
                pais.put("sgPais", cf.getPais().getSgPais());
                pais.put("nmPais", cf.getPais().getNmPais());
            }

            caracteristicaFisica.put("pais", pais);
        }

        data.put("caracteristicaFisica", caracteristicaFisica);
        return data;
    }

    private Map<String, Object> getReturnFieldsInformacoesBancarias(PessoaFisica pf) {
        return this.getReturnFieldsInformacoesBancarias(pf, this.getReturnFieldsBasicas(pf));
    }

    private Map<String, Object> getReturnFieldsInformacoesBancarias(PessoaFisica pf, Map<String, Object> data) {
        Map<String, Object> pessoa = (Map)data.get("pessoa");
        List<Map<String, Object>> contas = new ArrayList();
        if (pf.getPessoa().getContas() != null) {
            Iterator var7 = pf.getPessoa().getContas().iterator();

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

        pessoa.put("contas", contas);
        return data;
    }

    private Map<String, Object> getReturnFieldsVinculoPessoa(PessoaFisica pf) {
        return this.getReturnFieldsVinculoPessoa(pf, this.getReturnFieldsBasicas(pf));
    }

    private Map<String, Object> getReturnFieldsVinculoPessoa(PessoaFisica pf, Map<String, Object> data) {
        Map<String, Object> pessoa = (Map)data.get("pessoa");
        List<Map<String, Object>> pessoasVinculadas = new ArrayList();
        if (pf.getPessoa().getPessoasVinculadas() != null) {
            Iterator var7 = pf.getPessoa().getPessoasVinculadas().iterator();

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

        pessoa.put("pessoasVinculadas", pessoasVinculadas);
        List<Map<String, Object>> pessoasMeVincularam = new ArrayList();
        if (pf.getPessoa().getPessoasMeVincularam() != null) {
            Iterator var17 = pf.getPessoa().getPessoasMeVincularam().iterator();

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

        pessoa.put("pessoasMeVincularam", pessoasMeVincularam);
        return data;
    }

    private Map<String, Object> getReturnFieldsTudo(PessoaFisica pf) {
        Map<String, Object> toReturn = this.getReturnFieldsBasicas(pf);
        this.getReturnFieldsEndereco(pf, toReturn);
        this.getReturnFieldsDocumentacao(pf, toReturn);
        this.getReturnFieldsFormacao(pf, toReturn);
        this.getReturnFieldsCaracteristicasFisicas(pf, toReturn);
        this.getReturnFieldsInformacoesBancarias(pf, toReturn);
        this.getReturnFieldsVinculoPessoa(pf, toReturn);
        return toReturn;
    }

    private Map<String, Object> getReturnFields(SituacaoCadastralPF situacao, String cpf) {
        Map<String, Object> situacaoCadastral = new LinkedHashMap(4);
        situacaoCadastral.put("nrCpf", cpf);
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
                PessoaFisica pf = this.service.find(pessoa.getIdPessoa());
                toReturn.put("idPessoaFisica", pf.getIdPessoaFisica());
                toReturn.put("nmPessoaFisica", pf.getNmPessoaFisica());
                toReturn.put("nrCpf", pf.getNrCpf());
            case 'G':
            case 'H':
            case 'I':
            default:
                break;
            case 'J':
                PessoaJuridica pj = this.pjService.find(pessoa.getIdPessoa());
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
