package br.gov.fazenda.receita.infoconv.ws.cpf;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class PessoaPerfil3 implements Serializable {
    private String CPF;
    private String nome;
    private String situacaoCadastral;
    private String residenteExterior;
    private String codigoPaisExterior;
    private String nomePaisExterior;
    private String nomeMae;
    private String dataNascimento;
    private String sexo;
    private String naturezaOcupacao;
    private String ocupacaoPrincipal;
    private String exercicioOcupacao;
    private String tipoLogradouro;
    private String logradouro;
    private String numeroLogradouro;
    private String complemento;
    private String CEP;
    private String bairro;
    private String codigoMunicipio;
    private String municipio;
    private String UF;
    private String DDD;
    private String telefone;
    private String unidadeAdministrativa;
    private String anoObito;
    private String estrangeiro;
    private String dataAtualizacao;
    private String tituloEleitor;
    private String erro;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;
    private static TypeDesc typeDesc = new TypeDesc(PessoaPerfil3.class, true);

    static {
        typeDesc.setXmlType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil3"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("CPF");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Nome"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("situacaoCadastral");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "SituacaoCadastral"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("residenteExterior");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ResidenteExterior"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codigoPaisExterior");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CodigoPaisExterior"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomePaisExterior");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "NomePaisExterior"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeMae");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "NomeMae"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataNascimento");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "DataNascimento"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("sexo");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Sexo"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("naturezaOcupacao");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "NaturezaOcupacao"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("ocupacaoPrincipal");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "OcupacaoPrincipal"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("exercicioOcupacao");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ExercicioOcupacao"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("tipoLogradouro");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "TipoLogradouro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("logradouro");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Logradouro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("numeroLogradouro");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "NumeroLogradouro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("complemento");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Complemento"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CEP");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CEP"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("bairro");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Bairro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codigoMunicipio");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CodigoMunicipio"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("municipio");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Municipio"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("UF");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "UF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("DDD");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "DDD"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("telefone");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Telefone"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("unidadeAdministrativa");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "UnidadeAdministrativa"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("anoObito");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "AnoObito"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("estrangeiro");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Estrangeiro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataAtualizacao");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "DataAtualizacao"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("tituloEleitor");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "TituloEleitor"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("erro");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "Erro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    public PessoaPerfil3() {
    }

    public PessoaPerfil3(String CPF, String nome, String situacaoCadastral, String residenteExterior, String codigoPaisExterior, String nomePaisExterior, String nomeMae, String dataNascimento, String sexo, String naturezaOcupacao, String ocupacaoPrincipal, String exercicioOcupacao, String tipoLogradouro, String logradouro, String numeroLogradouro, String complemento, String CEP, String bairro, String codigoMunicipio, String municipio, String UF, String DDD, String telefone, String unidadeAdministrativa, String anoObito, String estrangeiro, String dataAtualizacao, String tituloEleitor, String erro) {
        this.CPF = CPF;
        this.nome = nome;
        this.situacaoCadastral = situacaoCadastral;
        this.residenteExterior = residenteExterior;
        this.codigoPaisExterior = codigoPaisExterior;
        this.nomePaisExterior = nomePaisExterior;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.naturezaOcupacao = naturezaOcupacao;
        this.ocupacaoPrincipal = ocupacaoPrincipal;
        this.exercicioOcupacao = exercicioOcupacao;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numeroLogradouro = numeroLogradouro;
        this.complemento = complemento;
        this.CEP = CEP;
        this.bairro = bairro;
        this.codigoMunicipio = codigoMunicipio;
        this.municipio = municipio;
        this.UF = UF;
        this.DDD = DDD;
        this.telefone = telefone;
        this.unidadeAdministrativa = unidadeAdministrativa;
        this.anoObito = anoObito;
        this.estrangeiro = estrangeiro;
        this.dataAtualizacao = dataAtualizacao;
        this.tituloEleitor = tituloEleitor;
        this.erro = erro;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacaoCadastral() {
        return this.situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public String getResidenteExterior() {
        return this.residenteExterior;
    }

    public void setResidenteExterior(String residenteExterior) {
        this.residenteExterior = residenteExterior;
    }

    public String getCodigoPaisExterior() {
        return this.codigoPaisExterior;
    }

    public void setCodigoPaisExterior(String codigoPaisExterior) {
        this.codigoPaisExterior = codigoPaisExterior;
    }

    public String getNomePaisExterior() {
        return this.nomePaisExterior;
    }

    public void setNomePaisExterior(String nomePaisExterior) {
        this.nomePaisExterior = nomePaisExterior;
    }

    public String getNomeMae() {
        return this.nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNaturezaOcupacao() {
        return this.naturezaOcupacao;
    }

    public void setNaturezaOcupacao(String naturezaOcupacao) {
        this.naturezaOcupacao = naturezaOcupacao;
    }

    public String getOcupacaoPrincipal() {
        return this.ocupacaoPrincipal;
    }

    public void setOcupacaoPrincipal(String ocupacaoPrincipal) {
        this.ocupacaoPrincipal = ocupacaoPrincipal;
    }

    public String getExercicioOcupacao() {
        return this.exercicioOcupacao;
    }

    public void setExercicioOcupacao(String exercicioOcupacao) {
        this.exercicioOcupacao = exercicioOcupacao;
    }

    public String getTipoLogradouro() {
        return this.tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroLogradouro() {
        return this.numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return this.CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUF() {
        return this.UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getDDD() {
        return this.DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUnidadeAdministrativa() {
        return this.unidadeAdministrativa;
    }

    public void setUnidadeAdministrativa(String unidadeAdministrativa) {
        this.unidadeAdministrativa = unidadeAdministrativa;
    }

    public String getAnoObito() {
        return this.anoObito;
    }

    public void setAnoObito(String anoObito) {
        this.anoObito = anoObito;
    }

    public String getEstrangeiro() {
        return this.estrangeiro;
    }

    public void setEstrangeiro(String estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    public String getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getTituloEleitor() {
        return this.tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PessoaPerfil3)) {
            return false;
        } else {
            PessoaPerfil3 other = (PessoaPerfil3)obj;
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.__equalsCalc != null) {
                return this.__equalsCalc == obj;
            } else {
                this.__equalsCalc = obj;
                boolean _equals = (this.CPF == null && other.getCPF() == null || this.CPF != null && this.CPF.equals(other.getCPF())) && (this.nome == null && other.getNome() == null || this.nome != null && this.nome.equals(other.getNome())) && (this.situacaoCadastral == null && other.getSituacaoCadastral() == null || this.situacaoCadastral != null && this.situacaoCadastral.equals(other.getSituacaoCadastral())) && (this.residenteExterior == null && other.getResidenteExterior() == null || this.residenteExterior != null && this.residenteExterior.equals(other.getResidenteExterior())) && (this.codigoPaisExterior == null && other.getCodigoPaisExterior() == null || this.codigoPaisExterior != null && this.codigoPaisExterior.equals(other.getCodigoPaisExterior())) && (this.nomePaisExterior == null && other.getNomePaisExterior() == null || this.nomePaisExterior != null && this.nomePaisExterior.equals(other.getNomePaisExterior())) && (this.nomeMae == null && other.getNomeMae() == null || this.nomeMae != null && this.nomeMae.equals(other.getNomeMae())) && (this.dataNascimento == null && other.getDataNascimento() == null || this.dataNascimento != null && this.dataNascimento.equals(other.getDataNascimento())) && (this.sexo == null && other.getSexo() == null || this.sexo != null && this.sexo.equals(other.getSexo())) && (this.naturezaOcupacao == null && other.getNaturezaOcupacao() == null || this.naturezaOcupacao != null && this.naturezaOcupacao.equals(other.getNaturezaOcupacao())) && (this.ocupacaoPrincipal == null && other.getOcupacaoPrincipal() == null || this.ocupacaoPrincipal != null && this.ocupacaoPrincipal.equals(other.getOcupacaoPrincipal())) && (this.exercicioOcupacao == null && other.getExercicioOcupacao() == null || this.exercicioOcupacao != null && this.exercicioOcupacao.equals(other.getExercicioOcupacao())) && (this.tipoLogradouro == null && other.getTipoLogradouro() == null || this.tipoLogradouro != null && this.tipoLogradouro.equals(other.getTipoLogradouro())) && (this.logradouro == null && other.getLogradouro() == null || this.logradouro != null && this.logradouro.equals(other.getLogradouro())) && (this.numeroLogradouro == null && other.getNumeroLogradouro() == null || this.numeroLogradouro != null && this.numeroLogradouro.equals(other.getNumeroLogradouro())) && (this.complemento == null && other.getComplemento() == null || this.complemento != null && this.complemento.equals(other.getComplemento())) && (this.CEP == null && other.getCEP() == null || this.CEP != null && this.CEP.equals(other.getCEP())) && (this.bairro == null && other.getBairro() == null || this.bairro != null && this.bairro.equals(other.getBairro())) && (this.codigoMunicipio == null && other.getCodigoMunicipio() == null || this.codigoMunicipio != null && this.codigoMunicipio.equals(other.getCodigoMunicipio())) && (this.municipio == null && other.getMunicipio() == null || this.municipio != null && this.municipio.equals(other.getMunicipio())) && (this.UF == null && other.getUF() == null || this.UF != null && this.UF.equals(other.getUF())) && (this.DDD == null && other.getDDD() == null || this.DDD != null && this.DDD.equals(other.getDDD())) && (this.telefone == null && other.getTelefone() == null || this.telefone != null && this.telefone.equals(other.getTelefone())) && (this.unidadeAdministrativa == null && other.getUnidadeAdministrativa() == null || this.unidadeAdministrativa != null && this.unidadeAdministrativa.equals(other.getUnidadeAdministrativa())) && (this.anoObito == null && other.getAnoObito() == null || this.anoObito != null && this.anoObito.equals(other.getAnoObito())) && (this.estrangeiro == null && other.getEstrangeiro() == null || this.estrangeiro != null && this.estrangeiro.equals(other.getEstrangeiro())) && (this.dataAtualizacao == null && other.getDataAtualizacao() == null || this.dataAtualizacao != null && this.dataAtualizacao.equals(other.getDataAtualizacao())) && (this.tituloEleitor == null && other.getTituloEleitor() == null || this.tituloEleitor != null && this.tituloEleitor.equals(other.getTituloEleitor())) && (this.erro == null && other.getErro() == null || this.erro != null && this.erro.equals(other.getErro()));
                this.__equalsCalc = null;
                return _equals;
            }
        }
    }

    public synchronized int hashCode() {
        if (this.__hashCodeCalc) {
            return 0;
        } else {
            this.__hashCodeCalc = true;
            int _hashCode = 1;
            if (this.getCPF() != null) {
                _hashCode += this.getCPF().hashCode();
            }

            if (this.getNome() != null) {
                _hashCode += this.getNome().hashCode();
            }

            if (this.getSituacaoCadastral() != null) {
                _hashCode += this.getSituacaoCadastral().hashCode();
            }

            if (this.getResidenteExterior() != null) {
                _hashCode += this.getResidenteExterior().hashCode();
            }

            if (this.getCodigoPaisExterior() != null) {
                _hashCode += this.getCodigoPaisExterior().hashCode();
            }

            if (this.getNomePaisExterior() != null) {
                _hashCode += this.getNomePaisExterior().hashCode();
            }

            if (this.getNomeMae() != null) {
                _hashCode += this.getNomeMae().hashCode();
            }

            if (this.getDataNascimento() != null) {
                _hashCode += this.getDataNascimento().hashCode();
            }

            if (this.getSexo() != null) {
                _hashCode += this.getSexo().hashCode();
            }

            if (this.getNaturezaOcupacao() != null) {
                _hashCode += this.getNaturezaOcupacao().hashCode();
            }

            if (this.getOcupacaoPrincipal() != null) {
                _hashCode += this.getOcupacaoPrincipal().hashCode();
            }

            if (this.getExercicioOcupacao() != null) {
                _hashCode += this.getExercicioOcupacao().hashCode();
            }

            if (this.getTipoLogradouro() != null) {
                _hashCode += this.getTipoLogradouro().hashCode();
            }

            if (this.getLogradouro() != null) {
                _hashCode += this.getLogradouro().hashCode();
            }

            if (this.getNumeroLogradouro() != null) {
                _hashCode += this.getNumeroLogradouro().hashCode();
            }

            if (this.getComplemento() != null) {
                _hashCode += this.getComplemento().hashCode();
            }

            if (this.getCEP() != null) {
                _hashCode += this.getCEP().hashCode();
            }

            if (this.getBairro() != null) {
                _hashCode += this.getBairro().hashCode();
            }

            if (this.getCodigoMunicipio() != null) {
                _hashCode += this.getCodigoMunicipio().hashCode();
            }

            if (this.getMunicipio() != null) {
                _hashCode += this.getMunicipio().hashCode();
            }

            if (this.getUF() != null) {
                _hashCode += this.getUF().hashCode();
            }

            if (this.getDDD() != null) {
                _hashCode += this.getDDD().hashCode();
            }

            if (this.getTelefone() != null) {
                _hashCode += this.getTelefone().hashCode();
            }

            if (this.getUnidadeAdministrativa() != null) {
                _hashCode += this.getUnidadeAdministrativa().hashCode();
            }

            if (this.getAnoObito() != null) {
                _hashCode += this.getAnoObito().hashCode();
            }

            if (this.getEstrangeiro() != null) {
                _hashCode += this.getEstrangeiro().hashCode();
            }

            if (this.getDataAtualizacao() != null) {
                _hashCode += this.getDataAtualizacao().hashCode();
            }

            if (this.getTituloEleitor() != null) {
                _hashCode += this.getTituloEleitor().hashCode();
            }

            if (this.getErro() != null) {
                _hashCode += this.getErro().hashCode();
            }

            this.__hashCodeCalc = false;
            return _hashCode;
        }
    }

    public static TypeDesc getTypeDesc() {
        return typeDesc;
    }

    public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
        return new BeanSerializer(_javaType, _xmlType, typeDesc);
    }

    public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
        return new BeanDeserializer(_javaType, _xmlType, typeDesc);
    }
}
