package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.TipoAbrangencia;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/tipo_abrangencia")
@Auditar
public class TipoAbrangenciaRESTService {
    @Inject
    private GenericCrudService service;

    public TipoAbrangenciaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public Collection<TipoAbrangencia> listarTiposAbrangencia(@Context HttpServletRequest request) {
        return this.service.findAll(TipoAbrangencia.class);
    }
}
