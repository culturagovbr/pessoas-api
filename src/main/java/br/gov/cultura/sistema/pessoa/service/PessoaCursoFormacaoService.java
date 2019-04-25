package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.PessoaCursoFormacao;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaCursoFormacaoService {
    @PersistenceContext(
            unitName = "primary"
    )
    private EntityManager em;
    @Inject
    private GenericCrudService genericCrudService;

    public PessoaCursoFormacaoService() {
    }

    public PessoaCursoFormacao create(PessoaCursoFormacao cursoFormacaoPessoa) throws NegocioException {
        try {
            cursoFormacaoPessoa.setIdPessoaCursoFormacao(0);
            return (PessoaCursoFormacao)this.genericCrudService.create(cursoFormacaoPessoa);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public PessoaCursoFormacao find(int id) {
        return (PessoaCursoFormacao)this.genericCrudService.find(PessoaCursoFormacao.class, id);
    }

    public boolean exists(int id) {
        return this.genericCrudService.exists(PessoaCursoFormacao.class, id);
    }

    public PessoaCursoFormacao update(PessoaCursoFormacao formacaoPessoa) throws NegocioException {
        try {
            return (PessoaCursoFormacao)this.genericCrudService.update(formacaoPessoa);
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
