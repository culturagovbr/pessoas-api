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

public class CNPJPerfil3 implements Serializable {
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
    private String CPFResponsavel;
    private String nomeResponsavel;
    private String capitalSocial;
    private Socio[] sociedade;
    private String tipoCRCContadorPJ;
    private String classificacaoCRCContadorPJ;
    private String numeroCRCContadorPJ;
    private String UFCRCContadorPJ;
    private String CNPJContador;
    private String tipoCRCContadorPF;
    private String classificacaoCRCContadorPF;
    private String numeroCRCContadorPF;
    private String UFCRCContadorPF;
    private String CPFContador;
    private String porte;
    private String opcaoSimples;
    private String dataOpcaoSimples;
    private String dataExclusaoSimples;
    private String CNPJSucedida;
    private String[] CNPJSucessora;
    private String erro;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;
    private static TypeDesc typeDesc = new TypeDesc(CNPJPerfil3.class, true);

    static {
        typeDesc.setXmlType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil3"));
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
        elemField.setFieldName("CPFResponsavel");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFResponsavel"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeResponsavel");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NomeResponsavel"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("capitalSocial");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CapitalSocial"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("sociedade");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Sociedade"));
        elemField.setXmlType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Socio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Socio"));
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("tipoCRCContadorPJ");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "TipoCRCContadorPJ"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("classificacaoCRCContadorPJ");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ClassificacaoCRCContadorPJ"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("numeroCRCContadorPJ");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NumeroCRCContadorPJ"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("UFCRCContadorPJ");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "UFCRCContadorPJ"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CNPJContador");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJContador"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("tipoCRCContadorPF");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "TipoCRCContadorPF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("classificacaoCRCContadorPF");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ClassificacaoCRCContadorPF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("numeroCRCContadorPF");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "NumeroCRCContadorPF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("UFCRCContadorPF");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "UFCRCContadorPF"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CPFContador");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFContador"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("porte");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Porte"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("opcaoSimples");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "OpcaoSimples"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataOpcaoSimples");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "DataOpcaoSimples"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataExclusaoSimples");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "DataExclusaoSimples"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CNPJSucedida");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJSucedida"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("CNPJSucessora");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJSucessora"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("erro");
        elemField.setXmlName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Erro"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    public CNPJPerfil3() {
    }

    public CNPJPerfil3(String CNPJ, String estabelecimento, String nomeEmpresarial, String nomeFantasia, String situacaoCadastral, String dataSituacaoCadastral, String cidadeExterior, String codigoPais, String nomePais, String naturezaJuridica, String dataAbertura, String CNAEPrincipal, String[] CNAESecundario, String tipoLogradouro, String logradouro, String numeroLogradouro, String complemento, String bairro, String CEP, String UF, String codigoMunicipio, String nomeMunicipio, String DDD1, String telefone1, String DDD2, String telefone2, String email, String CPFResponsavel, String nomeResponsavel, String capitalSocial, Socio[] sociedade, String tipoCRCContadorPJ, String classificacaoCRCContadorPJ, String numeroCRCContadorPJ, String UFCRCContadorPJ, String CNPJContador, String tipoCRCContadorPF, String classificacaoCRCContadorPF, String numeroCRCContadorPF, String UFCRCContadorPF, String CPFContador, String porte, String opcaoSimples, String dataOpcaoSimples, String dataExclusaoSimples, String CNPJSucedida, String[] CNPJSucessora, String erro) {
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
        this.CPFResponsavel = CPFResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.capitalSocial = capitalSocial;
        this.sociedade = sociedade;
        this.tipoCRCContadorPJ = tipoCRCContadorPJ;
        this.classificacaoCRCContadorPJ = classificacaoCRCContadorPJ;
        this.numeroCRCContadorPJ = numeroCRCContadorPJ;
        this.UFCRCContadorPJ = UFCRCContadorPJ;
        this.CNPJContador = CNPJContador;
        this.tipoCRCContadorPF = tipoCRCContadorPF;
        this.classificacaoCRCContadorPF = classificacaoCRCContadorPF;
        this.numeroCRCContadorPF = numeroCRCContadorPF;
        this.UFCRCContadorPF = UFCRCContadorPF;
        this.CPFContador = CPFContador;
        this.porte = porte;
        this.opcaoSimples = opcaoSimples;
        this.dataOpcaoSimples = dataOpcaoSimples;
        this.dataExclusaoSimples = dataExclusaoSimples;
        this.CNPJSucedida = CNPJSucedida;
        this.CNPJSucessora = CNPJSucessora;
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

    public String getCPFResponsavel() {
        return this.CPFResponsavel;
    }

    public void setCPFResponsavel(String CPFResponsavel) {
        this.CPFResponsavel = CPFResponsavel;
    }

    public String getNomeResponsavel() {
        return this.nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCapitalSocial() {
        return this.capitalSocial;
    }

    public void setCapitalSocial(String capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public Socio[] getSociedade() {
        return this.sociedade;
    }

    public void setSociedade(Socio[] sociedade) {
        this.sociedade = sociedade;
    }

    public String getTipoCRCContadorPJ() {
        return this.tipoCRCContadorPJ;
    }

    public void setTipoCRCContadorPJ(String tipoCRCContadorPJ) {
        this.tipoCRCContadorPJ = tipoCRCContadorPJ;
    }

    public String getClassificacaoCRCContadorPJ() {
        return this.classificacaoCRCContadorPJ;
    }

    public void setClassificacaoCRCContadorPJ(String classificacaoCRCContadorPJ) {
        this.classificacaoCRCContadorPJ = classificacaoCRCContadorPJ;
    }

    public String getNumeroCRCContadorPJ() {
        return this.numeroCRCContadorPJ;
    }

    public void setNumeroCRCContadorPJ(String numeroCRCContadorPJ) {
        this.numeroCRCContadorPJ = numeroCRCContadorPJ;
    }

    public String getUFCRCContadorPJ() {
        return this.UFCRCContadorPJ;
    }

    public void setUFCRCContadorPJ(String UFCRCContadorPJ) {
        this.UFCRCContadorPJ = UFCRCContadorPJ;
    }

    public String getCNPJContador() {
        return this.CNPJContador;
    }

    public void setCNPJContador(String CNPJContador) {
        this.CNPJContador = CNPJContador;
    }

    public String getTipoCRCContadorPF() {
        return this.tipoCRCContadorPF;
    }

    public void setTipoCRCContadorPF(String tipoCRCContadorPF) {
        this.tipoCRCContadorPF = tipoCRCContadorPF;
    }

    public String getClassificacaoCRCContadorPF() {
        return this.classificacaoCRCContadorPF;
    }

    public void setClassificacaoCRCContadorPF(String classificacaoCRCContadorPF) {
        this.classificacaoCRCContadorPF = classificacaoCRCContadorPF;
    }

    public String getNumeroCRCContadorPF() {
        return this.numeroCRCContadorPF;
    }

    public void setNumeroCRCContadorPF(String numeroCRCContadorPF) {
        this.numeroCRCContadorPF = numeroCRCContadorPF;
    }

    public String getUFCRCContadorPF() {
        return this.UFCRCContadorPF;
    }

    public void setUFCRCContadorPF(String UFCRCContadorPF) {
        this.UFCRCContadorPF = UFCRCContadorPF;
    }

    public String getCPFContador() {
        return this.CPFContador;
    }

    public void setCPFContador(String CPFContador) {
        this.CPFContador = CPFContador;
    }

    public String getPorte() {
        return this.porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getOpcaoSimples() {
        return this.opcaoSimples;
    }

    public void setOpcaoSimples(String opcaoSimples) {
        this.opcaoSimples = opcaoSimples;
    }

    public String getDataOpcaoSimples() {
        return this.dataOpcaoSimples;
    }

    public void setDataOpcaoSimples(String dataOpcaoSimples) {
        this.dataOpcaoSimples = dataOpcaoSimples;
    }

    public String getDataExclusaoSimples() {
        return this.dataExclusaoSimples;
    }

    public void setDataExclusaoSimples(String dataExclusaoSimples) {
        this.dataExclusaoSimples = dataExclusaoSimples;
    }

    public String getCNPJSucedida() {
        return this.CNPJSucedida;
    }

    public void setCNPJSucedida(String CNPJSucedida) {
        this.CNPJSucedida = CNPJSucedida;
    }

    public String[] getCNPJSucessora() {
        return this.CNPJSucessora;
    }

    public void setCNPJSucessora(String[] CNPJSucessora) {
        this.CNPJSucessora = CNPJSucessora;
    }

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CNPJPerfil3)) {
            return false;
        } else {
            CNPJPerfil3 other = (CNPJPerfil3)obj;
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.__equalsCalc != null) {
                return this.__equalsCalc == obj;
            } else {
                this.__equalsCalc = obj;
                boolean _equals = (this.CNPJ == null && other.getCNPJ() == null || this.CNPJ != null && this.CNPJ.equals(other.getCNPJ())) && (this.estabelecimento == null && other.getEstabelecimento() == null || this.estabelecimento != null && this.estabelecimento.equals(other.getEstabelecimento())) && (this.nomeEmpresarial == null && other.getNomeEmpresarial() == null || this.nomeEmpresarial != null && this.nomeEmpresarial.equals(other.getNomeEmpresarial())) && (this.nomeFantasia == null && other.getNomeFantasia() == null || this.nomeFantasia != null && this.nomeFantasia.equals(other.getNomeFantasia())) && (this.situacaoCadastral == null && other.getSituacaoCadastral() == null || this.situacaoCadastral != null && this.situacaoCadastral.equals(other.getSituacaoCadastral())) && (this.dataSituacaoCadastral == null && other.getDataSituacaoCadastral() == null || this.dataSituacaoCadastral != null && this.dataSituacaoCadastral.equals(other.getDataSituacaoCadastral())) && (this.cidadeExterior == null && other.getCidadeExterior() == null || this.cidadeExterior != null && this.cidadeExterior.equals(other.getCidadeExterior())) && (this.codigoPais == null && other.getCodigoPais() == null || this.codigoPais != null && this.codigoPais.equals(other.getCodigoPais())) && (this.nomePais == null && other.getNomePais() == null || this.nomePais != null && this.nomePais.equals(other.getNomePais())) && (this.naturezaJuridica == null && other.getNaturezaJuridica() == null || this.naturezaJuridica != null && this.naturezaJuridica.equals(other.getNaturezaJuridica())) && (this.dataAbertura == null && other.getDataAbertura() == null || this.dataAbertura != null && this.dataAbertura.equals(other.getDataAbertura())) && (this.CNAEPrincipal == null && other.getCNAEPrincipal() == null || this.CNAEPrincipal != null && this.CNAEPrincipal.equals(other.getCNAEPrincipal())) && (this.CNAESecundario == null && other.getCNAESecundario() == null || this.CNAESecundario != null && Arrays.equals(this.CNAESecundario, other.getCNAESecundario())) && (this.tipoLogradouro == null && other.getTipoLogradouro() == null || this.tipoLogradouro != null && this.tipoLogradouro.equals(other.getTipoLogradouro())) && (this.logradouro == null && other.getLogradouro() == null || this.logradouro != null && this.logradouro.equals(other.getLogradouro())) && (this.numeroLogradouro == null && other.getNumeroLogradouro() == null || this.numeroLogradouro != null && this.numeroLogradouro.equals(other.getNumeroLogradouro())) && (this.complemento == null && other.getComplemento() == null || this.complemento != null && this.complemento.equals(other.getComplemento())) && (this.bairro == null && other.getBairro() == null || this.bairro != null && this.bairro.equals(other.getBairro())) && (this.CEP == null && other.getCEP() == null || this.CEP != null && this.CEP.equals(other.getCEP())) && (this.UF == null && other.getUF() == null || this.UF != null && this.UF.equals(other.getUF())) && (this.codigoMunicipio == null && other.getCodigoMunicipio() == null || this.codigoMunicipio != null && this.codigoMunicipio.equals(other.getCodigoMunicipio())) && (this.nomeMunicipio == null && other.getNomeMunicipio() == null || this.nomeMunicipio != null && this.nomeMunicipio.equals(other.getNomeMunicipio())) && (this.DDD1 == null && other.getDDD1() == null || this.DDD1 != null && this.DDD1.equals(other.getDDD1())) && (this.telefone1 == null && other.getTelefone1() == null || this.telefone1 != null && this.telefone1.equals(other.getTelefone1())) && (this.DDD2 == null && other.getDDD2() == null || this.DDD2 != null && this.DDD2.equals(other.getDDD2())) && (this.telefone2 == null && other.getTelefone2() == null || this.telefone2 != null && this.telefone2.equals(other.getTelefone2())) && (this.email == null && other.getEmail() == null || this.email != null && this.email.equals(other.getEmail())) && (this.CPFResponsavel == null && other.getCPFResponsavel() == null || this.CPFResponsavel != null && this.CPFResponsavel.equals(other.getCPFResponsavel())) && (this.nomeResponsavel == null && other.getNomeResponsavel() == null || this.nomeResponsavel != null && this.nomeResponsavel.equals(other.getNomeResponsavel())) && (this.capitalSocial == null && other.getCapitalSocial() == null || this.capitalSocial != null && this.capitalSocial.equals(other.getCapitalSocial())) && (this.sociedade == null && other.getSociedade() == null || this.sociedade != null && Arrays.equals(this.sociedade, other.getSociedade())) && (this.tipoCRCContadorPJ == null && other.getTipoCRCContadorPJ() == null || this.tipoCRCContadorPJ != null && this.tipoCRCContadorPJ.equals(other.getTipoCRCContadorPJ())) && (this.classificacaoCRCContadorPJ == null && other.getClassificacaoCRCContadorPJ() == null || this.classificacaoCRCContadorPJ != null && this.classificacaoCRCContadorPJ.equals(other.getClassificacaoCRCContadorPJ())) && (this.numeroCRCContadorPJ == null && other.getNumeroCRCContadorPJ() == null || this.numeroCRCContadorPJ != null && this.numeroCRCContadorPJ.equals(other.getNumeroCRCContadorPJ())) && (this.UFCRCContadorPJ == null && other.getUFCRCContadorPJ() == null || this.UFCRCContadorPJ != null && this.UFCRCContadorPJ.equals(other.getUFCRCContadorPJ())) && (this.CNPJContador == null && other.getCNPJContador() == null || this.CNPJContador != null && this.CNPJContador.equals(other.getCNPJContador())) && (this.tipoCRCContadorPF == null && other.getTipoCRCContadorPF() == null || this.tipoCRCContadorPF != null && this.tipoCRCContadorPF.equals(other.getTipoCRCContadorPF())) && (this.classificacaoCRCContadorPF == null && other.getClassificacaoCRCContadorPF() == null || this.classificacaoCRCContadorPF != null && this.classificacaoCRCContadorPF.equals(other.getClassificacaoCRCContadorPF())) && (this.numeroCRCContadorPF == null && other.getNumeroCRCContadorPF() == null || this.numeroCRCContadorPF != null && this.numeroCRCContadorPF.equals(other.getNumeroCRCContadorPF())) && (this.UFCRCContadorPF == null && other.getUFCRCContadorPF() == null || this.UFCRCContadorPF != null && this.UFCRCContadorPF.equals(other.getUFCRCContadorPF())) && (this.CPFContador == null && other.getCPFContador() == null || this.CPFContador != null && this.CPFContador.equals(other.getCPFContador())) && (this.porte == null && other.getPorte() == null || this.porte != null && this.porte.equals(other.getPorte())) && (this.opcaoSimples == null && other.getOpcaoSimples() == null || this.opcaoSimples != null && this.opcaoSimples.equals(other.getOpcaoSimples())) && (this.dataOpcaoSimples == null && other.getDataOpcaoSimples() == null || this.dataOpcaoSimples != null && this.dataOpcaoSimples.equals(other.getDataOpcaoSimples())) && (this.dataExclusaoSimples == null && other.getDataExclusaoSimples() == null || this.dataExclusaoSimples != null && this.dataExclusaoSimples.equals(other.getDataExclusaoSimples())) && (this.CNPJSucedida == null && other.getCNPJSucedida() == null || this.CNPJSucedida != null && this.CNPJSucedida.equals(other.getCNPJSucedida())) && (this.CNPJSucessora == null && other.getCNPJSucessora() == null || this.CNPJSucessora != null && Arrays.equals(this.CNPJSucessora, other.getCNPJSucessora())) && (this.erro == null && other.getErro() == null || this.erro != null && this.erro.equals(other.getErro()));
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

            int i;
            Object obj;
            if (this.getCNAESecundario() != null) {
                for(i = 0; i < Array.getLength(this.getCNAESecundario()); ++i) {
                    obj = Array.get(this.getCNAESecundario(), i);
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

            if (this.getCPFResponsavel() != null) {
                _hashCode += this.getCPFResponsavel().hashCode();
            }

            if (this.getNomeResponsavel() != null) {
                _hashCode += this.getNomeResponsavel().hashCode();
            }

            if (this.getCapitalSocial() != null) {
                _hashCode += this.getCapitalSocial().hashCode();
            }

            if (this.getSociedade() != null) {
                for(i = 0; i < Array.getLength(this.getSociedade()); ++i) {
                    obj = Array.get(this.getSociedade(), i);
                    if (obj != null && !obj.getClass().isArray()) {
                        _hashCode += obj.hashCode();
                    }
                }
            }

            if (this.getTipoCRCContadorPJ() != null) {
                _hashCode += this.getTipoCRCContadorPJ().hashCode();
            }

            if (this.getClassificacaoCRCContadorPJ() != null) {
                _hashCode += this.getClassificacaoCRCContadorPJ().hashCode();
            }

            if (this.getNumeroCRCContadorPJ() != null) {
                _hashCode += this.getNumeroCRCContadorPJ().hashCode();
            }

            if (this.getUFCRCContadorPJ() != null) {
                _hashCode += this.getUFCRCContadorPJ().hashCode();
            }

            if (this.getCNPJContador() != null) {
                _hashCode += this.getCNPJContador().hashCode();
            }

            if (this.getTipoCRCContadorPF() != null) {
                _hashCode += this.getTipoCRCContadorPF().hashCode();
            }

            if (this.getClassificacaoCRCContadorPF() != null) {
                _hashCode += this.getClassificacaoCRCContadorPF().hashCode();
            }

            if (this.getNumeroCRCContadorPF() != null) {
                _hashCode += this.getNumeroCRCContadorPF().hashCode();
            }

            if (this.getUFCRCContadorPF() != null) {
                _hashCode += this.getUFCRCContadorPF().hashCode();
            }

            if (this.getCPFContador() != null) {
                _hashCode += this.getCPFContador().hashCode();
            }

            if (this.getPorte() != null) {
                _hashCode += this.getPorte().hashCode();
            }

            if (this.getOpcaoSimples() != null) {
                _hashCode += this.getOpcaoSimples().hashCode();
            }

            if (this.getDataOpcaoSimples() != null) {
                _hashCode += this.getDataOpcaoSimples().hashCode();
            }

            if (this.getDataExclusaoSimples() != null) {
                _hashCode += this.getDataExclusaoSimples().hashCode();
            }

            if (this.getCNPJSucedida() != null) {
                _hashCode += this.getCNPJSucedida().hashCode();
            }

            if (this.getCNPJSucessora() != null) {
                for(i = 0; i < Array.getLength(this.getCNPJSucessora()); ++i) {
                    obj = Array.get(this.getCNPJSucessora(), i);
                    if (obj != null && !obj.getClass().isArray()) {
                        _hashCode += obj.hashCode();
                    }
                }
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
