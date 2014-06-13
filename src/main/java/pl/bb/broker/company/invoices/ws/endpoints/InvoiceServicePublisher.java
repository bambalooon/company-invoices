package pl.bb.broker.company.invoices.ws.endpoints;

import com.sun.net.httpserver.*;
import pl.bb.broker.company.invoices.ws.services.InvoiceServiceImpl;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.ws.Endpoint;
import javax.xml.ws.http.HTTPBinding;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 11.06.14
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
public class InvoiceServicePublisher {
    public static int maxConnections = 100000;

    public static void publish(String uri, String hostname, int port, File keystore, String password) throws NoSuchAlgorithmException, KeyStoreException,
            IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        SSLContext ssl = SSLContext.getInstance("TLS");

        KeyManagerFactory keyFactory =
                KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

        KeyStore store = KeyStore.getInstance("JKS");

        store.load(new FileInputStream(keystore), password.toCharArray());

        keyFactory.init(store, password.toCharArray());

        TrustManagerFactory trustFactory =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        trustFactory.init(store);

        ssl.init(keyFactory.getKeyManagers(), trustFactory.getTrustManagers(), new SecureRandom());

        HttpsConfigurator configurator = new HttpsConfigurator(ssl);

        HttpsServer server = HttpsServer.create(new InetSocketAddress(hostname, port), InvoiceServicePublisher.maxConnections);
        server.setHttpsConfigurator(configurator);

        HttpContext httpContext = server.createContext(uri);

        server.start();

        Endpoint endpoint = Endpoint.create(new InvoiceServiceImpl());
        endpoint.publish(httpContext);
    }

    public static void publishNoSsl(String address) {
        Endpoint.publish(address, new InvoiceServiceImpl());
    }
}
