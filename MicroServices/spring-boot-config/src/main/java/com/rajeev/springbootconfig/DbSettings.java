package com.rajeev.springbootconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
public class DbSettings {

    private String connection;
    private String host;
    @Override
    public String toString() {
        return "DbSettings [connection=" + connection + ", host=" + host + ", port=" + port + "]";
    }
    public DbSettings(String connection, String host, int port) {
        this.connection = connection;
        this.host = host;
        this.port = port;
    }
    public DbSettings() {
    }
    public String getConnection() {
        return connection;
    }
    public void setConnection(String connection) {
        this.connection = connection;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    private int port;
   
    
}
