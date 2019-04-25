package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Email;
import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.enums.BooleanEnum;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmailService {
    @Inject
    private GenericCrudService genericCrudService;

    public EmailService() {
    }

    public Email create(Email email) throws NegocioException {
        this.validarDados(email);
        email.setIdEmail(0);
        return (Email)this.genericCrudService.create(email);
    }

    public Email find(int idEmail) {
        return (Email)this.genericCrudService.find(Email.class, idEmail);
    }

    public boolean exists(int idEmail) {
        return this.genericCrudService.exists(Email.class, idEmail);
    }

    public List<Email> findByCpf(String cpf) {
        try {
            Map<String, Object> paramMap = new HashMap();
            paramMap.put("nrCpf", cpf);
            return this.genericCrudService.findWithNamedQuery("Email.findByCpf", paramMap);
        } catch (Exception var3) {
            return null;
        }
    }

    public List<Email> findByCnpj(String cnpj) {
        try {
            Map<String, Object> paramMap = new HashMap();
            paramMap.put("nrCnpj", cnpj);
            return this.genericCrudService.findWithNamedQuery("Email.findByCnpj", paramMap);
        } catch (Exception var3) {
            return null;
        }
    }

    public Email find(Email Email) {
        try {
            StringBuilder query = (new StringBuilder()).append("SELECT e FROM Email e WHERE e.pessoa.idPessoa = :idPessoa ").append("AND e.tipoEmail.idTipoEmail = :idTipoEmail ").append("AND e.dsEmail = :dsEmail");
            Map<String, Object> parameters = new HashMap();
            parameters.put("idPessoa", Email.getPessoa().getIdPessoa());
            parameters.put("idTipoEmail", Email.getTipoEmail().getIdTipoEmail());
            parameters.put("dsEmail", Email.getDsEmail());
            return (Email)this.genericCrudService.findSingleResult(Email.class, query.toString(), parameters);
        } catch (Exception var4) {
            return null;
        }
    }

    public Email update(Email email) throws NegocioException {
        this.validarDados(email);
        return (Email)this.genericCrudService.update(email);
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

    private void validarDados(Email email) throws NegocioException {
        this.validarEmailPrincipal(email);
    }

    private void validarEmailPrincipal(Email email) throws NegocioException {
        if (BooleanEnum.SIM.getSigla().equalsIgnoreCase(email.getStEmailPrincipal())) {
            Pessoa pessoa = (Pessoa)this.genericCrudService.find(Pessoa.class, email.getIdPessoa());
            Iterator var4 = pessoa.getEmails().iterator();

            while(var4.hasNext()) {
                Email e = (Email)var4.next();
                if (BooleanEnum.SIM.getSigla().equalsIgnoreCase(e.getStEmailPrincipal())) {
                    throw new NegocioException(PessoaUtils.getMsgEmailPrincipal());
                }
            }
        }

    }
}
