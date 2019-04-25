package br.gov.fazenda.receita.infoconv.ws.cpf;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.SerializerFactory;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.DeserializerFactory;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;

public class ConsultarCPFSoapStub extends Stub implements ConsultarCPFSoap {
    private Vector cachedSerClasses;
    private Vector cachedSerQNames;
    private Vector cachedSerFactories;
    private Vector cachedDeserFactories;
    static OperationDesc[] _operations = new OperationDesc[7];

    static {
        _initOperationDesc1();
    }

    private static void _initOperationDesc1() {
        OperationDesc oper = new OperationDesc();
        oper.setName("ConsultarCPFP1");
        ParameterDesc param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ListaDeCPF"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil1"));
        oper.setReturnClass(PessoaPerfil1[].class);
        oper.setReturnQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP1Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil1"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[0] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCPFP1T");
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ListaDeCPF"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil1"));
        oper.setReturnClass(PessoaPerfil1[].class);
        oper.setReturnQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP1TResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil1"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[1] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCPFP2");
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ListaDeCPF"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil2"));
        oper.setReturnClass(PessoaPerfil2[].class);
        oper.setReturnQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP2Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil2"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[2] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCPFP2T");
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ListaDeCPF"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil2"));
        oper.setReturnClass(PessoaPerfil2[].class);
        oper.setReturnQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP2TResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil2"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[3] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCPFP3");
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ListaDeCPF"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil3"));
        oper.setReturnClass(PessoaPerfil3[].class);
        oper.setReturnQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP3Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil3"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[4] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCPFP3T");
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ListaDeCPF"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil3"));
        oper.setReturnClass(PessoaPerfil3[].class);
        oper.setReturnQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP3TResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil3"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[5] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCPFPD");
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ListaDeCPF"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfilD"));
        oper.setReturnClass(PessoaPerfilD[].class);
        oper.setReturnQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFPDResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfilD"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[6] = oper;
    }

    public ConsultarCPFSoapStub() throws AxisFault {
        this((Service)null);
    }

    public ConsultarCPFSoapStub(URL endpointURL, Service service) throws AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
    }

    public ConsultarCPFSoapStub(Service service) throws AxisFault {
        this.cachedSerClasses = new Vector();
        this.cachedSerQNames = new Vector();
        this.cachedSerFactories = new Vector();
        this.cachedDeserFactories = new Vector();
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }

        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
        Class beansf = BeanSerializerFactory.class;
        Class beandf = BeanDeserializerFactory.class;
        Class enumsf = EnumSerializerFactory.class;
        Class enumdf = EnumDeserializerFactory.class;
        Class arraysf = ArraySerializerFactory.class;
        Class arraydf = ArrayDeserializerFactory.class;
        Class simplesf = SimpleSerializerFactory.class;
        Class simpledf = SimpleDeserializerFactory.class;
        Class simplelistsf = SimpleListSerializerFactory.class;
        Class simplelistdf = SimpleListDeserializerFactory.class;
        QName qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil1");
        this.cachedSerQNames.add(qName);
        Class cls = PessoaPerfil1[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil1");
        QName qName2 = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil1");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil2");
        this.cachedSerQNames.add(qName);
        cls = PessoaPerfil2[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil2");
        qName2 = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil2");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfil3");
        this.cachedSerQNames.add(qName);
        cls = PessoaPerfil3[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil3");
        qName2 = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil3");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ArrayOfPessoaPerfilD");
        this.cachedSerQNames.add(qName);
        cls = PessoaPerfilD[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfilD");
        qName2 = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfilD");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil1");
        this.cachedSerQNames.add(qName);
        cls = PessoaPerfil1.class;
        this.cachedSerClasses.add(cls);
        this.cachedSerFactories.add(beansf);
        this.cachedDeserFactories.add(beandf);
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil2");
        this.cachedSerQNames.add(qName);
        cls = PessoaPerfil2.class;
        this.cachedSerClasses.add(cls);
        this.cachedSerFactories.add(beansf);
        this.cachedDeserFactories.add(beandf);
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfil3");
        this.cachedSerQNames.add(qName);
        cls = PessoaPerfil3.class;
        this.cachedSerClasses.add(cls);
        this.cachedSerFactories.add(beansf);
        this.cachedDeserFactories.add(beandf);
        qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "PessoaPerfilD");
        this.cachedSerQNames.add(qName);
        cls = PessoaPerfilD.class;
        this.cachedSerClasses.add(cls);
        this.cachedSerFactories.add(beansf);
        this.cachedDeserFactories.add(beandf);
    }

    protected Call createCall() throws RemoteException {
        try {
            Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }

            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }

            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }

            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }

            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }

            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }

            Enumeration keys = super.cachedProperties.keys();

            while(keys.hasMoreElements()) {
                String key = (String)keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }

            synchronized(this) {
                if (this.firstCall()) {
                    _call.setEncodingStyle((String)null);

                    for(int i = 0; i < this.cachedSerFactories.size(); ++i) {
                        Class cls = (Class)this.cachedSerClasses.get(i);
                        QName qName = (QName)this.cachedSerQNames.get(i);
                        Object x = this.cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)this.cachedSerFactories.get(i);
                            Class df = (Class)this.cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        } else if (x instanceof SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)this.cachedSerFactories.get(i);
                            DeserializerFactory df = (DeserializerFactory)this.cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }

            return _call;
        } catch (Throwable var11) {
            throw new AxisFault("Failure trying to get the Call object", var11);
        }
    }

    public PessoaPerfil1[] consultarCPFP1(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[0]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP1");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP1"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{listaDeCPF, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (PessoaPerfil1[])_resp;
                    } catch (Exception var6) {
                        return (PessoaPerfil1[])JavaUtils.convert(_resp, PessoaPerfil1[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public PessoaPerfil1[] consultarCPFP1T(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[1]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP1T");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP1T"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{listaDeCPF, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (PessoaPerfil1[])_resp;
                    } catch (Exception var6) {
                        return (PessoaPerfil1[])JavaUtils.convert(_resp, PessoaPerfil1[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public PessoaPerfil2[] consultarCPFP2(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[2]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP2");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP2"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{listaDeCPF, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (PessoaPerfil2[])_resp;
                    } catch (Exception var6) {
                        return (PessoaPerfil2[])JavaUtils.convert(_resp, PessoaPerfil2[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public PessoaPerfil2[] consultarCPFP2T(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[3]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP2T");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP2T"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{listaDeCPF, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (PessoaPerfil2[])_resp;
                    } catch (Exception var6) {
                        return (PessoaPerfil2[])JavaUtils.convert(_resp, PessoaPerfil2[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public PessoaPerfil3[] consultarCPFP3(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[4]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP3");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP3"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{listaDeCPF, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (PessoaPerfil3[])_resp;
                    } catch (Exception var6) {
                        return (PessoaPerfil3[])JavaUtils.convert(_resp, PessoaPerfil3[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public PessoaPerfil3[] consultarCPFP3T(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[5]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP3T");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFP3T"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{listaDeCPF, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (PessoaPerfil3[])_resp;
                    } catch (Exception var6) {
                        return (PessoaPerfil3[])JavaUtils.convert(_resp, PessoaPerfil3[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public PessoaPerfilD[] consultarCPFPD(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[6]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFPD");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFPD"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{listaDeCPF, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (PessoaPerfilD[])_resp;
                    } catch (Exception var6) {
                        return (PessoaPerfilD[])JavaUtils.convert(_resp, PessoaPerfilD[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }
}
