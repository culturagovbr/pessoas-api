package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.IdiomaPessoa;
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
public class IdiomaPessoaService {
    @Inject
    private GenericCrudService genericCrudService;

    public IdiomaPessoaService() {
    }

    public IdiomaPessoa create(IdiomaPessoa idiomaPessoa) throws NegocioException {
        try {
            idiomaPessoa.setIdIdiomaPessoa(0);
            return (IdiomaPessoa)this.genericCrudService.create(idiomaPessoa);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public IdiomaPessoa find(int idIdiomaPessoa) {
        return (IdiomaPessoa)this.genericCrudService.find(IdiomaPessoa.class, idIdiomaPessoa);
    }

    public boolean exists(int idIdiomaPessoa) {
        return this.genericCrudService.exists(IdiomaPessoa.class, idIdiomaPessoa);
    }

    public List<IdiomaPessoa> findByCpf(String cpf) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("nrCpf", cpf);
        List<IdiomaPessoa> idiomaList = this.genericCrudService.findWithNamedQuery("IdiomaPessoa.findByCpf", paramMap);
        return idiomaList;
    }

    public IdiomaPessoa update(IdiomaPessoa idiomaPessoa) throws NegocioException {
        try {
            return (IdiomaPessoa)this.genericCrudService.update(idiomaPessoa);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
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
