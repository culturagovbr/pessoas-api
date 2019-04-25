package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.DocumentacaoPessoa;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.pessoa.service.DocumentacaoPessoaService;
import br.gov.cultura.sistema.pessoa.service.PessoaFisicaService;
import br.gov.cultura.sistema.service.SegurancaService;
import br.gov.cultura.sistema.util.DateUtils;
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

@Path("/documentacao_pessoa")
@Auditar
public class DocumentacaoPessoaRESTService {
    @Inject
    private DocumentacaoPessoaService service;
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    @Inject
    private SegurancaService segurancaService;

    public DocumentacaoPessoaRESTService() {
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirDocumentacaoPessoa(DocumentacaoPessoa documentacaoPessoa, @Context HttpServletRequest request) {
        try {
            int idPessoaFisica = documentacaoPessoa.getIdPessoaFisica();
            Servico servico = this.segurancaService.getServicoByRequest(request);
            this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
            return Response.ok(this.getReturnFields(this.service.create(documentacaoPessoa))).build();
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
    public Response atualizarDocumentacaoPessoa(DocumentacaoPessoa documentacaoPessoa, @Context HttpServletRequest request) {
        if (this.service.find(documentacaoPessoa.getIdPessoaFisica()) != null) {
            try {
                int idPessoaFisica = documentacaoPessoa.getIdPessoaFisica();
                Servico servico = this.segurancaService.getServicoByRequest(request);
                this.pessoaFisicaService.isPermitidoAlterar(idPessoaFisica, servico);
                return Response.ok(this.getReturnFields(this.service.update(documentacaoPessoa))).build();
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
    public Response excluirDocumentacaoPessoa(@PathParam("id") int id, @Context HttpServletRequest request) {
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

    private Map<String, Object> getReturnFields(DocumentacaoPessoa dp) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        toReturn.put("idPessoaFisica", dp.getIdPessoaFisica());
        Map<String, Object> ufTituloEleitoral = new HashMap(1);
        toReturn.put("ufTituloEleitoral", ufTituloEleitoral);
        if (dp.getUfTituloEleitoral() != null) {
            ufTituloEleitoral.put("sgUf", dp.getUfTituloEleitoral().getSgUf());
        }

        Map<String, Object> ufConselhoClasse = new HashMap(1);
        toReturn.put("ufConselhoClasse", ufConselhoClasse);
        if (dp.getUfConselhoClasse() != null) {
            ufConselhoClasse.put("sgUf", dp.getUfConselhoClasse().getSgUf());
        }

        Map<String, Object> ufCarteiraTrabalho = new HashMap(1);
        toReturn.put("ufCarteiraTrabalho", ufCarteiraTrabalho);
        if (dp.getUfCarteiraTrabalho() != null) {
            ufCarteiraTrabalho.put("sgUf", dp.getUfCarteiraTrabalho().getSgUf());
        }

        Map<String, Object> ufIdentidade = new HashMap(1);
        toReturn.put("ufIdentidade", ufIdentidade);
        if (dp.getUfIdentidade() != null) {
            ufIdentidade.put("sgUf", dp.getUfIdentidade().getSgUf());
        }

        toReturn.put("nrTituloEleitor", dp.getNrTituloEleitor());
        toReturn.put("nrZonaTituloEleitor", dp.getNrZonaTituloEleitor());
        toReturn.put("nrSecaoTituloEleitor", dp.getNrSecaoTituloEleitor());
        toReturn.put("dtExpTituloEleitor", DateUtils.getDataFormatada(dp.getDtExpTituloEleitor()));
        toReturn.put("nrCertificadoReservista", dp.getNrCertificadoReservista());
        toReturn.put("nmExpCertificadoReservista", dp.getNmExpCertificadoReservista());
        toReturn.put("dtExpCertificadoReservista", DateUtils.getDataFormatada(dp.getDtExpCertificadoReservista()));
        toReturn.put("nrHabilitacao", dp.getNrHabilitacao());
        toReturn.put("dsCategoriaHabilitacao", dp.getDsCategoriaHabilitacao());
        toReturn.put("nrCarteiraConselhoClasse", dp.getNrCarteiraConselhoClasse());
        toReturn.put("nmExpConselhoClasse", dp.getNmExpConselhoClasse());
        toReturn.put("dsRegiaoReservista", dp.getDsRegiaoReservista());
        toReturn.put("cdCategoriaReservista", dp.getCdCategoriaReservista());
        toReturn.put("nrCarteiraTrabalho", dp.getNrCarteiraTrabalho());
        toReturn.put("nrSerieCarteiraTrabalho", dp.getNrSerieCarteiraTrabalho());
        toReturn.put("nrRg", dp.getNrRg());
        toReturn.put("nmOrgaoExpRg", dp.getNmOrgaoExpRg());
        toReturn.put("dtExpedicaoRg", DateUtils.getDataFormatada(dp.getDtExpedicaoRg()));
        toReturn.put("nrPisPasep", dp.getNrPisPasep());
        return toReturn;
    }
}
