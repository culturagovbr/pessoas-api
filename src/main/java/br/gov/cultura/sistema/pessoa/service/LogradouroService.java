package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Logradouro;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class LogradouroService {
    @Inject
    private GenericCrudService genericCrudService;

    public LogradouroService() {
    }

    public Logradouro create(Logradouro logradouro) {
        logradouro.setIdLogradouro(0);
        return (Logradouro)this.genericCrudService.create(logradouro);
    }

    public List<Logradouro> findAll() {
        return this.genericCrudService.findAll(Logradouro.class);
    }

    public Logradouro find(int idLogradouro) {
        return (Logradouro)this.genericCrudService.find(Logradouro.class, idLogradouro);
    }

    public boolean exists(int idLogradouro) {
        return this.genericCrudService.exists(Logradouro.class, idLogradouro);
    }

    public Logradouro findByCep(String cep) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("nrCep", cep);
        List<Logradouro> logradouroList = this.genericCrudService.findWithNamedQuery("Logradouro.findByCep", paramMap);
        return logradouroList.isEmpty() ? null : (Logradouro)logradouroList.get(0);
    }

    public Logradouro update(Logradouro logradouro) {
        return (Logradouro)this.genericCrudService.update(logradouro);
    }

    public void delete(int id) throws NegocioException {
        try {
            this.genericCrudService.delete(this.find(id));
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDependentes());
            } else {
                throw new NegocioException(var3.getMessage());
            }
        }
    }
}
