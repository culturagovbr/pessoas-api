package br.gov.fazenda.receita.infoconv.ws.cnpj;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

public class ConsultarCNPJLocator extends Service implements ConsultarCNPJ {
    private String ConsultarCNPJSoap_address = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/ConsultarCNPJ.asmx";
    private String ConsultarCNPJSoapWSDDServiceName = "ConsultarCNPJSoap";
    private HashSet ports = null;

    public ConsultarCNPJLocator() {
    }

    public ConsultarCNPJLocator(EngineConfiguration config) {
        super(config);
    }

    public ConsultarCNPJLocator(String wsdlLoc, QName sName) throws ServiceException {
        super(wsdlLoc, sName);
    }

    public String getConsultarCNPJSoapAddress() {
        return this.ConsultarCNPJSoap_address;
    }

    public String getConsultarCNPJSoapWSDDServiceName() {
        return this.ConsultarCNPJSoapWSDDServiceName;
    }

    public void setConsultarCNPJSoapWSDDServiceName(String name) {
        this.ConsultarCNPJSoapWSDDServiceName = name;
    }

    public ConsultarCNPJSoap getConsultarCNPJSoap() throws ServiceException {
        URL endpoint;
        try {
            endpoint = new URL(this.ConsultarCNPJSoap_address);
        } catch (MalformedURLException var3) {
            throw new ServiceException(var3);
        }

        return this.getConsultarCNPJSoap(endpoint);
    }

    public ConsultarCNPJSoap getConsultarCNPJSoap(URL portAddress) throws ServiceException {
        try {
            ConsultarCNPJSoapStub _stub = new ConsultarCNPJSoapStub(portAddress, this);
            _stub.setPortName(this.getConsultarCNPJSoapWSDDServiceName());
            return _stub;
        } catch (AxisFault var3) {
            return null;
        }
    }

    public void setConsultarCNPJSoapEndpointAddress(String address) {
        this.ConsultarCNPJSoap_address = address;
    }

    public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
        try {
            if (ConsultarCNPJSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                ConsultarCNPJSoapStub _stub = new ConsultarCNPJSoapStub(new URL(this.ConsultarCNPJSoap_address), this);
                _stub.setPortName(this.getConsultarCNPJSoapWSDDServiceName());
                return _stub;
            }
        } catch (Throwable var3) {
            throw new ServiceException(var3);
        }

        throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
        if (portName == null) {
            return this.getPort(serviceEndpointInterface);
        } else {
            String inputPortName = portName.getLocalPart();
            if ("ConsultarCNPJSoap".equals(inputPortName)) {
                return this.getConsultarCNPJSoap();
            } else {
                Remote _stub = this.getPort(serviceEndpointInterface);
                ((Stub)_stub).setPortName(portName);
                return _stub;
            }
        }
    }

    public QName getServiceName() {
        return new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "ConsultarCNPJ");
    }

    public Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new HashSet();
            this.ports.add(new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "ConsultarCNPJSoap"));
        }

        return this.ports.iterator();
    }

    public void setEndpointAddress(String portName, String address) throws ServiceException {
        if ("ConsultarCNPJSoap".equals(portName)) {
            this.setConsultarCNPJSoapEndpointAddress(address);
        } else {
            throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    public void setEndpointAddress(QName portName, String address) throws ServiceException {
        this.setEndpointAddress(portName.getLocalPart(), address);
    }
}
