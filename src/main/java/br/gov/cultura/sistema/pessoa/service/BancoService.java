package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Agencia;
import br.gov.cultura.sistema.model.corporativo.Banco;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BancoService {
    @Inject
    private GenericCrudService genericCrudService;

    public BancoService() {
    }

    public Banco create(Banco banco) throws NegocioException {
        try {
            return (Banco)this.genericCrudService.create(banco);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public boolean exists(String nrBanco) {
        return this.genericCrudService.exists(Agencia.class, nrBanco);
    }

    public List<Banco> findAll() {
        return this.genericCrudService.findAll(Banco.class);
    }

    public Banco find(String nrBanco) {
        return (Banco)this.genericCrudService.find(Banco.class, nrBanco);
    }

    public Banco update(Banco banco) throws NegocioException {
        try {
            return (Banco)this.genericCrudService.update(banco);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public void delete(String id) throws NegocioException {
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
