package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.CursoArea;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CursoAreaService {
    @Inject
    private GenericCrudService genericCrudService;

    public CursoAreaService() {
    }

    public CursoArea create(CursoArea areaCurso) {
        areaCurso.setIdCursoArea(0);
        return (CursoArea)this.genericCrudService.create(areaCurso);
    }

    public List<CursoArea> findAll() {
        return this.genericCrudService.findAll(CursoArea.class);
    }

    public CursoArea find(int idCursoArea) {
        return (CursoArea)this.genericCrudService.find(CursoArea.class, idCursoArea);
    }

    public boolean exists(int idCursoArea) {
        return this.genericCrudService.exists(CursoArea.class, idCursoArea);
    }

    public CursoArea update(CursoArea areaCurso) {
        return (CursoArea)this.genericCrudService.update(areaCurso);
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
