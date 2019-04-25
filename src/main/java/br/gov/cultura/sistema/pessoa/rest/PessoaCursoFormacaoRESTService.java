package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.PessoaCursoFormacao;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.PessoaCursoFormacaoService;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.service.SegurancaService;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

@Path("/formacao")
@Auditar
public class PessoaCursoFormacaoRESTService {
    @Inject
    private PessoaCursoFormacaoService service;
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    @Inject
    private SegurancaService segurancaService;

    public PessoaCursoFormacaoRESTService() {
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirCursoFormacaoPessoa(PessoaCursoFormacao formacaoPessoa, @Context HttpServletRequest request) {
        try {
            int idPessoaFisica = formacaoPessoa.getPessoaFisica().getIdPessoaFisica();
            Servico servico = this.segurancaService.getServicoByRequest(request);
            this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
            return Response.ok(this.getReturnFields(this.service.create(formacaoPessoa))).build();
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
    public Response atualizarCursoFormacaoPessoa(PessoaCursoFormacao formacaoPessoa, @Context HttpServletRequest request) {
        PessoaCursoFormacao formacaoAtual = this.service.find(formacaoPessoa.getIdPessoaCursoFormacao());
        if (formacaoAtual != null) {
            try {
                int idPessoaFisica = formacaoPessoa.getPessoaFisica().getIdPessoaFisica();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                this.pessoaFisicaService.isPermitidoAlterar(formacaoAtual.getPessoaFisica().getIdPessoaFisica(), servico);
                return Response.ok(this.getReturnFields(this.service.update(formacaoPessoa))).build();
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
    public Response excluirCursoFormacaoPessoa(@PathParam("id") int id, @Context HttpServletRequest request) {
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

    private Map<String, Object> getReturnFields(PessoaCursoFormacao formacao) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idCursoFormacaoPessoa", formacao.getIdPessoaCursoFormacao());
        Map<String, Object> pessoa = new HashMap(1);
        toReturn.put("pessoaFisica", pessoa);
        if (formacao.getPessoaFisica() != null) {
            pessoa.put("idPessoaFisica", formacao.getPessoaFisica().getIdPessoaFisica());
        }

        Map<String, Object> ddd = new HashMap(1);
        toReturn.put("cursoFormacao", ddd);
        if (formacao.getCursoFormacao() != null) {
            ddd.put("idCursoFormacao", formacao.getCursoFormacao().getIdCursoFormacao());
        }

        Map<String, Object> pais = new HashMap(1);
        toReturn.put("pais", pais);
        if (formacao.getPais() != null) {
            pais.put("sgPais", formacao.getPais().getSgPais());
        }

        Map<String, Object> muncipio = new HashMap(1);
        toReturn.put("municipio", muncipio);
        if (formacao.getMunicipio() != null) {
            muncipio.put("idMunicipio", formacao.getMunicipio().getIdMunicipio());
        }

        toReturn.put("nmInstituicaoEnsino", formacao.getNmInstituicaoEnsino());
        toReturn.put("dsTituloAcademico", formacao.getDsTituloAcademico());
        toReturn.put("nrCargaHoraria", formacao.getNrCargaHoraria());
        toReturn.put("aaInicioCurso", formacao.getAaInicioCurso());
        toReturn.put("aaFimCurso", formacao.getAaFimCurso());
        return toReturn;
    }
}
