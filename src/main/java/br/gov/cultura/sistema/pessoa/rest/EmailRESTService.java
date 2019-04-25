package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Email;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.EmailService;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.service.SegurancaService;
import br.gov.cultura.sistema.util.FormatadorUtils;
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

@Path("/email")
@Auditar
public class EmailRESTService {
    @Inject
    private EmailService service;
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    @Inject
    private SegurancaService segurancaService;

    public EmailRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/pessoa_fisica/{cpf}")
    public Response retornarEmailPessoaFisica(@PathParam("cpf") String cpf, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findByCpf(FormatadorUtils.removerPontosETracos(cpf)))).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/pessoa_juridica/{cnpj}")
    public Response retornarEmailPessoaJuridica(@PathParam("cnpj") String cnpj, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findByCnpj(FormatadorUtils.removerPontosETracos(cnpj)))).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirEmail(Email email, @Context HttpServletRequest request) {
        try {
            int idPessoa = email.getIdPessoa();
            Servico servico = this.segurancaService.getServicoByRequest(request);
            this.pessoaFisicaService.isPermitidoAlterar(idPessoa, servico);
            return Response.ok(this.getReturnFields(this.service.create(email))).build();
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
    public Response atualizarEmail(Email email, @Context HttpServletRequest request) {
        Email emailAtual = this.service.find(email.getIdEmail());
        if (emailAtual != null) {
            try {
                int idPessoa = email.getIdPessoa();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoa, servico);
                this.pessoaFisicaService.isPermitidoAlterar(emailAtual.getIdPessoa(), servico);
                return Response.ok(this.getReturnFields(this.service.update(email))).build();
            } catch (NegocioException var6) {
                return Response.status(Status.PRECONDITION_FAILED).entity(var6.getErroMap()).build();
            } catch (Exception var7) {
                return Response.status(Status.NOT_MODIFIED).build();
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    @Produces({"application/json"})
    public Response excluirEmail(@PathParam("id") int id, @Context HttpServletRequest request) {
        if (this.service.exists(id)) {
            try {
                int idPessoaFisica = this.service.find(id).getIdPessoa();
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

    private List<Map<String, Object>> getReturnFields(Collection<Email> emails) {
        List<Map<String, Object>> toReturn = new ArrayList();
        Iterator var4 = emails.iterator();

        while(var4.hasNext()) {
            Email email = (Email)var4.next();
            toReturn.add(this.getReturnFields(email));
        }

        return toReturn;
    }

    private Map<String, Object> getReturnFields(Email email) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idEmail", email.getIdEmail());
        toReturn.put("dsEmail", email.getDsEmail());
        Map<String, Object> tipoEmail = new HashMap(1);
        toReturn.put("tipoEmail", tipoEmail);
        if (email.getTipoEmail() != null) {
            tipoEmail.put("idTipoEmail", email.getTipoEmail().getIdTipoEmail());
        }

        Map<String, Object> pessoa = new HashMap(1);
        toReturn.put("pessoa", pessoa);
        if (email.getPessoa() != null) {
            pessoa.put("idPessoa", email.getPessoa().getIdPessoa());
        }

        toReturn.put("stEmailPrincipal", email.getStEmailPrincipal());
        return toReturn;
    }
}
