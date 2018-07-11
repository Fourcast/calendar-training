package io.fourcast.calendar;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.InputStream;
import java.util.List;

/**
 * Created by nielsbuekers
 */
public class AbstractGoogleService {
    protected static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    protected static final JsonFactory JSON_FACTORY = new JacksonFactory();


    protected static GoogleCredential getCredentialsForScope(InputStream in, List<String> scope, String user) throws Exception {

        GoogleCredential credentials = GoogleCredential.fromStream(in, HTTP_TRANSPORT, JSON_FACTORY);
        credentials = credentials.createScoped(scope);

        return new GoogleCredential.Builder()
                .setTransport(credentials.getTransport())
                .setJsonFactory(credentials.getJsonFactory())
                .setServiceAccountId(credentials.getServiceAccountId())
                .setServiceAccountScopes(credentials.getServiceAccountScopes())
                .setServiceAccountPrivateKey(credentials.getServiceAccountPrivateKey())
                .setServiceAccountPrivateKeyId(credentials.getServiceAccountPrivateKeyId())
                .setServiceAccountUser(user)
                .build();
    }
}
