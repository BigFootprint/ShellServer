package com.shell.server.base.model;

/**
 * Created by liquanmin on 15/11/24.
 */
public class HttpRequest {
    private String requestUrl;
    private Method method;

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

    public void setMethod(String method) {

    }

    public Method getMethod() {
        return method;
    }
}
