package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.TipoPessoa;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/tipo_pessoa")
@Auditar
public class TipoPessoaRESTService {
    @Inject
    private GenericCrudService service;

    public TipoPessoaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/")
    public Collection<TipoPessoa> listarTiposPessoa(@Context HttpServletRequest request) {
        return this.service.findAll(TipoPessoa.class);
    }
}
