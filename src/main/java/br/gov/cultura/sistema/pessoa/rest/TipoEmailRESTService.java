package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.TipoEmail;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/tipo_email")
@Auditar
public class TipoEmailRESTService {
    @Inject
    private GenericCrudService service;

    public TipoEmailRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public Collection<TipoEmail> listarTiposEmail(@Context HttpServletRequest request) {
        return this.service.findAll(TipoEmail.class);
    }
}
