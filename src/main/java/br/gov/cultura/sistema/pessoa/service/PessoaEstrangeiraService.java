package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.corporativo.PessoaEstrangeira;
import br.gov.cultura.sistema.model.corporativo.TipoAbrangencia;
import br.gov.cultura.sistema.model.corporativo.TipoPessoa;
import br.gov.cultura.sistema.model.enums.corporativo.TipoAbrangenciaEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoPessoaEnum;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PessoaEstrangeiraService {
    @Inject
    private GenericCrudService genericCrudService;

    public PessoaEstrangeiraService() {
    }

    public PessoaEstrangeira find(int id) {
        return (PessoaEstrangeira)this.genericCrudService.find(PessoaEstrangeira.class, id);
    }

    public PessoaEstrangeira create(PessoaEstrangeira pessoaEstrangeira) {
        this.setDadosPadraoPessoaEstrangeira(pessoaEstrangeira);
        pessoaEstrangeira.setPessoa((Pessoa)this.genericCrudService.create(pessoaEstrangeira.getPessoa()));
        pessoaEstrangeira.setIdPessoaEstrangeira(pessoaEstrangeira.getPessoa().getIdPessoa());
        return (PessoaEstrangeira)this.genericCrudService.create(pessoaEstrangeira);
    }

    public PessoaEstrangeira update(PessoaEstrangeira pessoaEstrangeira) {
        this.setDadosPadraoPessoaEstrangeira(pessoaEstrangeira);
        return (PessoaEstrangeira)this.genericCrudService.update(pessoaEstrangeira);
    }

    public PessoaEstrangeira getPessoaEstrangeiraPorNrIdentificacao(String nrIdentificacao) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("nrIdentificacao", nrIdentificacao);
        List<PessoaEstrangeira> list = this.genericCrudService.findWithNamedQuery("PessoaEstrangeira.findByNrIdentificacao", paramMap);
        PessoaEstrangeira pessoa = list.isEmpty() ? null : (PessoaEstrangeira)list.get(0);
        return pessoa;
    }

    private void setDadosPadraoPessoaEstrangeira(PessoaEstrangeira pessoaEstrangeira) {
        Pessoa p = pessoaEstrangeira.getPessoa();
        if (p.getDtRegistro() == null) {
            p.setDtRegistro(new GregorianCalendar());
        }

        TipoAbrangencia ta = new TipoAbrangencia();
        ta.setCdTipoAbrangencia(TipoAbrangenciaEnum.ESTRANGEIRO.getCodigoAsString());
        p.setTipoAbrangencia(ta);
        TipoPessoa tp = new TipoPessoa();
        tp.setCdTipoPessoa(TipoPessoaEnum.ESTRANGEIRA.getCodigoAsString());
        p.setTipoPessoa(tp);
    }
}
