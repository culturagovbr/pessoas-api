package br.gov.fazenda.receita.infoconv.ws.cnpj;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class CNPJPerfil2 implements Serializable {
    private String CNPJ;
    private String estabelecimento;
    private String nomeEmpresarial;
    private String nomeFantasia;
    private String situacaoCadastral;
    private String dataSituacaoCadastral;
    private String cidadeExterior;
    private String codigoPais;
    private String nomePais;
    private String naturezaJuridica;
    private String dataAbertura;
    private String CNAEPrincipal;
    private String[] CNAESecundario;
    private String tipoLogradouro;
    private String logradouro;
    private String numeroLogradouro;
    private String complemento;
    private String bairro;
    private String CEP;
    private String UF;
    private String codigoMunicipio;
    private String nomeMunicipio;
    private String DDD1;
    private String telefone1;
    private String DDD2;
    private String telefone2;
    private String email;
    private String erro;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;
    private static TypeDesc typeDesc = new TypeDesc(CNPJPerfil2.class, true);

    static {
        typeDesc.setXmlType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil2"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("CNPJ");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJ"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("estabelecimento");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Estabelecimento"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeEmpresarial");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NomeEmpresarial"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeFantasia");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NomeFantasia"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("situacaoCadastral");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "SituacaoCadastral"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataSituacaoCadastral");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "DataSituacaoCadastral"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("cidadeExterior");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CidadeExterior"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codigoPais");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CodigoPais"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomePais");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NomePais"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("naturezaJuridica");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NaturezaJuridica"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataAbertura");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "DataAbertura"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CNAEPrincipal");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNAEPrincipal"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CNAESecundario");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNAESecundario"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("tipoLogradouro");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "TipoLogradouro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("logradouro");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Logradouro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("numeroLogradouro");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NumeroLogradouro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("complemento");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Complemento"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("bairro");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Bairro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CEP");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CEP"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("UF");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "UF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codigoMunicipio");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CodigoMunicipio"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeMunicipio");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NomeMunicipio"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("DDD1");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "DDD1"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("telefone1");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Telefone1"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("DDD2");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "DDD2"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("telefone2");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Telefone2"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Email"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("erro");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Erro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    public CNPJPerfil2() {
    }

    public CNPJPerfil2(String CNPJ, String estabelecimento, String nomeEmpresarial, String nomeFantasia, String situacaoCadastral, String dataSituacaoCadastral, String cidadeExterior, String codigoPais, String nomePais, String naturezaJuridica, String dataAbertura, String CNAEPrincipal, String[] CNAESecundario, String tipoLogradouro, String logradouro, String numeroLogradouro, String complemento, String bairro, String CEP, String UF, String codigoMunicipio, String nomeMunicipio, String DDD1, String telefone1, String DDD2, String telefone2, String email, String erro) {
        this.CNPJ = CNPJ;
        this.estabelecimento = estabelecimento;
        this.nomeEmpresarial = nomeEmpresarial;
        this.nomeFantasia = nomeFantasia;
        this.situacaoCadastral = situacaoCadastral;
        this.dataSituacaoCadastral = dataSituacaoCadastral;
        this.cidadeExterior = cidadeExterior;
        this.codigoPais = codigoPais;
        this.nomePais = nomePais;
        this.naturezaJuridica = naturezaJuridica;
        this.dataAbertura = dataAbertura;
        this.CNAEPrincipal = CNAEPrincipal;
        this.CNAESecundario = CNAESecundario;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numeroLogradouro = numeroLogradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.CEP = CEP;
        this.UF = UF;
        this.codigoMunicipio = codigoMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.DDD1 = DDD1;
        this.telefone1 = telefone1;
        this.DDD2 = DDD2;
        this.telefone2 = telefone2;
        this.email = email;
        this.erro = erro;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEstabelecimento() {
        return this.estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getNomeEmpresarial() {
        return this.nomeEmpresarial;
    }

    public void setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getSituacaoCadastral() {
        return this.situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public String getDataSituacaoCadastral() {
        return this.dataSituacaoCadastral;
    }

    public void setDataSituacaoCadastral(String dataSituacaoCadastral) {
        this.dataSituacaoCadastral = dataSituacaoCadastral;
    }

    public String getCidadeExterior() {
        return this.cidadeExterior;
    }

    public void setCidadeExterior(String cidadeExterior) {
        this.cidadeExterior = cidadeExterior;
    }

    public String getCodigoPais() {
        return this.codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNomePais() {
        return this.nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getNaturezaJuridica() {
        return this.naturezaJuridica;
    }

    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    public String getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getCNAEPrincipal() {
        return this.CNAEPrincipal;
    }

    public void setCNAEPrincipal(String CNAEPrincipal) {
        this.CNAEPrincipal = CNAEPrincipal;
    }

    public String[] getCNAESecundario() {
        return this.CNAESecundario;
    }

    public void setCNAESecundario(String[] CNAESecundario) {
        this.CNAESecundario = CNAESecundario;
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

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCEP() {
        return this.CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getUF() {
        return this.UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNomeMunicipio() {
        return this.nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getDDD1() {
        return this.DDD1;
    }

    public void setDDD1(String DDD1) {
        this.DDD1 = DDD1;
    }

    public String getTelefone1() {
        return this.telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getDDD2() {
        return this.DDD2;
    }

    public void setDDD2(String DDD2) {
        this.DDD2 = DDD2;
    }

    public String getTelefone2() {
        return this.telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CNPJPerfil2)) {
            return false;
        } else {
            CNPJPerfil2 other = (CNPJPerfil2)obj;
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.__equalsCalc != null) {
                return this.__equalsCalc == obj;
            } else {
                this.__equalsCalc = obj;
                boolean _equals = (this.CNPJ == null && other.getCNPJ() == null || this.CNPJ != null && this.CNPJ.equals(other.getCNPJ())) && (this.estabelecimento == null && other.getEstabelecimento() == null || this.estabelecimento != null && this.estabelecimento.equals(other.getEstabelecimento())) && (this.nomeEmpresarial == null && other.getNomeEmpresarial() == null || this.nomeEmpresarial != null && this.nomeEmpresarial.equals(other.getNomeEmpresarial())) && (this.nomeFantasia == null && other.getNomeFantasia() == null || this.nomeFantasia != null && this.nomeFantasia.equals(other.getNomeFantasia())) && (this.situacaoCadastral == null && other.getSituacaoCadastral() == null || this.situacaoCadastral != null && this.situacaoCadastral.equals(other.getSituacaoCadastral())) && (this.dataSituacaoCadastral == null && other.getDataSituacaoCadastral() == null || this.dataSituacaoCadastral != null && this.dataSituacaoCadastral.equals(other.getDataSituacaoCadastral())) && (this.cidadeExterior == null && other.getCidadeExterior() == null || this.cidadeExterior != null && this.cidadeExterior.equals(other.getCidadeExterior())) && (this.codigoPais == null && other.getCodigoPais() == null || this.codigoPais != null && this.codigoPais.equals(other.getCodigoPais())) && (this.nomePais == null && other.getNomePais() == null || this.nomePais != null && this.nomePais.equals(other.getNomePais())) && (this.naturezaJuridica == null && other.getNaturezaJuridica() == null || this.naturezaJuridica != null && this.naturezaJuridica.equals(other.getNaturezaJuridica())) && (this.dataAbertura == null && other.getDataAbertura() == null || this.dataAbertura != null && this.dataAbertura.equals(other.getDataAbertura())) && (this.CNAEPrincipal == null && other.getCNAEPrincipal() == null || this.CNAEPrincipal != null && this.CNAEPrincipal.equals(other.getCNAEPrincipal())) && (this.CNAESecundario == null && other.getCNAESecundario() == null || this.CNAESecundario != null && Arrays.equals(this.CNAESecundario, other.getCNAESecundario())) && (this.tipoLogradouro == null && other.getTipoLogradouro() == null || this.tipoLogradouro != null && this.tipoLogradouro.equals(other.getTipoLogradouro())) && (this.logradouro == null && other.getLogradouro() == null || this.logradouro != null && this.logradouro.equals(other.getLogradouro())) && (this.numeroLogradouro == null && other.getNumeroLogradouro() == null || this.numeroLogradouro != null && this.numeroLogradouro.equals(other.getNumeroLogradouro())) && (this.complemento == null && other.getComplemento() == null || this.complemento != null && this.complemento.equals(other.getComplemento())) && (this.bairro == null && other.getBairro() == null || this.bairro != null && this.bairro.equals(other.getBairro())) && (this.CEP == null && other.getCEP() == null || this.CEP != null && this.CEP.equals(other.getCEP())) && (this.UF == null && other.getUF() == null || this.UF != null && this.UF.equals(other.getUF())) && (this.codigoMunicipio == null && other.getCodigoMunicipio() == null || this.codigoMunicipio != null && this.codigoMunicipio.equals(other.getCodigoMunicipio())) && (this.nomeMunicipio == null && other.getNomeMunicipio() == null || this.nomeMunicipio != null && this.nomeMunicipio.equals(other.getNomeMunicipio())) && (this.DDD1 == null && other.getDDD1() == null || this.DDD1 != null && this.DDD1.equals(other.getDDD1())) && (this.telefone1 == null && other.getTelefone1() == null || this.telefone1 != null && this.telefone1.equals(other.getTelefone1())) && (this.DDD2 == null && other.getDDD2() == null || this.DDD2 != null && this.DDD2.equals(other.getDDD2())) && (this.telefone2 == null && other.getTelefone2() == null || this.telefone2 != null && this.telefone2.equals(other.getTelefone2())) && (this.email == null && other.getEmail() == null || this.email != null && this.email.equals(other.getEmail())) && (this.erro == null && other.getErro() == null || this.erro != null && this.erro.equals(other.getErro()));
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
            if (this.getCNPJ() != null) {
                _hashCode += this.getCNPJ().hashCode();
            }

            if (this.getEstabelecimento() != null) {
                _hashCode += this.getEstabelecimento().hashCode();
            }

            if (this.getNomeEmpresarial() != null) {
                _hashCode += this.getNomeEmpresarial().hashCode();
            }

            if (this.getNomeFantasia() != null) {
                _hashCode += this.getNomeFantasia().hashCode();
            }

            if (this.getSituacaoCadastral() != null) {
                _hashCode += this.getSituacaoCadastral().hashCode();
            }

            if (this.getDataSituacaoCadastral() != null) {
                _hashCode += this.getDataSituacaoCadastral().hashCode();
            }

            if (this.getCidadeExterior() != null) {
                _hashCode += this.getCidadeExterior().hashCode();
            }

            if (this.getCodigoPais() != null) {
                _hashCode += this.getCodigoPais().hashCode();
            }

            if (this.getNomePais() != null) {
                _hashCode += this.getNomePais().hashCode();
            }

            if (this.getNaturezaJuridica() != null) {
                _hashCode += this.getNaturezaJuridica().hashCode();
            }

            if (this.getDataAbertura() != null) {
                _hashCode += this.getDataAbertura().hashCode();
            }

            if (this.getCNAEPrincipal() != null) {
                _hashCode += this.getCNAEPrincipal().hashCode();
            }

            if (this.getCNAESecundario() != null) {
                for(int i = 0; i < Array.getLength(this.getCNAESecundario()); ++i) {
                    Object obj = Array.get(this.getCNAESecundario(), i);
                    if (obj != null && !obj.getClass().isArray()) {
                        _hashCode += obj.hashCode();
                    }
                }
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

            if (this.getBairro() != null) {
                _hashCode += this.getBairro().hashCode();
            }

            if (this.getCEP() != null) {
                _hashCode += this.getCEP().hashCode();
            }

            if (this.getUF() != null) {
                _hashCode += this.getUF().hashCode();
            }

            if (this.getCodigoMunicipio() != null) {
                _hashCode += this.getCodigoMunicipio().hashCode();
            }

            if (this.getNomeMunicipio() != null) {
                _hashCode += this.getNomeMunicipio().hashCode();
            }

            if (this.getDDD1() != null) {
                _hashCode += this.getDDD1().hashCode();
            }

            if (this.getTelefone1() != null) {
                _hashCode += this.getTelefone1().hashCode();
            }

            if (this.getDDD2() != null) {
                _hashCode += this.getDDD2().hashCode();
            }

            if (this.getTelefone2() != null) {
                _hashCode += this.getTelefone2().hashCode();
            }

            if (this.getEmail() != null) {
                _hashCode += this.getEmail().hashCode();
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
