package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Telefone;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.pessoa.service.TelefoneService;
import br.gov.cultura.sistema.service.SegurancaService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

@Path("/telefone")
@Auditar
public class TelefoneRESTService {
    @Inject
    private TelefoneService service;
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    @Inject
    private SegurancaService segurancaService;

    public TelefoneRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/pessoa_fisica/{cpf}")
    public Response retornarTelefonePessoaFisica(@PathParam("cpf") String cpf, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findByCpf(cpf))).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/pessoa_juridica/{cnpj}")
    public Response retornarTelefonePessoaJuridica(@PathParam("cnpj") String cnpj, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findByCnpj(cnpj))).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirTelefone(Telefone telefone, @Context HttpServletRequest request) {
        try {
            int idPessoaFisica = telefone.getPessoa().getIdPessoa();
            Servico servico = this.segurancaService.getServicoByRequest(request);
            this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
            return Response.ok(this.getReturnFields(this.service.create(telefone))).build();
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
    public Response atualizarTelefone(Telefone telefone, @Context HttpServletRequest request) {
        Telefone telefoneAtual = this.service.find(telefone.getIdTelefone());
        if (telefoneAtual != null) {
            try {
                int idPessoaFisica = telefone.getPessoa().getIdPessoa();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                this.pessoaFisicaService.isPermitidoAlterar(telefoneAtual.getPessoa().getIdPessoa(), servico);
                this.service.validarTelefoneDaReceitaFederal(telefoneAtual);
                return Response.ok(this.getReturnFields(this.service.update(telefone))).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    @Produces({"application/json"})
    public Response excluirTelefone(@PathParam("id") int id, @Context HttpServletRequest request) {
        if (this.service.exists(id)) {
            try {
                int idPessoaFisica = this.service.find(id).getPessoa().getIdPessoa();
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

    private List<Map<String, Object>> getReturnFields(Collection<Telefone> telefones) {
        List<Map<String, Object>> toReturn = new ArrayList();
        Iterator var4 = telefones.iterator();

        while(var4.hasNext()) {
            Telefone tel = (Telefone)var4.next();
            toReturn.add(this.getReturnFields(tel));
        }

        return toReturn;
    }

    private Map<String, Object> getReturnFields(Telefone tel) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idTelefone", tel.getIdTelefone());
        Map<String, Object> ddd = new HashMap(1);
        toReturn.put("ddd", ddd);
        if (tel.getDdd() != null) {
            ddd.put("cdDdd", tel.getDdd().getCdDdd());
        }

        toReturn.put("nrTelefone", tel.getNrTelefone());
        toReturn.put("nrRamal", tel.getNrRamal());
        Map<String, Object> pais = new HashMap(1);
        toReturn.put("pais", pais);
        if (tel.getPais() != null) {
            pais.put("sgPais", tel.getPais().getSgPais());
        }

        Map<String, Object> pessoa = new HashMap(1);
        toReturn.put("pessoa", pessoa);
        if (tel.getPessoa() != null) {
            pessoa.put("idPessoa", tel.getPessoa().getIdPessoa());
        }

        Map<String, Object> tipoTelefone = new HashMap(1);
        toReturn.put("tipoTelefone", tipoTelefone);
        if (tel.getTipoTelefone() != null) {
            tipoTelefone.put("idTipoTelefone", tel.getTipoTelefone().getIdTipoTelefone());
        }

        return toReturn;
    }
}
