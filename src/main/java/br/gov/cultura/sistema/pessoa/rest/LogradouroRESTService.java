package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Logradouro;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.LogradouroService;
import br.gov.cultura.sistema.util.FormatadorUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

@Path("/logradouro")
@Auditar
public class LogradouroRESTService {
    @Inject
    private LogradouroService service;

    public LogradouroRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cep}")
    public Response retornarLogradouro(@PathParam("cep") String cep, @Context HttpServletRequest request) {
        String cepApenasNumeros = FormatadorUtils.removerPontosETracos(cep);
        Logradouro logradouro = this.service.findByCep(cepApenasNumeros);
        return logradouro == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFields(logradouro)).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirLogradouro(Logradouro logradouro, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.getReturnFields(this.service.create(logradouro))).build();
        } catch (Exception var4) {
            var4.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar")
    public Response atualizarLogradouro(Logradouro logradouro, @Context HttpServletRequest request) {
        if (this.service.find(logradouro.getIdLogradouro()) != null) {
            try {
                return Response.ok(this.getReturnFields(this.service.update(logradouro))).build();
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
    public Response excluirBairro(@PathParam("id") int id, @Context HttpServletRequest request) {
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

    private Map<String, Object> getReturnFields(Logradouro logradouro) {
        Map<String, Object> toReturn = new LinkedHashMap(17);
        toReturn.put("idLogradouro", logradouro.getIdLogradouro());
        toReturn.put("nmLogradouro", logradouro.getNmLogradouro());
        toReturn.put("nmAbrevLogradouro", logradouro.getNmAbrevLogradouro());
        toReturn.put("dsTipoLogradouro", logradouro.getDsTipoLogradouro());
        toReturn.put("stLogradouro", logradouro.getStLogradouro());
        toReturn.put("dsComplemento", logradouro.getDsComplemento());
        toReturn.put("nrCep", logradouro.getNrCep());
        toReturn.put("tpCep", logradouro.getTpCep());
        toReturn.put("stAtualizacao", logradouro.getStAtualizacao());
        toReturn.put("nrCpc", logradouro.getNrCpc());
        toReturn.put("nrSecaoInicial", logradouro.getNrSecaoInicial());
        toReturn.put("nrSecaoFinal", logradouro.getNrSecaoFinal());
        toReturn.put("tpParidade", logradouro.getTpParidade());
        Map<String, Object> uf = new HashMap(1);
        toReturn.put("uf", uf);
        uf.put("sgUf", logradouro.getUf().getSgUf());
        uf.put("nmUf", logradouro.getUf().getNmUf());
        Map<String, Object> municipio = new HashMap(1);
        toReturn.put("municipio", municipio);
        municipio.put("idMunicipio", logradouro.getMunicipio().getIdMunicipio());
        municipio.put("nmMunicipio", logradouro.getMunicipio().getNmMunicipio());
        Map<String, Object> bairroInicio = new HashMap(1);
        toReturn.put("bairroInicio", bairroInicio);
        if (logradouro.getBairroInicio() != null) {
            bairroInicio.put("idBairro", logradouro.getBairroInicio().getIdBairro());
            bairroInicio.put("nmBairro", logradouro.getBairroInicio().getNmBairro());
        } else {
            bairroInicio.put("idBairro", (Object)null);
            bairroInicio.put("nmBairro", (Object)null);
        }

        Map<String, Object> bairroFim = new HashMap(1);
        toReturn.put("bairroFim", bairroFim);
        if (logradouro.getBairroFim() != null) {
            bairroFim.put("idBairro", logradouro.getBairroFim().getIdBairro());
            bairroFim.put("nmBairro", logradouro.getBairroFim().getNmBairro());
        } else {
            bairroFim.put("idBairro", (Object)null);
            bairroFim.put("nmBairro", (Object)null);
        }

        return toReturn;
    }
}
