package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Cnae;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CnaeService {
    @Inject
    private GenericCrudService genericCrudService;

    public CnaeService() {
    }

    public Cnae pesquisarPorCodigo(String codigoCnae) throws NegocioException {
        Cnae cnae = null;

        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put("cdCnae", codigoCnae);
            String jpql = "SELECT c FROM Cnae c WHERE REPLACE(REPLACE(REPLACE(c.cdCnae,'-',''),'.',''),'/','') = :cdCnae";
            List<Cnae> cnaeList = this.genericCrudService.findWithQuery(Cnae.class, jpql, parameters);
            if (cnaeList.size() == 1) {
                cnae = (Cnae)cnaeList.get(0);
            } else if (cnaeList.size() > 1) {
                throw new NegocioException("Não foi possível identificar o CNAE da Empresa, dado ambíguo | " + codigoCnae);
            }
        } catch (NegocioException var6) {
            throw var6;
        } catch (Exception var7) {
            ;
        }

        return cnae;
    }
}
