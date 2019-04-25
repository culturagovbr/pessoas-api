package br.gov.fazenda.receita.infoconv.ws.cnpj;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;

public class ConsultarCNPJSoapProxy implements ConsultarCNPJSoap {
    private String _endpoint = null;
    private ConsultarCNPJSoap consultarCNPJSoap = null;

    public ConsultarCNPJSoapProxy() {
        this._initConsultarCNPJSoapProxy();
    }

    public ConsultarCNPJSoapProxy(String endpoint) {
        this._endpoint = endpoint;
        this._initConsultarCNPJSoapProxy();
    }

    private void _initConsultarCNPJSoapProxy() {
        try {
            this.consultarCNPJSoap = (new ConsultarCNPJLocator()).getConsultarCNPJSoap();
            if (this.consultarCNPJSoap != null) {
                if (this._endpoint != null) {
                    ((Stub)this.consultarCNPJSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
                } else {
                    this._endpoint = (String)((Stub)this.consultarCNPJSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
                }
            }
        } catch (ServiceException var2) {
            ;
        }

    }

    public String getEndpoint() {
        return this._endpoint;
    }

    public void setEndpoint(String endpoint) {
        this._endpoint = endpoint;
        if (this.consultarCNPJSoap != null) {
            ((Stub)this.consultarCNPJSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
        }

    }

    public ConsultarCNPJSoap getConsultarCNPJSoap() {
        if (this.consultarCNPJSoap == null) {
            this._initConsultarCNPJSoapProxy();
        }

        return this.consultarCNPJSoap;
    }

    public CNPJPerfil1[] consultarCNPJP1(String CNPJ, String CPFUsuario) throws RemoteException {
        if (this.consultarCNPJSoap == null) {
            this._initConsultarCNPJSoapProxy();
        }

        return this.consultarCNPJSoap.consultarCNPJP1(CNPJ, CPFUsuario);
    }

    public CNPJPerfil1[] consultarCNPJP1T(String CNPJ, String CPFUsuario) throws RemoteException {
        if (this.consultarCNPJSoap == null) {
            this._initConsultarCNPJSoapProxy();
        }

        return this.consultarCNPJSoap.consultarCNPJP1T(CNPJ, CPFUsuario);
    }

    public CNPJPerfil2[] consultarCNPJP2(String CNPJ, String CPFUsuario) throws RemoteException {
        if (this.consultarCNPJSoap == null) {
            this._initConsultarCNPJSoapProxy();
        }

        return this.consultarCNPJSoap.consultarCNPJP2(CNPJ, CPFUsuario);
    }

    public CNPJPerfil2[] consultarCNPJP2T(String CNPJ, String CPFUsuario) throws RemoteException {
        if (this.consultarCNPJSoap == null) {
            this._initConsultarCNPJSoapProxy();
        }

        return this.consultarCNPJSoap.consultarCNPJP2T(CNPJ, CPFUsuario);
    }

    public CNPJPerfil3[] consultarCNPJP3(String CNPJ, String CPFUsuario) throws RemoteException {
        if (this.consultarCNPJSoap == null) {
            this._initConsultarCNPJSoapProxy();
        }

        return this.consultarCNPJSoap.consultarCNPJP3(CNPJ, CPFUsuario);
    }

    public CNPJPerfil3[] consultarCNPJP3T(String CNPJ, String CPFUsuario) throws RemoteException {
        if (this.consultarCNPJSoap == null) {
            this._initConsultarCNPJSoapProxy();
        }

        return this.consultarCNPJSoap.consultarCNPJP3T(CNPJ, CPFUsuario);
    }
}
