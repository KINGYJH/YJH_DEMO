package com.yjh.demo.core.util.httpclient;

import org.apache.http.Consts;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class CustomHttpClient {

    private static class IntelHolder {
        private static final CustomHttpClient INSTANCE = new CustomHttpClient();
    }

    private CloseableHttpClient httpClient;

    public CustomHttpClient() {

        // Create socket configuration
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(30000)
                .setTcpNoDelay(true)
                .build();

        // Create connection configuration
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
//                    .setMalformedInputAction(CodingErrorAction.IGNORE)
//                    .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .build();


        // Create a connection manager with custom configuration.
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setDefaultConnectionConfig(connectionConfig);
        connManager.setMaxTotal(400);
        connManager.setDefaultMaxPerRoute(200);

        httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public static final CustomHttpClient getInstance() {
        return IntelHolder.INSTANCE;
    }
}
