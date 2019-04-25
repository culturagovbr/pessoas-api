package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.CursoFormacao;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CursoFormacaoService {
    @Inject
    private GenericCrudService genericCrudService;

    public CursoFormacaoService() {
    }

    public CursoFormacao create(CursoFormacao cursoFormacao) throws NegocioException {
        try {
            cursoFormacao.setIdCursoFormacao(0);
            return (CursoFormacao)this.genericCrudService.create(cursoFormacao);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public List<CursoFormacao> findAll() {
        return this.genericCrudService.findAll(CursoFormacao.class);
    }

    public CursoFormacao find(int idCursoFormacao) {
        return (CursoFormacao)this.genericCrudService.find(CursoFormacao.class, idCursoFormacao);
    }

    public boolean exists(int idCursoFormacao) {
        return this.genericCrudService.exists(CursoFormacao.class, idCursoFormacao);
    }

    public CursoFormacao update(CursoFormacao cursoFormacao) throws NegocioException {
        try {
            return (CursoFormacao)this.genericCrudService.update(cursoFormacao);
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
