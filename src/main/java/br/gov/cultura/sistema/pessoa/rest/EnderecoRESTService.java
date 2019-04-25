package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Endereco;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.EnderecoService;
import br.gov.cultura.sistema.service.SegurancaService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/endereco")
@Auditar
public class EnderecoRESTService {
    @Inject
    private EnderecoService service;
    @Inject
    private SegurancaService segurancaService;

    public EnderecoRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{id}")
    public Response retornarEndereco(@PathParam("id") int id, @Context HttpServletRequest request) {
        Endereco end = this.service.find(id);
        Servico servico = this.segurancaService.getServicoByRequest(request);
        if (!servico.equals(end.getServico())) {
            end = null;
        }

        return end == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFields(end)).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirEndereco(Endereco endereco, @Context HttpServletRequest request) {
        Servico servico = this.segurancaService.getServicoByRequest(request);
        endereco.setServico(servico);

        try {
            return Response.ok(this.getReturnFields(this.service.create(endereco))).build();
        } catch (Exception var5) {
            var5.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar")
    public Response atualizarEndereco(Endereco endereco, @Context HttpServletRequest request) {
        Endereco enderecoAtual = this.service.find(endereco.getIdEndereco());
        if (enderecoAtual != null) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                endereco.setServico(servico);
                if (!servico.equals(enderecoAtual.getServico())) {
                    throw new NegocioException(PessoaUtils.getMsgEnderecoOutroServico());
                } else {
                    return Response.ok(this.getReturnFields(this.service.update(endereco))).build();
                }
            } catch (NegocioException var5) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var5.getErroMap()).build();
            } catch (Exception var6) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    @Produces({"application/json"})
    public Response excluirEndereco(@PathParam("id") int id, @Context HttpServletRequest request) {
        if (this.service.exists(id)) {
            try {
                Servico servico = this.segurancaService.getServicoByRequest(request);
                if (!servico.equals(this.service.getServicoDoEndereco(id))) {
                    throw new NegocioException(PessoaUtils.getMsgEnderecoOutroServico());
                } else {
                    this.service.delete(id);
                    return Response.ok().build();
                }
            } catch (NegocioException var4) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var4.getErroMap()).build();
            } catch (Exception var5) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    private Map<String, Object> getReturnFields(Endereco end) {
        Map<String, Object> toReturn = new LinkedHashMap(11);
        toReturn.put("idEndereco", end.getIdEndereco());
        toReturn.put("dsComplementoEndereco", end.getDsComplementoEndereco());
        toReturn.put("nrComplemento", end.getNrComplemento());
        toReturn.put("dsLograEndereco", end.getDsLograEndereco());
        toReturn.put("dsBairroEndereco", end.getDsBairroEndereco());
        Map<String, Object> pessoa = new HashMap(1);
        toReturn.put("pessoa", pessoa);
        pessoa.put("idPessoa", end.getPessoa().getIdPessoa());
        Map<String, Object> tipoEndereco = new HashMap(1);
        toReturn.put("tipoEndereco", tipoEndereco);
        tipoEndereco.put("cdTipoEndereco", end.getTipoEndereco().getCdTipoEndereco());
        Map<String, Object> subdistritoIbge = new HashMap(1);
        toReturn.put("subdistritoIbge", subdistritoIbge);
        if (end.getSubdistritoIbge() != null) {
            subdistritoIbge.put("idSubdistritoIbge", end.getSubdistritoIbge().getIdSubdistritoIbge());
        } else {
            subdistritoIbge.put("idSubdistritoIbge", (Object)null);
        }

        Map<String, Object> logradouro = new HashMap(1);
        toReturn.put("logradouro", logradouro);
        logradouro.put("idLogradouro", end.getLogradouro().getIdLogradouro());
        Map<String, Object> bairro = new HashMap(1);
        toReturn.put("bairro", bairro);
        bairro.put("idBairro", end.getBairro().getIdBairro());
        Map<String, Object> servico = new HashMap(1);
        toReturn.put("servico", servico);
        if (end.getServico() != null) {
            servico.put("idServico", end.getServico().getIdServico());
        } else {
            servico.put("idServico", (Object)null);
        }

        return toReturn;
    }
}
