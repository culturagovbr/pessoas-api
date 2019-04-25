package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.Idioma;
import br.gov.cultura.sistema.model.corporativo.IdiomaPessoa;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.IdiomaPessoaService;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.service.SegurancaService;
import br.gov.cultura.sistema.util.FormatadorUtils;
import br.gov.cultura.sistema.util.ValidacaoUtils;
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

@Path("/idioma_pessoa")
@Auditar
public class IdiomaPessoaRESTService {
    @Inject
    private IdiomaPessoaService service;
    @Inject
    private GenericCrudService genericCrudService;
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    @Inject
    private SegurancaService segurancaService;

    public IdiomaPessoaRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{cpf}")
    public Response retornarIdiomaPessoa(@PathParam("cpf") String cpf, @Context HttpServletRequest request) {
        return Response.ok(this.getReturnFields((Collection)this.service.findByCpf(FormatadorUtils.removerPontosETracos(cpf)))).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirIdiomaPessoa(IdiomaPessoa idiomaPessoa, @Context HttpServletRequest request) {
        try {
            int idPessoaFisica = idiomaPessoa.getPessoaFisica().getIdPessoaFisica();
            Servico servico = this.segurancaService.getServicoByRequest(request);
            this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
            return Response.ok(this.getReturnFields(this.service.create(idiomaPessoa))).build();
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
    public Response atualizarIdiomaPessoa(IdiomaPessoa idiomaPessoa, @Context HttpServletRequest request) {
        IdiomaPessoa idiomaPessoaAtual = this.service.find(idiomaPessoa.getIdIdiomaPessoa());
        if (idiomaPessoaAtual != null) {
            try {
                int idPessoaFisica = idiomaPessoa.getPessoaFisica().getIdPessoaFisica();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                this.pessoaFisicaService.isPermitidoAlterar(idiomaPessoaAtual.getPessoaFisica().getIdPessoaFisica(), servico);
                return Response.ok(this.getReturnFields(this.service.update(idiomaPessoa))).build();
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
    public Response excluirIdiomaPessoa(@PathParam("id") int id, @Context HttpServletRequest request) {
        if (this.service.exists(id)) {
            try {
                int idPessoaFisica = this.service.find(id).getPessoaFisica().getIdPessoaFisica();
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

    private List<Map<String, Object>> getReturnFields(Collection<IdiomaPessoa> idiomas) {
        List<Map<String, Object>> toReturn = new ArrayList();
        Iterator var4 = idiomas.iterator();

        while(var4.hasNext()) {
            IdiomaPessoa idiomaPessoa = (IdiomaPessoa)var4.next();
            toReturn.add(this.getReturnFields(idiomaPessoa));
        }

        return toReturn;
    }

    private Map<String, Object> getReturnFields(IdiomaPessoa idiomaPessoa) {
        idiomaPessoa.setIdioma((Idioma)this.genericCrudService.refresh(idiomaPessoa.getIdioma()));
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idIdiomaPessoa", idiomaPessoa.getIdIdiomaPessoa());
        Map<String, Object> pessoa = new HashMap(1);
        toReturn.put("pessoaFisica", pessoa);
        if (idiomaPessoa.getPessoaFisica() != null) {
            pessoa.put("idPessoaFisica", idiomaPessoa.getPessoaFisica().getIdPessoaFisica());
        }

        Map<String, Object> idioma = new HashMap(1);
        toReturn.put("idioma", idioma);
        if (idiomaPessoa.getIdioma() != null) {
            idioma.put("idIdioma", idiomaPessoa.getIdioma().getIdIdioma());
            if (ValidacaoUtils.isNotEmpty(idiomaPessoa.getIdioma().getDsIdioma())) {
                idioma.put("dsIdioma", idiomaPessoa.getIdioma().getDsIdioma());
            }
        }

        toReturn.put("nmEstabelecimentoEnsino", idiomaPessoa.getNmEstabelecimentoEnsino());
        toReturn.put("stEntende", idiomaPessoa.getStEntende());
        toReturn.put("stFala", idiomaPessoa.getStFala());
        toReturn.put("stLe", idiomaPessoa.getStLe());
        toReturn.put("stEscreve", idiomaPessoa.getStEscreve());
        toReturn.put("stDominioPortugues", idiomaPessoa.getStDominioPortugues());
        return toReturn;
    }
}
