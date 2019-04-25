package br.gov.fazenda.receita.infoconv.ws.cpf;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface ConsultarCPF extends Service {
    String getConsultarCPFSoapAddress();

    ConsultarCPFSoap getConsultarCPFSoap() throws ServiceException;

    ConsultarCPFSoap getConsultarCPFSoap(URL var1) throws ServiceException;
}
