package br.gov.fazenda.receita.infoconv.ws.cpf;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class PessoaPerfil2 implements Serializable {
    private String CPF;
    private String nome;
    private String situacaoCadastral;
    private String residenteExterior;
    private String nomeMae;
    private String dataNascimento;
    private String sexo;
    private String tituloEleitor;
    private String anoObito;
    private String dataAtualizacao;
    private String erro;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;
    private static TypeDesc typeDesc = new TypeDesc(PessoaPerfil2.class, true);

    static {
        typeDesc.setXmlType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil2"));
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
        elemField.setFieldName("tituloEleitor");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "TituloEleitor"));
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
        elemField.setFieldName("dataAtualizacao");
        elemField.setXmlName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "DataAtualizacao"));
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

    public PessoaPerfil2() {
    }

    public PessoaPerfil2(String CPF, String nome, String situacaoCadastral, String residenteExterior, String nomeMae, String dataNascimento, String sexo, String tituloEleitor, String anoObito, String dataAtualizacao, String erro) {
        this.CPF = CPF;
        this.nome = nome;
        this.situacaoCadastral = situacaoCadastral;
        this.residenteExterior = residenteExterior;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tituloEleitor = tituloEleitor;
        this.anoObito = anoObito;
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

    public String getTituloEleitor() {
        return this.tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public String getAnoObito() {
        return this.anoObito;
    }

    public void setAnoObito(String anoObito) {
        this.anoObito = anoObito;
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
        if (!(obj instanceof PessoaPerfil2)) {
            return false;
        } else {
            PessoaPerfil2 other = (PessoaPerfil2)obj;
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.__equalsCalc != null) {
                return this.__equalsCalc == obj;
            } else {
                this.__equalsCalc = obj;
                boolean _equals = (this.CPF == null && other.getCPF() == null || this.CPF != null && this.CPF.equals(other.getCPF())) && (this.nome == null && other.getNome() == null || this.nome != null && this.nome.equals(other.getNome())) && (this.situacaoCadastral == null && other.getSituacaoCadastral() == null || this.situacaoCadastral != null && this.situacaoCadastral.equals(other.getSituacaoCadastral())) && (this.residenteExterior == null && other.getResidenteExterior() == null || this.residenteExterior != null && this.residenteExterior.equals(other.getResidenteExterior())) && (this.nomeMae == null && other.getNomeMae() == null || this.nomeMae != null && this.nomeMae.equals(other.getNomeMae())) && (this.dataNascimento == null && other.getDataNascimento() == null || this.dataNascimento != null && this.dataNascimento.equals(other.getDataNascimento())) && (this.sexo == null && other.getSexo() == null || this.sexo != null && this.sexo.equals(other.getSexo())) && (this.tituloEleitor == null && other.getTituloEleitor() == null || this.tituloEleitor != null && this.tituloEleitor.equals(other.getTituloEleitor())) && (this.anoObito == null && other.getAnoObito() == null || this.anoObito != null && this.anoObito.equals(other.getAnoObito())) && (this.dataAtualizacao == null && other.getDataAtualizacao() == null || this.dataAtualizacao != null && this.dataAtualizacao.equals(other.getDataAtualizacao())) && (this.erro == null && other.getErro() == null || this.erro != null && this.erro.equals(other.getErro()));
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

            if (this.getDataNascimento() != null) {
                _hashCode += this.getDataNascimento().hashCode();
            }

            if (this.getSexo() != null) {
                _hashCode += this.getSexo().hashCode();
            }

            if (this.getTituloEleitor() != null) {
                _hashCode += this.getTituloEleitor().hashCode();
            }

            if (this.getAnoObito() != null) {
                _hashCode += this.getAnoObito().hashCode();
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
