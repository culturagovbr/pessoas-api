package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.PessoaVinculada;
import br.gov.cultura.sistema.model.corporativo.PessoaVinculadaPK;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.pessoa.service.PessoaVinculadaService;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.service.SegurancaService;
import br.gov.cultura.sistema.util.DateUtils;
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

@Path("/pessoa_vinculada")
@Auditar
public class PessoaVinculadaRESTService {
    @Inject
    GenericCrudService genericCrudService;
    @Inject
    private PessoaVinculadaService service;
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    @Inject
    private SegurancaService segurancaService;

    public PessoaVinculadaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{idPessoa}/{idPessoaVinculada}/{idTipoVinculoPessoa}")
    public Response retornarPessoaVinculada(@PathParam("idPessoa") int idPessoa, @PathParam("idPessoaVinculada") int idPessoaVinculada, @PathParam("idTipoVinculoPessoa") int idTipoVinculoPessoa, @Context HttpServletRequest request) {
        PessoaVinculadaPK id = new PessoaVinculadaPK();
        id.setIdPessoa(idPessoa);
        id.setIdPessoaVinculada(idPessoaVinculada);
        id.setIdTipoVinculoPessoa(idTipoVinculoPessoa);
        PessoaVinculada pv = this.service.find(id);
        return pv == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFields(pv)).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirPessoaVinculada(PessoaVinculada pv, @Context HttpServletRequest request) {
        try {
            int idPessoaFisica = pv.getPessoa().getIdPessoa();
            Servico servico = this.segurancaService.getServicoByRequest(request);
            this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
            return Response.ok(this.getReturnFields(this.service.create(pv))).build();
        } catch (NegocioException var5) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var5.getErroMap()).build();
        } catch (Exception var6) {
            var6.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar/{idPessoa}/{idPessoaVinculada}/{idTipoVinculoPessoa}")
    public Response atualizarPessoaVinculada(PessoaVinculada pessoaVinculada, @PathParam("idPessoa") int idPessoa, @PathParam("idPessoaVinculada") int idPessoaVinculada, @PathParam("idTipoVinculoPessoa") int idTipoVinculoPessoa, @Context HttpServletRequest request) {
        PessoaVinculadaPK idOld = new PessoaVinculadaPK();
        idOld.setIdPessoa(idPessoa);
        idOld.setIdPessoaVinculada(idPessoaVinculada);
        idOld.setIdTipoVinculoPessoa(idTipoVinculoPessoa);
        PessoaVinculada pessoaVinculadaAtual = this.service.find(idOld);
        if (pessoaVinculadaAtual != null) {
            try {
                int idPessoaFisica = pessoaVinculada.getPessoa().getIdPessoa();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                this.pessoaFisicaService.isPermitidoAlterar(pessoaVinculadaAtual.getPessoa().getIdPessoa(), servico);
                return Response.ok(this.getReturnFields(this.service.update(idOld, pessoaVinculada))).build();
            } catch (NegocioException var10) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var10.getErroMap()).build();
            } catch (Exception var11) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    @DELETE
    @Path("/deletar/{idPessoa}/{idPessoaVinculada}/{idTipoVinculoPessoa}")
    @Produces({"application/json"})
    public Response excluirPessoaVinculada(@PathParam("idPessoa") int idPessoa, @PathParam("idPessoaVinculada") int idPessoaVinculada, @PathParam("idTipoVinculoPessoa") int idTipoVinculoPessoa, @Context HttpServletRequest request) {
        PessoaVinculadaPK id = new PessoaVinculadaPK();
        id.setIdPessoa(idPessoa);
        id.setIdPessoaVinculada(idPessoaVinculada);
        id.setIdTipoVinculoPessoa(idTipoVinculoPessoa);
        if (this.service.exists(id)) {
            try {
                int idPessoaFisica = this.service.find(id).getPessoa().getIdPessoa();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                this.service.delete(id);
                return Response.ok().build();
            } catch (NegocioException var8) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var8.getErroMap()).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    private Map<String, Object> getReturnFields(PessoaVinculada pessoaVinculada) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        Map<String, Object> id = new LinkedHashMap(1);
        toReturn.put("id", id);
        id.put("idPessoa", pessoaVinculada.getId().getIdPessoa());
        id.put("idPessoaVinculada", pessoaVinculada.getId().getIdPessoaVinculada());
        id.put("idTipoVinculoPessoa", pessoaVinculada.getId().getIdTipoVinculoPessoa());
        toReturn.put("dtInicio", DateUtils.getDataFormatada(pessoaVinculada.getDtInicio()));
        toReturn.put("dtFim", DateUtils.getDataFormatada(pessoaVinculada.getDtFim()));
        toReturn.put("stPessoaVinculada", pessoaVinculada.getStPessoaVinculada());
        return toReturn;
    }
}
