package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Curso;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.CursoService;
import java.util.Collection;
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

@Path("/curso")
@Auditar
public class CursoRESTService {
    @Inject
    private CursoService service;

    public CursoRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public Collection<Curso> listarCursos(@Context HttpServletRequest request) {
        return this.service.findAll();
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{id}")
    public Curso retornarCurso(@PathParam("id") int id, @Context HttpServletRequest request) {
        return this.service.find(id);
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirCurso(Curso curso, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.service.create(curso)).build();
        } catch (Exception var4) {
            var4.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar")
    public Response atualizarCurso(Curso curso, @Context HttpServletRequest request) {
        if (this.service.find(curso.getIdCurso()) != null) {
            try {
                return Response.ok(this.service.update(curso)).build();
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
}
