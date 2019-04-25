package br.gov.fazenda.receita.infoconv.ws.cnpj;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface ConsultarCNPJ extends Service {
    String getConsultarCNPJSoapAddress();

    ConsultarCNPJSoap getConsultarCNPJSoap() throws ServiceException;

    ConsultarCNPJSoap getConsultarCNPJSoap(URL var1) throws ServiceException;
}
