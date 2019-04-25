package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.CaracteristicaFisica;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CaracteristicaFisicaService {
    @Inject
    private GenericCrudService genericCrudService;

    public CaracteristicaFisicaService() {
    }

    public CaracteristicaFisica create(CaracteristicaFisica cf) throws NegocioException {
        try {
            return (CaracteristicaFisica)this.genericCrudService.create(cf);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public CaracteristicaFisica find(int idCaracteristicaFisica) {
        return (CaracteristicaFisica)this.genericCrudService.find(CaracteristicaFisica.class, idCaracteristicaFisica);
    }

    public boolean exists(int idCaracteristicaFisica) {
        return this.genericCrudService.exists(CaracteristicaFisica.class, idCaracteristicaFisica);
    }

    public CaracteristicaFisica update(CaracteristicaFisica cf) throws NegocioException {
        try {
            return (CaracteristicaFisica)this.genericCrudService.update(cf);
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
