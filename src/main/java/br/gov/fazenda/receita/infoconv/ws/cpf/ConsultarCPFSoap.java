package br.gov.fazenda.receita.infoconv.ws.cpf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConsultarCPFSoap extends Remote {
    PessoaPerfil1[] consultarCPFP1(String var1, String var2) throws RemoteException;

    PessoaPerfil1[] consultarCPFP1T(String var1, String var2) throws RemoteException;

    PessoaPerfil2[] consultarCPFP2(String var1, String var2) throws RemoteException;

    PessoaPerfil2[] consultarCPFP2T(String var1, String var2) throws RemoteException;

    PessoaPerfil3[] consultarCPFP3(String var1, String var2) throws RemoteException;

    PessoaPerfil3[] consultarCPFP3T(String var1, String var2) throws RemoteException;

    PessoaPerfilD[] consultarCPFPD(String var1, String var2) throws RemoteException;
}
