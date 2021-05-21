package br.gov.fazenda.receita.infoconv.ws.cnpj;

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

public class ConsultarCNPJSoapStub extends Stub implements ConsultarCNPJSoap {
    private Vector cachedSerClasses;
    private Vector cachedSerQNames;
    private Vector cachedSerFactories;
    private Vector cachedDeserFactories;
    static OperationDesc[] _operations = new OperationDesc[6];

    static {
        _initOperationDesc1();
    }

    private static void _initOperationDesc1() {
        OperationDesc oper = new OperationDesc();
        oper.setName("ConsultarCNPJP1");
        ParameterDesc param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJ"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil1"));
        oper.setReturnClass(CNPJPerfil1[].class);
        oper.setReturnQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP1Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil1"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[0] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCNPJP1T");
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJ"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil1"));
        oper.setReturnClass(CNPJPerfil1[].class);
        oper.setReturnQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP1TResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil1"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[1] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCNPJP2");
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJ"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil2"));
        oper.setReturnClass(CNPJPerfil2[].class);
        oper.setReturnQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP2Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil2"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[2] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCNPJP2T");
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJ"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil2"));
        oper.setReturnClass(CNPJPerfil2[].class);
        oper.setReturnQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP2TResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil2"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[3] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCNPJP3");
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJ"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil3"));
        oper.setReturnClass(CNPJPerfil3[].class);
        oper.setReturnQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP3Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil3"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[4] = oper;
        oper = new OperationDesc();
        oper.setName("ConsultarCNPJP3T");
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJ"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CPFUsuario"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil3"));
        oper.setReturnClass(CNPJPerfil3[].class);
        oper.setReturnQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP3TResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil3"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[5] = oper;
    }

    public ConsultarCNPJSoapStub() throws AxisFault {
        this((Service)null);
    }

    public ConsultarCNPJSoapStub(URL endpointURL, Service service) throws AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
    }

    public ConsultarCNPJSoapStub(Service service) throws AxisFault {
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
        QName qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil1");
        this.cachedSerQNames.add(qName);
        Class cls = CNPJPerfil1[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil1");
        QName qName2 = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil1");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil2");
        this.cachedSerQNames.add(qName);
        cls = CNPJPerfil2[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil2");
        qName2 = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil2");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfCNPJPerfil3");
        this.cachedSerQNames.add(qName);
        cls = CNPJPerfil3[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil3");
        qName2 = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil3");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfSocio");
        this.cachedSerQNames.add(qName);
        cls = Socio[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Socio");
        qName2 = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Socio");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ArrayOfString");
        this.cachedSerQNames.add(qName);
        cls = String[].class;
        this.cachedSerClasses.add(cls);
        qName = new QName("http://www.w3.org/2001/XMLSchema", "string");
        qName2 = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "string");
        this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
        this.cachedDeserFactories.add(new ArrayDeserializerFactory());
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil1");
        this.cachedSerQNames.add(qName);
        cls = CNPJPerfil1.class;
        this.cachedSerClasses.add(cls);
        this.cachedSerFactories.add(beansf);
        this.cachedDeserFactories.add(beandf);
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil2");
        this.cachedSerQNames.add(qName);
        cls = CNPJPerfil2.class;
        this.cachedSerClasses.add(cls);
        this.cachedSerFactories.add(beansf);
        this.cachedDeserFactories.add(beandf);
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "CNPJPerfil3");
        this.cachedSerQNames.add(qName);
        cls = CNPJPerfil3.class;
        this.cachedSerClasses.add(cls);
        this.cachedSerFactories.add(beansf);
        this.cachedDeserFactories.add(beandf);
        qName = new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "Socio");
        this.cachedSerQNames.add(qName);
        cls = Socio.class;
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

    public CNPJPerfil1[] consultarCNPJP1(String CNPJ, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[0]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/ConsultarCNPJP1");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP1"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{CNPJ, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (CNPJPerfil1[])_resp;
                    } catch (Exception var6) {
                        return (CNPJPerfil1[])JavaUtils.convert(_resp, CNPJPerfil1[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public CNPJPerfil1[] consultarCNPJP1T(String CNPJ, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[1]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/ConsultarCNPJP1T");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP1T"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{CNPJ, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (CNPJPerfil1[])_resp;
                    } catch (Exception var6) {
                        return (CNPJPerfil1[])JavaUtils.convert(_resp, CNPJPerfil1[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public CNPJPerfil2[] consultarCNPJP2(String CNPJ, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[2]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/ConsultarCNPJP2");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP2"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{CNPJ, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (CNPJPerfil2[])_resp;
                    } catch (Exception var6) {
                        return (CNPJPerfil2[])JavaUtils.convert(_resp, CNPJPerfil2[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public CNPJPerfil2[] consultarCNPJP2T(String CNPJ, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[3]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/ConsultarCNPJP2T");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP2T"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{CNPJ, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (CNPJPerfil2[])_resp;
                    } catch (Exception var6) {
                        return (CNPJPerfil2[])JavaUtils.convert(_resp, CNPJPerfil2[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public CNPJPerfil3[] consultarCNPJP3(String CNPJ, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[4]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/ConsultarCNPJP3");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP3"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{CNPJ, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (CNPJPerfil3[])_resp;
                    } catch (Exception var6) {
                        return (CNPJPerfil3[])JavaUtils.convert(_resp, CNPJPerfil3[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }

    public CNPJPerfil3[] consultarCNPJP3T(String CNPJ, String CPFUsuario) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        } else {
            Call _call = this.createCall();
            _call.setOperation(_operations[5]);
            _call.setUseSOAPAction(true);
            _call.setSOAPActionURI("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/ConsultarCNPJP3T");
            _call.setEncodingStyle((String)null);
            _call.setProperty("sendXsiTypes", Boolean.FALSE);
            _call.setProperty("sendMultiRefs", Boolean.FALSE);
            _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            _call.setOperationName(new QName("https://infoconv.turismo.gov.br/infoconv-proxy/api/cnpj/", "ConsultarCNPJP3T"));
            this.setRequestHeaders(_call);
            this.setAttachments(_call);

            try {
                Object _resp = _call.invoke(new Object[]{CNPJ, CPFUsuario});
                if (_resp instanceof RemoteException) {
                    throw (RemoteException)_resp;
                } else {
                    this.extractAttachments(_call);

                    try {
                        return (CNPJPerfil3[])_resp;
                    } catch (Exception var6) {
                        return (CNPJPerfil3[])JavaUtils.convert(_resp, CNPJPerfil3[].class);
                    }
                }
            } catch (AxisFault var7) {
                throw var7;
            }
        }
    }
}
