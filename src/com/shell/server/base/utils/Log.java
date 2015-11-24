package com.shell.server.base.utils;

/**
 * Created by liquanmin on 15/11/24.
 */
public class Log {
    public static void i(String info) {
        System.out.println("[Info] " + info);
    }

    public static void e(String error) {
        System.err.println("[Error] " + error);
    }
}
