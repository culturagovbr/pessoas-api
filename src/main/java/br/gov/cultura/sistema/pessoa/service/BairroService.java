package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Agencia;
import br.gov.cultura.sistema.model.corporativo.Bairro;
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
public class BairroService {
    @Inject
    private GenericCrudService genericCrudService;

    public BairroService() {
    }

    public Bairro create(Bairro bairro) {
        bairro.setIdBairro(0);
        return (Bairro)this.genericCrudService.create(bairro);
    }

    public List<Bairro> findByIdMunicipio(Integer idMunicipio) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("idMunicipio", idMunicipio);
        List<Bairro> BairroList = this.genericCrudService.findWithNamedQuery("Bairro.findByIdMunicipio", paramMap);
        return BairroList;
    }

    public boolean exists(int idBairro) {
        return this.genericCrudService.exists(Agencia.class, idBairro);
    }

    public Bairro find(int idBairro) {
        return (Bairro)this.genericCrudService.find(Bairro.class, idBairro);
    }

    public Bairro update(Bairro bairro) {
        return (Bairro)this.genericCrudService.update(bairro);
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
