package com.shell.server.base.utils;

import com.shell.server.base.model.HttpResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by liquanmin on 15/11/24.
 */
public class ResponseWriter {
    public static void writeResponseToStream(HttpResponse response, OutputStream outputStream) {
        try {
            outputStream.write(response.getProtocolHeader().getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            Map<String, String> commonHeaders = response.getResponseCommonHeader();
            for (Map.Entry<String, String> entry : commonHeaders.entrySet()) {
                stringBuilder.append(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            stringBuilder.append("\n");

            outputStream.write(stringBuilder.toString().getBytes());

            outputStream.write(response.getBody());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
