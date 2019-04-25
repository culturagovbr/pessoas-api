package br.gov.fazenda.receita.infoconv.ws.cpf;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;

public class ConsultarCPFSoapProxy implements ConsultarCPFSoap {
    private String _endpoint = null;
    private ConsultarCPFSoap consultarCPFSoap = null;

    public ConsultarCPFSoapProxy() {
        this._initConsultarCPFSoapProxy();
    }

    public ConsultarCPFSoapProxy(String endpoint) {
        this._endpoint = endpoint;
        this._initConsultarCPFSoapProxy();
    }

    private void _initConsultarCPFSoapProxy() {
        try {
            this.consultarCPFSoap = (new ConsultarCPFLocator()).getConsultarCPFSoap();
            if (this.consultarCPFSoap != null) {
                if (this._endpoint != null) {
                    ((Stub)this.consultarCPFSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
                } else {
                    this._endpoint = (String)((Stub)this.consultarCPFSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
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
        if (this.consultarCPFSoap != null) {
            ((Stub)this.consultarCPFSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
        }

    }

    public ConsultarCPFSoap getConsultarCPFSoap() {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap;
    }

    public PessoaPerfil1[] consultarCPFP1(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap.consultarCPFP1(listaDeCPF, CPFUsuario);
    }

    public PessoaPerfil1[] consultarCPFP1T(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap.consultarCPFP1T(listaDeCPF, CPFUsuario);
    }

    public PessoaPerfil2[] consultarCPFP2(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap.consultarCPFP2(listaDeCPF, CPFUsuario);
    }

    public PessoaPerfil2[] consultarCPFP2T(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap.consultarCPFP2T(listaDeCPF, CPFUsuario);
    }

    public PessoaPerfil3[] consultarCPFP3(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap.consultarCPFP3(listaDeCPF, CPFUsuario);
    }

    public PessoaPerfil3[] consultarCPFP3T(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap.consultarCPFP3T(listaDeCPF, CPFUsuario);
    }

    public PessoaPerfilD[] consultarCPFPD(String listaDeCPF, String CPFUsuario) throws RemoteException {
        if (this.consultarCPFSoap == null) {
            this._initConsultarCPFSoapProxy();
        }

        return this.consultarCPFSoap.consultarCPFPD(listaDeCPF, CPFUsuario);
    }
}
