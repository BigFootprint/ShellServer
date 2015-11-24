package com.shell.server.test;

import com.shell.server.base.HttpServer;

/**
 * Created by liquanmin on 15/11/24.
 */
public class ServerLoader {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.startUp();
    }
}
