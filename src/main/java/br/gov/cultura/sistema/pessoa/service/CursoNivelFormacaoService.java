package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.CursoNivelFormacao;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CursoNivelFormacaoService {
    @Inject
    private GenericCrudService genericCrudService;

    public CursoNivelFormacaoService() {
    }

    public CursoNivelFormacao create(CursoNivelFormacao nivelFormacao) {
        nivelFormacao.setIdCursoNivelFormacao(0);
        return (CursoNivelFormacao)this.genericCrudService.create(nivelFormacao);
    }

    public List<CursoNivelFormacao> findAll() {
        return this.genericCrudService.findAll(CursoNivelFormacao.class);
    }

    public CursoNivelFormacao find(int idCursoNivelFormacao) {
        return (CursoNivelFormacao)this.genericCrudService.find(CursoNivelFormacao.class, idCursoNivelFormacao);
    }

    public boolean exists(int idCursoNivelFormacao) {
        return this.genericCrudService.exists(CursoNivelFormacao.class, idCursoNivelFormacao);
    }

    public CursoNivelFormacao update(CursoNivelFormacao nivelFormacao) {
        return (CursoNivelFormacao)this.genericCrudService.update(nivelFormacao);
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
