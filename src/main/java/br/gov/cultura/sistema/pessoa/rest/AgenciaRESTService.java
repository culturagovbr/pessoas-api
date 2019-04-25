package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Agencia;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.AgenciaService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

@Path("/agencia")
@Auditar
public class AgenciaRESTService {
    @Inject
    private AgenciaService service;

    public AgenciaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{idAgencia}")
    public Response retornarAgencia(@PathParam("idAgencia") Integer idAgencia, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields(this.service.find(idAgencia))).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/banco/{nrBanco}")
    public Response listarAgenciasPorBanco(@PathParam("nrBanco") String nrBanco, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findByNrBanco(nrBanco))).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirAgencia(Agencia agencia, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.getReturnFields(this.service.create(agencia))).build();
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
    public Response atualizarAgencia(Agencia agencia, @Context HttpServletRequest request) {
        if (this.service.find(agencia.getIdAgencia()) != null) {
            try {
                return Response.ok(this.getReturnFields(this.service.update(agencia))).build();
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
    public Response excluirAgencia(@PathParam("id") int id, @Context HttpServletRequest request) {
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

    private List<Map<String, Object>> getReturnFields(Collection<Agencia> agencias) {
        List<Map<String, Object>> toReturn = new ArrayList();
        Iterator var4 = agencias.iterator();

        while(var4.hasNext()) {
            Agencia agencia = (Agencia)var4.next();
            toReturn.add(this.getReturnFields(agencia));
        }

        return toReturn;
    }

    private Map<String, Object> getReturnFields(Agencia agencia) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idAgencia", agencia.getIdAgencia());
        toReturn.put("nrAgencia", agencia.getNrAgencia());
        Map<String, Object> banco = new HashMap(1);
        toReturn.put("banco", banco);
        if (agencia.getBanco() != null) {
            banco.put("nrBanco", agencia.getBanco().getNrBanco());
        }

        toReturn.put("nmAgencia", agencia.getNmAgencia());
        return toReturn;
    }
}
