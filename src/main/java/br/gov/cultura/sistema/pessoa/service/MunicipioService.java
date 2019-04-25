package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Municipio;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MunicipioService {
    @Inject
    private GenericCrudService service;

    public MunicipioService() {
    }

    public List<Municipio> findByUf(String siglaUf) {
        Map<String, Object> params = new HashMap(1);
        params.put("sgUf", siglaUf);
        return this.service.findWithNamedQuery("Municipio.findByUf", params);
    }
}
