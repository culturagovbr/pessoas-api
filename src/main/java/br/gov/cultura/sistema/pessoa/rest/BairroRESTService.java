package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Bairro;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.BairroService;
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

@Path("/bairro")
@Auditar
public class BairroRESTService {
    @Inject
    private BairroService service;

    public BairroRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{id}")
    public Response retornarBairro(@PathParam("id") int idMunicipio, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findByIdMunicipio(idMunicipio))).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirBairro(Bairro bairro, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.getReturnFields(this.service.create(bairro))).build();
        } catch (Exception var4) {
            var4.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar")
    public Response atualizarBairro(Bairro bairro, @Context HttpServletRequest request) {
        if (this.service.find(bairro.getIdBairro()) != null) {
            try {
                return Response.ok(this.getReturnFields(this.service.update(bairro))).build();
            } catch (Exception var4) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    @Produces({"application/json"})
    public Response excluirBairro(@PathParam("id") int id, @Context HttpServletRequest request) {
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

    private List<Map<String, Object>> getReturnFields(Collection<Bairro> list) {
        List<Map<String, Object>> toReturn = new ArrayList();
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            Bairro bairro = (Bairro)var4.next();
            toReturn.add(this.getReturnFields(bairro));
        }

        return toReturn;
    }

    private Map<String, Object> getReturnFields(Bairro bairro) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idBairro", bairro.getIdBairro());
        toReturn.put("nmBairro", bairro.getNmBairro());
        toReturn.put("nmBairroAbreviado", bairro.getNmBairroAbreviado());
        toReturn.put("tpOrigem", bairro.getTpOrigem());
        Map<String, Object> uf = new HashMap(1);
        toReturn.put("uf", uf);
        uf.put("sgUf", bairro.getUf().getSgUf());
        Map<String, Object> municipio = new HashMap(1);
        toReturn.put("municipio", municipio);
        municipio.put("idMunicipio", bairro.getMunicipio().getIdMunicipio());
        return toReturn;
    }
}
