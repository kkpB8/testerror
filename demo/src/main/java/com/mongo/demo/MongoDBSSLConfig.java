package com.mongo.demo;

import com.mongodb.MongoClientSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class MongoDBSSLConfig {
    @Bean
    public MongoClientSettings mongoClientSettings() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream in = new FileInputStream("path/to/your/pem-certificate.p12")) {
            keyStore.load(in, "your-keystore-password".toCharArray());
        }

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        return MongoClientSettings.builder()
                .applyToSslSettings(sslBuilder -> sslBuilder.enabled(true).context(sslContext))
                .build();
    }
}
