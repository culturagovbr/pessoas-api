package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.EstadoCivil;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/estado_civil")
@Auditar
public class EstadoCivilRESTService {
    @Inject
    private GenericCrudService service;

    public EstadoCivilRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public List<EstadoCivil> listarEstadoCivil(@Context HttpServletRequest request) {
        return this.service.findAll(EstadoCivil.class);
    }
}
