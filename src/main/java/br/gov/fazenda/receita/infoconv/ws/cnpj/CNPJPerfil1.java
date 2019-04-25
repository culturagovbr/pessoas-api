package br.gov.fazenda.receita.infoconv.ws.cnpj;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class CNPJPerfil1 implements Serializable {
    private String CNPJ;
    private String estabelecimento;
    private String nomeEmpresarial;
    private String nomeFantasia;
    private String situacaoCadastral;
    private String cidadeExterior;
    private String codigoPais;
    private String nomePais;
    private String erro;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;
    private static TypeDesc typeDesc = new TypeDesc(CNPJPerfil1.class, true);

    static {
        typeDesc.setXmlType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "CNPJPerfil1"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("CNPJ");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "CNPJ"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("estabelecimento");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "Estabelecimento"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeEmpresarial");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "NomeEmpresarial"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeFantasia");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "NomeFantasia"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("situacaoCadastral");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "SituacaoCadastral"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("cidadeExterior");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "CidadeExterior"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codigoPais");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "CodigoPais"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomePais");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "NomePais"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("erro");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "Erro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    public CNPJPerfil1() {
    }

    public CNPJPerfil1(String CNPJ, String estabelecimento, String nomeEmpresarial, String nomeFantasia, String situacaoCadastral, String cidadeExterior, String codigoPais, String nomePais, String erro) {
        this.CNPJ = CNPJ;
        this.estabelecimento = estabelecimento;
        this.nomeEmpresarial = nomeEmpresarial;
        this.nomeFantasia = nomeFantasia;
        this.situacaoCadastral = situacaoCadastral;
        this.cidadeExterior = cidadeExterior;
        this.codigoPais = codigoPais;
        this.nomePais = nomePais;
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

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CNPJPerfil1)) {
            return false;
        } else {
            CNPJPerfil1 other = (CNPJPerfil1)obj;
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.__equalsCalc != null) {
                return this.__equalsCalc == obj;
            } else {
                this.__equalsCalc = obj;
                boolean _equals = (this.CNPJ == null && other.getCNPJ() == null || this.CNPJ != null && this.CNPJ.equals(other.getCNPJ())) && (this.estabelecimento == null && other.getEstabelecimento() == null || this.estabelecimento != null && this.estabelecimento.equals(other.getEstabelecimento())) && (this.nomeEmpresarial == null && other.getNomeEmpresarial() == null || this.nomeEmpresarial != null && this.nomeEmpresarial.equals(other.getNomeEmpresarial())) && (this.nomeFantasia == null && other.getNomeFantasia() == null || this.nomeFantasia != null && this.nomeFantasia.equals(other.getNomeFantasia())) && (this.situacaoCadastral == null && other.getSituacaoCadastral() == null || this.situacaoCadastral != null && this.situacaoCadastral.equals(other.getSituacaoCadastral())) && (this.cidadeExterior == null && other.getCidadeExterior() == null || this.cidadeExterior != null && this.cidadeExterior.equals(other.getCidadeExterior())) && (this.codigoPais == null && other.getCodigoPais() == null || this.codigoPais != null && this.codigoPais.equals(other.getCodigoPais())) && (this.nomePais == null && other.getNomePais() == null || this.nomePais != null && this.nomePais.equals(other.getNomePais())) && (this.erro == null && other.getErro() == null || this.erro != null && this.erro.equals(other.getErro()));
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

            if (this.getCidadeExterior() != null) {
                _hashCode += this.getCidadeExterior().hashCode();
            }

            if (this.getCodigoPais() != null) {
                _hashCode += this.getCodigoPais().hashCode();
            }

            if (this.getNomePais() != null) {
                _hashCode += this.getNomePais().hashCode();
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
