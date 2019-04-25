package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Idioma;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/idioma")
@Auditar
public class IdiomaRESTService {
    @Inject
    private GenericCrudService service;

    public IdiomaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public Collection<Idioma> listarIdiomas(@Context HttpServletRequest request) {
        return this.service.findAll(Idioma.class);
    }
}
