package com.shell.server.base.constants;

/**
 * Created by liquanmin on 15/11/24.
 */
public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE"),
    PUT("PUT"),
    TRACE("TRACE");

    private String methodName = "";

    HttpMethod(String methodName) {
        this.methodName = methodName;
    }
}
