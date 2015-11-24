package com.shell.server.base.model;

/**
 * Created by liquanmin on 15/11/24.
 */
public class ProtocolHeader {
    private HttpRequest.Method method;
    private String path;
    private String protocol;

    public HttpRequest.Method getMethod() {
        return method;
    }

    public void setMethod(HttpRequest.Method method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
