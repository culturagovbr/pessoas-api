package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Agencia;
import br.gov.cultura.sistema.model.corporativo.ContaCorrente;
import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.enums.BooleanEnum;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ContaCorrenteService {
    @Inject
    private GenericCrudService genericCrudService;
    @Inject
    private AgenciaService agenciaService;

    public ContaCorrenteService() {
    }

    public ContaCorrente create(ContaCorrente cc) throws NegocioException {
        this.validarDados(cc);
        cc.setIdContaCorrente(0);

        try {
            return (ContaCorrente)this.genericCrudService.create(cc);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public List<ContaCorrente> findAll() {
        return this.genericCrudService.findAll(ContaCorrente.class);
    }

    public ContaCorrente find(int idContaCorrente) {
        return (ContaCorrente)this.genericCrudService.find(ContaCorrente.class, idContaCorrente);
    }

    public boolean exists(int idContaCorrente) {
        return this.genericCrudService.exists(ContaCorrente.class, idContaCorrente);
    }

    public ContaCorrente update(ContaCorrente cc) throws NegocioException {
        this.validarDados(cc);

        try {
            return (ContaCorrente)this.genericCrudService.update(cc);
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

    private void validarDados(ContaCorrente cc) throws NegocioException {
        this.validarAgenciaEBanco(cc);
        this.validarContaCorrentePrincipal(cc);
    }

    private void validarContaCorrentePrincipal(ContaCorrente cc) throws NegocioException {
        if (BooleanEnum.SIM.getSigla().equalsIgnoreCase(cc.getStContaCorrentePrincipal())) {
            Pessoa pessoa = (Pessoa)this.genericCrudService.find(Pessoa.class, cc.getPessoa().getIdPessoa());
            Iterator var4 = pessoa.getContas().iterator();

            while(var4.hasNext()) {
                ContaCorrente contaCorrente = (ContaCorrente)var4.next();
                if (BooleanEnum.SIM.getSigla().equalsIgnoreCase(contaCorrente.getStContaCorrentePrincipal())) {
                    throw new NegocioException(PessoaUtils.getMsgContaCorrentePrincipal());
                }
            }
        }

    }

    private void validarAgenciaEBanco(ContaCorrente cc) throws NegocioException {
        List<Agencia> agencias = this.agenciaService.findByNrBanco(cc.getBanco().getNrBanco());
        Iterator var4 = agencias.iterator();

        while(var4.hasNext()) {
            Agencia agencia = (Agencia)var4.next();
            if (agencia.getIdAgencia() == cc.getAgencia().getIdAgencia()) {
                return;
            }
        }

        throw new NegocioException(PessoaUtils.getMsgAgenciaOutroBanco());
    }
}
