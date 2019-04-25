package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Telefone;
import br.gov.cultura.sistema.model.enums.corporativo.TipoTelefoneEnum;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TelefoneService {
    @Inject
    private GenericCrudService genericCrudService;

    public TelefoneService() {
    }

    public Telefone create(Telefone telefone) throws NegocioException {
        this.validarDados(telefone);
        telefone.setIdTelefone(0);
        return (Telefone)this.genericCrudService.create(telefone);
    }

    public Telefone find(int idTelefone) {
        return (Telefone)this.genericCrudService.find(Telefone.class, idTelefone);
    }

    public boolean exists(int idTelefone) {
        return this.genericCrudService.exists(Telefone.class, idTelefone);
    }

    public List<Telefone> findByCpf(String cpf) {
        try {
            Map<String, Object> paramMap = new HashMap();
            paramMap.put("nrCpf", cpf);
            return this.genericCrudService.findWithNamedQuery("Telefone.findByCpf", paramMap);
        } catch (Exception var3) {
            return null;
        }
    }

    public List<Telefone> findByCnpj(String cnpj) {
        try {
            Map<String, Object> paramMap = new HashMap();
            paramMap.put("nrCnpj", cnpj);
            return this.genericCrudService.findWithNamedQuery("Telefone.findByCnpj", paramMap);
        } catch (Exception var3) {
            return null;
        }
    }

    public Telefone find(Telefone telefone) {
        try {
            StringBuilder query = (new StringBuilder()).append("SELECT t FROM Telefone t WHERE t.pessoa.idPessoa = :idPessoa ").append("AND t.tipoTelefone.idTipoTelefone = :idTipoTelefone ").append("AND t.ddd.cdDdd = :ddd AND t.nrTelefone = :numero");
            Map<String, Object> parameters = new HashMap();
            parameters.put("idPessoa", telefone.getPessoa().getIdPessoa());
            parameters.put("idTipoTelefone", telefone.getTipoTelefone().getIdTipoTelefone());
            parameters.put("ddd", telefone.getDdd().getCdDdd());
            parameters.put("numero", telefone.getNrTelefone());
            return (Telefone)this.genericCrudService.findSingleResult(Telefone.class, query.toString(), parameters);
        } catch (Exception var4) {
            return null;
        }
    }

    public Telefone update(Telefone telefone) throws NegocioException {
        this.validarDados(telefone);
        return (Telefone)this.genericCrudService.update(telefone);
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

    private void validarDados(Telefone telefone) throws NegocioException {
        this.validarTelefoneDaReceitaFederal(telefone);
    }

    public void validarTelefoneDaReceitaFederal(Telefone telefone) throws NegocioException {
        if (TipoTelefoneEnum.RECEITA_FEDERAL.getCodigo() == telefone.getTipoTelefone().getIdTipoTelefone()) {
            throw new NegocioException(PessoaUtils.getMsgTelefoneReceitaFederal());
        }
    }
}
