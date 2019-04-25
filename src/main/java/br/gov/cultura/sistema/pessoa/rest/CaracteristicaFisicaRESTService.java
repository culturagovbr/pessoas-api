package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.CaracteristicaFisica;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.CaracteristicaFisicaService;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.service.SegurancaService;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/caracteristica_fisica")
@Auditar
public class CaracteristicaFisicaRESTService {
    @Inject
    private CaracteristicaFisicaService service;
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    @Inject
    private SegurancaService segurancaService;

    public CaracteristicaFisicaRESTService() {
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirCaracteristicaFisica(CaracteristicaFisica caracteristicaFisica, @Context HttpServletRequest request) {
        try {
            int idPessoaFisica = caracteristicaFisica.getIdPessoaFisica();
            Servico servico = this.segurancaService.getServicoByRequest(request);
            this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
            return Response.ok(this.getReturnFields(this.service.create(caracteristicaFisica))).build();
        } catch (NegocioException var5) {
            return Response.status(Status.PRECONDITION_FAILED).entity(var5.getErroMap()).build();
        } catch (Exception var6) {
            var6.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar")
    public Response atualizarCaracteristicaFisica(CaracteristicaFisica caracteristicaFisica, @Context HttpServletRequest request) {
        if (this.service.find(caracteristicaFisica.getIdPessoaFisica()) != null) {
            try {
                int idPessoaFisica = caracteristicaFisica.getIdPessoaFisica();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                return Response.ok(this.getReturnFields(this.service.update(caracteristicaFisica))).build();
            } catch (NegocioException var5) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var5.getErroMap()).build();
            } catch (Exception var6) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    @Produces({"application/json"})
    public Response excluirCaracteristicaFisica(@PathParam("id") int id, @Context HttpServletRequest request) {
        if (this.service.exists(id)) {
            try {
                int idPessoaFisica = this.service.find(id).getIdPessoaFisica();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                this.service.delete(id);
                return Response.ok().build();
            } catch (NegocioException var5) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var5.getErroMap()).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    private Map<String, Object> getReturnFields(CaracteristicaFisica cf) {
        Map<String, Object> map = new HashMap();
        map.put("idPessoa", cf.getIdPessoaFisica());
        map.put("idCor", cf.getCor().getIdCor());
        map.put("sgPais", cf.getPais().getSgPais());
        return map;
    }
}
