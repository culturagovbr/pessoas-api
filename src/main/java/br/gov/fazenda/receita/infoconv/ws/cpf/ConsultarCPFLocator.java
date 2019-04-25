package br.gov.fazenda.receita.infoconv.ws.cpf;

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

public class ConsultarCPFLocator extends Service implements ConsultarCPF {
    private String ConsultarCPFSoap_address = "https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPF.asmx";
    private String ConsultarCPFSoapWSDDServiceName = "ConsultarCPFSoap";
    private HashSet ports = null;

    public ConsultarCPFLocator() {
    }

    public ConsultarCPFLocator(EngineConfiguration config) {
        super(config);
    }

    public ConsultarCPFLocator(String wsdlLoc, QName sName) throws ServiceException {
        super(wsdlLoc, sName);
    }

    public String getConsultarCPFSoapAddress() {
        return this.ConsultarCPFSoap_address;
    }

    public String getConsultarCPFSoapWSDDServiceName() {
        return this.ConsultarCPFSoapWSDDServiceName;
    }

    public void setConsultarCPFSoapWSDDServiceName(String name) {
        this.ConsultarCPFSoapWSDDServiceName = name;
    }

    public ConsultarCPFSoap getConsultarCPFSoap() throws ServiceException {
        URL endpoint;
        try {
            endpoint = new URL(this.ConsultarCPFSoap_address);
        } catch (MalformedURLException var3) {
            throw new ServiceException(var3);
        }

        return this.getConsultarCPFSoap(endpoint);
    }

    public ConsultarCPFSoap getConsultarCPFSoap(URL portAddress) throws ServiceException {
        try {
            ConsultarCPFSoapStub _stub = new ConsultarCPFSoapStub(portAddress, this);
            _stub.setPortName(this.getConsultarCPFSoapWSDDServiceName());
            return _stub;
        } catch (AxisFault var3) {
            return null;
        }
    }

    public void setConsultarCPFSoapEndpointAddress(String address) {
        this.ConsultarCPFSoap_address = address;
    }

    public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
        try {
            if (ConsultarCPFSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                ConsultarCPFSoapStub _stub = new ConsultarCPFSoapStub(new URL(this.ConsultarCPFSoap_address), this);
                _stub.setPortName(this.getConsultarCPFSoapWSDDServiceName());
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
            if ("ConsultarCPFSoap".equals(inputPortName)) {
                return this.getConsultarCPFSoap();
            } else {
                Remote _stub = this.getPort(serviceEndpointInterface);
                ((Stub)_stub).setPortName(portName);
                return _stub;
            }
        }
    }

    public QName getServiceName() {
        return new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPF");
    }

    public Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new HashSet();
            this.ports.add(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFSoap"));
        }

        return this.ports.iterator();
    }

    public void setEndpointAddress(String portName, String address) throws ServiceException {
        if ("ConsultarCPFSoap".equals(portName)) {
            this.setConsultarCPFSoapEndpointAddress(address);
        } else {
            throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    public void setEndpointAddress(QName portName, String address) throws ServiceException {
        this.setEndpointAddress(portName.getLocalPart(), address);
    }
}
