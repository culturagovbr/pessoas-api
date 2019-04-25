package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Agencia;
import br.gov.cultura.sistema.model.corporativo.Banco;
import br.gov.cultura.sistema.model.corporativo.ContaCorrente;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.ContaCorrenteService;
import br.gov.cultura.sistema.service.GenericCrudService;
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

@Path("/conta_corrente")
@Auditar
public class ContaCorrenteRESTService {
    @Inject
    private ContaCorrenteService service;
    @Inject
    private GenericCrudService genericCrudService;

    public ContaCorrenteRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{id}")
    public Response retornarContaCorrente(@PathParam("id") int id, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields(this.service.find(id))).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirContaCorrente(ContaCorrente cc, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.getReturnFields(this.service.create(cc))).build();
        } catch (NegocioException var4) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var4.getErroMap()).build();
        } catch (Exception var5) {
            var5.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar")
    public Response atualizarContaCorrente(ContaCorrente cc, @Context HttpServletRequest request) {
        if (this.service.find(cc.getIdContaCorrente()) != null) {
            try {
                return Response.ok(this.getReturnFields(this.service.update(cc))).build();
            } catch (NegocioException var4) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var4.getErroMap()).build();
            } catch (Exception var5) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    @Produces({"application/json"})
    public Response excluirContaCorrente(@PathParam("id") int id, @Context HttpServletRequest request) {
        if (this.service.exists(id)) {
            try {
                this.service.delete(id);
                return Response.ok().build();
            } catch (NegocioException var4) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var4.getErroMap()).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    private Map<String, Object> getReturnFields(ContaCorrente cc) {
        cc.setBanco((Banco)this.genericCrudService.refresh(cc.getBanco()));
        cc.setAgencia((Agencia)this.genericCrudService.refresh(cc.getAgencia()));
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idContaCorrente", cc.getIdContaCorrente());
        Map<String, Object> banco = new HashMap(1);
        toReturn.put("banco", banco);
        if (cc.getBanco() != null) {
            banco.put("nrBanco", cc.getBanco().getNrBanco());
            banco.put("nmBanco", cc.getBanco().getNmBanco());
        }

        Map<String, Object> agencia = new HashMap(2);
        toReturn.put("agencia", agencia);
        if (cc.getAgencia() != null) {
            agencia.put("idAgencia", cc.getAgencia().getIdAgencia());
            agencia.put("nrAgencia", cc.getAgencia().getNrAgencia());
        }

        toReturn.put("nrContaCorrente", cc.getNrContaCorrente());
        toReturn.put("stContaCorrentePrincipal", cc.getStContaCorrentePrincipal());
        Map<String, Object> pessoa = new HashMap(1);
        toReturn.put("pessoa", pessoa);
        if (cc.getPessoa() != null) {
            pessoa.put("idPessoa", cc.getPessoa().getIdPessoa());
        }

        return toReturn;
    }
}
