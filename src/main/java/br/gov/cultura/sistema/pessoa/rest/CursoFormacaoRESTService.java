package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.CursoFormacao;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.CursoFormacaoService;
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

@Path("/curso_formacao")
@Auditar
public class CursoFormacaoRESTService {
    @Inject
    private CursoFormacaoService service;

    public CursoFormacaoRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public Response listarCursoFormacao(@Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findAll())).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{id}")
    public Response retornarCursoFormacao(@PathParam("id") int id, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields(this.service.find(id))).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirCursoFormacao(CursoFormacao cursoFormacao, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.getReturnFields(this.service.create(cursoFormacao))).build();
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
    public Response atualizarCursoFormacao(CursoFormacao cursoFormacao, @Context HttpServletRequest request) {
        if (this.service.find(cursoFormacao.getIdCursoFormacao()) != null) {
            try {
                return Response.ok(this.getReturnFields(this.service.update(cursoFormacao))).build();
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
    public Response excluirCurso(@PathParam("id") int id, @Context HttpServletRequest request) {
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

    private List<Map<String, Object>> getReturnFields(Collection<CursoFormacao> list) {
        List<Map<String, Object>> toReturn = new ArrayList();
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            CursoFormacao cf = (CursoFormacao)var4.next();
            toReturn.add(this.getReturnFields(cf));
        }

        return toReturn;
    }

    private Map<String, Object> getReturnFields(CursoFormacao cf) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idCursoFormacao", cf.getIdCursoFormacao());
        Map<String, Object> curso = new HashMap(1);
        toReturn.put("curso", curso);
        curso.put("idCurso", cf.getCurso().getIdCurso());
        Map<String, Object> cursoArea = new HashMap(1);
        toReturn.put("cursoArea", cursoArea);
        cursoArea.put("idCursoArea", cf.getCursoArea().getIdCursoArea());
        Map<String, Object> cursoNivelFormacao = new HashMap(1);
        toReturn.put("cursoNivelFormacao", cursoNivelFormacao);
        cursoNivelFormacao.put("idCursoNivelFormacao", cf.getCursoNivelFormacao().getIdCursoNivelFormacao());
        return toReturn;
    }
}
