package com.shell.server.base.model;

import com.shell.server.base.utils.CollectionUtils;

import java.util.Map;

/**
 * Created by liquanmin on 15/11/24.
 */
public class HttpRequest {
    private String requestUrl;
    private ProtocolHeader protocolHeader;
    private Map<String, String> headersMap;

    public enum Method {
        GET("GET"),
        POST("POST"),
        DELETE("DELETE"),
        PUT("PUT"),
        TRACE("TRACE");

        private String methodName = "";

        Method(String methodName) {
            this.methodName = methodName;
        }
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public ProtocolHeader getProtocolHeader() {
        return protocolHeader;
    }

    public void setProtocolHeader(ProtocolHeader protocolHeader) {
        this.protocolHeader = protocolHeader;
    }

    public Map<String, String> getHeadersMap() {
        return headersMap;
    }

    public void setHeadersMap(Map<String, String> headersMap) {
        this.headersMap = headersMap;
    }

    public String getHeader(String headerKey) {
        if (CollectionUtils.isMapEmpty(headersMap))
            return "";

        return headersMap.get(headerKey);
    }
}
