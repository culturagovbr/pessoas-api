package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.DocumentacaoPessoa;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DocumentacaoPessoaService {
    @Inject
    private GenericCrudService genericCrudService;

    public DocumentacaoPessoaService() {
    }

    public DocumentacaoPessoa create(DocumentacaoPessoa dp) throws NegocioException {
        try {
            return (DocumentacaoPessoa)this.genericCrudService.create(dp);
        } catch (Exception var3) {
            if (ValidacaoUtils.isErroDeConstraint(var3)) {
                throw new NegocioException(PessoaUtils.getMsgRegistroDuplicado());
            } else {
                throw var3;
            }
        }
    }

    public DocumentacaoPessoa find(int idDocumentacaoPessoa) {
        return (DocumentacaoPessoa)this.genericCrudService.find(DocumentacaoPessoa.class, idDocumentacaoPessoa);
    }

    public boolean exists(int idDocumentacaoPessoa) {
        return this.genericCrudService.exists(DocumentacaoPessoa.class, idDocumentacaoPessoa);
    }

    public DocumentacaoPessoa update(DocumentacaoPessoa dp) throws NegocioException {
        try {
            return (DocumentacaoPessoa)this.genericCrudService.update(dp);
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
