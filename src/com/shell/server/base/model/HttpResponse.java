package com.shell.server.base.model;

import com.shell.server.base.constants.ResponseHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liquanmin on 15/11/24.
 */
public class HttpResponse {
    private Map<String, String> responseCommonHeader = new HashMap<String, String>();
    private byte[] body;
    private int statusCode;
    private String protocolHeader = ResponseHeader.REQPONSE_HEADER_200;

    public void addHeader(String key, String value) {
        if (key == null || value == null)
            return;

        responseCommonHeader.put(key, value);
    }

    public Map<String, String> getResponseCommonHeader() {
        return responseCommonHeader;
    }

    public void setResponseCommonHeader(Map<String, String> responseCommonHeader) {
        this.responseCommonHeader = responseCommonHeader;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getProtocolHeader() {
        switch (statusCode) {
            case 200:
                return ResponseHeader.REQPONSE_HEADER_200 + "\r\n";
        }
        return protocolHeader;
    }
}
