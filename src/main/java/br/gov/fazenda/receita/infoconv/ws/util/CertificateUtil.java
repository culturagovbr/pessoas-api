package br.gov.fazenda.receita.infoconv.ws.util;

import br.gov.cultura.sistema.util.PropertyFileUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Properties;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class CertificateUtil {
    private static final String PROPERTY_FILE_PATH = "/opt/config/minc-pessoa.properties";
    public static final String CPF_CONVENIO_SERPRO;
    private static final Properties props = PropertyFileUtils.readFile("/opt/config/minc-pessoa.properties", false);

    static {
        CPF_CONVENIO_SERPRO = props.getProperty("cpf");
    }

    public CertificateUtil() {
    }

    public static String getKeyEntryAlias(KeyStore certificadoPFX) {
        try {
            Enumeration aliases = certificadoPFX.aliases();

            while(aliases.hasMoreElements()) {
                String keyEntryAlias = (String)aliases.nextElement();
                if (certificadoPFX.isKeyEntry(keyEntryAlias)) {
                    return keyEntryAlias;
                }
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return null;
    }

    public static TrustManager[] getTrustManagers() {
        try (InputStream inputStream = new FileInputStream(props.getProperty("trustStore"))) {
            KeyStore trustStore = KeyStore.getInstance(props.getProperty("trustStoreType"));
            trustStore.load(inputStream, props.getProperty("trustStorePassword").toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);
            return trustManagerFactory.getTrustManagers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static KeyManager[] getKeyManagers() {
        try (InputStream inputStream = new FileInputStream(props.getProperty("keyStore"))) {
            // Abre o keystore
            KeyStore keyStore = KeyStore.getInstance(props.getProperty("keyStoreType"));
            keyStore.load(inputStream, props.getProperty("keyStorePassword").toCharArray());
            // Recupera o Certificado e a Chave Privada
            String keyEntryAlias = getKeyEntryAlias(keyStore);
            X509Certificate certificado = (X509Certificate) keyStore.getCertificate(keyEntryAlias);
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyEntryAlias, props.getProperty("keyStorePassword").toCharArray());

            return new KeyManager[] { new CustomX509KeyManager( certificado, privateKey ) };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
