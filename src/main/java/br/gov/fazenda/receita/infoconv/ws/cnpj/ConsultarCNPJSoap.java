package br.gov.fazenda.receita.infoconv.ws.cnpj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConsultarCNPJSoap extends Remote {
    CNPJPerfil1[] consultarCNPJP1(String var1, String var2) throws RemoteException;

    CNPJPerfil1[] consultarCNPJP1T(String var1, String var2) throws RemoteException;

    CNPJPerfil2[] consultarCNPJP2(String var1, String var2) throws RemoteException;

    CNPJPerfil2[] consultarCNPJP2T(String var1, String var2) throws RemoteException;

    CNPJPerfil3[] consultarCNPJP3(String var1, String var2) throws RemoteException;

    CNPJPerfil3[] consultarCNPJP3T(String var1, String var2) throws RemoteException;
}
