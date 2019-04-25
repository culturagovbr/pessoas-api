package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Endereco;
import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EnderecoService {
    @Inject
    private GenericCrudService genericCrudService;

    public EnderecoService() {
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(0);
        return (Endereco)this.genericCrudService.create(endereco);
    }

    public Endereco find(int idEndereco) {
        return (Endereco)this.genericCrudService.find(Endereco.class, idEndereco);
    }

    public boolean exists(int idEndereco) {
        return this.genericCrudService.exists(Endereco.class, idEndereco);
    }

    public Servico getServicoDoEndereco(int idEndereco) {
        Servico servico = null;
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("idEndereco", idEndereco);
        String jpql = "SELECT s FROM Endereco e JOIN e.servico s WHERE e.idEndereco = :idEndereco";
        servico = (Servico)this.genericCrudService.findSingleResult(Servico.class, jpql, paramMap);
        return servico;
    }

    public List<Endereco> getEnderecos(Pessoa pessoa, Servico servico) {
        List<Integer> idServicos = new ArrayList(2);
        idServicos.add(PessoaUtils.getIdServicoReceita());
        if (servico != null) {
            idServicos.add(servico.getIdServico());
        }

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("pessoa", pessoa);
        paramMap.put("servicos", idServicos);
        List<Endereco> enderecos = this.genericCrudService.findWithNamedQuery("Endereco.findByPessoaServico", paramMap);
        return enderecos;
    }

    public Endereco find(Endereco endereco) {
        try {
            StringBuilder query = (new StringBuilder()).append("SELECT e FROM Endereco e WHERE e.pessoa.idPessoa = :idPessoa ").append("AND e.tipoEndereco.cdTipoEndereco = :cdTipoEndereco ").append("AND e.logradouro.idLogradouro = :idLogradouro AND e.servico.idServico = :idServico");
            Map<String, Object> parameters = new HashMap();
            parameters.put("idPessoa", endereco.getPessoa().getIdPessoa());
            parameters.put("cdTipoEndereco", endereco.getTipoEndereco().getCdTipoEndereco());
            parameters.put("idLogradouro", endereco.getLogradouro().getIdLogradouro());
            parameters.put("idServico", endereco.getServico().getIdServico());
            return (Endereco)this.genericCrudService.findSingleResult(Endereco.class, query.toString(), parameters);
        } catch (Exception var4) {
            return null;
        }
    }

    public Endereco update(Endereco endereco) {
        return (Endereco)this.genericCrudService.update(endereco);
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
