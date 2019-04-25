package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.TipoEndereco;
import br.gov.cultura.sistema.model.corporativo.TipoPessoa;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TipoEnderecoService {
    @Inject
    private GenericCrudService service;

    public TipoEnderecoService() {
    }

    public List<TipoEndereco> findAll() {
        return this.service.findAll(TipoEndereco.class);
    }

    public List<TipoEndereco> findByTipoPessoa(String tipoPessoa) {
        Map<String, Object> params = new HashMap(1);
        TipoPessoa tipo = new TipoPessoa();
        tipo.setCdTipoPessoa(tipoPessoa);
        params.put("tipoPessoa", tipo);
        return this.service.findWithNamedQuery("TipoEnderecoEnum.findByTipoPessoa", params);
    }
}
