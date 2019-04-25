package br.gov.fazenda.receita.infoconv.ws.util;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509KeyManager;

public class CustomX509KeyManager implements X509KeyManager {
    private X509Certificate certificado = null;
    private PrivateKey privateKey = null;

    public CustomX509KeyManager(X509Certificate certificado, PrivateKey privateKey) {
        this.certificado = certificado;
        this.privateKey = privateKey;
    }

    public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
        return this.certificado.getIssuerDN().getName();
    }

    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        return null;
    }

    public X509Certificate[] getCertificateChain(String alias) {
        return new X509Certificate[]{this.certificado};
    }

    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return new String[]{this.certificado.getIssuerDN().getName()};
    }

    public PrivateKey getPrivateKey(String alias) {
        return this.privateKey;
    }

    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return null;
    }
}
