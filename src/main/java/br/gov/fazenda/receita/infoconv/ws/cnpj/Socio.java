package br.gov.fazenda.receita.infoconv.ws.cnpj;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Socio implements Serializable {
    private String tipo;
    private String nome;
    private String numero;
    private String percentualParticipacao;
    private String codigoPaisOrigem;
    private String nomePaisOrigem;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;
    private static TypeDesc typeDesc = new TypeDesc(Socio.class, true);

    static {
        typeDesc.setXmlType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "Socio"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "Tipo"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "Nome"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "Numero"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("percentualParticipacao");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "PercentualParticipacao"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codigoPaisOrigem");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "CodigoPaisOrigem"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomePaisOrigem");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "NomePaisOrigem"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    public Socio() {
    }

    public Socio(String tipo, String nome, String numero, String percentualParticipacao, String codigoPaisOrigem, String nomePaisOrigem) {
        this.tipo = tipo;
        this.nome = nome;
        this.numero = numero;
        this.percentualParticipacao = percentualParticipacao;
        this.codigoPaisOrigem = codigoPaisOrigem;
        this.nomePaisOrigem = nomePaisOrigem;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPercentualParticipacao() {
        return this.percentualParticipacao;
    }

    public void setPercentualParticipacao(String percentualParticipacao) {
        this.percentualParticipacao = percentualParticipacao;
    }

    public String getCodigoPaisOrigem() {
        return this.codigoPaisOrigem;
    }

    public void setCodigoPaisOrigem(String codigoPaisOrigem) {
        this.codigoPaisOrigem = codigoPaisOrigem;
    }

    public String getNomePaisOrigem() {
        return this.nomePaisOrigem;
    }

    public void setNomePaisOrigem(String nomePaisOrigem) {
        this.nomePaisOrigem = nomePaisOrigem;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Socio)) {
            return false;
        } else {
            Socio other = (Socio)obj;
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.__equalsCalc != null) {
                return this.__equalsCalc == obj;
            } else {
                this.__equalsCalc = obj;
                boolean _equals = (this.tipo == null && other.getTipo() == null || this.tipo != null && this.tipo.equals(other.getTipo())) && (this.nome == null && other.getNome() == null || this.nome != null && this.nome.equals(other.getNome())) && (this.numero == null && other.getNumero() == null || this.numero != null && this.numero.equals(other.getNumero())) && (this.percentualParticipacao == null && other.getPercentualParticipacao() == null || this.percentualParticipacao != null && this.percentualParticipacao.equals(other.getPercentualParticipacao())) && (this.codigoPaisOrigem == null && other.getCodigoPaisOrigem() == null || this.codigoPaisOrigem != null && this.codigoPaisOrigem.equals(other.getCodigoPaisOrigem())) && (this.nomePaisOrigem == null && other.getNomePaisOrigem() == null || this.nomePaisOrigem != null && this.nomePaisOrigem.equals(other.getNomePaisOrigem()));
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
            if (this.getTipo() != null) {
                _hashCode += this.getTipo().hashCode();
            }

            if (this.getNome() != null) {
                _hashCode += this.getNome().hashCode();
            }

            if (this.getNumero() != null) {
                _hashCode += this.getNumero().hashCode();
            }

            if (this.getPercentualParticipacao() != null) {
                _hashCode += this.getPercentualParticipacao().hashCode();
            }

            if (this.getCodigoPaisOrigem() != null) {
                _hashCode += this.getCodigoPaisOrigem().hashCode();
            }

            if (this.getNomePaisOrigem() != null) {
                _hashCode += this.getNomePaisOrigem().hashCode();
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
