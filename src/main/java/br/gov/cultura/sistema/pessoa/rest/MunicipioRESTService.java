package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Municipio;
import br.gov.cultura.sistema.pessoa.service.MunicipioService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/municipio")
@Auditar
public class MunicipioRESTService {
    @Inject
    private MunicipioService service;

    public MunicipioRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{sgUf}")
    public Response listarMunicipios(@PathParam("sgUf") String siglaUf, @Context HttpServletRequest request) {
        List<Map<String, Object>> responseList = new ArrayList();
        List<Municipio> municipios = this.service.findByUf(siglaUf);
        Iterator var6 = municipios.iterator();

        while(var6.hasNext()) {
            Municipio m = (Municipio)var6.next();
            Map<String, Object> map = new HashMap();
            map.put("idMunicipio", m.getIdMunicipio());
            map.put("nmMunicipio", m.getNmMunicipio());
            map.put("sgPais", m.getPais().getSgPais());
            map.put("sgUf", siglaUf.toUpperCase());
            responseList.add(map);
        }

        return Response.ok(responseList).build();
    }
}
