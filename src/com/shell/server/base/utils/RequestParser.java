package com.shell.server.base.utils;

import com.shell.server.base.constants.HttpMethod;
import com.shell.server.base.model.HttpRequest;
import com.shell.server.base.model.ProtocolHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liquanmin on 15/11/24.
 */
public class RequestParser {
    public static HttpRequest parseRequest(InputStream inputStream) {
        HttpRequest httpRequest = new HttpRequest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            line = reader.readLine();
            if (StringUtils.isEmpty(line)) {
                //解析协议行
                httpRequest.setProtocolHeader(parseProtocolHeader(line));
            }

            Map<String, String> headerMap = new HashMap<String, String>();
            while (!StringUtils.isEmpty(line = reader.readLine())) {
                //解析Header
                String strs[] = line.split(": ");
                if (strs.length != 2)
                    continue;

                headerMap.put(strs[0], strs[1]);
            }

            httpRequest.setHeadersMap(headerMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpRequest;
    }

    private static ProtocolHeader parseProtocolHeader(String headerLine) {
        ProtocolHeader protocolHeader = new ProtocolHeader();
        String[] strs = headerLine.split(" ");

        HttpMethod method = null;
        if (strs[0].equalsIgnoreCase("get")) {
            method = HttpMethod.GET;
        } else if (strs[0].equalsIgnoreCase("post")) {
            method = HttpMethod.POST;
        } else if (strs[0].equalsIgnoreCase("put")) {
            method = HttpMethod.PUT;
        } else if (strs[0].equalsIgnoreCase("delete")) {
            method = HttpMethod.DELETE;
        } else if (strs[0].equalsIgnoreCase("trace")) {
            method = HttpMethod.TRACE;
        }

        protocolHeader.setMethod(method);
        protocolHeader.setPath(strs[1]);
        protocolHeader.setProtocol(strs[2]);
        return protocolHeader;
    }
}
