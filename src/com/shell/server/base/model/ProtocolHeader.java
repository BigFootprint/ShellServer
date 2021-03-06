package com.shell.server.base.model;

import com.shell.server.base.constants.HttpMethod;

/**
 * Created by liquanmin on 15/11/24.
 */
public class ProtocolHeader {
    private HttpMethod method;
    private String path;
    private String protocol;

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
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
