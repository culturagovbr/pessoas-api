package br.gov.fazenda.receita.infoconv.ws.cpf;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class PessoaPerfil1 implements Serializable {
    private String CPF;
    private String nome;
    private String situacaoCadastral;
    private String residenteExterior;
    private String nomeMae;
    private String dataAtualizacao;
    private String erro;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;
    private static TypeDesc typeDesc = new TypeDesc(PessoaPerfil1.class, true);

    static {
        typeDesc.setXmlType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "PessoaPerfil1"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("CPF");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "CPF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "Nome"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("situacaoCadastral");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "SituacaoCadastral"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("residenteExterior");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "ResidenteExterior"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeMae");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "NomeMae"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataAtualizacao");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "DataAtualizacao"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("erro");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cpf/", "Erro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    public PessoaPerfil1() {
    }

    public PessoaPerfil1(String CPF, String nome, String situacaoCadastral, String residenteExterior, String nomeMae, String dataAtualizacao, String erro) {
        this.CPF = CPF;
        this.nome = nome;
        this.situacaoCadastral = situacaoCadastral;
        this.residenteExterior = residenteExterior;
        this.nomeMae = nomeMae;
        this.dataAtualizacao = dataAtualizacao;
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

    public String getNomeMae() {
        return this.nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PessoaPerfil1)) {
            return false;
        } else {
            PessoaPerfil1 other = (PessoaPerfil1)obj;
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.__equalsCalc != null) {
                return this.__equalsCalc == obj;
            } else {
                this.__equalsCalc = obj;
                boolean _equals = (this.CPF == null && other.getCPF() == null || this.CPF != null && this.CPF.equals(other.getCPF())) && (this.nome == null && other.getNome() == null || this.nome != null && this.nome.equals(other.getNome())) && (this.situacaoCadastral == null && other.getSituacaoCadastral() == null || this.situacaoCadastral != null && this.situacaoCadastral.equals(other.getSituacaoCadastral())) && (this.residenteExterior == null && other.getResidenteExterior() == null || this.residenteExterior != null && this.residenteExterior.equals(other.getResidenteExterior())) && (this.nomeMae == null && other.getNomeMae() == null || this.nomeMae != null && this.nomeMae.equals(other.getNomeMae())) && (this.dataAtualizacao == null && other.getDataAtualizacao() == null || this.dataAtualizacao != null && this.dataAtualizacao.equals(other.getDataAtualizacao())) && (this.erro == null && other.getErro() == null || this.erro != null && this.erro.equals(other.getErro()));
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

            if (this.getNomeMae() != null) {
                _hashCode += this.getNomeMae().hashCode();
            }

            if (this.getDataAtualizacao() != null) {
                _hashCode += this.getDataAtualizacao().hashCode();
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
