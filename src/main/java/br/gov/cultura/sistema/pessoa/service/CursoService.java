package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Curso;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CursoService {
    @Inject
    private GenericCrudService genericCrudService;

    public CursoService() {
    }

    public Curso create(Curso curso) {
        curso.setIdCurso(0);
        return (Curso)this.genericCrudService.create(curso);
    }

    public List<Curso> findAll() {
        return this.genericCrudService.findAll(Curso.class);
    }

    public Curso find(int idCurso) {
        return (Curso)this.genericCrudService.find(Curso.class, idCurso);
    }

    public boolean exists(int idCurso) {
        return this.genericCrudService.exists(Curso.class, idCurso);
    }

    public Curso update(Curso curso) {
        return (Curso)this.genericCrudService.update(curso);
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
