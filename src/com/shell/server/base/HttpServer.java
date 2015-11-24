package com.shell.server.base;

import com.shell.server.base.model.DefaultServlet;
import com.shell.server.base.model.HttpResponse;
import com.shell.server.base.utils.Log;
import com.shell.server.base.utils.RequestParser;
import com.shell.server.base.utils.ResponseWriter;
import com.shell.server.base.model.HttpRequest;
import com.shell.server.base.shell.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liquanmin on 15/11/24.
 */
public class HttpServer {
    private ServerSocket serverSocket = null;
    private boolean shutDown = false;
    private Servlet servlet;

    public boolean startUp() {
        try {
            Log.i("Server starting...");
            /* 第二个参数表示客户端连接请求的队列长度 */
            serverSocket = new ServerSocket(ServerConfig.PORT, 1, InetAddress.getByName("127.0.0.1"));
            Log.i("Server started !");
            while (!shutDown) {
                Socket socket = null;
                InputStream input = null;
                OutputStream output = null;

                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                HttpRequest httpRequest = RequestParser.parseRequest(input);
                HttpResponse httpResponse = new HttpResponse();

                getServlet().service(httpRequest, httpResponse);

                ResponseWriter.writeResponseToStream(httpResponse, output);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Server stoped for : " + e.toString());
            shutDown(1);
            return false;
        }
        shutDown(0);
        return true;
    }

    public void shutDown(int code) {
        getServlet().destroy();//没实例化此处不应当实例化
        Log.i("Server shutdown with code " + code);
        System.exit(code);
    }

    private Servlet getServlet() {
        if (servlet == null) {
            servlet = new DefaultServlet();
            servlet.init();
        }

        return servlet;
    }
}
