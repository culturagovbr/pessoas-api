package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Banco;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.BancoService;
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

@Path("/banco")
@Auditar
public class BancoRESTService {
    @Inject
    private BancoService service;

    public BancoRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public Response listarBancos(@Context HttpServletRequest request) {
        return Response.ok(this.service.findAll()).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{nrBanco}")
    public Response retornarBanco(@PathParam("nrBanco") String nrBanco, @Context HttpServletRequest request) {
        return Response.ok(this.service.find(nrBanco)).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirBanco(Banco banco, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.service.create(banco)).build();
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
    public Response atualizarBanco(Banco banco, @Context HttpServletRequest request) {
        if (this.service.find(banco.getNrBanco()) != null) {
            try {
                return Response.ok(this.service.update(banco)).build();
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
    @Path("/deletar/{nrBanco}")
    @Produces({"application/json"})
    public Response excluirBanco(@PathParam("nrBanco") String nrBanco, @Context HttpServletRequest request) {
        if (this.service.exists(nrBanco)) {
            try {
                this.service.delete(nrBanco);
                return Response.ok().build();
            } catch (NegocioException var4) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var4.getErroMap()).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }
}
