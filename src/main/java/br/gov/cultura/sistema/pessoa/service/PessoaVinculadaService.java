package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.PessoaVinculada;
import br.gov.cultura.sistema.model.corporativo.PessoaVinculadaPK;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class PessoaVinculadaService {
    @Inject
    private GenericCrudService genericCrudService;

    public PessoaVinculadaService() {
    }

    public PessoaVinculada create(PessoaVinculada pessoaVinculada) throws NegocioException {
        try {
            pessoaVinculada.setStPessoaVinculada("A");
            return (PessoaVinculada)this.genericCrudService.create(pessoaVinculada);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public PessoaVinculada find(PessoaVinculadaPK id) {
        return (PessoaVinculada)this.genericCrudService.find(PessoaVinculada.class, id);
    }

    public boolean exists(PessoaVinculadaPK id) {
        return this.genericCrudService.exists(PessoaVinculada.class, id);
    }

    public PessoaVinculada update(PessoaVinculadaPK oldId, PessoaVinculada curso) throws NegocioException {
        try {
            StringBuilder jpql = (new StringBuilder(236)).append("UPDATE PessoaVinculada SET ").append("id.idPessoa = :idPessoa, ").append("id.idPessoaVinculada = :idPessoaVinculada, ").append("id.idTipoVinculoPessoa = :idTipoVinculoPessoa, ").append("dtInicio = :dtInicio, ").append("dtFim = :dtFim, ").append("stPessoaVinculada = :stPessoaVinculada ").append("WHERE id = :oldId");
            EntityManager em = this.genericCrudService.getEntityManager();
            Query q = em.createQuery(jpql.toString());
            q.setParameter("idPessoa", curso.getId().getIdPessoa());
            q.setParameter("idPessoaVinculada", curso.getId().getIdPessoaVinculada());
            q.setParameter("idTipoVinculoPessoa", curso.getId().getIdTipoVinculoPessoa());
            q.setParameter("dtInicio", curso.getDtInicio());
            q.setParameter("dtFim", curso.getDtFim());
            q.setParameter("stPessoaVinculada", curso.getStPessoaVinculada());
            q.setParameter("oldId", oldId);
            q.executeUpdate();
            return this.find(curso.getId());
        } catch (Exception var6) {
            if (ValidacaoUtils.isErroDeConstraint(var6)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var6;
            }
        }
    }

    public void delete(PessoaVinculadaPK id) throws NegocioException {
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
