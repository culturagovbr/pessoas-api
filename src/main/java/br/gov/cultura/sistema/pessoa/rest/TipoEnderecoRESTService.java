package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.TipoEndereco;
import br.gov.cultura.sistema.pessoa.service.TipoEnderecoService;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/tipo_endereco")
@Auditar
public class TipoEnderecoRESTService {
    @Inject
    private TipoEnderecoService service;

    public TipoEnderecoRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar")
    public List<TipoEndereco> listarTipoEndereco(@Context HttpServletRequest request) {
        return this.service.findAll();
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{tpPessoa}")
    public List<TipoEndereco> listarTipoEnderecoPorTipoPessoa(@PathParam("tpPessoa") String tipoPessoa, @Context HttpServletRequest request) {
        return this.service.findByTipoPessoa(tipoPessoa);
    }
}
