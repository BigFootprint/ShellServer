package com.shell.server.base.model;

import com.shell.server.base.shell.Servlet;

/**
 * Created by liquanmin on 15/11/24.
 */
public class ProcessThread extends Thread {
    private Servlet servlet;

    public ProcessThread(Servlet servlet) {
        this.servlet = servlet;
    }

    @Override
    public void run() {

    }
}
