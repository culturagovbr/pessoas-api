package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.TipoTelefone;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/tipo_telefone")
@Auditar
public class TipoTelefoneRESTService {
    @Inject
    private GenericCrudService service;

    public TipoTelefoneRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/")
    public List<TipoTelefone> listarTiposTelefone(@Context HttpServletRequest request) {
        return this.service.findAll(TipoTelefone.class);
    }
}
