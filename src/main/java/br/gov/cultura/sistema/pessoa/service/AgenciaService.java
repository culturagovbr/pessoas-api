package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Agencia;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
public class AgenciaService {
    @Inject
    private GenericCrudService genericCrudService;

    public AgenciaService() {
    }

    public Agencia create(Agencia agencia) throws NegocioException {
        try {
            agencia.setIdAgencia(0);
            return (Agencia)this.genericCrudService.create(agencia);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public boolean exists(int idAgencia) {
        return this.genericCrudService.exists(Agencia.class, idAgencia);
    }

    public Agencia find(int idAgencia) {
        return (Agencia)this.genericCrudService.find(Agencia.class, idAgencia);
    }

    public List<Agencia> findByNrBanco(String nrBanco) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("nrBanco", nrBanco);
        return this.genericCrudService.findWithNamedQuery("Agencia.findByNrBanco", paramMap);
    }

    public Agencia update(Agencia agencia) throws NegocioException {
        Agencia ag = null;

        try {
            ag = (Agencia)this.genericCrudService.update(agencia);
            this.genericCrudService.getEntityManager().flush();
            return ag;
        } catch (Exception var4) {
            if (ValidacaoUtils.isErroDeConstraint(var4)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var4;
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

    public <T> List<T> filter(Map<String, Object> filters, Class<T> clazz) {
        CriteriaBuilder cb = this.genericCrudService.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(clazz);
        Root<T> from = query.from(clazz);
        query.select(from);
        List<Predicate> predicates = new ArrayList();
        Iterator var8 = filters.entrySet().iterator();

        while(var8.hasNext()) {
            Entry<String, Object> filter = (Entry)var8.next();
            Predicate p = cb.equal(from.get((String)filter.getKey()), filter.getValue());
            predicates.add(p);
        }

        Predicate clauses = cb.and((Predicate[])predicates.toArray(new Predicate[predicates.size()]));
        query.where(clauses);
        TypedQuery<T> selectQuery = this.genericCrudService.getEntityManager().createQuery(query);
        return selectQuery.getResultList();
    }
}
