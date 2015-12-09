package com.shell.server.base.model;

import com.shell.server.base.shell.Servlet;

/**
 * Created by liquanmin on 15/11/24.
 */
public class DefaultServlet implements Servlet{

    @Override
    public void init() {

    }

    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.setStatusCode(200);

        httpResponse.addHeader("Server", "Shell/1.0");
        httpResponse.addHeader("Date", "Mon, 5 Jan 2004 13:13:33 GMT");
        httpResponse.addHeader("Content-Type", "text/html");
        httpResponse.addHeader("Last-Modified", "Mon, 5 Jan 2004 13:13:12 GMT");


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>").append("\r\n")
                .append("<head>").append("\r\n")
                .append("<title>HTTP Response Example</title>").append("\r\n")
                .append("</head>").append("\r\n")
                .append("<body>").append("\r\n")
                .append("Welcome to Brainy Software").append("\r\n")
                .append("</body>").append("\r\n")
                .append("</html>");

        byte[] body = stringBuilder.toString().getBytes();
        httpResponse.setBody(body);
        httpResponse.addHeader("Content-Length", "\"" + body.length + "\"");
    }

    @Override
    public void destroy() {

    }
}
