package br.gov.cultura.sistema.pessoa.rest;

import br.gov.cultura.sistema.interceptor.Auditar;
import br.gov.cultura.sistema.model.corporativo.PessoaEstrangeira;
import br.gov.cultura.sistema.pessoa.service.PessoaEstrangeiraService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pessoa_estrangeira")
@Auditar
public class PessoaEstrangeiraRESTService {
    @Inject
    private PessoaEstrangeiraService service;

    public PessoaEstrangeiraRESTService() {
    }

    @GET
    @Produces({"application/json"})
    @Path("/consultar/{nrIdentificacao}")
    public Response retornarPessoaEstrangeira(@PathParam("nrIdentificacao") String nrIdentificacao, @Context HttpServletRequest request) {
        PessoaEstrangeira pessoa = this.service.getPessoaEstrangeiraPorNrIdentificacao(nrIdentificacao);
        return pessoa == null ? Response.status(Status.NO_CONTENT).build() : Response.ok(this.getReturnFields(pessoa)).build();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/cadastrar")
    public Response inserirPessoaEstrangeira(PessoaEstrangeira pessoaEstrangeira, @Context HttpServletRequest request) {
        try {
            return Response.ok(this.getReturnFields(this.service.create(pessoaEstrangeira))).build();
        } catch (Exception var4) {
            var4.printStackTrace();
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/atualizar")
    public Response atualizarPessoaEstrangeira(PessoaEstrangeira pessoaEstrangeira, @Context HttpServletRequest request) {
        String nrIdentificacao = pessoaEstrangeira.getNrIdentificacao();
        PessoaEstrangeira pessoaEstrangeiraAtual = this.service.getPessoaEstrangeiraPorNrIdentificacao(nrIdentificacao);
        if (pessoaEstrangeiraAtual != null) {
            if (!this.isAlteracoesValidas(pessoaEstrangeiraAtual, pessoaEstrangeira)) {
                return Response.status(Status.BAD_REQUEST).build();
            } else {
                try {
                    return Response.ok(this.getReturnFields(this.service.update(pessoaEstrangeiraAtual))).build();
                } catch (Exception var6) {
                    return Response.status(Status.NOT_MODIFIED).build();
                }
            }
        } else {
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    private Map<String, Object> getReturnFields(PessoaEstrangeira pe) {
        Map<String, Object> toReturn = new LinkedHashMap(1);
        Map<String, Object> pessoa = new LinkedHashMap(2);
        toReturn.put("pessoa", pessoa);
        Map<String, Object> tipoPessoa = new LinkedHashMap(2);
        if (pe.getPessoa().getTipoPessoa() != null) {
            tipoPessoa.put("cdTipoPessoa", pe.getPessoa().getTipoPessoa().getCdTipoPessoa());
            tipoPessoa.put("dsTipoPessoa", pe.getPessoa().getTipoPessoa().getDsTipoPessoa());
        }

        pessoa.put("tipoPessoa", tipoPessoa);
        Map<String, Object> pais = new LinkedHashMap(2);
        if (pe.getPessoa().getPais() != null) {
            pais.put("sgPais", pe.getPessoa().getPais().getSgPais());
            pais.put("nmPais", pe.getPessoa().getPais().getNmPais());
        }

        pessoa.put("pais", pais);
        toReturn.put("nmPessoaEstrangeira", pe.getNmPessoaEstrangeira());
        toReturn.put("nrIdentificacao", pe.getNrIdentificacao());
        toReturn.put("tpIdentificacao", pe.getTpIdentificacao());
        toReturn.put("dsTelefone", pe.getDsTelefone());
        toReturn.put("dsEndereco", pe.getDsEndereco());
        toReturn.put("dsEmail", pe.getDsEmail());
        return toReturn;
    }

    private boolean isAlteracoesValidas(PessoaEstrangeira pessoaEstrangeiraAtual, PessoaEstrangeira pessoaEstrangeira) {
        if (!ValidacaoUtils.isNotEmpty(pessoaEstrangeira.getNmPessoaEstrangeira()) && !ValidacaoUtils.isNotEmpty(pessoaEstrangeira.getTpIdentificacao()) && !ValidacaoUtils.isNotEmpty(pessoaEstrangeira.getPessoa())) {
            pessoaEstrangeiraAtual.setDsEmail(pessoaEstrangeira.getDsEmail());
            pessoaEstrangeiraAtual.setDsEndereco(pessoaEstrangeira.getDsEndereco());
            pessoaEstrangeiraAtual.setDsTelefone(pessoaEstrangeira.getDsTelefone());
            return true;
        } else {
            return false;
        }
    }
}
